package database;

import android.net.Uri;

import androidx.room.TypeConverter;

public class Converters {
    @TypeConverter
    public static Uri StringToUri(String string) {
        return Uri.parse(string);
    }

    @TypeConverter
    public static String UriToString(Uri uri) {
        return uri.toString();
    }
}
