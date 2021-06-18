package com.example.puneguide.hostel;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.database.Databaseaccess;
import com.example.puneguide.R;

public class hostellist extends AppCompatActivity {

    Context context = this;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hostellist);
        Databaseaccess access = Databaseaccess.getInstance(getApplicationContext());
        access.open();
        final SQLiteDatabase db = access.open();
        Bundle bundle = getIntent().getExtras();
        final String area = bundle.getString("area");

        Toast.makeText(getApplicationContext(), area, Toast.LENGTH_SHORT).show();
        String a = "select name from hostels where area = " + "'" + area + "'";

        // db.execSQL("select * from hospitallist");/*
        int id =0;
        final Cursor cursor = db.rawQuery(a, new String[]{});
        if (cursor.getCount() == 0) {

        } else {
            while (cursor.moveToNext()) {
                final Button name1;
                name1 = new Button(this);

                name1.setText(cursor.getString(0));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                params.setMargins(-4, -6, -4, -14);
                params.height = 200;
                LinearLayout layout = (LinearLayout) findViewById(R.id.hostellinear);


                name1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, hosteldata.class);
                        intent.putExtra("name", name1.getText().toString());
                        intent.putExtra("area", area);
                        cursor.close();
                        db.close();

                        startActivity(intent);
                    }
                });

                layout.addView(name1, params);



            }
        }
        db.close();


    }

}
