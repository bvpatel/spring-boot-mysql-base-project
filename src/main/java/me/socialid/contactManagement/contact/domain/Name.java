package me.socialid.contactManagement.contact.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "name")
@Audited	
@SQLDelete(sql = "UPDATE name SET deleted = 1, deleted_at = CURDATE() WHERE ID = ?")
@Where(clause = "DELETED <> 1")
public class Name extends ConstraintEntity{
	private String prefix;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("middle_name")
	private String middleName;
	private String surname;
	private String suffix;

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

}
