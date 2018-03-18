package com.example.shagun.ezi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class customerhome extends AppCompatActivity {
    Button btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerhome);
        btn=findViewById(R.id.findvendor);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(customerhome.this,vendorlist.class));
            }
        });
        btn2=findViewById(R.id.requestbtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(customerhome.this, "Item added to list", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
