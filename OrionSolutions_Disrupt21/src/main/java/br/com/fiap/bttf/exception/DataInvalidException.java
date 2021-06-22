package br.com.fiap.bttf.exception;

/**
 * Classe respons�vel pela exce��o de dados inv�lidos
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class DataInvalidException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padr�o da exception
	 */
	public DataInvalidException() {
		super();
	}
	
	/**
	 * Construtor que recebe uma messagem de aviso
	 * @param message Menssagem enviada quando ocorre a exce��o
	 */
	public DataInvalidException(String message) {
		super(message);
	}
}
