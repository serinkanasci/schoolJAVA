package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class Devoir {
    private int id;

    private String texte;
    private String documents;
    private String liens;
    private Date dateButoir;

    private Enseignant prof;
    private Classe classe;
    private Eleve eleve;


    public Devoir(String texte, String documents, String liens, Date dateButoir)
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

    public String getTexte()
    {
        return texte;
    }

    public int getID()
    {
        return id;
    }


    public String getDocuments()
    {
        return documents;
    }


    public String getLiens()
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

    public Classe getClasse()
    {
        return classe;
    }

    public Eleve getEleve()
    {
        return eleve;
    }

    public void setTexte(String _texte)
    {
        this.texte = _texte;
    }

    public void setDocuments(String _documents)
    {
        this.documents = _documents;
    }

    public void setLiens(String _liens)
    {
        this.liens = _liens;
    }

    public void setID(int _ID)
    {
        this.id = _ID;
    }

    public void setDateButoir(Date _dateButoir)
    {
        this.dateButoir = _dateButoir;
    }

    public void setEnseignant(Enseignant _prof)
    {
        this.prof = _prof;
    }

    public void setClasse(Classe _classe)
    {
        this.classe = _classe;
    }

    public void setEleve(Eleve _eleve)
    {
        this.eleve = _eleve;
    }


    //    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
//    texte TEXT,
//    documents TEXT,
//    liens TEXT,
//    dateButoir DATETIME,
//    idEleve VARCHAR(100) REFERENCES Eleve(nomPrenom),
//    idEnseignant VARCHAR(100) NOT NULL REFERENCES Enseignant(nomPrenom),
//    idClasse INT REFERENCES Classe(id)

    public void enregistreClasseDevoir(Connection conn) throws SQLException {
        String SQL = "INSERT INTO Devoir(texte, documents, liens, dateButoir, idEleve, idEnseignant, idClasse) VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS))
        {
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                setID(rs.getInt(1));
            }

            pstmt.setString(1, this.getTexte());
            pstmt.setString(2, this.getDocuments());
            pstmt.setString(3, this.getLiens());
            pstmt.setDate(4, this.getDateButoir());
            pstmt.setString(5, null);
            pstmt.setString(6, this.getEnseignant().getNom() + this.getEnseignant().getPrenom());
            pstmt.setInt(7, this.getClasse().getID());

            pstmt.execute();
            pstmt.close();
            System.out.println("Devoir created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Devoir already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING Devoir !!! " + e);
        }
    }

    public void enregistreEleveDevoir(Connection conn) throws SQLException {
        String SQL = "INSERT INTO Devoir(texte, documents, liens, dateButoir, idEleve, idEnseignant, idClasse) VALUES (?,?,?,?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setString(1, this.getTexte());
            pstmt.setString(2, this.getDocuments());
            pstmt.setString(3, this.getLiens());
            pstmt.setDate(4, this.getDateButoir());
            pstmt.setString(5, this.getEleve().getNom() + this.getEleve().getPrenom());
            pstmt.setString(6, this.getEnseignant().getNom() + this.getEnseignant().getPrenom());
            pstmt.setNull(7, java.sql.Types.INTEGER);

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                setID(rs.getInt(1));
            }

            pstmt.execute();
            pstmt.close();
            System.out.println("Devoir created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Devoir already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING Devoir !!! " + e);
        }
    }

    public void deleteDevoir(Connection conn) throws SQLException {
        try {
            String query = "DELETE FROM Devoir WHERE id='" + this.getID() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Devoir deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateDevoirEleve(Connection conn, String _texte, String _documents, String _liens, Date _dateButoir, String _idEleve, String _idEnseignant) throws SQLException {
        try {
            String query = "UPDATE Devoir SET texte='" + _texte
                    + "', documents='" + _documents
                    + "', liens='" + _liens
                    + "', dateButoir='" + _dateButoir
                    + "', idEleve='" + _idEleve
                    + "', idEnseignant='" + _idEnseignant
                    + "', idClasse='" + null + "' WHERE id='" + this.getID() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Devoir updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateDevoirClasse(Connection conn, String _texte, String _documents, String _liens, Date _dateButoir, String _idClasse, String _idEnseignant) throws SQLException {
        try {
            String query = "UPDATE Devoir SET texte='" + _texte
                    + "', documents='" + _documents
                    + "', liens='" + _liens
                    + "', dateButoir='" + _dateButoir
                    + "', idEleve='" + null
                    + "', idEnseignant='" + _idEnseignant
                    + "', idClasse='" + _idClasse + "' WHERE id='" + this.getID() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Devoir updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}


