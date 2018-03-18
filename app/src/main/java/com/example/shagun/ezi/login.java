package com.example.shagun.ezi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    Button btn,register;
    EditText nametext,passtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn=findViewById(R.id.loginbtn);
        nametext=findViewById(R.id.nametext);
        passtext=findViewById(R.id.passtext);
        register=findViewById(R.id.registerbtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor myresult=null;
                try {
                    SQLiteDatabase mydb = openOrCreateDatabase("hackdb", MODE_PRIVATE, null);
                    String mystring="select * from usertable where name="+nametext.getText().toString()+"and phone="+passtext.getText().toString();
                    try {
                        myresult= mydb.rawQuery("select * from usertable where name=? and phone=?",new String[]{nametext.getText().toString(),passtext.getText().toString()});
                        if(myresult.moveToNext())
                        {
                            startActivity(new Intent(login.this,MainActivity.class));
                            login.this.finish();
                        }
                        else
                        {
                            Toast.makeText(login.this, "Wrong Name and Password ", Toast.LENGTH_SHORT).show();
                        }

                    } catch (Exception e) {
                        // Toast.makeText(this, "Error in Query " + e.getMessage(), Toast.LENGTH_LONG).show();
                        //Toast.makeText(favourite.this, "No Favourites Added", Toast.LENGTH_SHORT).show();
                        //this.finish();
                    }
                    finally {
                        myresult.close();
                        mydb.close();
                    }
                }
                catch(Exception e)
                {
                    //Toast.makeText(this, "Error in Database " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {//for database
                    SQLiteDatabase mydb = openOrCreateDatabase("hackdb", MODE_PRIVATE, null);//there can be error in creating database.
                    try//for query
                    {
                        //there can be error in executing query .
                        mydb.execSQL("create table if not exists usertable(name varchar,phone varchar primary key)");
                        mydb.execSQL("insert into usertable(name,phone) values(?,?)",new Object[]{nametext.getText().toString(),passtext.getText().toString()});
                        Toast.makeText(login.this, "Registered", Toast.LENGTH_SHORT).show();
                        nametext.setText("");
                        passtext.setText("");
                        //startActivity(new Intent(login.this,MainActivity.class));
                    }
                    catch(Exception e)
                    {
                        Toast.makeText(login.this, "Already Registered", Toast.LENGTH_LONG).show();
                    }
                    finally {
                        mydb.close();
                    }
                }
                catch(Exception e)
                {
                    //Toast.makeText(save.this, "Error occured in database"+e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
