package hr.tvz.ilisinovic.hardwareapp.services;

import hr.tvz.ilisinovic.hardwareapp.interfaces.IHardwareService;
import hr.tvz.ilisinovic.hardwareapp.model.Hardware;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareCommand;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareDTO;
import hr.tvz.ilisinovic.hardwareapp.repositories.MockHardwareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HardwareService implements IHardwareService {

    private final MockHardwareRepository mockHardwareRepository;

    public HardwareService(MockHardwareRepository mockHardwareRepository){
        this.mockHardwareRepository=mockHardwareRepository;
    }

    @Override
    public List<HardwareDTO> findAll() {
        return mockHardwareRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public HardwareDTO findByCode(String code) {
        return mockHardwareRepository.findByCode(code).map(this::mapToDTO).get();
    }

    @Override
    public Optional<HardwareDTO> save(HardwareCommand command) {
        return mockHardwareRepository.save(mapCommandToHardware(command)).map(this::mapToDTO);
    }

    @Override
    public void deleteByCode(String code) {
        mockHardwareRepository.deleteByCode(code);
    }

    private HardwareDTO mapToDTO(Hardware hardware){
        return new HardwareDTO(hardware.getName(),hardware.getPrice());
    }

    private Hardware mapCommandToHardware(HardwareCommand command) {

        Hardware h= new Hardware(command.getId(),
                command.getName(),
                command.getPrice(),
                command.getType(),
                command.getNumberOf());
        System.out.println(h.getId()+h.getType()+h.getPrice());
        return h;
    }
}
