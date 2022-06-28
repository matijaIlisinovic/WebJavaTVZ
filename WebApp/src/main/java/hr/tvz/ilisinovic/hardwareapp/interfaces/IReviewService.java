package hr.tvz.ilisinovic.hardwareapp.interfaces;

import hr.tvz.ilisinovic.hardwareapp.model.Hardware;
import hr.tvz.ilisinovic.hardwareapp.model.ReviewDTO;

import java.util.List;

public interface IReviewService {
    public List<ReviewDTO> findAll();

    public List<ReviewDTO> findByHardware(Hardware hardware);
}
