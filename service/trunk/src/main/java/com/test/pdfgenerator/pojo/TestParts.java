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

@Document(collection = "testparts")
@XmlType(propOrder = {"name","cost", "type","description","actualParts"})
public class TestParts {
	@Id
	@Field(value = "_id")
	private ObjectId id;

	private String name;

	private int cost;

	private PartType type;
	
	private String description = "This is test description";
	
	@DBRef(lazy=true)
	private List<ActualParts> actualParts;
	

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

	/**
	 * @return the actualParts
	 */
	@XmlElement (name="actual-parts")
	public List<ActualParts> getActualParts() {
		return actualParts;
	}

	/**
	 * @param actualParts the actualParts to set
	 */
	public void setActualParts(List<ActualParts> actualParts) {
		this.actualParts = actualParts;
	}

	
}
