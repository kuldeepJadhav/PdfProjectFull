/**
 * 
 */
package com.test.pdfgenerator.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author jadhavk
 * Class to store the information about the machine category
 */
@Document
@XmlType(propOrder = {"name", "description", "parts", "machineCategoryBasePrice"})
public class MachineCategory {
	
	@Id
	@Field(value = "_id")
	ObjectId machineCategoryId;
	
	private String name;
	
	private int machineCategoryBasePrice;
	
	private String description;
	
	@DBRef(lazy=true)
	private List<Parts> parts;
	
	

	/**
	 * @return the machineCategoryId
	 */
	@XmlTransient
	public ObjectId getMachineCategoryId() {
		return machineCategoryId;
	}

	/**
	 * @param machineCategoryId the machineCategoryId to set
	 */
	public void setMachineCategoryId(ObjectId machineCategoryId) {
		this.machineCategoryId = machineCategoryId;
	}

	@XmlElement(name="machine-category-name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="machine-category-baserate")
	public int getMachineCategoryBasePrice() {
		return machineCategoryBasePrice;
	}

	public void setMachineCategoryBasePrice(int machineCategoryBasePrice) {
		this.machineCategoryBasePrice = machineCategoryBasePrice;
	}

	@XmlElement(name="machine-category-description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement (name="accessory")
	public List<Parts> getParts() {
		return parts;
	}

	public void setParts(List<Parts> parts) {
		this.parts = parts;
	}

	
	

}
