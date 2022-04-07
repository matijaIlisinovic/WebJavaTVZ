package hr.tvz.ilisinovic.hardwareapp.interfaces;

import hr.tvz.ilisinovic.hardwareapp.model.HardwareCommand;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface IHardwareService {

    List<HardwareDTO> findAll();

    HardwareDTO findByCode(String code);

    Optional<HardwareDTO> save(HardwareCommand command);

    public void deleteByCode(String code);
}
