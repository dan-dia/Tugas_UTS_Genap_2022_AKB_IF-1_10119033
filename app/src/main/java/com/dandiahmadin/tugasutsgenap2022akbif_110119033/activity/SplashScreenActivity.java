package com.dandiahmadin.tugasutsgenap2022akbif_110119033.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.dandiahmadin.tugasutsgenap2022akbif_110119033.MainActivity;
import com.dandiahmadin.tugasutsgenap2022akbif_110119033.R;
//NIM 10119033
//Nama Dandi Ahmadin
//Kelas IF-1
public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash_screen = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(splash_screen);
                finish();
            }
        }, 1000);

    }
}