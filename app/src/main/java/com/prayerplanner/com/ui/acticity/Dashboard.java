package com.prayerplanner.com.ui.acticity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;

import com.prayerplanner.com.R;
import com.prayerplanner.com.adapter.AdapterRecycler;
import com.prayerplanner.com.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {


    NavController mNavController;
    NavOptions navOptions;
    private ActivityDashboardBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDashboardBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.nav_host_fragment);
//
//        if (navHostFragment != null) {
//            mNavController = navHostFragment.getNavController();
//        }
//
////        navOptions = new NavOptions.Builder()
////                .setLaunchSingleTop(true)
////                .setPopUpTo(mNavController.getGraph().getStartDestination(), false)
////                .build();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}