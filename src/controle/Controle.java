package controle;

import java.util.List;

import dao.DAOArtefato;
import modelo.Artefato;

public class Controle {
	DAOArtefato dao=DAOArtefato.getInstance();
	
	public List<Artefato> selectArtefato(){
		
		return dao.selectArtefato();
		
	}
	
	
}
