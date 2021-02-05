package com.example.demo;

import java.sql.*;
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

    public String getID() {
        return this.getNom() + this.getPrenom();
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

    public void enregistreEnseignant(Connection conn) throws SQLException {
        String SQL = "INSERT INTO Enseignant(nomPrenom) VALUES (?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setString(1, this.getNom() + this.getPrenom());

            pstmt.execute();
            pstmt.close();
            System.out.println("Enseignant created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Enseignant already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING Enseignant !!! " + e);
        }

        this.enregistreUser(conn);
    }

    public void deleteEnseignant(Connection conn) throws SQLException {
        try {
            String query = "DELETE FROM Enseignant WHERE nomPrenom='" + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Enseignant deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateEnseignant(Connection conn, String _nomPrenom) throws SQLException {
        try {
            String query = "UPDATE Enseignant SET nomPrenom='" + _nomPrenom + "' WHERE nomPrenom='" + this.getNom() + this.getPrenom() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Enseignant updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*public int getID(Connection conn) throws SQLException{
        int _id = 0; 
        try{
            String query = "SELECT id FROM Enseignant WHERE nom='" + this.getNom() + "' AND prenom='" + this.getPrenom() + "'";
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
    }*/
}

/*

while (rs.next()) {
                int id = rs.getInt("id");
                System.out.format("%s\n", id);
            }
            
            

    // create our mysql database connection
    String myDriver = "org.gjt.mm.mysql.Driver";
    String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
              Connection conn = DriverManager.getConnection(myUrl, "root", "");

              // our SQL SELECT query.
              // if you only need a few columns, specify them by name instead of using "*"
              String query = "SELECT * FROM users";

              // create the java statement
              Statement st = conn.createStatement();

              // execute the query, and get a java resultset
              ResultSet rs = st.executeQuery(query);

              // iterate through the java resultset
              while (rs.next())
              {
              int id = rs.getInt("id");
              String firstName = rs.getString("first_name");
              String lastName = rs.getString("last_name");
              Date dateCreated = rs.getDate("date_created");
              boolean isAdmin = rs.getBoolean("is_admin");
              int numPoints = rs.getInt("num_points");

              // print the results
              System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
              }
              st.close();
              }
              catch (Exception e)
              {
              System.err.println("Got an exception! ");
              System.err.println(e.getMessage());


 */