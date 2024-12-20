package DAO.Practica3;

import java.util.List;

public interface AsignaturaDAO {
    Asignatura getAsignaturaById(int id);
    void addAsignatura(Asignatura asignatura);
    void updateAsignatura(Asignatura asignatura);
    void deleteAsignatura(int id);
    List<Asignatura> getAllAsignaturas();
}
