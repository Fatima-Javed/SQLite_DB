package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 ="ID";
    public static final String COL_2 ="NAME";
    public static final String COL_3 ="SURNAME";
    public static final String COL_4 ="MARKS";
    public static final String COL_5 ="CONTACT";
    public static final String COL_6 ="EMAIL";
    public static final String COL_7 ="DEPARTMENT";
    public static final String COL_8 ="ADDRESS";

    public DatabaseHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " +TABLE_NAME+ " (ID INTEGER PRIMARY KEY AUTOINCREMENT,"+"NAME TEXT,SURNAME TEXT,MARKS INTEGER,CONTACT TEXT, EMAIL TEXT,  DEPARTMENT TEXT,ADDRESS TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String name,String surname, String marks, String contact,String email,String department,String address)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        contentValues.put(COL_5,contact);
        contentValues.put(COL_6,email);
        contentValues.put(COL_7,department);
        contentValues.put(COL_8,address);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from " +TABLE_NAME,null);
        return res;
    }


    public boolean updateData(String id,String name,String surname,String marks,String contact,String email,String department,String address)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        contentValues.put(COL_5,contact);
        contentValues.put(COL_6,email);
        contentValues.put(COL_7,department);
        contentValues.put(COL_8,address);
        db.update(TABLE_NAME,contentValues,"ID=?",new String[]{id});
        return  true;

    }

}
