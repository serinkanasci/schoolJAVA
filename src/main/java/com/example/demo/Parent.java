package com.example.demo;

import java.util.ArrayList;

public class Parent extends Utilisateur {
    private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
    private ArrayList<Mot> mots = new ArrayList<Mot>();

    public Parent(String nom, String prenom, String login, String motDePasse)
    {
        super(nom, prenom, login, motDePasse);
    }

    public String toString() {
        return this.getToString();
    }

    public ArrayList<Eleve> getEleves()
    {
        return eleves;
    }

    public ArrayList<Mot> getMots()
    {
        return mots;
    }

    public void addEleve(Eleve eleve)
    {
        eleves.add(eleve);
    }

    public void addMot(Mot unMot)
    {
        mots.add(unMot);
    }

    public int nbEleves()
    {
        int nbEleves = 0;

        for(Eleve x : eleves){
            nbEleves++;
        }
        return nbEleves;
    }

    public int nbMots()
    {
        int nbMots = 0;

        for(Mot x : mots){
            nbMots++;
        }
        return nbMots;
    }

}
