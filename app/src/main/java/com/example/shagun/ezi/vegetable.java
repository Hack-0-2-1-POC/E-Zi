package com.example.shagun.ezi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class vegetable extends AppCompatActivity {
    Button btn;
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable);
        btn=findViewById(R.id.addbtn);
        et1=findViewById(R.id.nametext);
        et2=findViewById(R.id.passtext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(vegetable.this, et2.getText().toString()+" kg "+et1.getText().toString()+"added to the store", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
