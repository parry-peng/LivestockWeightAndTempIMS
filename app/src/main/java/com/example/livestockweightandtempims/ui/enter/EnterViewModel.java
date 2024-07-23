package com.example.livestockweightandtempims.ui.enter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.livestockweightandtempims.MyApplication;
import com.example.livestockweightandtempims.dao.ArchiveDao;
import com.example.livestockweightandtempims.dao.LivestockDao;
import com.example.livestockweightandtempims.database.LivestockDatabase;
import com.example.livestockweightandtempims.entity.ArchiveInfo;
import com.example.livestockweightandtempims.entity.LivestockInfo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;

public class EnterViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    private ArchiveDao archiveDao;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public EnterViewModel() {
        mText = new MutableLiveData<>();

        archiveDao = MyApplication.getInstance().getLivestockDB().archiveDao();
    }

    public LiveData<String> getText() {
        return mText;
    }
    public void insertArchive(ArchiveInfo entity) {
        // 直接调用insert方法，同步执行插入操作
        archiveDao.insert(entity);
    }
    public boolean existsArchive(long id) {
        try {
            // 直接调用查询方法并检查结果
            ArchiveInfo info = archiveDao.findById(id);
            // 如果查询结果不为null，则表示存在该记录，返回true
            return info != null;
        } catch (Exception e) {
            // 处理查询过程中可能发生的任何异常
            // 可以记录日志
            return false; // 由于发生异常，返回false表示查询未成功
        }
    }
}