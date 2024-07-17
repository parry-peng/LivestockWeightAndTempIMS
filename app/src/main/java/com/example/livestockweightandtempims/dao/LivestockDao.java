package com.example.livestockweightandtempims.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.livestockweightandtempims.entity.LivestockInfo;

import java.util.List;

@Dao
public interface LivestockDao {
    @Insert
    void insert(LivestockInfo... Livestock);

    @Delete
    void delete(LivestockInfo... Livestock);

    // 删除所有牲畜信息
    @Query("DELETE FROM LivestockInfo")
    void deleteAll();

    @Update
    int update(LivestockInfo... Livestock);

    // 加载所有牲畜信息
    @Query("SELECT * FROM LivestockInfo")
    List<LivestockInfo> queryAll();

}
