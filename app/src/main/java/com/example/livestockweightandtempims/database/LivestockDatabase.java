package com.example.livestockweightandtempims.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.livestockweightandtempims.dao.LivestockDao;
import com.example.livestockweightandtempims.entity.LivestockInfo;

@Database(entities = {LivestockInfo.class}, version = 1, exportSchema = true)
public abstract class LivestockDatabase extends RoomDatabase {
    public abstract LivestockDao livestockDao();
}
