
package com.kathir.holyday.home;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kathir.holyday.R;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeScreen extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private NavController navigationController;

    @BindView(R.id.bottom_navigation)
    BottomNavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        ButterKnife.bind(this);
        NavHostFragment hostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        navigationController = hostFragment.getNavController();
        mNavigationView.setOnNavigationItemSelectedListener(this);
        navigationController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId()==R.id.menu)
            navigationController.navigate(R.id.homeFragment);
        else  if(menuItem.getItemId()==R.id.post)
            navigationController.navigate(R.id.postfragment);
        else  if(menuItem.getItemId()==R.id.event)
            navigationController.navigate(R.id.keygenerate);
        else  if(menuItem.getItemId()==R.id.more)
            navigationController.navigate(R.id.settingfragment);
        return false;
    }
}
