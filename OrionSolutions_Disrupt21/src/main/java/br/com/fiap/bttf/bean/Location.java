package br.com.fiap.bttf.bean;

import java.util.List;

/**
 * Classe que representa o Local "Cenário"
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 */
public class Location {

	private int id;
	private String name;
	private String description;
	private List<LocationImage> locationImages;

	/**
	 * Construtor Inicialização sem parâmetros
	 */
	public Location() {
	}

	/**
	 * Construtor Inicialização com todos os parâmetros
	 * 
	 * @param id             Id do Local
	 * @param name           Nome do Local
	 * @param description    Descrição do Local
	 * @param locationImages Lista de Imagens do Local
	 */
	public Location(int id, String name, String description, List<LocationImage> locationImages) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.locationImages = locationImages;
	}

	/**
	 * Id do Local
	 * 
	 * @return id Id do Local
	 */
	public int getId() {
		return id;
	}

	/**
	 * Id do Local
	 * 
	 * @param id Id do Local
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Nome do Local
	 * 
	 * @return name Nome do Local
	 */
	public String getName() {
		return name;
	}

	/**
	 * Nome do Local
	 * 
	 * @param name Nome do Local
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Descrição do Local
	 * 
	 * @return description Descrição do Local
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Descrição do Local
	 * 
	 * @param description Descrição do Local
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Lista de Imagens do Local
	 * 
	 * @return List LocationImage Lista de Imagens do Local
	 */
	public List<LocationImage> getLocationImages() {
		return locationImages;
	}

	/**
	 * Lista de Imagens do Local
	 * 
	 * @param locationImages Lista de Imagens do Local
	 */
	public void setLocationImages(List<LocationImage> locationImages) {
		this.locationImages = locationImages;
	}
}
