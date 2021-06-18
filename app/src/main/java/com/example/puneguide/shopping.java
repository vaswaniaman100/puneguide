package com.example.puneguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class shopping extends AppCompatActivity {
    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping);
        final Button shoppingmarketarea = (Button) findViewById(R.id.shoppingmarketarea);
        shoppingmarketarea.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, shoppingmarketlist.class);
                intent.putExtra("area","shivajinagar");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        final Button mallslist = (Button) findViewById(R.id.shoppingmalls);
        mallslist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, mallslist.class);
                intent.putExtra("area","shivajinagar");
                //Toast.makeText(getApplicationContext(),shivajinagar.getText().toString(),Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}
