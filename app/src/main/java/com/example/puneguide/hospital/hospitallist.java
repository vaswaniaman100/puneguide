package com.example.puneguide.hospital;

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


public class hospitallist extends AppCompatActivity {

    Context context = this;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hospitallist);
        Databaseaccess access = Databaseaccess.getInstance(getApplicationContext());
        access.open();
        SQLiteDatabase db = access.open();
        Bundle bundle = getIntent().getExtras();
        final String area = bundle.getString("area");

        Toast.makeText(getApplicationContext(), area, Toast.LENGTH_SHORT).show();
        String a = "select name from hospitals where area = " + "'" + area + "'";
        // db.execSQL("select * from hospitallist");/*
        Cursor cursor = db.rawQuery(a, new String[]{});
        if (cursor.getCount() == 0) {

        } else {
            while (cursor.moveToNext()) {
                final Button name;
                 name = new Button(this);

                name.setText(cursor.getString(0));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                params.setMargins(-4, -6, -4, -14);
                params.height = 200;
                LinearLayout layout = (LinearLayout) findViewById(R.id.hospitallinear);
                layout.addView(name, params);
                name.setCompoundDrawablesWithIntrinsicBounds(R.drawable.common_google_signin_btn_icon_dark_focused, 0, 0, 0);
                name.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, hospitaldata.class);
                        intent.putExtra("name", name.getText().toString());
                        intent.putExtra("area", area);
                        startActivity(intent);
                    }
                });




            }
        }
        db.close();


    }

}
