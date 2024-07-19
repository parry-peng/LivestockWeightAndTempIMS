package com.example.livestockweightandtempims.ui.enter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.livestockweightandtempims.MyApplication;
import com.example.livestockweightandtempims.dao.LivestockDao;
import com.example.livestockweightandtempims.database.LivestockDatabase;
import com.example.livestockweightandtempims.entity.LivestockInfo;

public class EnterViewModel extends ViewModel {
    private final MutableLiveData<String> mText;
    private LivestockDao livestockDao;

    public EnterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is 数据录入 fragment");

        livestockDao = MyApplication.getInstance().getLivestockDB().livestockDao();
    }

    public LiveData<String> getText() {
        return mText;
    }
    public void insertLivestock(LivestockInfo entity) {
        new Thread(() -> {
            livestockDao.insert(entity);
        }).start();
    }
}