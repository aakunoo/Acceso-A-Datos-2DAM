package DAO.Practica3;

import java.util.List;

public interface ProfesorDAO {

    Profesor getProfesorById(int idProfesor);
    void addProfesor(Profesor profesor);
    void updateProfesor(Profesor profesor);
    void deleteProfesor(int idProfesor);
    List<Profesor> getAllProfesores();

}
