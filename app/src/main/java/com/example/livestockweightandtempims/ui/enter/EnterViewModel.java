package com.example.livestockweightandtempims.ui.enter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EnterViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EnterViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is 数据录入 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}