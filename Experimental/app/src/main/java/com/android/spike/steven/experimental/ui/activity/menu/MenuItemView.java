package com.android.spike.steven.experimental.ui.activity.menu;

import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.spike.steven.experimental.R;

/**
 * Created by us53216 on 11/16/17.
 */

public class MenuItemView extends RecyclerView.ViewHolder {

    TextView activityName;
    RelativeLayout viewRoot;

    public MenuItemView(View itemView) {
        super(itemView);
        activityName = itemView.findViewById(R.id.activity_name);
        viewRoot = itemView.findViewById(R.id.menu_item_root);
    }

    public void init(final MenuItemTuple<?> menuItemTuple,
                     final MenuItemSelectedInterface itemSelectedCallback) {

        activityName.setText(menuItemTuple.getActivityName());
        viewRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemSelectedCallback.onItemSelected(menuItemTuple);
            }
        });
    }
}
