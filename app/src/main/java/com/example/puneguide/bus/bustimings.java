package com.example.puneguide.bus;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;
import com.example.puneguide.database.Databaseaccess;

public class bustimings extends AppCompatActivity {

    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bustimings);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle bundle = getIntent().getExtras();
        String trainno = bundle.getString("trainno");
        String trainname = bundle.getString("trainname");
        String traindays = bundle.getString("traindays");
        String source = bundle.getString("source");
        String destination = bundle.getString("destination");


        // train no
        final TextView trainno1 = (TextView)findViewById(R.id.busnooftime);
        trainno1.setText("Bus no: "+trainno);


        final TextView traindays1 = (TextView)findViewById(R.id.busdaysoftime);
        traindays1.setText("Runs: "+traindays);

        Databaseaccess access = Databaseaccess.getInstance(getApplicationContext());
        access.open();
        SQLiteDatabase db = access.open();
        String a = "select ArrivalTime,Busstopname,DepTime from bus \n" +
                "where Busname =  '"+trainname+"' AND \n" +
                "seq>= (select seq from bus where Busname =  '"+trainname+"' AND Busstopname ='"+source+"')\n" +
                "AND        seq<=     (select seq from bus where Busname =  '"+trainname+"' AND Busstopname ='"+destination+"')\n";
        Cursor cursor = db.rawQuery(a, new String[]{});
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(),trainno+destination,Toast.LENGTH_SHORT).show();
        }
        else {
            while (cursor.moveToNext()) {



                LinearLayout layout = (LinearLayout) findViewById(R.id.bustimingslayout);

                //  params
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
                );


                LinearLayout part1= new LinearLayout(context);
                params.width=LinearLayout.LayoutParams.MATCH_PARENT;
                params.height = 100;
                part1.setOrientation(LinearLayout.HORIZONTAL);
                part1.setLayoutParams(params);



                LinearLayout.LayoutParams textviewparams =  new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT, 1f);
                textviewparams.weight = 1;

                // timeleft
                final TextView timeleft = new TextView(context);
                timeleft.setText(cursor.getString(0));
                timeleft.setGravity(Gravity.CENTER_VERTICAL);

              // Toast.makeText(getApplicationContext(),timeleft.getText(),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),source,Toast.LENGTH_SHORT).show();

                timeleft.setLayoutParams(textviewparams);
                part1.addView(timeleft,0);

                // train time
                final TextView stationname = new TextView(context);
                stationname.setText(cursor.getString(1));
                stationname.setGravity(Gravity.CENTER);
               // Toast.makeText(getApplicationContext(),stationname.getText(),Toast.LENGTH_SHORT).show();
                stationname.setLayoutParams(textviewparams);
                part1.addView(stationname,1);

                //time right
                final TextView timeright = new TextView(context);
                timeright.setText(cursor.getString(2));
                timeright.setGravity(Gravity.CENTER_VERTICAL);
                timeright.setGravity(Gravity.END|Gravity.CENTER_VERTICAL);
              // Toast.makeText(getApplicationContext(),timeright.getText(),Toast.LENGTH_SHORT).show();
                timeright.setLayoutParams(textviewparams);
                part1.addView(timeright,2);


                params.width = LinearLayout.LayoutParams.MATCH_PARENT;
                params.height=100;
                params.weight=1;



                layout.addView(part1,params);



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
