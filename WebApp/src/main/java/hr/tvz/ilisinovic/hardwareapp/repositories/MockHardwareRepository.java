package hr.tvz.ilisinovic.hardwareapp.repositories;

import hr.tvz.ilisinovic.hardwareapp.interfaces.IHardwareRepository;
import hr.tvz.ilisinovic.hardwareapp.model.Hardware;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareType;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MockHardwareRepository implements IHardwareRepository {

    private List<Hardware>  storage = Arrays.asList(
            new Hardware("3dk534","CPForU2x",200, HardwareType.CPU,3),
            new Hardware("2dk534","GAProcess 3000",200,HardwareType.GPU,4)
    );

    @Override
    public List<Hardware> findAll() {
        return storage;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return storage.stream().filter(item -> item.getId().equals(code)).findAny();
    }
}
