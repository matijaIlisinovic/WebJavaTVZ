package hr.tvz.ilisinovic.hardwareapp.web;


import hr.tvz.ilisinovic.hardwareapp.model.HardwareCommand;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareDTO;
import hr.tvz.ilisinovic.hardwareapp.services.HardwareService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class HardwareController {
    private final HardwareService hardwareService;

    public HardwareController(HardwareService hardwareService) {
        this.hardwareService = hardwareService;
    }

    @GetMapping
    public List<HardwareDTO> getAllStudents(){
        return hardwareService.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<HardwareDTO> getStudentByJMBAG(@PathVariable final String code){
        try {
            return new ResponseEntity<HardwareDTO>(hardwareService.findByCode(code),HttpStatus.OK);
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

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void delete(@PathVariable String code){
        hardwareService.deleteByCode(code);
    }

}
