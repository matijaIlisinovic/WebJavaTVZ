package hr.tvz.ilisinovic.hardwareapp.services;

import hr.tvz.ilisinovic.hardwareapp.interfaces.IHardwareService;
import hr.tvz.ilisinovic.hardwareapp.model.Hardware;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareCommand;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareDTO;
import hr.tvz.ilisinovic.hardwareapp.repositories.JdbcHardwareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareService implements IHardwareService {

    private final JdbcHardwareRepository jdbcHardwareRepository;

    public HardwareService(JdbcHardwareRepository jdbcHardwareRepository){
        this.jdbcHardwareRepository=jdbcHardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAll() {
        return jdbcHardwareRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public HardwareDTO findByCode(String code) {
        return jdbcHardwareRepository.findByCode(code).map(this::mapToDTO).get();
    }

    public List<HardwareDTO> findByPref(String prefix) {
        return jdbcHardwareRepository.findByPref(prefix.toLowerCase()).get().stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    @Override
    public Optional<HardwareDTO> save(HardwareCommand command) {
        return jdbcHardwareRepository.save(mapCommandToHardware(command)).map(this::mapToDTO);
    }

    @Override
    public void deleteByCode(String code){ jdbcHardwareRepository.deleteByCode(code);
    }

    private HardwareDTO mapToDTO(Hardware hardware){
        return new HardwareDTO(hardware.getId(), hardware.getName(),hardware.getPrice());
    }

    private Hardware mapCommandToHardware(HardwareCommand command) {

        Hardware h= new Hardware(command.getCode(),
                command.getName(),
                command.getPrice(),
                command.getType(),
                command.getStock());
        System.out.println(h.getId()+h.getType()+h.getPrice());
        return h;
    }

    public Optional<HardwareDTO> update(String code, HardwareCommand updateHardwareCommand) {
        return jdbcHardwareRepository.update(code, mapCommandToHardware(updateHardwareCommand)).map(this::mapToDTO);
    }
}
