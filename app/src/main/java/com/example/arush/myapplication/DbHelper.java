package com.example.arush.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by arush on 02-10-2016.
 */

public class DbHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="Books.db";
    public static final String TABLE_NAME="Books_data";
    public static final String col1="BookID";
    public static final String col2="Name";
    public static final String col3="Genre";

    public DbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    //    SQLiteDatabase db=  this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table "+ TABLE_NAME + "(BookID INTEGER PRIMARY KEY, Name TEXT, Genre TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String bookid, String bookname, String bookgenre )
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(col1, bookid);
        contentValues.put(col2, bookname);
        contentValues.put(col3, bookgenre);
        long result= db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor getinfo()                //random read write access to your result
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from " + TABLE_NAME,  null);
        return res;
    }
}

