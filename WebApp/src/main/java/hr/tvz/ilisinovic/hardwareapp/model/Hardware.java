package hr.tvz.ilisinovic.hardwareapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="hardware")
public class Hardware implements Serializable {

    @Id
    private String id;

    @Column(name = "hardwarename")
    private String name;

    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "hardwaretype")
    private HardwareType type;

    @Column(name = "numberof")
    private int numberOf;

    @OneToMany(mappedBy="hardware",fetch=FetchType.EAGER)
    private List<Review> reviewList;


    public Hardware(String id, String name, double price, HardwareType type, int numberOf) {
        this.id = id;
        this.name=name;
        this.price = price;
        this.type = type;
        this.numberOf = numberOf;
    }

    public Hardware() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hardware hardware = (Hardware) o;
        return id.equals(hardware.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
