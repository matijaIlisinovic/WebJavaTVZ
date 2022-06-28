package hr.tvz.ilisinovic.hardwareapp.services;

import hr.tvz.ilisinovic.hardwareapp.interfaces.IReviewService;
import hr.tvz.ilisinovic.hardwareapp.model.Hardware;
import hr.tvz.ilisinovic.hardwareapp.model.Review;
import hr.tvz.ilisinovic.hardwareapp.model.ReviewDTO;
import hr.tvz.ilisinovic.hardwareapp.repositories.JdbcHardwareRepository;
import hr.tvz.ilisinovic.hardwareapp.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService implements IReviewService {
    private final ReviewRepository reviewRepository;
    private final  JdbcHardwareRepository hardwareRepository;

    public ReviewService(ReviewRepository reviewRepository, JdbcHardwareRepository hardwareRepository) {
        this.reviewRepository = reviewRepository;
        this.hardwareRepository = hardwareRepository;
    }

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findByHardware(Hardware hardware) {
        return reviewRepository.findByHardware(hardware).stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }

    public void deleteByHardware(String code) {
        Hardware hardware=hardwareRepository.findByCode(code).get();
        reviewRepository.deleteByHardware(hardware);
    }

    public List<ReviewDTO> findByTitle(String title) {
        String s="%"+title+"%";

        return reviewRepository.findByReviewtitleIgnoreCaseLike(s).stream().map(this::mapReviewToDTO).collect(Collectors.toList());
    }
    public ReviewDTO findById(int id) {
       return mapReviewToDTO(reviewRepository.findById(String.valueOf(id)));
    }

    private ReviewDTO mapReviewToDTO(Review review){
        System.out.println(review.getHardware().getId());
        return new ReviewDTO(review.getId(), review.getTitle(), review.getText(), review.getGrade(),review.getHardware().getId());
    }

}
