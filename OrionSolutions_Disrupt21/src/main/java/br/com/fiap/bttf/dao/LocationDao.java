package br.com.fiap.bttf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bttf.bean.Location;
import br.com.fiap.bttf.bean.LocationImage;
import br.com.fiap.bttf.exception.DataNotFoundException;

/**
 * Classe responsável por realizar consulta de Locais
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class LocationDao {

	private Connection connection;

	public LocationDao(Connection connection) {
		this.connection = connection;
	}
	
	
	/**
	 * Método de transformação de um ResultSet para Location
	 * @param rs Objeto do tipo ResultSet
	 * @return Location  Objeto do tipo Location
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public Location parse(ResultSet rs) throws SQLException, ClassNotFoundException, DataNotFoundException {
		
		LocationImageDao locationImageDao = new LocationImageDao(connection); 
		
		int id = rs.getInt("id_location");
		String name = rs.getString("nm_location");
		String description = rs.getString("ds_location");
		List<LocationImage> locations = locationImageDao.searchByLocationId(id);
		Location location = new Location(id, name, description,locations);
		return location;
	}

	/**
	 * Pesquisar pelo Id do Local 
	 * @param Id Id do Local
	 * @return Location Objeto do tipo Location
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public Location searchById(int Id) throws ClassNotFoundException, SQLException, DataNotFoundException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection
					.prepareStatement("SELECT id_location, nm_location, ds_location FROM t_bttf_location "
							+ "WHERE id_location = ?");
			ps.setInt(1, Id);
			rs = ps.executeQuery();

			Location location = null;

			if (rs.next())
				location = this.parse(rs);
			else
				throw new DataNotFoundException("Local não encontrado");

			return location;

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
	 * Listar todos os locais
	 * @return List Location Lista de Locais
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<Location> list() throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<Location> locationList = new ArrayList<Location>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement(
					"SELECT id_location, nm_location, ds_location FROM t_bttf_location");

			rs = ps.executeQuery();

			while (rs.next()) {
				locationList.add(this.parse(rs));
			}
			if (locationList.size() == 0) {
				throw new DataNotFoundException("Local não encontrado");
			}

			return locationList;

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
