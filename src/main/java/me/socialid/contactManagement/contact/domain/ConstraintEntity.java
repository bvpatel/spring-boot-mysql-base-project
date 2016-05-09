package me.socialid.contactManagement.contact.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.hibernate.envers.Audited;

import me.socialid.contactManagement.audit.DateFormatterAdapter;

@MappedSuperclass
@Audited
public abstract class ConstraintEntity extends AbstractEntity {

	public static final String VALIDFROM = "validFrom";
	public static final String VALIDTO = "validTo";
	public static final String CONSTRAINTS = "constraints";
	
	private String constraints;
	@XmlJavaTypeAdapter(DateFormatterAdapter.class)
	private Date validFrom;
	@XmlJavaTypeAdapter(DateFormatterAdapter.class)
	private Date validTo;
	
	@Column(name = "constraints", columnDefinition = "Text")
	public String getConstraints() {
		return constraints;
	}

	public void setConstraints(String constraints) {
		this.constraints = constraints;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
}