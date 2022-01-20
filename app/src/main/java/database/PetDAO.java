package database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PetDAO {
    @Query("SELECT * FROM pet")
    List<Pet> getAll();

    @Query("SELECT * FROM pet WHERE uid IN (:petIds)")
    List<Pet> loadAllByIds(int[] petIds);

    @Query("SELECT * FROM pet WHERE pet_name LIKE :petName LIMIT 1")
    Pet findByName(String petName);

    @Insert
    void insertAll(Pet... pets);

    @Delete
    void delete(Pet pet);
}
