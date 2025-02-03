package DAO;

import java.util.List;

public interface GrupoDAO {

	boolean insertarGrupo(Grupo grupo);
	Grupo buscarGrupoPorNombre(String nombre);
    List<Grupo> listarTodosGrupos();
    boolean actualizarGrupo(String nombre, String genero);
    boolean eliminarGrupo(String nombre);
	
}
