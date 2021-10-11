package com.example.puneguide.bus;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;
import com.example.puneguide.database.Databaseaccess;
import com.example.puneguide.main.AutoSuggestAdapter;

import java.util.ArrayList;

public class busbetweenstands extends AppCompatActivity {

    Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busbetweenstands);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final ArrayList<String> stations = new ArrayList<String>();
        Databaseaccess access = Databaseaccess.getInstance(getApplicationContext());
        access.open();
        SQLiteDatabase db = access.open();
        String a = "select busstopnames from busstops";
        Cursor cursor = db.rawQuery(a, new String[]{});
        if (cursor.getCount() == 0) {

        }
        else {
            while (cursor.moveToNext()) {
                stations.add(cursor.getString(0));
            }
        }
        final AutoSuggestAdapter adapter = new AutoSuggestAdapter(this,android.R.layout.select_dialog_item,stations);
        final AutoCompleteTextView sourcestation =  (AutoCompleteTextView)findViewById(R.id.sourcestop);
        sourcestation.setThreshold(3);
        sourcestation.setAdapter(adapter);
        sourcestation.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                     String  a= sourcestation.getText().toString();
                     if(!stations.contains(a)) {
                            Toast.makeText(getApplicationContext(),"check source stand",Toast.LENGTH_SHORT).show();
                      }
                }
            }
        });
        final AutoCompleteTextView desitnationstation =  (AutoCompleteTextView)findViewById(R.id.destinationstop);
        desitnationstation.setThreshold(3);
        desitnationstation.setAdapter(adapter);
        desitnationstation.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    String  a= desitnationstation.getText().toString();
                    if(!stations.contains(a)) {
                        Toast.makeText(getApplicationContext(),"check destination stop",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Button trainsearch = (Button)findViewById(R.id.bussearch);
        trainsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, buslist.class);
                intent.putExtra("sourcestation", sourcestation.getText().toString());
                intent.putExtra("deststation", desitnationstation.getText().toString());
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
