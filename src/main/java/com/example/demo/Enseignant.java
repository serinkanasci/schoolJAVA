package com.example.demo;

import java.util.ArrayList;

public class Enseignant extends Utilisateur {
    private ArrayList<Classe> classes = new ArrayList<Classe>();

    public Enseignant(String nom, String prenom, String login, String motDePasse)
    {
        super(nom, prenom, login, motDePasse);
    }

    public String toString() {
        return this.getToString();
    }

    public ArrayList<Classe> getClasses()
    {
        return classes;
    }

    public void addClasse(Classe classe)
    {
        classes.add(classe);
    }

    public int nbClasses()
    {
        int nbClasses = 0;

        for(Classe x : classes){
            nbClasses++;
        }
        return nbClasses;
    }

}
