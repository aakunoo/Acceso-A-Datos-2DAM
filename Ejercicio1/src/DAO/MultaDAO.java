package DAO;

import java.util.List;

public interface MultaDAO {

	Multa getMultaByCodigo(int codMulta);
	void addMulta(Multa multa);
	void updateMulta(Multa multa);
	void deleteMulta(int codMulta);
	List<Multa> getAllMultas();
	
	
}
