package database;

import android.net.Uri;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = Owner.class,
        parentColumns = "uid",
        childColumns = "owner_uid",
        onDelete = ForeignKey.CASCADE)})

public class Pet {
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "owner_uid", index = true)
    public int ownerUid;

    @ColumnInfo(name = "pet_name")
    public String petName;

    @ColumnInfo(name = "pet_breed")
    public String petBreed;

    @ColumnInfo(name = "pet_age")
    public Integer petAge;

    @ColumnInfo(name = "pet_activity")
    public Integer petActivity;

    @ColumnInfo(name = "pet_info")
    public String petInfo;

    @ColumnInfo(name = "pet_uri")
    public Uri petUri;


    @Override
    public String toString() {
        return "Pet{" +
                "uid=" + uid +
                ", ownerUid=" + ownerUid +
                ", petName='" + petName + '\'' +
                ", petBreed='" + petBreed + '\'' +
                ", petAge=" + petAge +
                ", petActivity=" + petActivity +
                ", petInfo='" + petInfo + '\'' +
                ", petUri=" + petUri +
                '}';
    }
}