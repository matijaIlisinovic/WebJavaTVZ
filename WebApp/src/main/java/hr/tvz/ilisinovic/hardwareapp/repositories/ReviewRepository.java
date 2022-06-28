package hr.tvz.ilisinovic.hardwareapp.repositories;

import hr.tvz.ilisinovic.hardwareapp.model.Hardware;
import hr.tvz.ilisinovic.hardwareapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review, Long> {
    @Override
    public List<Review> findAll();

    public List<Review> findByHardware(Hardware hardware);

    @Transactional
    public void deleteByHardware(Hardware hardware);

    public List<Review> findByReviewtitleIgnoreCaseLike(String title);

    public Review findById(String id);
}
