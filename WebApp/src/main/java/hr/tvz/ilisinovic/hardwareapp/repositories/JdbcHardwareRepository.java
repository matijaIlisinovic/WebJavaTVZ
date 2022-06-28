package hr.tvz.ilisinovic.hardwareapp.repositories;

import hr.tvz.ilisinovic.hardwareapp.interfaces.IHardwareRepository;
import hr.tvz.ilisinovic.hardwareapp.model.Hardware;
import hr.tvz.ilisinovic.hardwareapp.model.HardwareType;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Primary
@Repository
public class JdbcHardwareRepository implements IHardwareRepository {

    private static final String SELECT_ALL = "SELECT id, hardwareName, price, hardwareType, numberOf FROM hardware";

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public JdbcHardwareRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.inserter = new SimpleJdbcInsert(jdbc)
                .withTableName("hardware");
    }

    @Override
    public List<Hardware> findAll() {
        return List.copyOf(jdbc.query(SELECT_ALL, this::mapRowToHardware));
    }

    @Override
    public Optional<Hardware> findByCode(String code) {
        try{
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE id = ?", this::mapRowToHardware, code)
            );
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }

    public Optional<List<Hardware>> findByPref(String prefix) {
        try{
            return Optional.ofNullable(
                    jdbc.query(SELECT_ALL + " WHERE lower(id) LIKE concat(?,'%')", this::mapRowToHardware, prefix.toLowerCase())
            );
        } catch (EmptyResultDataAccessException e){
            return Optional.empty();
        }
    }
    @Override
    public Optional<Hardware> save(Hardware student) {
        try {
            saveHardwareDetails(student);
            return Optional.of(student);
        } catch (DuplicateKeyException e){
            return Optional.empty();
        }
    }

    @Override
    public void deleteByCode(String code) {
        jdbc.update("DELETE FROM hardware WHERE id = ?", code);
    }

    private Hardware mapRowToHardware(ResultSet resultSet, int i) throws SQLException {
        return new Hardware(
                resultSet.getString("id"),
                resultSet.getString("hardwareName"),
                resultSet.getDouble("price"),
                findTypeByName(resultSet.getString("hardwareType")),
                resultSet.getInt("numberOf")
        );
    }

    private HardwareType findTypeByName(String name) {
        HardwareType result = HardwareType.OTHER;
        for (HardwareType type : HardwareType.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                result = type;
                break;
            }
        }
        return result;
    }

    public Optional<Hardware> update(String code, Hardware hardware) {
        try {
            jdbc.update("UPDATE hardware " +
                    "SET hardwarename = ? , price = ? ,hardwaretype = ? ,numberof = ? " +
                    "WHERE id = ?",
                    hardware.getName(),hardware.getPrice(),hardware.getType().name(),hardware.getNumberOf(),
                            code);
            return Optional.of(hardware);
        } catch (DuplicateKeyException e){
            return Optional.empty();
        }
    }

    private void saveHardwareDetails(Hardware hardware) {
        Map<String, Object> values = new HashMap<>();

        values.put("id", hardware.getId());
        values.put("hardwareName", hardware.getName());
        values.put("price", hardware.getPrice());
        values.put("hardwareType", hardware.getType().name());
        values.put("numberOf", hardware.getNumberOf());

        inserter.execute(values);
    }


}
