

import java.io.Serializable;

public class Movies implements Serializable{
    private Long id;
    private String name;
    private String duration;
    private String rating;
    private int price;
    private int count;

    public Movies(Long id, String name, String duration, String rating, int price, int count) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.rating = rating;
        this.price = price;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
