/**
 * 
 */
package com.test.pdfgenerator.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlTransient; 

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author jadhavk 
 * 
 * Class stores the information about the machine.
 */
@Document(collection="machine")
@XmlType(propOrder = {"machineName", "description","imageUrl", "machineCategories"})
public class Machine {

	@Id
	@Field(value = "_id")
	private ObjectId machineId;
	
	
	private String machineName;

	private String description;

	private String imageUrl;

	private int machineBasePrice;

	@DBRef(lazy=true)
	private List <MachineCategory> machineCategories;

	
	@XmlTransient
	public ObjectId getMachineId() {
		return machineId;
	}

	public void setMachineId(ObjectId machineId) {
		this.machineId = machineId;
	}

	@XmlElement(name="machine-name")
	public String getMachineName() {
		return machineName;
	}

	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}

	@XmlElement(name="machine-info")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name="machine-image")
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@XmlTransient
	public int getMachineBasePrice() {
		return machineBasePrice;
	}

	public void setMachineBasePrice(int machineBasePrice) {
		this.machineBasePrice = machineBasePrice;
	}

	@XmlElement(name="machine-category")
	public List<MachineCategory> getMachineCategories() {
		return machineCategories;
	}

	public void setMachineCategories(List<MachineCategory> machineCategories) {
		this.machineCategories = machineCategories;
	}

	
	


	
}
