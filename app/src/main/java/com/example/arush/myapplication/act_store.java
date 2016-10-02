package com.example.arush.myapplication;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

import static com.example.arush.myapplication.act2.edit1;
import static com.example.arush.myapplication.act2.edit2;
import static com.example.arush.myapplication.act2.edit3;

public class act_store extends AppCompatActivity
{
    private android.widget.Button read1, write1, read2, write2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_store);
        read1 = (Button) findViewById(R.id.button8);
        write1 = (Button) findViewById(R.id.button9);
        read2 = (Button) findViewById(R.id.button10);
        write2 = (Button) findViewById(R.id.button11);

        read1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               readinfo(v);
            }
        });

        write1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void  onClick(View v)
            {
                writeinfo(v);
            }
        });
        read2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                readexternal(v);
            }
        });

        write2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void  onClick(View v)
            {
                writeexternal(v);
            }
        });
    }

        public void writeexternal(View view)
        {
            String s1;    //state of the external storage
            s1=Environment.getExternalStorageState();
            String abc=edit3.getText().toString();
            if(Environment.MEDIA_MOUNTED.equals(s1))   //storage is available(Environment.MEDIA_MOUNTED)
            {
                File r1= Environment.getExternalStorageDirectory();    //root of the external storage
                File dir = new File(r1.getAbsolutePath()+ "/afile");
                if(!dir.exists())
                {
                    dir.mkdir();

                }
                File file = new File (dir, "mymsg.txt");

                try
                {

                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(abc.getBytes());
                    Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_LONG).show();

                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }


            }
            else
            {
                Toast.makeText(getApplicationContext(), "sd card not found", Toast.LENGTH_LONG).show();
            }
        }

        public void readexternal(View view)
        {
            File r1= Environment.getExternalStorageDirectory();    //root of the external storage
            File dir = new File(r1.getAbsolutePath()+ "/afile");
            File file = new File (dir, "mymsg.txt");
            String m;
            try
            {
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr= new InputStreamReader(fis);
                BufferedReader br= new BufferedReader(isr);
                StringBuffer sb= new StringBuffer();
                while((m=br.readLine())!=null)
                {
                    sb.append(m+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("Read");
                builder.setMessage(sb.toString());
                builder.show();
            }

            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }

        public void writeinfo(View view)
        {

            String info_id = edit1.getText().toString();
            String info_name = edit2.getText().toString();
            String info_genre = edit3.getText().toString();
            String fname = "bookdata";
            try
            {
                FileOutputStream fos = openFileOutput(fname, MODE_PRIVATE);
                fos.write(info_name.getBytes());
                fos.close();
                Toast.makeText(getApplicationContext(), "Message saved", Toast.LENGTH_LONG).show();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        public void readinfo(View view)
        {
            try
            {
                String msgname;
                FileInputStream fis=openFileInput("bookdata");
                InputStreamReader isr =new InputStreamReader(fis);
                BufferedReader br= new BufferedReader(isr);
                StringBuffer sb= new StringBuffer();
                while((msgname=br.readLine())!=null)    //line is existing
                {
                    sb.append(msgname + "\n");

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(true);
                builder.setTitle("Read");
                builder.setMessage(sb.toString());
                builder.show();
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }


}
