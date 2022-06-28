package hr.tvz.ilisinovic.hardwareapp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="review")
public class Review implements Serializable {

    @Id
    @GeneratedValue
    private String id;

    @Column(name = "reviewtitle")
    private String reviewtitle;

    @Column(name = "reviewtext")
    private String text;

    private int grade;

    @ManyToOne
    @JoinColumn(name="hardware")
    private Hardware hardware;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id.equals(review.id);
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

    public String getTitle() {
        return reviewtitle;
    }

    public void setTitle(String title) {
        this.reviewtitle = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Hardware getHardware() {
        return hardware;
    }

    public void setHardware(Hardware hardware) {
        this.hardware = hardware;
    }
}
