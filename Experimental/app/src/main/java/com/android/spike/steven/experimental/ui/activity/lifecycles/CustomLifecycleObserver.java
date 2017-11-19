package com.android.spike.steven.experimental.ui.activity.lifecycles;

import android.arch.lifecycle.DefaultLifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by us53216 on 11/16/17.
 */

public class CustomLifecycleObserver implements DefaultLifecycleObserver {
    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        logOutStuff("onCreate");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        logOutStuff("onStart");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        logOutStuff("onResume");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        logOutStuff("onPause");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        logOutStuff("onStop");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        logOutStuff("onDestroy");
        owner.getLifecycle().removeObserver(this);
    }

    private void logOutStuff(String method) {
        Log.d("TRACE_APP", "CustomLifecycleObserver: " + method);
    }
}
