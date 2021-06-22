package br.com.fiap.bttf.bean;

import java.util.Date;

/**
 * Classe que representa o evento
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class Event {

	private int id;
	private int locationId;
	private int characterId;
	private String name;
	private String description;
	private Image image;
	private Date dateEvent;

	/**
	 * Contrutor de Inicialização sem parâmetros
	 */
	public Event() {

	}

	/**
	 * Construtor de Inicialização com todos os parâmetros
	 * 
	 * @param id          Id do Evento
	 * @param locationId  Id do Local
	 * @param characterId Id do Personagem
	 * @param name        Nome do Evento
	 * @param description Descrição do Evento
	 * @param image       Imagem do Evento
	 * @param dateEvent   Data do Evento
	 */
	public Event(int id, int locationId, int characterId, String name, String description, Image image,
			Date dateEvent) {
		this.id = id;
		this.locationId = locationId;
		this.characterId = characterId;
		this.name = name;
		this.description = description;
		this.image = image;
		this.dateEvent = dateEvent;
	}

	/**
	 * Id do Evento
	 * 
	 * @return id Id do Evento
	 */
	public int getId() {
		return id;
	}

	/**
	 * Id do Evento
	 * 
	 * @param id Id do Evento
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Id do Local
	 * 
	 * @return locationId Id do Local
	 */
	public int getLocationId() {
		return locationId;
	}

	/**
	 * Id do Local
	 * 
	 * @param locationId Id do Local
	 */
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	/**
	 * Id do Personagem
	 * 
	 * @return characterId Id do Personagem
	 */
	public int getCharacterId() {
		return characterId;
	}

	/**
	 * Id do Personagem
	 * 
	 * @param characterId Id do Personagem
	 */
	public void setCharacterId(int characterId) {
		this.characterId = characterId;
	}

	/**
	 * Nome do Evento
	 * 
	 * @return name Nome do Evento
	 */
	public String getName() {
		return name;
	}

	/**
	 * Nome do Evento
	 * 
	 * @param name Nome do Evento
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Descrição do Evento
	 * 
	 * @return description Descrição do Evento
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Descrição do Evento
	 * 
	 * @param description Descrição do Evento
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Imagem do Evento
	 * 
	 * @return image Imagem do Evento
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Imagem do Evento
	 * 
	 * @param image Imagem do Evento
	 */
	public void setImage(Image image) {
		this.image = image;
	}

	/**
	 * Data do Evento
	 * 
	 * @return dateEvent Data do Evento
	 */
	public Date getDateEvent() {
		return dateEvent;
	}

	/**
	 * Data do Evento
	 * 
	 * @param dateEvent Data do Evento
	 */
	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

}
