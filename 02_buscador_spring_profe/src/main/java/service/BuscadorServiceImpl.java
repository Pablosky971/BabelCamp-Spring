package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import model.Pagina;

// De esta forma, Spring instanciará la clase. Proviene del módulo Spring Core.

@Service
public class BuscadorServiceImpl implements BuscadorService {

	static ArrayList<Pagina> paginas=new ArrayList<>();
	public BuscadorServiceImpl() {
		paginas.add(new Pagina("http://www.fnac.es","libros","Libros y más cosas"));
		paginas.add(new Pagina("http://www.gamer.es","juegos","Juegos on-line"));
		paginas.add(new Pagina("http://www.casadellibro.es","libros","La Web de los libros"));
		paginas.add(new Pagina("http://www.mydisc.es","musica","Música de todo tipo"));
		paginas.add(new Pagina("http://www.radio.es","musica","Música de actualidad"));
	}
	public List<Pagina> buscar(String tematica) {
		
		return paginas.stream().filter(p -> p.getTematica().equals(tematica)).collect(Collectors.toList());
	}
	
	public void agregar(Pagina p) {
		
		paginas.add(p);
	}
}
