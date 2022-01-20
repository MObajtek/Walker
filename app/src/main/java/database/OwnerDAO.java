package database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OwnerDAO {
    @Query("SELECT * FROM owner")
    List<Owner> getAll();

    @Query("SELECT * FROM owner WHERE uid IN (:ownerIds)")
    List<Owner> loadAllByIds(int[] ownerIds);

    @Query("SELECT * FROM owner WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    Owner findByName(String first, String last);

    @Insert
    void insertAll(Owner... users);

    @Delete
    void delete(Owner user);
}
