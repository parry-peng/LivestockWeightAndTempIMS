package com.example.livestockweightandtempims.ui.query;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.livestockweightandtempims.MyApplication;
import com.example.livestockweightandtempims.dao.LivestockDao;
import com.example.livestockweightandtempims.entity.LivestockInfo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QueryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private LivestockDao livestockDao;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    LivestockInfo query_result;

    public QueryViewModel() {
        mText = new MutableLiveData<>();

        livestockDao = MyApplication.getInstance().getLivestockDB().livestockDao();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void queryLivestock(long id) {
        // 使用 Callable 来异步执行查询并获取结果
        Callable<LivestockInfo> callable = () -> livestockDao.queryById(id);
        Future<LivestockInfo> future = executorService.submit(callable);

        // 调用 get 方法来获取查询结果，这个方法会阻塞直到结果可用
        try {
            query_result = future.get();
            // 处理结果
        } catch (InterruptedException | ExecutionException e) {
            // 处理异常
        }
    }
}