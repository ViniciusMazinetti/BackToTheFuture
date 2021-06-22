package br.com.fiap.bttf.bean;

/**
 * Classe que representa Objeto (Objetos marcantes do Filme)
 * 
 * @author OrionSolutionsTeam
 * @version 1.0
 */
public class MovieObject {

	private int id;
	private String name;
	private String description;
	private Image image;

	/**
	 * Construtor Inicialização sem parâmetros
	 */
	public MovieObject() {
	}

	/**
	 * Construtor Inicialização com todos os parâmetros
	 * 
	 * @param id          Id do Objeto
	 * @param name        Nome do Objeto
	 * @param description Descrição do Objeto
	 * @param image       Imagem do Objeto
	 */
	public MovieObject(int id, String name, String description, Image image) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = image;
	}

	/**
	 * Id do Objeto
	 * 
	 * @return id Id do Objeto
	 */
	public int getId() {
		return id;
	}

	/**
	 * Id do Objeto
	 * 
	 * @param id Id do Objeto
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Nome do Objeto
	 * 
	 * @return name Nome do Objeto
	 */
	public String getName() {
		return name;
	}

	/**
	 * Nome do Objeto
	 * 
	 * @param name Nome do Objeto
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Descrição do Objeto
	 * 
	 * @return description Descrição do Objeto
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Descrição do Objeto
	 * 
	 * @param description Descrição do Objeto
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Imagem do Objeto
	 * 
	 * @return image Imagem do Objeto
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Imagem do Objeto
	 * 
	 * @param image Imagem do Objeto
	 */
	public void setImage(Image image) {
		this.image = image;
	}

}
