package database;

import android.content.Context;

import androidx.room.Room;

public final class  DatabaseGetter {
    private static AppDatabase instance;

    private static AppDatabase createDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "database-name")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = createDatabase(context);
        }
        return instance;
    }
}