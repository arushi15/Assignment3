package com.example.arush.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.SQLException;

import static android.R.id.hint;

public class MainActivity extends AppCompatActivity
{
     public static final String MyPREFERENCES = "SPref" ;
     public static final String name = "name";
     public static final String age = "age";
     public static final String id = "id";
     private Button mNextButton, mViewButton;
     private EditText ed1, ed2, ed3;
     private SharedPreferences sharedpreferences;

  static DbHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNextButton = (Button) findViewById(R.id.NextButton);
        mViewButton = (Button) findViewById(R.id.ViewButton);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        SQLiteDatabase mydatabase = openOrCreateDatabase("book_detail",MODE_PRIVATE,null);

        mydb = new DbHelper(this);



        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        mNextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name1  = ed1.getText().toString();
                String age1  = ed2.getText().toString();
                String id1  = ed3.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(name, name1);
                editor.putString(age, age1);
                editor.putString(id, id1);
                editor.commit();

                nextfunction();

            }
        });


        mViewButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
             viewfunction();
            }
        });
    }

    private void nextfunction()
    {
        Intent intent =new Intent(this, actmenu.class);
        startActivity(intent);

    }

    private void viewfunction() {
        Intent intent = new Intent(this, act1.class);
//        SharedPreferences settings = this.getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
//        String name = settings.getString("name ", "");
        startActivity(intent);
    }

}
