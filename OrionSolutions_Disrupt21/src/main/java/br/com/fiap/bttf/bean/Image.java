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
	 * Contrutor Inicialização sem parâmetros
	 */
	public Image() {
	}

	/**
	 * Contrutor Inicialização com todos os parâmetros
	 * 
	 * @param url         Url da Imagem
	 * @param description Descrição da Imagem
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
	 * Descrição da Imagem
	 * 
	 * @return description Descrição da Imagem
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Descrição da Imagem
	 * 
	 * @param description Descrição da Imagem
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
