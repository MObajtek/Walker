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

    public Pet(Bitmap photo, String name, Integer age, Integer activity, String breed, String info) {
        this.photo = photo;
        this.name = name;
        this.age = age;
        this.activity = activity;
        this.breed = breed;
        this.info = info;
    }

    // Tworzy 8-cyfrowy petID, oparty na losowej liczbie i imieniu zwierzaka
    // TODO: czy ta metoda powinna być tutaj?
    public Long createPetID(Pet pet){
        int min = 100000;
        int max = 999999;
        int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        // TODO: podmienic na pobieranie imienia
        String str = "Pufek";
        double prod = 1d;
        Long id;

        System.out.println(randomNum);

        char[] ch = new char[str.length()];
        int[] vals = new int[str.length()];

        // Copy character by character into array
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
            vals[i] = ch[i];
        }

        for (char c : ch) {
            System.out.println(c);
        }
        for (int c : vals) {
            System.out.println(c);
            prod = prod * c;
        }

        id = Math.round( (randomNum*prod) / 100000000d);
        return id;
    }
}
