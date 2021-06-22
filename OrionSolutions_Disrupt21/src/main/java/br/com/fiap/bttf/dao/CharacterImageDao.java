package br.com.fiap.bttf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bttf.bean.CharacterImage;
import br.com.fiap.bttf.exception.DataNotFoundException;

/**
 * Classe responsável por realizar consulta de Imagens dos Personagens
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class CharacterImageDao {

	private Connection connection;

	public CharacterImageDao(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Método de transformação de um ResultSet para CharacterImage
	 * 
	 * @param rs Objeto do tipo ResultSet
	 * @return CharacterImage Objeto do tipo CharacterImage
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public CharacterImage parse(ResultSet rs) throws SQLException, ClassNotFoundException, DataNotFoundException {
		int id = rs.getInt("id_character");
		int characterId = rs.getInt("id_image");
		String url = rs.getString("url_image");
		String description = rs.getString("ds_image");

		CharacterImage characterImage = new CharacterImage(id, characterId, url, description);
		return characterImage;
	}

	/**
	 * Pesquisar Imagens de Personagem pelo Id do Personagem
	 * 
	 * @param characterId Id do Personagem
	 * @return CharacterImage Objeto do tipo CharacterImage
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<CharacterImage> searchByCharacterId(int characterId)
			throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<CharacterImage> characterImage = new ArrayList<CharacterImage>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection.prepareStatement("SELECT id_character, id_image, url_image, ds_image"
					+ " FROM t_bttf_image_character WHERE id_character = ? ");

			ps.setInt(1, characterId);
			rs = ps.executeQuery();

			while (rs.next()) {
				characterImage.add(this.parse(rs));
			}
			if (characterImage.size() == 0) {
				throw new DataNotFoundException("Imagem de personagem não encontrada");
			}

			return characterImage;

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
	 * Listar todas as Imagens dos Personagens
	 * 
	 * @return List CharacterImage Lista de Imagens de Personagens
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<CharacterImage> list() throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<CharacterImage> characterImageList = new ArrayList<CharacterImage>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection
					.prepareStatement("SELECT id_character, id_image, url_image, ds_image FROM t_bttf_image_character");

			rs = ps.executeQuery();

			while (rs.next()) {
				characterImageList.add(this.parse(rs));
			}
			if (characterImageList.size() == 0) {
				throw new DataNotFoundException("Imagem de personagem não encontrada");
			}

			return characterImageList;

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
	 * Pesquisa pelo Id da Image do Personagem
	 * 
	 * @param Id Id da Imagem do Personagem
	 * @return CharacterImage Objeto do tipo CharacterImage
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public CharacterImage searchById(int Id) throws ClassNotFoundException, SQLException, DataNotFoundException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection
					.prepareStatement("SELECT id_character, id_image, url_image, ds_image FROM t_bttf_image_character"
							+ "WHERE id_character = ?");
			ps.setInt(1, Id);
			rs = ps.executeQuery();

			CharacterImage characterImage = null;

			if (rs.next())
				characterImage = this.parse(rs);
			else
				throw new DataNotFoundException("Imagem de personagem não encontrada");

			return characterImage;

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
