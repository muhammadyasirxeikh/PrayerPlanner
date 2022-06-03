package com.prayerplanner.com.ui.acticity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.prayerplanner.com.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Handler handler = new Handler();



        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.removeCallbacks(this);


                    Intent intent=new Intent(Splash.this, Dashboard.class);
                    startActivity(intent);
                    finish();




            }
        }, 3000);
    }
}