package com.example.demo;

import java.sql.*;
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
        String SQL = "INSERT INTO Eleve(nomPrenom, idParentEleve, idClasseEleve, idMotEleve) VALUES (?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setString(1, this.getNom() + this.getPrenom());
            pstmt.setInt(2, this.getParentEleveID(conn));
            pstmt.setInt(3, this.getClasseEleveID(conn));
            pstmt.setInt(4, this.getMotEleveID(conn));

            pstmt.execute();
            pstmt.close();
            System.out.println("Eleve created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Eleve already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING Eleve !!! " + e);
        }
    }

    public void deleteEleve(Connection conn) throws SQLException {
        try {
            String query = "DELETE FROM Eleve WHERE nomPrenom='" + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Eleve deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateEleve(Connection conn, String _nomPrenom, int _idParentEleve, int _idClasseEleve, int _idMotEleve) throws SQLException {
        try {
            String query = "UPDATE Eleve SET nomPrenom='" + _nomPrenom + "', idParentEleve='" + _idParentEleve
                    + "', idClasseEleve='" + _idClasseEleve + "', idMotEleve='" + _idMotEleve + "' WHERE nomPrenom='"
                    + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Eleve updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public int getParentEleveID(Connection conn) throws SQLException{
        int _id = 0;
        try{
            String query = "SELECT id FROM ParentEleve WHERE idEleve='" + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            _id = rs.getInt("id");
            System.out.format("%s\n", _id);

            st.close();
        }catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return _id;
    }

    public int getClasseEleveID(Connection conn) throws SQLException {
        int _id = 0;
        try {
            String query = "SELECT id FROM ClasseEleve WHERE idEleve='" + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            _id = rs.getInt("id");
            System.out.format("%s\n", _id);

            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return _id;
    }

    public int getMotEleveID(Connection conn) throws SQLException {
        int _id = 0;
        try {
            String query = "SELECT id FROM MotEleve WHERE idEleve='" + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            _id = rs.getInt("id");
            System.out.format("%s\n", _id);

            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return _id;
    }
}


   /* CREATE TABLE IF NOT EXISTS Eleve(
        idParent VARCHAR(100) REFERENCES Parent(nomPrenom),
        nomPrenom VARCHAR(100) NOT NULL PRIMARY KEY REFERENCES Utilisateur(nom,prenom),
        idParentEleve INT NULL REFERENCES ParentEleve(id),
        idClasseEleve INT NULL REFERENCES ClasseEleve(id),
        idMotEleve INT NULL REFERENCES MotEleve(id)
        );*/