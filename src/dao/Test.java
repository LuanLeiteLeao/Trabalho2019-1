package dao;

import java.sql.SQLException;

import modelo.Artefato;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		DAOArtefato a=DAOArtefato.getInstance();
		 a.selectArtefato();
		 
		 
		 Artefato art = new Artefato();
		 
		 art.setId(50000);
		 art.setNome("0");
         art.setQuantidade(100);
         art.setTipo("0");
         art.setUrlImagem("0");
         art.setDescricao("0");
		 
		 System.out.println(a.alterArtefato(art));
		 

	
		 
		 art.setId(1);
         
		// System.out.println(a.deleteArtefato(art)); 
		 a.selectArtefato();
	}

}
