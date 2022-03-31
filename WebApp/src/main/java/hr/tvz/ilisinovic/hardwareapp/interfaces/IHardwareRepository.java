package hr.tvz.ilisinovic.hardwareapp.interfaces;

import hr.tvz.ilisinovic.hardwareapp.model.Hardware;

import java.util.List;
import java.util.Optional;

public interface IHardwareRepository {

    List<Hardware> findAll();

    Optional<Hardware> findByCode(String code);

}
