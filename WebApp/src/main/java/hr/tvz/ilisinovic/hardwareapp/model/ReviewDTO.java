package hr.tvz.ilisinovic.hardwareapp.model;

public class ReviewDTO {
    private String code;

    private String title;

    private String text;

    private int rating;

    private String hardwareId;

    public ReviewDTO(String id, String title, String text, int rating,String hardwareId) {
        this.code = id;
        this.title = title;
        this.text = text;
        this.rating = rating;
        this.hardwareId=hardwareId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int grade) {
        this.rating = grade;
    }

    public String getHardwareId() {
        return hardwareId;
    }

    public void setHardwareId(String hardwareId) {
        this.hardwareId = hardwareId;
    }
}
