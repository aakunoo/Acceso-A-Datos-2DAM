package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MultaDAOImpl implements MultaDAO {
	
	private Connection connection;
	
	public MultaDAOImpl(Connection connection) {
		this.connection = connection;
	}
	
	

	@Override
	public Multa getMultaByCodigo(int codMulta) {
		String sql = "SELECT * FROM MULTA WHERE CODMULTA = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codMulta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Multa(
                        rs.getInt("CODMULTA"),
                        rs.getString("DESCRIPCION"),
                        rs.getInt("CODPERSONAMULTADA"),
                        rs.getInt("CODAGENTE"),
                        rs.getInt("IMPORTESANCION"),
                        rs.getInt("PUNTOSSANCION"),
                        rs.getDate("FECHAMULTA")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public void addMulta(Multa multa) {
		String sql = "INSERT INTO MULTA (CODMULTA, DESCRIPCION, CODPERSONAMULTADA, CODAGENTE, IMPORTESANCION, PUNTOSSANCION, FECHAMULTA) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, multa.getCodMulta());
            stmt.setString(2, multa.getDescripcion());
            stmt.setInt(3, multa.getCodPersonaMultada());
            stmt.setInt(4, multa.getCodAgente());
            stmt.setInt(5, multa.getImporteSancion());
            stmt.setInt(6, multa.getPuntosSancion());
            stmt.setDate(7, multa.getFechaMulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void updateMulta(Multa multa) {
		String sql = "UPDATE MULTA SET DESCRIPCION = ?, CODPERSONAMULTADA = ?, CODAGENTE = ?, IMPORTESANCION = ?, PUNTOSSANCION = ?, FECHAMULTA = ? WHERE CODMULTA = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, multa.getDescripcion());
            stmt.setInt(2, multa.getCodPersonaMultada());
            stmt.setInt(3, multa.getCodAgente());
            stmt.setInt(4, multa.getImporteSancion());
            stmt.setInt(5, multa.getPuntosSancion());
            stmt.setDate(7, multa.getFechaMulta());
            stmt.setInt(7, multa.getCodMulta());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void deleteMulta(int codMulta) {
		 String sql = "DELETE FROM MULTA WHERE CODMULTA = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, codMulta);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	@Override
	public List<Multa> getAllMultas() {
		List<Multa> multas = new ArrayList<>();
        String sql = "SELECT * FROM MULTA";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                multas.add(new Multa(
                		rs.getInt("CODMULTA"),
                        rs.getString("DESCRIPCION"),
                        rs.getInt("CODPERSONAMULTADA"),
                        rs.getInt("CODAGENTE"),
                        rs.getInt("IMPORTESANCION"),
                        rs.getInt("PUNTOSSANCION"),
                        rs.getDate("FECHAMULTA")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return multas;
	}

}
