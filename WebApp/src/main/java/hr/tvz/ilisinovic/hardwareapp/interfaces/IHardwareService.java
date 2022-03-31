package hr.tvz.ilisinovic.hardwareapp.interfaces;

import hr.tvz.ilisinovic.hardwareapp.model.HardwareDTO;

import java.util.List;

public interface IHardwareService {

    List<HardwareDTO> findAll();

    HardwareDTO findByCode(String code);

}
