package com.example.shagun.ezi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class vendorhome extends AppCompatActivity {
    Button requestbtn,addveg,show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendorhome);
        requestbtn=findViewById(R.id.request_farmer);
        requestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(vendorhome.this,farmerrequest.class));
            }
        });
        addveg=findViewById(R.id.add_vegetable);
        addveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(vendorhome.this,vegetable2.class));
            }
        });
        show=findViewById(R.id.show_request);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(vendorhome.this,customershow.class));
            }
        });
    }

}
