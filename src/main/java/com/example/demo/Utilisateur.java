package com.example.demo;

import java.sql.*;

public class Utilisateur {

    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;


    public Utilisateur(String nom, String prenom, String login, String motDePasse)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public String getToString() {
        return "Nom : " + nom + " Prenom : " + prenom + " Login : " + login + " Mot de passe : " + motDePasse;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getLogin()
    {
        return login;
    }
    public String getMotDePasse()
    {
        return motDePasse;
    }

    public void setNom(String _nom)
    {
        this.nom = _nom;
    }

    public void setPrenom(String _prenom)
    {
        this.prenom = _prenom;
    }

    public void setLogin(String _login)
    {
        this.login = _login;
    }

    public void setMotDePasse(String _motDePasse)
    {
        this.motDePasse = _motDePasse;
    }

    public void enregistreUser(Connection conn) throws SQLException {
        String SQL = "INSERT INTO Utilisateur(nom, prenom, login, motDePasse) VALUES (?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setString(1, this.getNom());
            pstmt.setString(2, this.getPrenom());
            pstmt.setString(3, this.getLogin());
            pstmt.setString(4, this.getMotDePasse());

            pstmt.execute();
            pstmt.close();
            System.out.println("User created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("User already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING USER !!! " + e);
        }
    }

    public void deleteUser(Connection conn) throws SQLException {
        try {
            String query = "DELETE FROM Utilisateur WHERE nom='" + this.getNom() + "' AND prenom='" + this.getPrenom() + "'" ;
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("User deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateUser(Connection conn, String _nom,String _prenom,String _login,String _motDePasse) throws SQLException {
        try {
            String query = "UPDATE Utilisateur SET nom='" + _nom + "', prenom='" + _prenom + "', login='" + _login +
                    "', motDePasse='" + _motDePasse + "' WHERE nomPrenom='" + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("User updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
