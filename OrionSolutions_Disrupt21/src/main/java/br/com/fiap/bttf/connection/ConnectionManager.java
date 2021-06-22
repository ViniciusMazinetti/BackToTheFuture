package br.com.fiap.bttf.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Classe responsável por criar as conexões com o banco de dados
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 */
public class ConnectionManager {

	private static ConnectionManager unico;
	private Properties configuracao;

	private ConnectionManager() {
		
	}

	/**
	 * Método que retorna a única instância da classe ConnectionManager
	 * 
	 * @return ConnectionManager Objeto do tipo ConnectionManager
	 * @throws FileNotFoundException Exceção de arquivo não encontrado
	 * @throws IOException Exceção IO
	 */
	public static ConnectionManager getInstance() throws FileNotFoundException, IOException {
		if (unico == null) {
			unico = new ConnectionManager();
		}
		return unico;
	}

	/**
	 * Obtem uma conexão com o banco de dados
	 * 
	 * @return Connection Objeto do tipo Connection
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl","RM84310","271193");

		return conexao;
	}

}
