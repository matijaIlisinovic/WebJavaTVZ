package hr.tvz.ilisinovic.hardwareapp.model;

import java.io.Serializable;

public class Hardware implements Serializable {
    private String id;
    private String name;
    private double price;
    private HardwareType type;
    private int numberOf;

    public Hardware(String id, String name, double price, HardwareType type, int numberOf) {
        this.id = id;
        this.name=name;
        this.price = price;
        this.type = type;
        this.numberOf = numberOf;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HardwareType getType() {
        return type;
    }

    public void setType(HardwareType type) {
        this.type = type;
    }

    public int getNumberOf() {
        return numberOf;
    }

    public void setNumberOf(int numberOf) {
        this.numberOf = numberOf;
    }
}
