package hr.tvz.ilisinovic.hardwareapp.repositories;

import hr.tvz.ilisinovic.hardwareapp.interfaces.IHardwareRepository;
import hr.tvz.ilisinovic.hardwareapp.model.Hardware;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareType;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MockHardwareRepository implements IHardwareRepository {

    private final List<Hardware>  storage = new ArrayList<>(
            Arrays.asList(
                new Hardware("3dk534","CPForU2x",300, HardwareType.CPU,3),
                new Hardware("2dk534","GAProcess 3000",200,HardwareType.GPU,2)
            )
    );

    @Override
    public List<Hardware> findAll() {
        return storage;
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        return storage.stream().filter(item -> item.getId().equals(code)).findAny();
    }

    @Override
    public Optional<Hardware> save(Hardware hardware) {
        if(!storage.contains(hardware)){
            System.out.println(hardware.getId());
            storage.add(hardware);
            System.out.println(hardware.getId());
            return Optional.of(hardware);
        } else {
            return Optional.empty();
        }

    }

    @Override
    public void deleteByCode(String code) {
        storage.removeIf(it -> Objects.equals(it.getId(), code));
    }

    public Optional<Hardware> changePrice(String code, double price) {
        for(Hardware item : storage){
            if(item.getId().equals(code)){
                item.setPrice(price);
                return Optional.of(item);
            }
        }
        return Optional.empty();

    }
}
