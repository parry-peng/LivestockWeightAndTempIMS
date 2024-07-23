package com.example.livestockweightandtempims.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.livestockweightandtempims.entity.LivestockHealthInfo;

import java.util.List;

@Dao
public interface LivestockHealthDao {
    @Insert
    void insert(LivestockHealthInfo... livestockHealthInfo);
    @Update
    void update(LivestockHealthInfo... livestockHealthInfo);
    @Delete
    void delete(LivestockHealthInfo... livestockHealthInfo);
    // 根据id删除LivestockHealthInfo记录
    @Query("DELETE FROM livestockHealthInfo WHERE id = :id")
    void deleteById(long id);
    @Query("SELECT * FROM livestockHealthInfo WHERE id = :id")
    List<LivestockHealthInfo> findById(long id);
    @Query("SELECT * FROM livestockHealthInfo")
    List<LivestockHealthInfo> getAll();
}
