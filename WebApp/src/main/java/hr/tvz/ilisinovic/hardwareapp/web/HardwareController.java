package hr.tvz.ilisinovic.hardwareapp.web;


import hr.tvz.ilisinovic.hardwareapp.model.HardwareCommand;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareDTO;
import hr.tvz.ilisinovic.hardwareapp.services.HardwareService;
import hr.tvz.ilisinovic.hardwareapp.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("hardware")
@CrossOrigin
public class HardwareController {
    private final HardwareService hardwareService;
    private final ReviewService reviewService;

    public HardwareController(HardwareService hardwareService,ReviewService reviewService) {
        this.hardwareService = hardwareService;
        this.reviewService = reviewService;
    }


    @GetMapping
    public ResponseEntity<List<HardwareDTO>> getAllHardware(){
        return new ResponseEntity<List<HardwareDTO>>(hardwareService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<HardwareDTO> getHardwareByCode(@PathVariable final String code){
        try {
            return new ResponseEntity<HardwareDTO>(hardwareService.findByCode(code),HttpStatus.OK);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/find/{prefix}")
    public ResponseEntity<List<HardwareDTO>> getHardwareByPref(@PathVariable final String prefix){
        try {
            return new ResponseEntity<List<HardwareDTO>>(hardwareService.findByPref(prefix),HttpStatus.OK);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<HardwareDTO> save(@Valid @RequestBody final HardwareCommand command){
        return hardwareService.save(command)
                .map(
                        hardwareDTO -> ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(hardwareDTO)
                )
                .orElseGet(
                        () -> ResponseEntity
                                .status(HttpStatus.CONFLICT)
                                .build()
                );
    }
    @PutMapping("/{code}")
    public ResponseEntity<HardwareDTO> update(@PathVariable String code, @Valid @RequestBody final HardwareCommand updateHardwareCommand){
        return hardwareService.update(code, updateHardwareCommand)
                .map(ResponseEntity::ok)
                .orElseGet(
                        () -> ResponseEntity.notFound().build()
                );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code){
        reviewService.deleteByHardware(code);
        hardwareService.deleteByCode(code);
    }


}
