package br.com.fiap.bttf.bean;

/**
 * Classe que representa Imagens de Locais
 * 
 * @author OrionSolutionsTeam
 * @version 1.0
 */
public class LocationImage extends Image {

	private int id;
	private int locationId;

	/**
	 * Construtor de Inicialização sem parâmetros
	 */
	public LocationImage() {
		super();
	}

	/**
	 * Construtor de Inicialização com todos os parâmetros
	 * 
	 * @param id          Id da Imagem do Local
	 * @param locationId  Id do Local
	 * @param url         Url da Imagem do Local
	 * @param description Descrição da Imagem do Local
	 */
	public LocationImage(int id, int locationId, String url, String description) {
		super(url, description);
		this.id = id;
		this.locationId = locationId;
	}

	/**
	 * Id da Imagem do Local
	 * 
	 * @return id Id da Imagem do Local
	 */
	public int getId() {
		return id;
	}

	/**
	 * Id da Imagem do Local
	 * 
	 * @param id Id da Imagem do Local
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Id do Local
	 * 
	 * @return id Id do Local
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

}
