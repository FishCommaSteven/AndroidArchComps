package com.android.spike.steven.experimental.ui.activity.menu;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.spike.steven.experimental.R;
import com.android.spike.steven.experimental.ui.activity.lifecycles.LifecyclesActivity;

public class MenuActivity extends AppCompatActivity
        implements MenuItemSelectedInterface {

    RecyclerView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu = findViewById(R.id.menu_list);
        MenuAdapter adapter = new MenuAdapter(this);
        menu.setAdapter(adapter);
        menu.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemSelected(MenuItemTuple<?> selectedItem) {
        startSelectedActivity(selectedItem);
    }

    private void startSelectedActivity(final MenuItemTuple<?> menuItem) {
        Intent intent = new Intent(this, menuItem.getActivityClass());
        startActivity(intent);
    }


    private MenuItemTuple[] createMenuList() {
        MenuItemTuple[] activityList = {new MenuItemTuple("Lifecycles", LifecyclesActivity.class)};
        return activityList;
    }

    public class MenuAdapter extends RecyclerView.Adapter<MenuItemView> {

        private MenuItemTuple[] menuItemTuples;
        private MenuItemSelectedInterface menuItemSelectedInterface;

        public MenuAdapter(MenuItemSelectedInterface menuItemSelectedInterface) {
            menuItemTuples = createMenuList();
            this.menuItemSelectedInterface = menuItemSelectedInterface;
        }

        @Override
        public MenuItemView onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
            MenuItemView menuItemView = new MenuItemView(view);
            return menuItemView;
        }

        @Override
        public void onBindViewHolder(MenuItemView holder, int position) {
            holder.init(menuItemTuples[position], menuItemSelectedInterface);
        }

        @Override
        public int getItemCount() {
            return menuItemTuples.length;
        }
    }
}
