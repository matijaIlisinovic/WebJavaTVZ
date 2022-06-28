package hr.tvz.ilisinovic.hardwareapp.model;

import javax.validation.constraints.*;

public class HardwareCommand {
    @NotBlank(message = "id must not be empty")
    @Pattern(message = "id must have 6 characters", regexp=".{6}")
    private String code;

    @NotBlank(message = "name must not be empty")
    private String name;

    @NotNull(message = "price must not be empty")
    @PositiveOrZero(message = "min price of items is zero")
    private Double price;

    @NotBlank(message = "type must not be empty")
    private String type;


    @NotNull(message = "number of items must not be empty")
    @PositiveOrZero(message = "min number of items is zero")

    public HardwareCommand(String code, String name, Double price, String type, Integer stock) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.type = type;
        this.stock = stock;
    }

    private Integer stock;

    public String getCode() {
        return code;
    }

    public String getName() { return name;}

    public double getPrice() {
        return price;
    }

    public HardwareType getType() {
        return HardwareType.valueOf(type);
    }

    public int getStock() {
        return stock;
    }
}
