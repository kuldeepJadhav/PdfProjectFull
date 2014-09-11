package com.test.pdfgenerator.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


/**
 * 
 * @author jadhavk
 * Class to store the information about each part of the machine
 */
@Document(collection = "parts")
@XmlType(propOrder = {"name","cost", "type","description"})
public class Parts {
	@Id
	@Field(value = "_id")
	private ObjectId id;

	private String name;

	private int cost;

	private PartType type;
	
	private String description = "This is test description";
	
	

	/**
	 * @return the description
	 */
	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	@XmlElement(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="cost")
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@XmlElement (name="type")
	public PartType getType() {
		return type;
	}

	public void setType(PartType type) {
		this.type = type;
	}

}
