package br.com.fiap.bttf.exception;

/**
 * Classe respons�vel pela exce��o de n�o encontrar os dados
 * @author OrionSolutionTeam
 * @version 1.0
 *
 */
public class DataNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor padr�o da exception
	 */
	public DataNotFoundException() {
		super();
	}
	
	/**
	 * Construtor que recebe uma messagem de aviso
	 * @param message Menssagem enviada quando ocorre a exce��o
	 */
	public DataNotFoundException(String message) {
		super(message);
	}

}
