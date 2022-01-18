package logistyka;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Load {
//    String PATHNAME =

    public void loadErrand(String pathname) throws IOException, ParseException {
        DateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(pathname));

        line = reader.readLine();
        String[] parts;
        parts = line.split(":", 2);
        Date data = dataFormat.parse(parts[1]);

//        new Errand()
    }

    public Pet loadPet(String pathname, String animalID) throws IOException {
        StringBuilder path = new StringBuilder(pathname + animalID);
        Bitmap petPhoto = BitmapFactory.decodeFile(path + ".jpg");

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(path + ".txt"));

        line = reader.readLine();
        String[] parts;
        parts = line.split(":", 2);
        String petName = parts[1];

        line = reader.readLine();
        parts = line.split(":", 2);
        String petBreed = parts[1];

        line = reader.readLine();
        parts = line.split(":", 2);
        Integer petAge = Integer.parseInt(parts[1]);

        line = reader.readLine();
        parts = line.split(":", 2);
        Integer petActivity = Integer.parseInt(parts[1]);

        line = reader.readLine();
        parts = line.split(":", 2);
        String petInfo = parts[1];

        return new Pet(petPhoto,petName,petAge,petActivity,petBreed,petInfo);
    }
}
