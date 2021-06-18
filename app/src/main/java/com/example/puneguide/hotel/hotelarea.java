package com.example.puneguide.hotel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;

public class hotelarea extends AppCompatActivity {
    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelarea);
        final Button shivajinagar = (Button)findViewById(R.id.shivajinagarhotel);

        shivajinagar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, hotellist.class);
                intent.putExtra("area","shivajinagar");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        final Button deccan = (Button)findViewById(R.id.deccanhotel);
        deccan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, hotellist.class);
                intent.putExtra("area","deccan");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        final Button fcroad = (Button)findViewById(R.id.fcroadhotel);

        fcroad.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, hotellist.class);
                intent.putExtra("area","fc road");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }
}
