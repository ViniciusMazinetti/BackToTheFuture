package br.com.fiap.bttf.bean;

import java.util.List;

/**
 * Classe que representa o Personagem
 * 
 * @author OrionSolutionTeam
 * @version 1.0
 */
public class Character {

	private int id;
	private String name;
	private String description;
	private String actorsName;
	private List<MovieObject> objects;
	private List<CharacterImage> characterImages;

	/**
	 * Construtor Inicializa��o sem par�metros
	 */
	public Character() {
	}

	/**
	 * Construtor Inicializa��o com todos os par�metros
	 * 
	 * @param id              Id do Personagem
	 * @param name            Nome do Personagem
	 * @param description     Descri��o do Personagem
	 * @param actorsName      Nome do Ator
	 * @param objects         Lista de Objetos relacionados ao Personagem
	 * @param characterImages Lista de Imagens do Personagem
	 */
	public Character(int id, String name, String description, String actorsName, List<MovieObject> objects,
			List<CharacterImage> characterImages) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.actorsName = actorsName;
		this.objects = objects;
		this.characterImages = characterImages;
	}

	/**
	 * Id do Personagem
	 * 
	 * @return id Id do Personagem
	 */
	public int getId() {
		return id;
	}

	/**
	 * Id do Personagem
	 * 
	 * @param id Id do Personagem
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Nome do Personagem
	 * 
	 * @return name Nome do Personagem
	 */
	public String getName() {
		return name;
	}

	/**
	 * Nome do Personagem
	 * 
	 * @param name Nome do Personagem
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Descri��o do Personagem
	 * 
	 * @return description Descri��o do Personagem
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Descri��o do Personagem
	 * 
	 * @param description Descri��o do Personagem
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Nome do Ator
	 * 
	 * @return actorsName Nome do Ator
	 */
	public String getActorsName() {
		return actorsName;
	}

	/**
	 * Nome do Ator
	 * 
	 * @param actorsName Nome do Ator
	 */
	public void setActorsName(String actorsName) {
		this.actorsName = actorsName;
	}

	/**
	 * Lista de Objetos relacionados ao Personagem
	 * 
	 * @return List Object Lista de Objetos
	 */
	public List<MovieObject> getObjects() {
		return objects;
	}

	/**
	 * Lista de Objetos relacionados ao Personagem
	 * 
	 * @param objects Lista de Objetos
	 */
	public void setObjects(List<MovieObject> objects) {
		this.objects = objects;
	}

	/**
	 * Lista de Imagens do Personagem
	 * 
	 * @return List CharacterImage Lista de Imagens do Personagem
	 */
	public List<CharacterImage> getCharacterImages() {
		return characterImages;
	}

	/**
	 * Lista de Imagens do Personagem
	 * 
	 * @param characterImages Lista de Imagens do Personagem
	 */
	public void setCharacterImages(List<CharacterImage> characterImages) {
		this.characterImages = characterImages;
	}
}
