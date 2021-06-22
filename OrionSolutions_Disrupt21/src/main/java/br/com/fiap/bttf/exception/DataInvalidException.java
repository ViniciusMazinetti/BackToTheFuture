package br.com.fiap.bttf.exception;

/**
 * Classe responsável pela exceção de dados inválidos
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class DataInvalidException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padrão da exception
	 */
	public DataInvalidException() {
		super();
	}
	
	/**
	 * Construtor que recebe uma messagem de aviso
	 * @param message Menssagem enviada quando ocorre a exceção
	 */
	public DataInvalidException(String message) {
		super(message);
	}
}
