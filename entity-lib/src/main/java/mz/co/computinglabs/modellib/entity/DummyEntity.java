package mz.co.computinglabs.modellib.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dummy")
public class DummyEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "property_value")
	private String propertyValue;

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

}
