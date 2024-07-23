package com.example.livestockweightandtempims.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.livestockweightandtempims.entity.ArchiveInfo;

import java.util.List;

@Dao
public interface ArchiveDao {
    @Insert
    void insert(ArchiveInfo... archiveInfo);
    @Update
    void update(ArchiveInfo... archiveInfo);
    @Delete
    void delete(ArchiveInfo... archiveInfo);
    @Query("SELECT * FROM ArchiveInfo WHERE id = :id")
    ArchiveInfo findById(long id);
    @Query("SELECT * FROM ArchiveInfo")
    List<ArchiveInfo> getAll();
}
