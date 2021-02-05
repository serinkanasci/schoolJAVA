package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class Classe {
    private String nom;
    private int id;
    private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
    private ArrayList<Enseignant> profs = new ArrayList<Enseignant>();
    private ArrayList<Mot> mots = new ArrayList<Mot>();


    public Classe(String nom)
    {
        this.nom = nom;
    }

    public String toString() {
        return "ID de la classe :" + id + " Nom de la classe : " + nom;
    }

    public String getNom()
    {
        return nom;
    }

    public int getID()
    {
        return id;
    }

    public void setNom(String _nom)
    {
        this.nom = _nom;
    }

    public void setID(int _ID)
    {
        this.id = _ID;
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

    public void enregistreClasse(Connection conn) throws SQLException {
        String SQL = "INSERT INTO Classe(nom, idClasseEleve, idClasseEnseignant, idMotClasse) VALUES (?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS))
        {
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                setID(rs.getInt(1));
            }

            pstmt.setString(1, this.getNom());
            pstmt.setInt(2, this.getID());
            pstmt.setInt(3, this.getID());
            pstmt.setInt(4, this.getID());

            pstmt.execute();
            pstmt.close();
            System.out.println("Classe created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Classe already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING Classe !!! " + e);
        }

    }

    public void deleteClasse(Connection conn) throws SQLException {
        try {
            String query = "DELETE FROM Classe WHERE id='" + this.getID() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Classe deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateClasse(Connection conn, String _nom, int _idClasseEleve, int _idClasseEnseignant, int _idMotClasse) throws SQLException {
        try {
            String query = "UPDATE Classe SET nom='" + _nom + "', idClasseEleve='" + _idClasseEleve
                    + "', idClasseEnseignant='" + _idClasseEnseignant + "', idMotClasse='" + _idMotClasse + "' WHERE id='"
                    + this.getID() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Classe updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public int getClasseEleveID(Connection conn) throws SQLException {
        int _id = 0;
        try {
            String query = "SELECT id FROM ClasseEleve WHERE idClasse='" + this.getID()  + "'";
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

    public int getClasseEnseignantID(Connection conn) throws SQLException{
        int _id = 0;
        try{
            String query = "SELECT id FROM ClasseEnseignant WHERE idClasse='" + this.getID() + "'";
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

    public int getMotClasseID(Connection conn) throws SQLException {
        int _id = 0;
        try {
            String query = "SELECT id FROM MotClasse WHERE idClasse='" + this.getID() + "'";
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

