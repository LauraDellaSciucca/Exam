package javaExamProject.spring.model;
/**
 * Classe che ci permette di descrivere il nostro insieme di dati
 * @author Angela D'Antonio 
 * @author Laura Della Sciucca
 */

public class Metadata {
	/**
	 * attributi della classe
	 */
	protected String alias;
	protected String sourceField;
	protected String type;

	/**
	 *metodo costruttore, ogni attributo del dataset attività è descritto da un oggetto di tipo metadata
	 * @param alias nome, specificato da noi che sostituisce il nome reale dell'attirbuto del dataset
	 * @param sourceField, nome reale dell'attributo
	 * @param type, tipo dell'attributo
	 */
	public Metadata(String alias, String sourceField, String type) {
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}
	/**
	 * 
	 * @return alias, alias dell'attributo
	 */

    public String getAlias() {
		return alias;
	}
    /**
     * 
     * @return sourceField, nome dell'attributo nel dataset
     */

	public String getSourceField() {
		return sourceField;
	}
	/**
	 * 
	 * @return type, tipo dell'attributo
	 */

	public String getType() {
		return type;
	}
	/**
	 * 
	 * @param alias, assegna un alias all'attributo
	 */

	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * 
	 * @param sourceField, assegna un nome all'attributo
	 */

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}
	/**
	 * 
	 * @param type, assegna un tipo all'attributo
	 */

	public void setType(String type) {
		this.type = type;
	}

}
