package com.test.pdfproject.pojo;

/**
 * 
 * @author jadhavk
 * Class to store the genereal information about the component.Basically used to send 
 * {@link com.test.pdfgeneratio.pojo.Machine} , {@link com.test.pdfgeneratio.pojo.MachineCategory} , 
 * {@link com.test.pdfgeneratio.pojo.Parts} , {@link com.test.pdfgeneratio.pojo.Company}    
 * 
 */
public class Component {
	
	private String id;
	
	private String name;
	
	private String description;
	
	private String url;
	
	private String rate;
	

	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	

}
