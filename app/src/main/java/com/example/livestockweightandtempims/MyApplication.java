package com.example.livestockweightandtempims;

import android.app.Application;
import androidx.room.Room;

import com.example.livestockweightandtempims.database.LivestockDatabase;

public class MyApplication extends Application {
    private static MyApplication mApp;
    private LivestockDatabase livestockDatabase;
    public static MyApplication getInstance() {
        return mApp;
    }
    public LivestockDatabase getLivestockDB() {
        return livestockDatabase;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;

        livestockDatabase = Room.databaseBuilder(this, LivestockDatabase.class, "livestock")
                // 允许迁移数据库（发生数据库变更时，Room默认删除原数据库再创建新数据库。如此一来原来的记录会丢失，故而要改为迁移方式以便保存原有记录）
                .addMigrations()
                // 允许在主线程中操作数据库（Room默认不能在主线程中操作数据库）
                .allowMainThreadQueries()
                .build();
    }
}
