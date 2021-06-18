package com.example.puneguide.train;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

        final Button trainbetweenstation = (Button)findViewById(R.id.trainbetweenstations);

        trainbetweenstation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, trainbetweenstations.class);
                startActivity(intent);
            }

        });
    }
}
