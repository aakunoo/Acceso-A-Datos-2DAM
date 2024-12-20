package DAO.Practica3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAOImpl implements AsignaturaDAO {
    private Connection connection;

    public AsignaturaDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Asignatura getAsignaturaById(int id) {
        String sql = "SELECT * FROM ASIGNATURA WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Asignatura(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getDouble("CREDITOS"),
                        rs.getString("TIPO"),
                        rs.getInt("CURSO"),
                        rs.getInt("CUATRIMESTRE"),
                        rs.getObject("ID_PROFESOR") != null ? rs.getInt("ID_PROFESOR") : null,
                        rs.getInt("ID_GRADO")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addAsignatura(Asignatura asignatura) {
        String sql = "INSERT INTO ASIGNATURA (ID, NOMBRE, CREDITOS, TIPO, CURSO, CUATRIMESTRE, ID_PROFESOR, ID_GRADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, asignatura.getId());
            stmt.setString(2, asignatura.getNombre());
            stmt.setDouble(3, asignatura.getCreditos());
            stmt.setString(4, asignatura.getTipo());
            stmt.setInt(5, asignatura.getCurso());
            stmt.setInt(6, asignatura.getCuatrimestre());
            if (asignatura.getIdProfesor() != null) {
                stmt.setInt(7, asignatura.getIdProfesor());
            } else {
                stmt.setNull(7, Types.INTEGER);
            }
            stmt.setInt(8, asignatura.getIdGrado());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAsignatura(Asignatura asignatura) {
        String sql = "UPDATE ASIGNATURA SET NOMBRE = ?, CREDITOS = ?, TIPO = ?, CURSO = ?, CUATRIMESTRE = ?, ID_PROFESOR = ?, ID_GRADO = ? WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, asignatura.getNombre());
            stmt.setDouble(2, asignatura.getCreditos());
            stmt.setString(3, asignatura.getTipo());
            stmt.setInt(4, asignatura.getCurso());
            stmt.setInt(5, asignatura.getCuatrimestre());
            if (asignatura.getIdProfesor() != null) {
                stmt.setInt(6, asignatura.getIdProfesor());
            } else {
                stmt.setNull(6, Types.INTEGER);
            }
            stmt.setInt(7, asignatura.getIdGrado());
            stmt.setInt(8, asignatura.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAsignatura(int id) {
        String sql = "DELETE FROM ASIGNATURA WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Asignatura> getAllAsignaturas() {
        List<Asignatura> asignaturas = new ArrayList<>();
        String sql = "SELECT * FROM ASIGNATURA";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                asignaturas.add(new Asignatura(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getDouble("CREDITOS"),
                        rs.getString("TIPO"),
                        rs.getInt("CURSO"),
                        rs.getInt("CUATRIMESTRE"),
                        rs.getObject("ID_PROFESOR") != null ? rs.getInt("ID_PROFESOR") : null,
                        rs.getInt("ID_GRADO")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignaturas;
    }
}
