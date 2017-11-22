package com.android.spike.steven.experimental.ui.activity.lifecycles;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;

import com.android.spike.steven.experimental.ui.activity.lifecycles.cache.DataCache;

/**
 * Created by sfish on 11/18/17.
 */

public class LifecyclesViewModel extends ViewModel {

    private LiveData<String> firstNameLiveData = Transformations.switchMap(DataCache.getInstance().getFirstNameLiveData(),
            this::updateFirstNameData);

    public LiveData<String> firstNameField() {
        return firstNameLiveData;
    }

    public void updateFirstName(String newFirstName) {
        DataCache.getInstance().getFirstNameLiveData().setValue(newFirstName);
    }

    private LiveData<String> updateFirstNameData(String firstName) {
        if (firstName.equalsIgnoreCase("NullFace")) {
            return null;
        }

        MutableLiveData<String> newField = new MutableLiveData<>();

        if (firstName.equalsIgnoreCase("NothingFace")) {
            return newField;
        }

        Runnable dataCall = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                newField.postValue(firstName);
            }
        };

        new Thread(dataCall).start();
        return newField;
    }
}
