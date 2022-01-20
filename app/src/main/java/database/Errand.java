package database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(foreignKeys = {@ForeignKey(entity = Pet.class,
        parentColumns = "uid",
        childColumns = "petID",
        onDelete = ForeignKey.CASCADE)})

public class Errand {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "errand_date")
    public Date errandDate;

    @ColumnInfo(name = "errand_state")
    public Boolean errandState;

    @ColumnInfo(name = "pet_ID")
    public int petID;


}