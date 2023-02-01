package com.example.jeudevinette.controller;

import android.content.Context;

import com.example.jeudevinette.model.AccLocal;
import com.example.jeudevinette.model.Players;
import com.example.jeudevinette.outils.Serializer;

import java.util.Date;

public final class HomeController {
    private static HomeController instance=null ;
    private static Players players;
    private static String nomFichier = "saved Players" ;
    private static AccLocal accLocal;


    private HomeController(){super();}

    public static final HomeController getInstance(Context context){
        if(HomeController.instance==null) HomeController.instance = new HomeController();
        //players= (Players) Serializer.deSerialize(nomFichier,context) ;
        accLocal = new AccLocal(context);
        players = accLocal.recupDernier();
        return HomeController.instance;
    }

    public void createPlayers(String playerName1, String playerName2, Context context){
        players = new Players(new Date(),playerName1,playerName2);
        //Serializer.serialize(nomFichier,HomeController.players,context);
        accLocal.ajout(players);
    }

    public String getPlayerName1() {
        if(players==null) return null;
        return players.getPlayerName1();
    }

    public String getPlayerName2() {
        if(players==null) return null;
        return players.getPlayerName2();
    }
}
