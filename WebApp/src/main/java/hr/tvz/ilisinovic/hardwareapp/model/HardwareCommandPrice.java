package hr.tvz.ilisinovic.hardwareapp.model;

import javax.validation.constraints.*;

public class HardwareCommandPrice {

    @NotNull(message = "price must not be empty")
    @PositiveOrZero(message = "min price of items is zero")
    private Double price;

    public double getPrice() {
        return price;
    }
}
