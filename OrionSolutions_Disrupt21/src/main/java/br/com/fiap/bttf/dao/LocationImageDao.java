package br.com.fiap.bttf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bttf.bean.LocationImage;
import br.com.fiap.bttf.exception.DataNotFoundException;

/**
 * Classe responsável por realizar consulta de Imagens dos Locais
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class LocationImageDao {

	private Connection connection;

	public LocationImageDao(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Método de transformação de um ResultSet para LocationImage
	 * 
	 * @param rs Objeto do tipo ResultSet
	 * @return LocationImage Objeto do tipo LocationImage
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public LocationImage parse(ResultSet rs) throws SQLException, ClassNotFoundException, DataNotFoundException {
		int id = rs.getInt("id_image");
		int localId = rs.getInt("id_location");
		String url = rs.getString("url_image");
		String description = rs.getString("ds_image");

		LocationImage locationImage = new LocationImage(id, localId, url, description);
		return locationImage;
	}

	/**
	 * Pesquisar pelo Id da Imagem do Local
	 * 
	 * @param Id Id da Imagem do Local
	 * @return LocationImage Objeto do tipo LocationImage
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public LocationImage searchById(int Id) throws ClassNotFoundException, SQLException, DataNotFoundException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection
					.prepareStatement("SELECT id_image, id_location, url_image, ds_image FROM t_bttf_image_location "
							+ "WHERE id_image = ?");
			ps.setInt(1, Id);
			rs = ps.executeQuery();

			LocationImage locationImage = null;

			if (rs.next())
				locationImage = this.parse(rs);
			else
				throw new DataNotFoundException("Imagem de personagem não encontrada");

			return locationImage;

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
	 * Pesquisar pelo Id do Local
	 * 
	 * @param locationId Id do Local
	 * @return List LocationImage Lista de Imagens do Local
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<LocationImage> searchByLocationId(int locationId)
			throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<LocationImage> locationImages = new ArrayList<LocationImage>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection.prepareStatement("SELECT id_image, id_location, url_image, ds_image"
					+ " FROM t_bttf_image_location WHERE id_location = ? ");

			ps.setInt(1, locationId);
			rs = ps.executeQuery();

			while (rs.next()) {
				locationImages.add(this.parse(rs));
			}
			if (locationImages.size() == 0) {
				return null;
			}

			return locationImages;

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
	 * Listar todas as Imagens do Local
	 * 
	 * @return List LocationImage Lista de Imagens do Local
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<LocationImage> list() throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<LocationImage> locationImageList = new ArrayList<LocationImage>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection
					.prepareStatement("SELECT id_image, id_location, url_image, ds_image FROM t_bttf_image_location");

			rs = ps.executeQuery();

			while (rs.next()) {
				locationImageList.add(this.parse(rs));
			}
			if (locationImageList.size() == 0) {
				throw new DataNotFoundException("Imagem de personagem não encontrada");
			}

			return locationImageList;

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
