package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;

import org.w3c.dom.Text;

public class Devoir {
    private Text texte;
    private Text documents;
    private Text liens;
    private Date dateButoir;

    private Enseignant prof;
    private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
    private ArrayList<Classe> classes = new ArrayList<Classe>();


    public Devoir(Text texte, Text documents, Text liens, Date dateButoir)
    {
        this.texte = texte;
        this.documents = documents;
        this.liens = liens;
        this.dateButoir = dateButoir;
    }

    public String toString() {
        return
                "Le devoir : " + texte +
                        ", les documents : " + documents +
                        ", les liens : " + liens +
                        ", la date butoir : " + dateButoir;
    }

    public Text getTexte()
    {
        return texte;
    }


    public Text getDocuments()
    {
        return documents;
    }


    public Text getLiens()
    {
        return liens;
    }


    public Date getDateButoir()
    {
        return dateButoir;
    }

    public Enseignant getEnseignant()
    {
        return prof;
    }

    public void setTexte(Text _texte)
    {
        this.texte = _texte;
    }

    public void setDocuments(Text _documents)
    {
        this.documents = _documents;
    }

    public void setLiens(Text _liens)
    {
        this.liens = _liens;
    }

    public void setDateButoir(Date _dateButoir)
    {
        this.dateButoir = _dateButoir;
    }

    public void setEnseignant(Enseignant _prof)
    {
        this.prof = _prof;
    }

    public ArrayList<Eleve> getEleves()
    {
        return eleves;
    }

    public ArrayList<Classe> getClasses()
    {
        return classes;
    }

    public void addEleve(Eleve eleve)
    {
        eleves.add(eleve);
    }

    public void addClasse(Classe classe)
    {
        classes.add(classe);
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

}



// private Enseignant prof;
// private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
// private ArrayList<Classe> classes = new ArrayList<Classe>();