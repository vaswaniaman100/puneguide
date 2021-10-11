package com.example.puneguide.transport;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;

public class transport extends AppCompatActivity {

    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transport);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Button transportcab = (Button)findViewById(R.id.cab);

        transportcab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, transportcab.class);
                startActivity(intent);
            }
        });
        final Button transportrickshaw = (Button)findViewById(R.id.rickshaw);
        transportrickshaw.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, transportrickshaw.class);
                startActivity(intent);

            }
        });
        final Button transportbus= (Button)findViewById(R.id.bus);

        transportbus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, transportbus.class);
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
