package com.example.shagun.ezi;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class vendorlist extends AppCompatActivity {
    Button call1,call2,map1,map2;
    static final int REQUEST_LOCATION=1;
    LocationManager locationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendorlist);
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
        locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        map1=findViewById(R.id.map1btn);
        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLocation();
            }
        });
        map2=findViewById(R.id.map2btn);
        map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLocation();
            }
        });
    }
    void getLocation() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        } else {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if (location != null){
                double latti = location.getLatitude();
                double longi = location.getLongitude();
                Toast.makeText(this, "Lattitude is "+latti, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Longitude is "+longi, Toast.LENGTH_SHORT).show();

                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latti, longi);
                Intent myintent=new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<latti>,<longi>?z=16"));
                startActivity(myintent);
            } else {
                //((EditText)findViewById(R.id.et_latitude)).setText("Unable to find correct location.");
                //((EditText)findViewById(R.id.et_longitude)).setText("Unable to find correct location. ");
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }
}
