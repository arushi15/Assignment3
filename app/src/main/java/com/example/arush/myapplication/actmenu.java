package com.example.arush.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.example.arush.myapplication.MainActivity.mydb;
import static com.example.arush.myapplication.act2.edit1;
import static com.example.arush.myapplication.act2.edit2;
import static com.example.arush.myapplication.act2.edit3;

public class actmenu extends AppCompatActivity
{

    private android.widget.Button mInsertButton, mShowButton, mStoreButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actmenu);
        mInsertButton = (Button) findViewById(R.id.insertbutton);
        mShowButton = (Button) findViewById(R.id.button4);
        mStoreButton = (Button) findViewById(R.id.button7);



        mInsertButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                insertfunction();
            }
        });

        mStoreButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                storefunc();
            }
        });

        viewinfo();
    }

        public void storefunc()
        {
            Intent intent =new Intent(this, act_store.class);
            startActivity(intent);
        }

        public void insertfunction()
        {
            Intent intent =new Intent(this, act2.class);
            startActivity(intent);
        }

        public void viewinfo()
        {
            mShowButton.setOnClickListener(
                    new  View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                           Cursor res =  mydb.getinfo();
                            if(res.getCount()==0)
                            {
                                //show some message
                                showMessage("Error", "Nothing found");
                                return ;
                            }

                            StringBuffer buffer = new StringBuffer();
                                while(res.moveToNext())
                                {
                                    buffer.append("BookID: "+res.getString(0)+ "\n");
                                    buffer.append("Book Name: "+res.getString(1)+ "\n");
                                    buffer.append("Book Genre: "+res.getString(2)+ "\n\n");
                                }
                            showMessage("Data", buffer.toString());
                        }
                    }
            );
        }
//#######################################
    public void showMessage(String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


    }
