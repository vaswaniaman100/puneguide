package com.example.puneguide.hospital;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;

public class hospitalarea extends AppCompatActivity {
    Context context=this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospitalarea);
        final Button shivajinagar = (Button)findViewById(R.id.shivajinagarhospital);

        shivajinagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, hospitallist.class);
                intent.putExtra("area","shivajinagar");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        final Button deccan = (Button)findViewById(R.id.deccanhospital);
deccan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, hospitallist.class);
                intent.putExtra("area","deccan");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        final Button fcroad = (Button)findViewById(R.id.fcroadhospital);

        fcroad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, hospitallist.class);
                intent.putExtra("area","fc road");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
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