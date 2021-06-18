package com.example.puneguide.college;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;
import com.example.puneguide.database.Databaseaccess;

public class collegelist extends AppCompatActivity {

    Context context = this;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collegelist);
        Databaseaccess access = Databaseaccess.getInstance(getApplicationContext());
        access.open();
        final SQLiteDatabase db = access.open();
        Bundle bundle = getIntent().getExtras();
        final String area = bundle.getString("area");

        Toast.makeText(getApplicationContext(), area, Toast.LENGTH_SHORT).show();
        String a = "select name from colleges where area = " + "'" + area + "'";
        // db.execSQL("select * from hospitallist");/*
        int id =0;
        final Cursor cursor = db.rawQuery(a, new String[]{});
        if (cursor.getCount() == 0) {

        } else {
            while (cursor.moveToNext()) {
                final Button name;
                name = new Button(this);
                name.setId(id+1);
                name.setText(cursor.getString(0));

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                params.setMargins(-4, -6, -4, -14);
                params.width= ViewGroup.LayoutParams.MATCH_PARENT;
                params.height = 200;
                LinearLayout layout = (LinearLayout) findViewById(R.id.collegelinear);
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(context, collegedata.class);
                        intent.putExtra("name", name.getText().toString());
                        intent.putExtra("area", area);
                        cursor.close();
                        db.close();

                        startActivity(intent);
                    }
                });
                layout.addView(name, params);




            }
        }
        db.close();


    }

}
