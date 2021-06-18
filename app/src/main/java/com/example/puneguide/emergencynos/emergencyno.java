package com.example.puneguide.emergencynos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.puneguide.R;

public class emergencyno extends AppCompatActivity {
    Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergencyno);
        final TextView c1091 = (TextView)findViewById(R.id.c1091);

        c1091.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1091.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c181 = (TextView)findViewById(R.id.c181);

        c181.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c181.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c108 = (TextView)findViewById(R.id.c108);

        c108.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c108.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c102 = (TextView)findViewById(R.id.c102);

        c102.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c102.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c101 = (TextView)findViewById(R.id.c101);

        c101.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c101.getText().toString().trim()));
                startActivity(callIntent);

            }
        });

        final TextView c100 = (TextView)findViewById(R.id.c100);

        c100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c100.getText().toString().trim()));
                startActivity(callIntent);

            }
        });

        final TextView c02026126296 = (TextView)findViewById(R.id.c02026126296);

        c02026126296.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c02026126296.getText().toString().trim()));
                startActivity(callIntent);

            }
        });

        final TextView c02026122880 = (TextView)findViewById(R.id.c02026122880);
        
        c02026122880.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c02026122880.getText().toString().trim()));
                startActivity(callIntent);

            }
        });

        final TextView c1910 = (TextView)findViewById(R.id.c1910);
        c1910.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1910.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c1077 = (TextView)findViewById(R.id.c1077);
        c1077.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1077.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c1512 = (TextView)findViewById(R.id.c1512);
        c1512.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1512.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c139 = (TextView)findViewById(R.id.c139);
        c139.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c139.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c1097 = (TextView)findViewById(R.id.c1097);
        c1097.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1097.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c1066 = (TextView)findViewById(R.id.c1066);
        c1066.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c1066.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
        final TextView c18001030222 = (TextView)findViewById(R.id.c18001030222);
        c18001030222.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse(Uri.parse("tel: ")+c18001030222.getText().toString().trim()));
                startActivity(callIntent);

            }
        });
    }
}

