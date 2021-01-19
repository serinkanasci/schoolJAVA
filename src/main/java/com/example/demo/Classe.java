package com.example.demo;

import java.util.ArrayList;

public class Classe {
    private String nom;
    private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
    private ArrayList<Enseignant> profs = new ArrayList<Enseignant>();
    private ArrayList<Mot> mots = new ArrayList<Mot>();


    public Classe(String nom)
    {
        this.nom = nom;
    }

    public String toString() {
        return "Nom de la classe : " + nom;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String _nom)
    {
        this.nom = _nom;
    }

    public ArrayList<Eleve> getEleves()
    {
        return eleves;
    }

    public ArrayList<Mot> getMots()
    {
        return mots;
    }

    public ArrayList<Enseignant> getEnseignants()
    {
        return profs;
    }

    public void addEleve(Eleve eleve)
    {
        eleves.add(eleve);
    }

    public void addMot(Mot unMot)
    {
        mots.add(unMot);
    }

    public void addEnseignant(Enseignant prof)
    {
        profs.add(prof);
    }

    public int nbEleves()
    {
        int nbEleves = 0;

        for(Eleve x : eleves){
            nbEleves++;
        }
        return nbEleves;
    }

    public int nbProfs()
    {
        int nbProfs = 0;

        for(Enseignant x : profs){
            nbProfs++;
        }
        return nbProfs;
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

