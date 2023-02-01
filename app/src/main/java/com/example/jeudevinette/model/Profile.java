package com.example.jeudevinette.model;

public class Profile {
    private int valsSaisie,valAchercher;
    private String resultat;

    public Profile(int valsSaisie, int valAchercher) {
        this.valsSaisie = valsSaisie;
        this.valAchercher = valAchercher;
    }

    public String getResultat(String player){
        if(getValsSaisie() == getValAchercher()) setResultat(player);
        if(getValsSaisie() > getValAchercher()) setResultat("Veillez saisir une valeur plus petite");
        if(getValsSaisie() < getValAchercher()) setResultat("Veillez saisir une valeur plus grand");

        return resultat;
    }

    public int getValsSaisie() {
        return valsSaisie;
    }

    public void setValsSaisie(int valsSaisie) {
        this.valsSaisie = valsSaisie;
    }

    public int getValAchercher() {
        return valAchercher;
    }

    public void setValAchercher(int valAchercher) {
        this.valAchercher = valAchercher;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
