package br.com.fiap.bttf.bean;

/**
 * Classe que representa Imagem de Personagens
 * 
 * @author OrionSolutionsTeams
 * @version 1.0
 */
public class CharacterImage extends Image {

	private int id;
	private int characterId;

	/**
	 * Contrutor de Inicialização sem parâmetros
	 */
	public CharacterImage() {
		super();
	}

	/**
	 * Construtor de Inicialização com todos os parâmetros
	 * 
	 * @param id          Id da imagem personagem
	 * @param characterId Id do Personagem
	 * @param url         Url da Imagem do Personagem
	 * @param description Descrição da Imagem do Personagem
	 */
	public CharacterImage(int id, int characterId, String url, String description) {
		super(url, description);
		this.id = id;
		this.characterId = characterId;
	}

	/**
	 * Id da Imagem do Personagem
	 * 
	 * @return id Id da Imagem do Personagem
	 */
	public int getId() {
		return id;
	}

	/**
	 * Id da Imagem do Personagem
	 * 
	 * @param id Id da Imagem do Personagem
	 */
	public void setId(int id) {
		this.id = id;
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
}
