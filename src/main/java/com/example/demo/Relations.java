package com.example.demo;

import java.sql.*;

public class Relations {
    //CREATION

    /*MotEleve (id, idMot, idEleve);*/
    public void enregistreMotEleve(Connection conn, int _idMot, String _idEleve) throws SQLException {
        String SQL = "INSERT INTO MotEleve(idMot, idEleve) VALUES (?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setInt(1, _idMot);
            pstmt.setString(2, _idEleve);

            pstmt.execute();
            pstmt.close();
            System.out.println("MotEleve created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("MotEleve already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING MotEleve !!! " + e);
        }
    }

    /*MotParent (id, idMot, idParent);*/
    public void enregistreMotParent(Connection conn, int _idMot, String _idParent) throws SQLException {
        String SQL = "INSERT INTO MotParent(idMot, idParent) VALUES (?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setInt(1, _idMot);
            pstmt.setString(2, _idParent);

            pstmt.execute();
            pstmt.close();
            System.out.println("MotParent created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("MotParent already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING MotParent !!! " + e);
        }
    }

    /*MotClasse (id, idMot, idClasse);*/
    public void enregistreMotClasse(Connection conn, int _idMot, int _idClasse) throws SQLException {
        String SQL = "INSERT INTO MotClasse(idMot, idClasse) VALUES (?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setInt(1, _idMot);
            pstmt.setInt(2, _idClasse);

            pstmt.execute();
            pstmt.close();
            System.out.println("MotClasse created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("MotClasse already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING MotClasse !!! " + e);
        }
    }

    /*ParentEleve (id, idParent, idEleve);*/
    public void enregistreParentEleve(Connection conn, String _idParent, String _idEleve) throws SQLException {
        String SQL = "INSERT INTO ParentEleve(idParent, idEleve) VALUES (?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setString(1, _idParent);
            pstmt.setString(2, _idEleve);

            pstmt.execute();
            pstmt.close();
            System.out.println("ParentEleve created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("ParentEleve already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING ParentEleve !!! " + e);
        }
    }

    /*ClasseEleve (id, idClasse, idEleve);*/
    public void enregistreClasseEleve(Connection conn, int _idClasse, String _idEleve) throws SQLException {
        String SQL = "INSERT INTO ClasseEleve(idClasse, idEleve) VALUES (?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setInt(1, _idClasse);
            pstmt.setString(2, _idEleve);

            pstmt.execute();
            pstmt.close();
            System.out.println("ClasseEleve created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("ClasseEleve already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING ClasseEleve !!! " + e);
        }
    }

    /*ClasseEnseignant (id,idClasse, idEnseignant);*/
    public void enregistreClasseEnseignant(Connection conn, int _idClasse, String _idEnseignant) throws SQLException {
        String SQL = "INSERT INTO ClasseEnseignant(idClasse, idEnseignant) VALUES (?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(SQL))
        {
            pstmt.setInt(1, _idClasse);
            pstmt.setString(2, _idEnseignant);

            pstmt.execute();
            pstmt.close();
            System.out.println("ClasseEnseignant created !");
        }catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("ClasseEnseignant already created !");
        }catch (Exception e){
            System.out.println("ERROR CREATING ClasseEnseignant !!! " + e);
        }
    }

    // DELETE

    /*MotEleve (id, idMot, idEleve);*/
    public void deleteMotEleve(Connection conn, int _idMot, String _idEleve) throws SQLException {
        try {
            String query = "DELETE FROM MotEleve WHERE idMot='" + _idMot + "' AND idEleve='" + _idEleve + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("MotEleve deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*MotParent (id, idMot, idParent);*/
    public void deleteMotParent(Connection conn, int _idMot, String _idParent) throws SQLException {
        try {
            String query = "DELETE FROM MotParent WHERE idMot='" + _idMot + "' AND idParent='" + _idParent + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("MotParent deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*MotClasse (id, idMot, idClasse);*/
    public void deleteMotClasse(Connection conn, int _idMot, int _idClasse) throws SQLException {
        try {
            String query = "DELETE FROM MotClasse WHERE idMot='" + _idMot + "' AND idClasse='" + _idClasse + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("MotClasse deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*ParentEleve (id, idParent, idEleve);*/
    public void deleteParentEleve(Connection conn, String _idParent, String _idEleve) throws SQLException {
        try {
            String query = "DELETE FROM ParentEleve WHERE idParent='" + _idParent + "' AND idEleve='" + _idEleve + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("ParentEleve deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    /*ClasseEleve (id, idClasse, idEleve);*/
    public void deleteClasseEleve(Connection conn, int _idClasse, String _idEleve) throws SQLException {
        try {
            String query = "DELETE FROM ClasseEleve WHERE idClasse='" + _idClasse + "' AND idEleve='" + _idEleve + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("ClasseEleve deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*ClasseEnseignant (id,idClasse, idEnseignant);*/
    public void deleteClasseEnseignant(Connection conn, int _idClasse, String _idEnseignant) throws SQLException {
        try {
            String query = "DELETE FROM ClasseEnseignant WHERE idClasse='" + _idClasse + "' AND idEnseignant='" + _idEnseignant + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("ClasseEnseignant deleted successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    // UPODATE
    /*MotEleve (id, idMot, idEleve);*/
    public void updateMotEleve(Connection conn, int _idMot, String _idEleve, int _newIdMot, String _newIdEleve) throws SQLException {
        try {
            String query = "UPDATE MotEleve SET idMot='" + _newIdMot + "', idEleve='" + _newIdEleve + "'  WHERE idMot='" + _idMot + "' AND idEleve='" + _idEleve + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("MotEleve updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*MotParent (id, idMot, idParent);*/
    public void updateMotParent(Connection conn, int _idMot, String _idParent, int _newIdMot, String _newIdParent) throws SQLException {
        try {
            String query = "UPDATE MotParent SET idMot='" + _newIdMot + "', idEleve='" + _newIdParent + "'  WHERE idMot='" + _idMot + "' AND idParent='" + _idParent + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("MotParent updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*MotClasse (id, idMot, idClasse);*/
    public void updateMotClasse(Connection conn, int _idMot, int _idClasse, int _newIdMot, int _newIdClasse) throws SQLException {
        try {
            String query = "UPDATE MotClasse SET idMot='" + _newIdMot + "', idClasse='" + _newIdClasse + "'  WHERE idMot='" + _idMot + "' AND idClasse='" + _idClasse + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("MotClasse updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*ParentEleve (id, idParent, idEleve);*/
    public void updateParentEleve(Connection conn, String _idParent, String _idEleve, String _newIdParent, String _newIdEleve) throws SQLException {
        try {
            String query = "UPDATE ParentEleve SET idParent='" + _newIdParent + "', idEleve='" + _newIdEleve + "'  WHERE idParent='" + _idParent + "' AND idEleve='" + _idEleve + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("ParentEleve updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*ClasseEleve (id, idClasse, idEleve);*/
    public void updateClasseEleve(Connection conn, int _idClasse, String _idEleve, int _newIdClasse, String _newIdEleve) throws SQLException {
        try {
            String query = "UPDATE ClasseEleve SET idClasse='" + _newIdClasse + "', idEleve='" + _newIdEleve + "'  WHERE idClasse='" + _idClasse + "' AND idEleve='" + _idEleve + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("ClasseEleve updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    /*ClasseEnseignant (id,idClasse, idEnseignant);*/
    public void updateClasseEnseignant(Connection conn, int _idClasse, String _idEnseignant, int _newIdClasse, String _newIdEnseignant) throws SQLException {
        try {
            String query = "UPDATE ClasseEnseignant SET idClasse='" + _newIdClasse + "', idEnseignant='" + _newIdEnseignant + "'  WHERE idClasse='" + _idClasse + "' AND idEnseignant='" + _idEnseignant + "'";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            st.executeUpdate(query);
            System.out.println("ClasseEnseignant updated successfully");
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}





/*MotEleve (id, idMot, idEleve);*/

/*MotParent (id, idMot, idParent);*/

/*MotClasse (id, idMot, idClasse);*/

/*ParentEleve (id, idParent, idEleve);*/

/*ClasseEleve (id, idClasse, idEleve);*/

/*ClasseEnseignant (id,idClasse, idEnseignant);*/







