package br.com.fiap.bttf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bttf.bean.Image;
import br.com.fiap.bttf.bean.MovieObject;
import br.com.fiap.bttf.exception.DataNotFoundException;

/**
 * Classe responsável por realizar consulta de Objetos
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class MovieObjectDao {

	private Connection connection;

	public MovieObjectDao(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Método de transformação de um ResultSet para MovieObject
	 * 
	 * @param rs Objeto do tipo ResultSet
	 * @return MovieObject Objeto do tipo MovieObject
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public MovieObject parse(ResultSet rs) throws SQLException, ClassNotFoundException, DataNotFoundException {
		int id = rs.getInt("id_object");
		String name = rs.getString("nm_object");
		String description = rs.getString("ds_object");
		String url = rs.getString("url_image");
		Image image = new Image(url, null);

		MovieObject movieObject = new MovieObject(id, name, description, image);
		return movieObject;
	}

	/**
	 * Pesquisar pelo Id do Objeto
	 * 
	 * @param id Id do Objeto
	 * @return MovieObject Objeto do tipo MovieObject
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public MovieObject searchById(int id) throws ClassNotFoundException, SQLException, DataNotFoundException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection
					.prepareStatement("SELECT O.id_object, o.nm_object, O.ds_object, O.url_image FROM  t_bttf_object O"
							+ " WHERE O.id_object = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			MovieObject movieObject = null;

			if (rs.next())
				movieObject = this.parse(rs);
			else
				throw new DataNotFoundException("Objeto não encontrado");

			return movieObject;

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			ps.close();
			rs.close();
		}
	}

	/**
	 * Pesquisar pelo Id do Personagem
	 * 
	 * @param characterId Id do Personagem
	 * @return List MovieObject Lista de Objetos
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<MovieObject> searchByCharacterId(int characterId)
			throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<MovieObject> movieObjectList = new ArrayList<MovieObject>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement("SELECT O.id_object, o.nm_object, O.ds_object, O.url_image"
					+ " FROM  t_bttf_object O JOIN t_bttf_character_object CO"
					+ "	ON CO.id_object = O.id_object WHERE CO.id_character  = ?");

			ps.setInt(1, characterId);
			rs = ps.executeQuery();

			while (rs.next()) {
				movieObjectList.add(this.parse(rs));
			}
			if (movieObjectList.size() == 0)
				return null;

			return movieObjectList;

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			ps.close();
			rs.close();
		}

	}

	/**
	 * Listar todos os Objetos
	 * 
	 * @return List MovieObject Lista de Objetos
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<MovieObject> list() throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<MovieObject> movieObjectList = new ArrayList<MovieObject>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement("SELECT O.id_object, o.nm_object, O.ds_object, O.url_image"
					+ " FROM  t_bttf_object O");

			rs = ps.executeQuery();

			while (rs.next()) {
				movieObjectList.add(this.parse(rs));
			}

			if (movieObjectList.size() == 0)
				throw new DataNotFoundException("Objeto não encontrado");

			return movieObjectList;

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			ps.close();
			rs.close();
		}

	}

}
