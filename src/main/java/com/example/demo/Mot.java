package com.example.demo;
import java.util.ArrayList;

import org.w3c.dom.Text;

public class Mot {
    private Text leMessage;

    private Enseignant prof;
    private ArrayList<Parent> parents = new ArrayList<Parent>();
    private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
    private ArrayList<Classe> classes = new ArrayList<Classe>();

    public Mot(Text leMessage)
    {
        this.leMessage = leMessage;
    }

    public String toString() {
        return "Le message : " + leMessage;
    }

    public Text getMessage()
    {
        return leMessage;
    }

    public void setMessage(Text _message)
    {
        this.leMessage = _message;
    }

    public Enseignant getEnseignant()
    {
        return prof;
    }

    public ArrayList<Parent> getParents()
    {
        return parents;
    }

    public ArrayList<Eleve> getEleves()
    {
        return eleves;
    }

    public ArrayList<Classe> getClasses()
    {
        return classes;
    }

    public void setEnseignant(Enseignant _prof)
    {
        this.prof = _prof;
    }

    public void addEleve(Eleve eleve)
    {
        eleves.add(eleve);
    }

    public void addClasse(Classe classe)
    {
        classes.add(classe);
    }

    public void addParent(Parent unParent)
    {
        parents.add(unParent);
    }

    public int nbEleves()
    {
        int nbEleves = 0;

        for(Eleve x : eleves){
            nbEleves++;
        }
        return nbEleves;
    }

    public int nbClasses()
    {
        int nbClasses = 0;

        for(Classe x : classes){
            nbClasses++;
        }
        return nbClasses;
    }

    public int nbParents()
    {
        int nbParents = 0;

        for(Parent x : parents){
            nbParents++;
        }
        return nbParents;
    }
}
