package com.example.arush.myapplication;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.arush.myapplication.MainActivity.age;
import static com.example.arush.myapplication.MainActivity.mydb;
import static com.example.arush.myapplication.MainActivity.name;

public class act2 extends AppCompatActivity
{
    private Button mSaveButton, mBackButton;
     static EditText edit1, edit2, edit3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        mSaveButton = (Button) findViewById(R.id.button);
        mBackButton = (Button) findViewById(R.id.button2);
        edit1=(EditText)findViewById(R.id.editText6);    //bookid
        edit2=(EditText)findViewById(R.id.editText4);    //book name
        edit3=(EditText)findViewById(R.id.editText5);    //book genre
        addDetails();

    }

    public void addDetails()
    {
        mSaveButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        boolean checkresult= mydb.insertData(edit1.getText().toString(), edit2.getText().toString(), edit3.getText().toString());
                        if(checkresult== true)
                        {
                            Toast.makeText(act2.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(act2.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

        mBackButton.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        finish();
                    }
                }
        );
    }


}
