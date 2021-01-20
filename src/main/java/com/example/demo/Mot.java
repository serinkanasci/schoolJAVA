package com.example.demo;
import java.sql.*;
import java.util.ArrayList;

public class Mot {
    private int id;
    private String leMessage;

    private Enseignant prof;
    private ArrayList<Parent> parents = new ArrayList<Parent>();
    private ArrayList<Eleve> eleves = new ArrayList<Eleve>();
    private ArrayList<Classe> classes = new ArrayList<Classe>();

    public Mot(String leMessage)
    {
        this.leMessage = leMessage;
    }

    public String toString() {
        return "Le message : " + leMessage;
    }

    public String getMessage()
    {
        return leMessage;
    }
    public int getID()
    {
        return id;
    }

    public void setMessage(String _message)
    {
        this.leMessage = _message;
    }

    public void setID(int _id)
    {
        this.id = _id;
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
    /*
    id AUTO_INCREMENT NOT NULL PRIMARY KEY,
    texte TEXT NOT NULL,
    idEnseignant VARCHAR(100) NOT NULL REFERENCES Enseignant(nomPrenom),
    idMotEleve INT NULL REFERENCES MotEleve(id),
    idMotParent INT NULL REFERENCES MotParent(id),
    idMotClasse INT NULL REFERENCES MotClasse(id)
*/

    public void enregistre(Connection conn) throws SQLException {
        String SQL = "INSERT INTO Mot(texte, idEnseignant, idMotEleve, idMotParent, idMotClasse) VALUES (?,?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setString(1, this.getMessage());
            pstmt.setString(2, this.getEnseignant().getNom() + this.getEnseignant().getPrenom());
            pstmt.setInt(3, this.getMotEleveID(conn));
            pstmt.setInt(4, this.getMotParentID(conn));
            pstmt.setInt(5, this.getMotClasseID(conn));

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()){
                setID(rs.getInt(1));
            }

            pstmt.execute();
            pstmt.close();
            System.out.println("Mot created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Mot already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING Mot !!! " + e);
        }

    }

    public void deleteMot(Connection conn) throws SQLException {
        try {
            String query = "DELETE FROM Mot WHERE id='" + this.getID() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Mot deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public void updateClasse(Connection conn, String _texte, int _idEnseignant, int idMotEleve, int _idMotParent, int _idMotClasse) throws SQLException {
        try {
            String query = "UPDATE Mot SET texte='" + _texte + "', idEnseignant='" + _idEnseignant
                    + "', idMotEleve='" + idMotEleve + "', idMotParent='" + _idMotParent + "', idMotClasse='" + _idMotClasse + "' WHERE id='"
                    + this.getID() + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("Mot updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public int getMotEleveID(Connection conn) throws SQLException {
        int _id = 0;
        try {
            String query = "SELECT id FROM MotEleve WHERE idMot='" + this.getID() + "'";
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

    public int getMotParentID(Connection conn) throws SQLException {
        int _id = 0;
        try {
            String query = "SELECT id FROM MotParent WHERE idMot='" + this.getID() + "'";
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

    public int getMotClasseID(Connection conn) throws SQLException {
        int _id = 0;
        try {
            String query = "SELECT id FROM MotClasse WHERE idMot='" + this.getID() + "'";
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
