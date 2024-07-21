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

    public QueryViewModel() {
        mText = new MutableLiveData<>();
        livestockDao = MyApplication.getInstance().getLivestockDB().livestockDao();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LivestockInfo queryLivestock(long id) {
        try {
            Callable<LivestockInfo> callable = () -> livestockDao.queryById(id);
            Future<LivestockInfo> future = executorService.submit(callable);
            return future.get(); // 这里会阻塞直到结果返回
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 保持中断状态
            // 可以记录日志或者重新抛出异常
            throw new RuntimeException("查询被中断", e);
        } catch (ExecutionException e) {
            // 处理查询过程中的异常
            // 可以记录日志或者根据异常类型进行更具体的处理
            throw new RuntimeException("查询执行异常", e);
        }
    }
}