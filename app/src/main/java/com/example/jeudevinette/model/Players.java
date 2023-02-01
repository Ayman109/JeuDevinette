package com.example.jeudevinette.model;

import java.io.Serializable;
import java.util.Date;

public class Players implements Serializable {
    private String playerName1 , playerName2 ;
    private Date playingDate ;

    public Players(Date playingDate,String playerName1, String playerName2) {
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
        this.playingDate=playingDate;
    }

    public Date getPlayingDate() {
        return playingDate;
    }

    public String getPlayerName1() {
        return playerName1;
    }

    public String getPlayerName2() {
        return playerName2;
    }
}
