package com.example.puneguide.train;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;

public class traintype extends AppCompatActivity {

Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traintype);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Button trainbetweenstation = (Button)findViewById(R.id.trainbetweenstations);

        trainbetweenstation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, trainbetweenstations.class);
                startActivity(intent);
            }

        });
        final Button localtrain = (Button)findViewById(R.id.localtraintimetable);

        localtrain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, localtraintimetable.class);
                startActivity(intent);
            }

        });
    }
    public boolean onOptionsItemSelected (MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
}
