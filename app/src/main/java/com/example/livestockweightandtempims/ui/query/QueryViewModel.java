package com.example.livestockweightandtempims.ui.query;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class QueryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public QueryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is 查询 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}