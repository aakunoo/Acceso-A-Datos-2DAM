package practicaCasa;

import java.util.List;

public interface AlumnoDAO {

	boolean insertarAlumno(Alumno alumno);
	Alumno buscarPorNombre(String nombre);
	List<Alumno> buscarTodos();
	boolean actualizarNota(String nombre, int nuevanota);
	boolean eliminarAlumno(String nombre);
	
}
