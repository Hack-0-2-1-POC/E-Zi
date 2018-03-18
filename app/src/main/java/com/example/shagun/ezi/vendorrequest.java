package com.example.shagun.ezi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vendorrequest extends AppCompatActivity {
    Button call1;
    Button call2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendorrequest);
        call1=findViewById(R.id.callbtn1);
        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent= new Intent(Intent.ACTION_DIAL);
                myintent.setData(Uri.parse("tel:"+"842701751"));
                startActivity(myintent);
            }
        });
        call2=findViewById(R.id.callbtn2);
        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent= new Intent(Intent.ACTION_DIAL);
                myintent.setData(Uri.parse("tel:"+"9888019027"));
                startActivity(myintent);
            }
        });
    }
}
