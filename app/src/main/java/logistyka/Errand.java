package logistyka;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Errand {
    private Date data;
    private Boolean state; // 1 dla aktywnego, 0 dla archiwalnego
    private Integer petID;


    public Errand() throws ParseException, IOException {

    }
}
