
package com.example.shagun.ezi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class farmerrequest extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmerrequest);
        btn=findViewById(R.id.sendbutton);
        // whatever data farmer request is saved on button click
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(farmerrequest.this, "Request Sent Successfully: Data Uploaded", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
