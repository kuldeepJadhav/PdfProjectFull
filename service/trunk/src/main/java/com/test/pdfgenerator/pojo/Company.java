/**
 * 
 */
package com.test.pdfgenerator.pojo;

import org.springframework.data.mongodb.core.mapping.Document;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * @author jadhavk
 * Class to store the company info
 */
@Document(collection="company")
@XmlType(propOrder = {"name", "description","logoUrl"})
public class Company {
	
	String name;
	
	String description;
	
	String logoUrl;
	
	@XmlElement(name="company-name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="company-info")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the logoUrl
	 */
	@XmlElement(name="company-logo")
	public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * @param logoUrl the logoUrl to set
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

		
	
	
	
	
	

}
