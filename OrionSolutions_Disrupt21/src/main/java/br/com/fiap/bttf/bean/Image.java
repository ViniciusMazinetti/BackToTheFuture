package br.com.fiap.bttf.bean;

/**
 * Classe que representa uma Imagem
 * 
 * @author OrionSolutionsTeam
 * @version 1.0
 */
public class Image {

	private String url;
	private String description;

	/**
	 * Contrutor Inicializa��o sem par�metros
	 */
	public Image() {
	}

	/**
	 * Contrutor Inicializa��o com todos os par�metros
	 * 
	 * @param url         Url da Imagem
	 * @param description Descri��o da Imagem
	 */
	public Image(String url, String description) {
		this.url = url;
		this.description = description;
	}

	/**
	 * Url da Imagem
	 * 
	 * @return url Url da Imagem
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Url da Imagem
	 * 
	 * @param url Url da Imagem
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Descri��o da Imagem
	 * 
	 * @return description Descri��o da Imagem
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Descri��o da Imagem
	 * 
	 * @param description Descri��o da Imagem
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
