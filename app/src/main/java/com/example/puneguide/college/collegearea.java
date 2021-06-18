package com.example.puneguide.college;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;

public class collegearea extends AppCompatActivity {
    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collegearea);
        final Button shivajinagar = (Button)findViewById(R.id.shivajinagarcollege);

        shivajinagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, collegelist.class);
                intent.putExtra("area","shivajinagar");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        final Button deccan = (Button)findViewById(R.id.deccancollege);
        deccan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, collegelist.class);
                intent.putExtra("area","deccan");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        final Button fcroad = (Button)findViewById(R.id.fcroadcollege);

        fcroad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, collegelist.class);
                intent.putExtra("area","fc road");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}