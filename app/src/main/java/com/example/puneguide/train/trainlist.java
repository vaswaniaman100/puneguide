package com.example.puneguide.train;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;
import com.example.puneguide.database.Databaseaccess;

public class trainlist extends AppCompatActivity {

    Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainlist);

       String c = null;
        String b = null;
        Databaseaccess access = Databaseaccess.getInstance(getApplicationContext());
        access.open();
        final SQLiteDatabase db = access.open();
        Bundle bundle = getIntent().getExtras();
        final String source = bundle.getString("sourcestation");
        final String destination = bundle.getString("deststation");
        String a = "SELECT x.trainno,x.stname as 'source',x.depttime, y.stname as 'dest',y.arrivaltime,y.runningdate,x.name,x.stationcode,y.stationcode\n" +
                "FROM train x, train y\n" +
                "WHERE x.trainno = y.trainno And x.stname = '"+source+"' AND y.stname= '"+destination+"' AND x.seq<y.seq\n" +
                "order by x.depttime asc";
        final Cursor cursor = db.rawQuery(a, new String[]{});
        final Cursor cursor1 = db.rawQuery("select x.stname from tabledelete x, train y\n" +
                "where x.stationcode = y.stationcode and x.trainno=11039 And y.trainno=11039 And y.stname='"+source+"'", new String[]{});
        final Cursor cursor2 = db.rawQuery("select x.stname from tabledelete x, train y\n" +
                "where x.stationcode = y.stationcode and x.trainno=11039 And y.trainno=11039 And y.stname='"+destination+"'", new String[]{});
        if (cursor.getCount() == 0) {

        }
        else {
            while (cursor.moveToNext()) {

                LinearLayout layout = (LinearLayout) findViewById(R.id.trainlistlayout);

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
                trainname.setText(cursor.getString(6));
                trainname.setGravity(Gravity.CENTER_VERTICAL);
                trainname.setLayoutParams(textviewparams);


                final TextView trainfromto = new TextView(context);
                trainfromto.setText(cursor.getString(7) +" -> "+cursor.getString(8));
                trainfromto.setGravity(Gravity.END|Gravity.CENTER_VERTICAL);
                trainfromto.setLayoutParams(textviewparams);


               // part2

                LinearLayout part2= new LinearLayout(context);
                part2.addView(trainname,0);
                part2.addView(trainfromto,1);
                box.addView(part2,1,params);

                while (cursor1.moveToNext()) {
                    c=cursor1.getString(0);
                }


                while (cursor2.moveToNext()) {
                    b=cursor2.getString(0);
                }
                final String d=c;
                final String e=b;

                //  box
                box.setClickable(true);
                box.setBackgroundResource(R.drawable.ripple_effect);
                box.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, traintimings.class);
                        intent.putExtra("trainno", trainno.getText().toString());
                        intent.putExtra("trainname", trainname.getText().toString());
                        intent.putExtra("traindays", traindays.getText().toString());
                        intent.putExtra("source",d);
                        intent.putExtra("destination", e);

                        startActivity(intent);
                    }
                });
                params.height = 200;

                layout.addView(box,params);

            }



        }

    }
}
