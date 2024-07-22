package com.example.livestockweightandtempims.ui.query;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.livestockweightandtempims.MyApplication;
import com.example.livestockweightandtempims.dao.LivestockDao;
import com.example.livestockweightandtempims.entity.LivestockInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QueryViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    private LivestockDao livestockDao;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public QueryViewModel() {
        mText = new MutableLiveData<>();
        livestockDao = MyApplication.getInstance().getLivestockDB().livestockDao();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LivestockInfo queryLivestock(long id) {
        try {
            // 直接调用查询方法并返回结果
            return livestockDao.queryById(id);
        } catch (Exception e) {
            // 处理查询过程中可能发生的任何异常
            // 可以记录日志
            throw new RuntimeException("查询执行异常", e); // 重新抛出异常，方便调用者处理
        }
    }
}