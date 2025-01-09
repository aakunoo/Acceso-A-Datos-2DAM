package DAO.Practica3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAOImpl implements ProfesorDAO {

	private Connection connection;

	public ProfesorDAOImpl(Connection connection) {
        this.connection = connection;
    }
	
	 @Override
	 public Profesor getProfesorById(int idProfesor) {
	     String sql = "SELECT * FROM PROFESOR WHERE ID_PROFESOR = ?";
	     try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	         stmt.setInt(1, idProfesor);
	         ResultSet rs = stmt.executeQuery();
	         if (rs.next()) {
	             return new Profesor(rs.getInt("ID_PROFESOR"), rs.getInt("ID_DEPARTAMENTO"));
	         }
	     } catch (SQLException e) {
	         e.printStackTrace();
	     }
	     return null;
	    }

	@Override
	public void addProfesor(Profesor profesor) {
		String sql = "INSERT INTO PROFESOR (ID_PROFESOR, ID_DEPARTAMENTO) VALUES (?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, profesor.getIdProfesor());
            stmt.setInt(2, profesor.getIdDepartamento());
            stmt.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void updateProfesor(Profesor profesor) {
		String sql = "UPDATE PROFESOR SET ID_DEPARTAMENTO = ? WHERE ID_PROFESOR = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, profesor.getIdDepartamento());
            stmt.setInt(2, profesor.getIdProfesor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void deleteProfesor(int idProfesor) {
		String sql = "DELETE FROM PROFESOR WHERE ID_PROFESOR = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProfesor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Profesor> getAllProfesores() {
		 List<Profesor> profesores = new ArrayList<>();
	        String sql = "SELECT * FROM PROFESOR";
	        try (Statement stmt = connection.createStatement()) {
	            ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	                profesores.add(new Profesor(rs.getInt("ID_PROFESOR"), rs.getInt("ID_DEPARTAMENTO")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return profesores;
	    }
}
