package javaExamProject.spring.util;
/**
 * Classe utile alla visualizzazione di errori in caso l'utente sbagli la richiesta oppure non ci siano atività con i valori specificati.
 * @author Angela D'Antonio
 * @author Laura Della Sciucca
 */
public class Error {

	private String message;
	/**
	 * metodo costruttore che permette di istanziare l'oggetto Error con una stringa contenente il messaggio
	 * @param message
	 */

	public Error(String message) {
		super();
		this.message = message;
	}
	/**
	 * @return message, messaggio importato dal costruttore
	 */
	public String getMessage() {
		return message;
	}


}
