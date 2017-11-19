package com.android.spike.steven.experimental.ui.activity.menu;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by us53216 on 11/16/17.
 */

public class MenuItemTuple<T extends AppCompatActivity> {

    private final String activityName;
    private final Class<T> activityClass;

    public MenuItemTuple(final String activityName, Class<T> activityClass) {
        this.activityName = activityName;
        this.activityClass = activityClass;
    }

    public String getActivityName() {
        return activityName;
    }

    public Class<T> getActivityClass() {
        return activityClass;
    }
}
