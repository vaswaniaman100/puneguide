package com.example.puneguide.bus;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;
import com.example.puneguide.database.Databaseaccess;

public class buslist extends AppCompatActivity {

    Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buslist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       String c = null;
        String b = null;
        Databaseaccess access = Databaseaccess.getInstance(getApplicationContext());
        access.open();
        final SQLiteDatabase db = access.open();
        Bundle bundle = getIntent().getExtras();
        final String source = bundle.getString("sourcestation");
        final String destination = bundle.getString("deststation");
        String a = "SELECT  x.Busno,x.Busstopname as 'source',x.DepTime, y.Busstopname as 'dest',y.ArrivalTime,y.Serviceid,x.Busname\n" +
                "                FROM bus x, bus y\n" +
                "                WHERE x.Busname = y.Busname And x.Busstopname = '"+source+"' AND y.Busstopname= '"+destination+"' AND x.Seq<y.Seq\n" +
                "                order by x.DepTime asc";
        final Cursor cursor = db.rawQuery(a, new String[]{});

        if (cursor.getCount() == 0) {

        }
        else {
            while (cursor.moveToNext()) {

                LinearLayout layout = (LinearLayout) findViewById(R.id.buslistlayout);

                //  params
                final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);


                //  box
                final LinearLayout box = new LinearLayout(context);
                box.setLayoutParams(params);
                box.setOrientation(LinearLayout.VERTICAL);

                //   part1
                LinearLayout part1= new LinearLayout(context);
                params.width=LinearLayout.LayoutParams.MATCH_PARENT;
                params.height = 100;
                part1.setLayoutParams(params);


                LinearLayout.LayoutParams textviewparams =  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
                textviewparams.weight = 1;

                // train no
                final TextView trainno = new TextView(context);
                trainno.setText(cursor.getString(0));
                trainno.setGravity(Gravity.CENTER_VERTICAL);

                trainno.setLayoutParams(textviewparams);
               part1.addView(trainno,0);

               // train time
              final TextView traintime = new TextView(context);
               traintime.setText(cursor.getString(2)+"  ->  "+cursor.getString(4));
                traintime.setGravity(Gravity.CENTER);
                traintime.setLayoutParams(textviewparams);
                part1.addView(traintime,1);

                //train running days
                final TextView traindays = new TextView(context);
                traindays.setText(cursor.getString(5));
                traindays.setGravity(Gravity.CENTER_VERTICAL);
                traindays.setGravity(Gravity.END|Gravity.CENTER_VERTICAL);
                traindays.setLayoutParams(textviewparams);
                part1.addView(traindays,2);


                params.width = LinearLayout.LayoutParams.MATCH_PARENT;
                params.height=100;
                params.weight=1;


                box.addView(part1,0,params);

                final TextView trainname = new TextView(context);
                trainname.setText(cursor.getString(6).substring(0, cursor.getString(6).length() - 7));

                trainname.setGravity(Gravity.CENTER_VERTICAL);
                trainname.setLayoutParams(textviewparams);
                trainname.setTextSize(10);
                final String result = cursor.getString(6);





               // part2

                LinearLayout part2= new LinearLayout(context);
                part2.addView(trainname);

                box.addView(part2,1,params);


                final String d=c;
                final String e=b;

                //  box
                box.setClickable(true);
                box.setBackgroundResource(R.drawable.ripple_effect);
               box.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, bustimings.class);
                        intent.putExtra("trainno", trainno.getText().toString());
                        intent.putExtra("trainname", result);
                        intent.putExtra("traindays", traindays.getText().toString());
                        intent.putExtra("source",source);
                        intent.putExtra("destination", destination);

                        startActivity(intent);
                    }
                });
                params.height = 200;
                params.setMargins(0,7,0,0);

                layout.addView(box,params);

            }



        }

    }
    public boolean onOptionsItemSelected (MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return false;
    }
}
