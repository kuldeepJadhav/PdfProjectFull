package com.test.pdfgenerator.pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.test.pdfgenerator.pojo.Company;
import com.test.pdfgenerator.pojo.Machine;

@XmlRootElement(name="root")
@XmlType(propOrder = {"company", "machine"})
public class PdfDataDetails {
	private Company company;
	private Machine machine;
	
	public PdfDataDetails(){};
	
	public PdfDataDetails(Company company, Machine machine) {
		this.company = company;
		this.machine = machine;
	}

	@XmlElement
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@XmlElement
	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
		
}