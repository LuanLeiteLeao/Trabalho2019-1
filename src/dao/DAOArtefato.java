/*
esta classe tem como responsabilidade fazer a conecxao com o banco de dados,
esta classe só pode ser instanciada uma vez, por esse motivo eu usei o padrao 
de projeto Singleton, ele me permite criar uma classe global, eu não precisso 
instanciar ela para poder usar, ela é unica, eu só posso fazer uma conecxao com 
o banco de dados.
*/
package dao;

import java.beans.Statement;
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

import modelo.Artefato;

public class DAOArtefato {
	//instanciado o meu objeto na minha propria classe "Auto Propri se referencia kjljlkjlkjkljk "
	private static DAOArtefato unicaInstancia = new DAOArtefato();
	
	
	private static DAOArtefato dao;
	private Connection con;
	public static final String SERVIDOR="172.18.0.3";
	public static final String BANCO_NOME="CUPAIB";
	public static final String USUARIO_NOME="postgres";
	public static final String USUARIO_SENHA="Postgres2018!";
	
	
	private DAOArtefato(){
		this.inicializarDriverConexao();
		this.inicializarConexao();
		
	}
	
	//como a minha class só pode ter uma instancia,é precisso ter um metodo que retorna o mesmo
	
		public static synchronized DAOArtefato getInstance() {
	        if (unicaInstancia == null)
	        	unicaInstancia = new DAOArtefato();
	 
	        return unicaInstancia;
	    }
	
	
	
	private void inicializarConexao() {
		try {
			con = DriverManager.getConnection("jdbc:postgresql://" + SERVIDOR + "/" + BANCO_NOME, USUARIO_NOME,
					USUARIO_SENHA);
			
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

	
	//essa parte do código estar relacionado a consultas e insercoes
	
	
	//este metodo tem a fução de fazer a consulta e restornar uma lista do tipo da minha consulta
	public void getTodosFuncionarios() {
		String sql = "select * from artefato";
		
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			List<Artefato> artefatosList = new ArrayList<Artefato>();
			
			while (rs.next()){
				Artefato retornoBanco = new Artefato();
				
				retornoBanco.setId(rs.getInt("id"));
				retornoBanco.setNome(rs.getString("nome"));
				retornoBanco.setQuantidade(rs.getInt("quantidade"));
				retornoBanco.setTipo(rs.getString("tipo"));
				retornoBanco.setUrlImagem(rs.getString("urlImagem"));
				retornoBanco.setDescricao(rs.getString("Descricao"));
				
				retornoBanco.print();
				
			}	
			
			rs.close();
			stmt.close();
			
			
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
			
		}
		
		
		
		
		//return artefatosList;
		
	}
	
	
	public String adiciona(Artefato artefato) {
        String sql = "insert into artefato " +
                "(nome, quantidade, tipo, urlImagem ,descricao)" +
                " values (?,?,?,?,?)";
        
        

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores

            
            stmt.setString(1,artefato.getNome());
            stmt.setInt(2,artefato.getQuantidade());
            stmt.setString(3,artefato.getTipo());
            stmt.setString(4,artefato.getUrlImagem());
            stmt.setString(5,artefato.getDescricao());
            
            // executa
            stmt.execute();
            stmt.close();
            
            
            
            return "Salvo Com Sucesso";
            
        } catch (SQLException e) {
        	return e.getMessage();
        }
        
    }
	
	
	public String deleteArtefato(Artefato artefato) {
		//instrução SQL
		
        String strSQL = "DELETE FROM artefato WHERE id = ?" ;

       
       

        try
        {
        	PreparedStatement stmt = con.prepareStatement(strSQL);
        	stmt.setInt(1,artefato.getId());
        	stmt.executeUpdate(); 
        	   
            
           

            stmt.close();
            
            return "O ID "+artefato.getId()+" foi Deletado";
            
        }

        catch (SQLException e)
        {
            return e.getMessage();
        }
		
	}
	
	
	
}








