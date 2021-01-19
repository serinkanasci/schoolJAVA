package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class Eleve extends Utilisateur {
    private ArrayList<Mot> mots = new ArrayList<Mot>();
    private ArrayList<Parent> parents = new ArrayList<Parent>();
    private ArrayList<Classe> classes = new ArrayList<Classe>();
    private ArrayList<Devoir> devoirs = new ArrayList<Devoir>();

    public Eleve(String nom, String prenom, String login, String motDePasse)
    {
        super(nom, prenom, login, motDePasse);
    }

    public String toString() {
        return this.getToString();
    }

    public ArrayList<Mot> getMots()
    {
        return mots;
    }

    public ArrayList<Parent> getParents()
    {
        return parents;
    }

    public ArrayList<Classe> getClasses()
    {
        return classes;
    }

    public ArrayList<Devoir> getDevoirs()
    {
        return devoirs;
    }

    public void addMot(Mot unMot)
    {
        mots.add(unMot);
    }

    public void addParent(Parent unParent)
    {
        parents.add(unParent);
    }

    public void addClasse(Classe uneClasse)
    {
        classes.add(uneClasse);
    }

    public void addDevoir(Devoir unDevoir)
    {
        devoirs.add(unDevoir);
    }

    public int nbMots()
    {
        int nbMots = 0;

        for(Mot x : mots){
            nbMots++;
        }
        return nbMots;
    }

    public int nbParents()
    {
        int nbParents = 0;

        for(Parent x : parents){
            nbParents++;
        }
        return nbParents;
    }

    public int nbClasses()
    {
        int nbClasses = 0;

        for(Classe x : classes){
            nbClasses++;
        }
        return nbClasses;
    }

    public int nbDevoirs()
    {
        int nbDevoirs = 0;

        for(Devoir x : devoirs){
            nbDevoirs++;
        }
        return nbDevoirs;
    }

    public void enregistre(Connection conn) throws SQLException {
        String SQL = "INSERT INTO Eleve(nom, prenom, login, motDePasse) VALUES (?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setString(1, this.getNom());
            pstmt.setString(2, this.getPrenom());
            pstmt.setString(2, this.getLogin());
            pstmt.setString(2, this.getMotDePasse());

            pstmt.execute();
            pstmt.close();
            System.out.println("User(Eleve) created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("User(Eleve) already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING USER(Eleve) !!! " + e);
        }
    }
}
