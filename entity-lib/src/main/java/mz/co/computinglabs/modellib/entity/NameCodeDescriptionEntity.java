package mz.co.computinglabs.modellib.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import mz.co.computinglabs.modellib.entity.AbstractEntity;
/**
 * 
 * @author Clerio Alfredo Faife
 *
 */
@MappedSuperclass
public class NameCodeDescriptionEntity  extends AbstractEntity{
	
 
	private static final long serialVersionUID = 1L;

	@Column(name="code", unique = true)
	private String code;
	
	@Column(name="name", unique = true)
	private String name;
	
	@Column(name="description")
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
