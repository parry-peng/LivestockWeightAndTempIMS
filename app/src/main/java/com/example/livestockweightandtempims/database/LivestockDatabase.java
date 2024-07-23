package com.example.livestockweightandtempims.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.livestockweightandtempims.dao.ArchiveDao;
import com.example.livestockweightandtempims.dao.LivestockDao;
import com.example.livestockweightandtempims.dao.LivestockHealthDao;
import com.example.livestockweightandtempims.entity.LivestockHealthInfo;
import com.example.livestockweightandtempims.entity.LivestockInfo;
import com.example.livestockweightandtempims.entity.ArchiveInfo;

@Database(entities = {LivestockInfo.class, ArchiveInfo.class, LivestockHealthInfo.class}, version = 1, exportSchema = true)
public abstract class LivestockDatabase extends RoomDatabase {
    public abstract LivestockDao livestockDao();
    public abstract ArchiveDao archiveDao();
    public abstract LivestockHealthDao livestockHealthDao();
}
