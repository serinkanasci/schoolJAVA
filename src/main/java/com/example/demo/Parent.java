package com.example.demo;

import java.sql.*;
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

    public void enregistre(Connection conn) throws SQLException {
        String SQL = "INSERT INTO Parent(nomPrenom,idMotParent,idParentEleve) VALUES (?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setString(1, this.getNom() + this.getPrenom());
            pstmt.setString(2, null);
            pstmt.setString(3, null);

            pstmt.execute();
            pstmt.close();
            System.out.println("Parent created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Parent already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING Parent !!! " + e);
        }
    }

    public void deleteParent(Connection conn) throws SQLException {
        try {
            String query = "DELETE FROM Parent WHERE nomPrenom='" + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Parent deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateParent(Connection conn, String _nomPrenom, int _idMotParent, int _idParentEleve) throws SQLException {
        try {
            String query = "UPDATE Parent SET nomPrenom='" + _nomPrenom + "', idMotParent='" + _idMotParent + "', idParentEleve='" + _idParentEleve + "' WHERE nomPrenom='" + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Parent updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public int getMotParentID(Connection conn) throws SQLException{
        int _id = 0;
        try{
            String query = "SELECT id FROM MotParent WHERE idParent='" + this.getNom() + this.getPrenom() + "'";
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

    public int getParentEleveID(Connection conn) throws SQLException{
        int _id = 0;
        try{
            String query = "SELECT id FROM ParentEleve WHERE idParent='" + this.getNom() + this.getPrenom() + "'";
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
}
