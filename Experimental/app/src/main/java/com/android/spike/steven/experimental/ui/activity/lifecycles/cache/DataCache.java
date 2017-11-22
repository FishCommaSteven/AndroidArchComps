package com.android.spike.steven.experimental.ui.activity.lifecycles.cache;

import android.arch.lifecycle.MutableLiveData;

/**
 * Created by sfish on 11/18/17.
 */

public class DataCache {
    private static DataCache instance = new DataCache();

    MutableLiveData<String> firstNameLiveData = new MutableLiveData<>();

    public static DataCache getInstance() {
        return instance;
    }

    public MutableLiveData<String> getFirstNameLiveData() {
        return firstNameLiveData;
    }
}
