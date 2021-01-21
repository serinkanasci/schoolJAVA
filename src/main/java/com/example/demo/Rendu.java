package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class Rendu {

    private int id;
    private String contenu;
    private Date dateRendu;

    private Eleve eleve;
    private Devoir devoir;

    public Rendu(String contenu, Date dateRendu)
    {
        this.contenu = contenu;
        this.dateRendu = dateRendu;
    }


    public String toString() {
        return devoir.toString() + " // Devoir " + contenu + " rendu le : " + dateRendu;
    }

    public int getID()
    {
        return id;
    }

    public String getContenu()
    {
        return contenu;
    }

    public Date getDateRendu()
    {
        return dateRendu;
    }

    public Eleve getEleve()
    {
        return eleve;
    }

    public Devoir getDevoir()
    {
        return devoir;
    }

    public void setID(int _ID)
    {
        this.id = _ID;
    }

    public void setContenu(String _contenu)
    {
        this.contenu = _contenu;
    }

    public void setDateRendu(Date _dateRendu)
    {
        this.dateRendu = _dateRendu;
    }

    public void setEleve(Eleve _eleve)
    {
        this.eleve = _eleve;
    }

    public void setDevoir(Devoir _devoir)
    {
        this.devoir = _devoir;
    }

    /*id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    contenu TEXT,
    dateRendu DATETIME,
    idEleve VARCHAR(100) REFERENCES Eleve(nomPrenom),
    idDevoir INT REFERENCES Devoir(id)*/

    public void enregistre(Connection conn) throws SQLException {
        String SQL = "INSERT INTO Rendu(contenu, dateRendu, idEleve, idDevoir) VALUES (?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS))
        {
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                setID(rs.getInt(1));
            }

            pstmt.setString(1, this.getContenu());
            pstmt.setDate(2, this.getDateRendu());
            pstmt.setString(3, this.getEleve().getNom() + this.getEleve().getPrenom());
            pstmt.setInt(4, this.getDevoir().getID());

            pstmt.execute();
            pstmt.close();
            System.out.println("Rendu created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Rendu already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING Rendu !!! " + e);
        }

    }

    public void deleteRendu(Connection conn) throws SQLException {
        try {
            String query = "DELETE FROM Rendu WHERE id='" + this.getID() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Rendu deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateRendu(Connection conn, String _contenu, Date _dateRendu, String _idEleve, int _idDevoir) throws SQLException {
        try {
            String query = "UPDATE Rendu SET contenu='" + _contenu + "', dateRendu='" + _dateRendu
                    + "', idEleve='" + _idEleve + "', idDevoir='" + _idDevoir + "' WHERE id='"
                    + this.getID() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Rendu updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}
