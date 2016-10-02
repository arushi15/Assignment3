package com.example.arush.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.Button;

import static com.example.arush.myapplication.MainActivity.MyPREFERENCES;

public class act1 extends AppCompatActivity
{
    private Button backtomain;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        backtomain = (Button) findViewById(R.id.button3);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act1);
        SharedPreferences settings = this.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String name = settings.getString("name", "DEFAULT NAME");
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();

//        backtomain.setOnClickListener(
//                new View.OnClickListener()
//                {
//                    @Override
//                    public void onClick(View v)
//                    {
//                        finish();
//                    }
//                }
//        );
    }
}
