package com.example.jeudevinette.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
public class MySQliteOpenHelper extends SQLiteOpenHelper {
    private String creation="CREATE TABLE players (playinDate TEXT PRIMARY KEY,playerName1 TEXT NOT NULL , playerName2 TEXT NOT NULL)";
    public MySQliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(creation);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
