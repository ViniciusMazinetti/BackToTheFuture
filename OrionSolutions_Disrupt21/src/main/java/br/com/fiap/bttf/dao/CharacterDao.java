package br.com.fiap.bttf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bttf.bean.Character;
import br.com.fiap.bttf.bean.CharacterImage;
import br.com.fiap.bttf.bean.MovieObject;
import br.com.fiap.bttf.exception.DataNotFoundException;

/**
 * Classe responsável por realizar consultas de Personagens
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class CharacterDao {

	private Connection connection;

	public CharacterDao(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Método de transformação de um ResultSet para Character
	 * 
	 * @param rs Objeto do tipo ResultSet
	 * @return Character Objeto do tipo Character
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public Character parse(ResultSet rs) throws SQLException, ClassNotFoundException, DataNotFoundException {
		MovieObjectDao objectDao = new MovieObjectDao(connection);
		CharacterImageDao characterimageDao = new CharacterImageDao(connection);

		int id = rs.getInt("id_character");
		String name = rs.getString("nm_character");
		String description = rs.getString("ds_character");
		String actorsName = rs.getString("nm_actor");
		List<MovieObject> objects = objectDao.searchByCharacterId(id);
		List<CharacterImage> images = characterimageDao.searchByCharacterId(id);

		Character character = new Character(id, name, description, actorsName, objects, images);

		return character;
	}

	/**
	 * Pesquisar pelo id do personagem
	 * 
	 * @param id Id do Personagem
	 * @return Character Objeto do tipo Character
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public Character searchById(int id) throws ClassNotFoundException, SQLException, DataNotFoundException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection
					.prepareStatement("SELECT id_character, nm_character, ds_character, nm_actor FROM t_bttf_character"
							+ "WHERE id_character = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			Character character = null;

			if (rs.next())
				character = this.parse(rs);
			else
				throw new DataNotFoundException("Personagem não encontrado");

			return character;

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
	 * Listar todos os Personagens
	 * 
	 * @return List Character Lista de Personagens
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<Character> list() throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<Character> characterList = new ArrayList<Character>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement(
					"SELECT id_character, nm_character, ds_character, nm_actor FROM t_bttf_character");

			rs = ps.executeQuery();

			while (rs.next()) {
				characterList.add(this.parse(rs));
			}
			if (characterList.size() == 0) {
				throw new DataNotFoundException("Personagem não encontrado");
			}

			return characterList;

		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			ps.close();
			rs.close();
		}

	}
	
	public List<Character> listCharacterByObjectId(int id) throws DataNotFoundException, ClassNotFoundException, SQLException{
		List<Character> characterList = new ArrayList<Character>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = connection.prepareStatement("SELECT c.id_character, c.nm_character, c.ds_character, c.nm_actor FROM T_BTTF_CHARACTER C JOIN T_BTTF_CHARACTER_OBJECT CO ON CO.ID_CHARACTER = C.ID_CHARACTER WHERE CO.ID_OBJECT = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				characterList.add(this.parse(rs));
			}
			
			return characterList; 
		}catch (ClassNotFoundException e) {
			throw new ClassNotFoundException();
		}catch (SQLException e) {
			throw new SQLException();
		} finally {
			ps.close();
			rs.close();
		}
	}

}
