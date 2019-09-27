package dao;

import java.sql.SQLException;

import modelo.Artefato;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		DAOArtefato a=DAOArtefato.getInstance();
		 a.selectArtefato();
		 
		 
		 Artefato art = new Artefato();
		 
		 art.setNome("123");
         art.setQuantidade(1);
         art.setTipo("0aa");
         art.setUrlImagem("0aa");
         art.setDescricao("0aa");
		 
		 System.out.println(a.adiciona(art));
		 

	
		 
		 art.setId(1);
         
		// System.out.println(a.deleteArtefato(art)); 
		 a.selectArtefato();
	}

}
