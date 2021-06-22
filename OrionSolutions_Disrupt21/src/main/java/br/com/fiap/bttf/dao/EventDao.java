package br.com.fiap.bttf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.bttf.bean.Event;
import br.com.fiap.bttf.bean.Image;
import br.com.fiap.bttf.exception.DataNotFoundException;

/**
 * Classe responsável por realizar consulta de Eventos
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class EventDao {

	private Connection connection;

	public EventDao(Connection connection) {
		this.connection = connection;
	}

	/**
	 * Método de transformação de um ResultSet para Event
	 * 
	 * @param rs Objeto do tipo ResultSet
	 * @return Event Objeto do tipo Event
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public Event parse(ResultSet rs) throws SQLException, ClassNotFoundException, DataNotFoundException {
		int id = rs.getInt("id_event");
		int localId = rs.getInt("id_location");
		int characterId = rs.getInt("id_character");
		String name = rs.getString("nm_event");
		String description = rs.getString("ds_event");
		String url = rs.getString("url_image");
		Date dateEvent = rs.getDate("dt_event");
		Image image = new Image(url, null);

		Event event = new Event(id, localId, characterId, name, description, image, dateEvent);
		return event;
	}

	/**
	 * Pesquisar pelo Id do Personagem
	 * 
	 * @param characterId Id do Personagem
	 * @return Event Objeto do tipo Event
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<Event> searchByCharacterId(int characterId)
			throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<Event> events = new ArrayList<Event>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection.prepareStatement(
					"SELECT id_event, id_location, id_character, nm_event, ds_event, url_image, dt_event"
							+ " FROM t_bttf_event WHERE id_character = ? ");

			ps.setInt(1, characterId);
			rs = ps.executeQuery();

			while (rs.next()) {
				events.add(this.parse(rs));
			}
			if (events.size() == 0) {
				throw new DataNotFoundException("Evento não encontrado");
			}

			return events;

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
	 * @param locationId Is do Local
	 * @return List Event Lista de Eventos
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<Event> searchByLocationId(int locationId)
			throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<Event> events = new ArrayList<Event>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection.prepareStatement(
					"SELECT id_event, id_location, id_character, nm_event, ds_event, url_image, dt_event"
							+ " FROM t_bttf_event WHERE id_location = ? ");

			ps.setInt(1, locationId);
			rs = ps.executeQuery();

			while (rs.next()) {
				events.add(this.parse(rs));
			}
			if (events.size() == 0) {
				throw new DataNotFoundException("Evento não encontrado");
			}

			return events;

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
	 * Listar todos os Eventos
	 * 
	 * @return List Event Lista de Evento
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public List<Event> list() throws DataNotFoundException, ClassNotFoundException, SQLException {
		List<Event> events = new ArrayList<Event>();

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement(
					"SELECT id_event, id_location, id_character, nm_event, ds_event, url_image, dt_event FROM t_bttf_event");

			rs = ps.executeQuery();

			while (rs.next()) {
				events.add(this.parse(rs));
			}
			if (events.size() == 0) {
				throw new DataNotFoundException("Não possui eventos");
			}

			return events;

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
	 * Pesquisar pelo Id do Evento
	 * 
	 * @param Id Id do Evento
	 * @return Event Objeto do tipo Event
	 * @throws SQLException           Exceção do tipo SQL
	 * @throws ClassNotFoundException Exceção quando a classe não é encontrada
	 * @throws DataNotFoundException  Exceção quando os dados não foram encontrados
	 */
	public Event searchById(int Id) throws ClassNotFoundException, SQLException, DataNotFoundException {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = connection.prepareStatement(
					"SELECT id_event, id_location, id_character, nm_event, ds_event, url_image, dt_event FROM t_bttf_event"
							+ "WHERE id_event = ?");
			ps.setInt(1, Id);
			rs = ps.executeQuery();

			Event event = null;

			if (rs.next())
				event = this.parse(rs);
			else
				throw new DataNotFoundException("Evento não encontrado");

			return event;

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
