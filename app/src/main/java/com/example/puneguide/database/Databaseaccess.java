package com.example.puneguide.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databaseaccess {
    public SQLiteOpenHelper openhelper;
   public SQLiteDatabase db;
    private static Databaseaccess instance;
    Cursor c = null;
    private Databaseaccess(Context context)
    {
        this.openhelper= new DataBaseHelper(context);
    }

    public static Databaseaccess getInstance(Context context) {
        if(instance == null)
        {
            instance= new Databaseaccess(context);
        }
        return instance;
    }
    public  SQLiteDatabase open( )
    {
        this.db= openhelper.getWritableDatabase();
        return db;
    }

}
