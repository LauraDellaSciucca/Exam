package javaExamProject.spring.model;

public class Metadata {
	protected String alias;
	protected String sourceField;
	protected String type;

	public Metadata(String alias, String sourceField, String type) {
		this.alias = alias;
		this.sourceField = sourceField;
		this.type = type;
	}

    public String getAlias() {
		return alias;
	}

	public String getSourceField() {
		return sourceField;
	}

	public String getType() {
		return type;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setSourceField(String sourceField) {
		this.sourceField = sourceField;
	}

	public void setType(String type) {
		this.type = type;
	}

}
