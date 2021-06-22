package br.com.fiap.bttf.exception;

/**
 * Classe responsável pela exceção de não encontrar os dados
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class DataNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padrão da exception
	 */
	public DataNotFoundException() {
		super();
	}
	
	/**
	 * Construtor que recebe uma messagem de aviso
	 * @param message Menssagem enviada quando ocorre a exceção
	 */
	public DataNotFoundException(String message) {
		super(message);
	}

}
