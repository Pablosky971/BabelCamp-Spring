package service;

import java.util.List;

import model.Pagina;

public interface BuscadorService {
	
	List<Pagina> buscar(String tematica);
	void agregar(Pagina p);

}
