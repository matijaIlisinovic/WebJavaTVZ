package hr.tvz.ilisinovic.hardwareapp.web;

import hr.tvz.ilisinovic.hardwareapp.model.ReviewDTO;
import hr.tvz.ilisinovic.hardwareapp.repositories.JdbcHardwareRepository;
import hr.tvz.ilisinovic.hardwareapp.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review")
@CrossOrigin
public class ReviewController {
    private final ReviewService reviewService;
    private final JdbcHardwareRepository hardwareRepository;
    public ReviewController(ReviewService reviewService, JdbcHardwareRepository hardwareRepository){
        this.reviewService = reviewService;
        this.hardwareRepository = hardwareRepository;
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getAllReviews(){
        return new ResponseEntity<List<ReviewDTO>>(reviewService.findAll(), HttpStatus.OK);
    }

    @GetMapping(params = "hardwareCode")
    public ResponseEntity<List<ReviewDTO>> getReviewsById(@RequestParam String hardwareCode){
        try {
            return new ResponseEntity<List<ReviewDTO>>(
                    reviewService.findByHardware(hardwareRepository.findByCode(hardwareCode).get()),
                    HttpStatus.OK);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(params="title")
    public ResponseEntity<List<ReviewDTO>> getReviewsByTitle(@RequestParam String title){
        try {
            return new ResponseEntity<List<ReviewDTO>>(
                    reviewService.findByTitle(title),
                    HttpStatus.OK);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(params = "id")
    public ResponseEntity<ReviewDTO> getReviewById(@RequestParam int id){
        try {
            return new ResponseEntity<ReviewDTO>(
                    reviewService.findById(id),
                    HttpStatus.OK);
        }catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
