package com.example.jeudevinette.controller;

import com.example.jeudevinette.model.Profile;

public final class Controller {
     private static Profile profile ;
    private static Controller instance = null ;


    private Controller() {super();}

    public static final Controller getInstance(){
        if(Controller.instance == null ){Controller.instance= new Controller();}
        return Controller.instance;
    }

    public void createProfile(int valSaisir, int valArechercher){
        profile =new Profile(valSaisir,valArechercher);
    }

    public String getResultat(String player){
        return profile.getResultat(player);
    }



}
