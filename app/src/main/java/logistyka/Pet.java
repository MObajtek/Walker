package logistyka;

import android.graphics.Bitmap;

import java.util.concurrent.ThreadLocalRandom;

public class Pet {
    private Bitmap photo;
    private String name;
    private Integer age;
    private Integer activity; // od 1 do 5
    private String breed;
    private String info;
    private Long id;

    public Pet(Bitmap photo, String name, Integer age, Integer activity, String breed, String info, Long id) {
        this.photo = photo;
        this.name = name;
        this.age = age;
        this.activity = activity;
        this.breed = breed;
        this.info = info;
        this.id = id;
    }

}
