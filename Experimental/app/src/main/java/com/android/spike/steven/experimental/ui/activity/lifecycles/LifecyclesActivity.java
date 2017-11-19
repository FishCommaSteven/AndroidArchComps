package com.android.spike.steven.experimental.ui.activity.lifecycles;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.spike.steven.experimental.R;
import com.android.spike.steven.experimental.archcomps.PremeraMutableLiveData;

public class LifecyclesActivity extends AppCompatActivity {

    PremeraMutableLiveData<String> pmld = new PremeraMutableLiveData<>();

    Observer<String> observer = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String s) {
            Log.d("TRACE_APP", "onChanged: " + s);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logStuff("onCreate");
        setContentView(R.layout.activity_lifecycles);
        CustomLifecycleObserver customLifecycleObserver = new CustomLifecycleObserver();
        getLifecycle().addObserver(customLifecycleObserver);

        pmld.observe(this, observer, new PremeraMutableLiveData.ObserveUnlessInterface() {
            @Override
            public <String> boolean unlessTrue(String result) {
                return result == "Steven";
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        logStuff("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        logStuff("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        logStuff("onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        logStuff("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        logStuff("onResume");
    }

    private void logStuff(String name) {
        Log.d("TRACE_APP", this.getLocalClassName() + ": " + name);
    }
}
