package com.example.puneguide.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DataBaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "puneguide.db";
    public static final int DATABASE_VERSION = 2;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }




}