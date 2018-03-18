package com.example.shagun.ezi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class farmermenu extends AppCompatActivity {
    Button addbtn,requestbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmermenu);
        addbtn=findViewById(R.id.addGrossary);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(farmermenu.this,vegetable.class));
            }
        });
        requestbtn=findViewById(R.id.viewRequests);
        requestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(farmermenu.this,vendorrequest.class));
            }
        });
    }
}
