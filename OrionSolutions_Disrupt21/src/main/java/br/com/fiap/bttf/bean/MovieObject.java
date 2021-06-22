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
	 * Construtor Inicializa��o sem par�metros
	 */
	public MovieObject() {
	}

	/**
	 * Construtor Inicializa��o com todos os par�metros
	 * 
	 * @param id          Id do Objeto
	 * @param name        Nome do Objeto
	 * @param description Descri��o do Objeto
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
	 * Descri��o do Objeto
	 * 
	 * @return description Descri��o do Objeto
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Descri��o do Objeto
	 * 
	 * @param description Descri��o do Objeto
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
