package dao;

import java.sql.SQLException;

import modelo.Artefato;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		DAOArtefato a=DAOArtefato.getInstance();
		 a.getTodosFuncionarios();
		 
		 
		 Artefato art = new Artefato();
		 
		 art.setNome("123");
         art.setQuantidade(1);
         art.setTipo("0aa");
         art.setUrlImagem("0aa");
         art.setDescricao("0aa");
		 
		 System.out.println(a.adiciona(art));
		 
		 a.getTodosFuncionarios();
	}

}
