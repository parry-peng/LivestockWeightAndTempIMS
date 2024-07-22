package com.example.livestockweightandtempims.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.livestockweightandtempims.entity.LivestockFullInfo;

import java.util.List;

@Dao
public interface LivestockFullDao {
    @Insert
    void insert(LivestockFullInfo... LivestockFull);
    @Query("DELETE FROM LivestockFullInfo WHERE id = :id")
    void deleteById(long id);
    @Delete
    void delete(LivestockFullInfo... LivestockFull);
    @Query("DELETE FROM LivestockFullInfo")
    void deleteAll();
    @Query("SELECT * FROM LivestockFullInfo WHERE id = :id")
    LivestockFullInfo queryById(long id);
    @Query("SELECT * FROM LivestockFullInfo")
    List<LivestockFullInfo> queryAll();
}
