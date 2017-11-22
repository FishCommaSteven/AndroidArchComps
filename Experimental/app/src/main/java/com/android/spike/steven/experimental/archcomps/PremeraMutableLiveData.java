package com.android.spike.steven.experimental.archcomps;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


/**
 * Created by us53216 on 11/16/17.
 */

public class PremeraMutableLiveData<T> extends MutableLiveData<T> {

    public void observe(@NonNull LifecycleOwner owner, @NonNull final Observer<T> observer, final ObserveUnlessInterface observeUnless) {
        Observer<T> wrapperObserver = new Observer<T>() {
            @Override
            public void onChanged(@Nullable T thing) {
                if (!observeUnless.unlessTrue(thing)) {
                    observer.onChanged(thing);
                }
            }
        };

        observe(owner, wrapperObserver);
    }

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<T> observer) {
        super.observe(owner, observer);
    }
}
