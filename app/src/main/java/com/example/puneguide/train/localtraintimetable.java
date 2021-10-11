package com.example.puneguide.train;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;

public class localtraintimetable extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localtraintimetable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
