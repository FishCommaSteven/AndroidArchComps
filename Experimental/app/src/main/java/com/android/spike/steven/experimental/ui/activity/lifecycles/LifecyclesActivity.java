package com.android.spike.steven.experimental.ui.activity.lifecycles;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.android.spike.steven.experimental.R;
import com.android.spike.steven.experimental.archcomps.ObserveUnlessInterface;
import com.android.spike.steven.experimental.archcomps.PremeraMutableLiveData;

public class LifecyclesActivity extends AppCompatActivity {

    Button updateButton;
    LifecyclesViewModel viewModel;
    EditText firstNameInputField;
    TextView firstNameField;

    Observer<String> firstNameObserver = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String firstName) {
            firstNameField.setText(firstName);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logStuff("onCreate");
        setContentView(R.layout.activity_lifecycles);
        CustomLifecycleObserver customLifecycleObserver = new CustomLifecycleObserver();
        getLifecycle().addObserver(customLifecycleObserver);

        viewModel = ViewModelProviders.of(this).get(LifecyclesViewModel.class);
        viewModel.firstNameField().observe(this, firstNameObserver);

        firstNameInputField = findViewById(R.id.firstname_input);
        firstNameField = findViewById(R.id.firstname_output);

        updateButton = findViewById(R.id.update_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.updateFirstName(firstNameInputField.getText().toString());
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
