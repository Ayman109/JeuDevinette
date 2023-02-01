package com.example.jeudevinette.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jeudevinette.outils.MySQliteOpenHelper;

import java.util.Date;

public class AccLocal {
    private SQLiteDatabase db ;
    private MySQliteOpenHelper accDB;
    private String baseName="bdPlayersSqlite";
    private int version = 1;
    public AccLocal(Context context){
    accDB = new MySQliteOpenHelper(context,baseName,null,version);
    }

    public void ajout(Players players){
        db = accDB.getWritableDatabase();
        String req=" insert into players(playinDate,playerName1,playerName2) values";
        req += "(\""+players.getPlayingDate()+"\",\""+players.getPlayerName1()+"\",\""+players.getPlayerName2()+"\")";
        db.execSQL(req);
    }

    public Players recupDernier(){
        db = accDB.getReadableDatabase();
        Players players=null ;
        String req = "select * from players";
        Cursor cursor = db.rawQuery(req,null);
        cursor.moveToLast();
        if(!cursor.isAfterLast()) {
            players = new Players(new Date(),cursor.getString(1),cursor.getString(2));
        }
        cursor.close();
        return players;
    }


}

