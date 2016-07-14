package hiberbank.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCHEMA_INFO")
public class SchemaInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String value;
	
	public SchemaInfo() {
	}
	
	public SchemaInfo(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		return "SchemaInfo [id=" + id + ", name=" + name + ", value=" + value + "]";
	}
}
