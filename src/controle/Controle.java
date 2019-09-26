package controle;

import java.util.List;

import dao.DAOArtefato;
import modelo.Artefato;

public class Controle {
	DAOArtefato dao=DAOArtefato.getInstance();
	
	public List<Artefato> selectArtefato(){
		
		return dao.selectArtefato();
		
	}
	
	public String inserArtefato(Artefato artefato) {
		
		return dao.adiciona(artefato);  
		
	}
	
	public String deleteArtefato(Artefato artefato) {
		return "";
	}
}
