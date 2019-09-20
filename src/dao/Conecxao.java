/*
esta classe tem como responsabilidade fazer a conecxao com o banco de dados,
esta classe só pode ser instanciada uma vez, por esse motivo eu usei o padrao 
de projeto Singleton, ele me permite criar uma classe global, eu não precisso 
instanciar ela para poder usar, ela é unica, eu só posso fazer uma conecxao com 
o banco de dados.
*/
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.postgresql.core.ConnectionFactory;

public class Conecxao {
	//instanciado o meu objeto na minha propria classe "Auto Propri se referencia kjljlkjlkjkljk "
	private static Conecxao unicaInstancia = new Conecxao();
	
	
	private static Conecxao dao;
	private Connection con;
	public static final String SERVIDOR="172.18.0.3";
	public static final String BANCO_NOME="CUPAIB";
	public static final String USUARIO_NOME="postgres";
	public static final String USUARIO_SENHA="Postgres2018!";
	
	
	private Conecxao(){
		
		
	}
	
	
	private void inicializarConexao() {
		try {
			con = DriverManager.getConnection("jdbc:postgresql://" + SERVIDOR + "/" + BANCO_NOME, USUARIO_NOME,
					USUARIO_SENHA);
			System.out.println("olae");
		} catch (SQLException e) {
			System.out.println("Erro de conex�o");
			e.printStackTrace();
			System.exit(2);
		}
	}

	private void inicializarDriverConexao() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Falha ao carregar o Driver de conex�o com banco de dados Postgresql");
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	
}








