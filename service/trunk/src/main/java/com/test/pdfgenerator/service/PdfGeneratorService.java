/**
 * 
 */
package com.test.pdfgenerator.service;

import java.util.List;

import com.test.pdfgenerator.pojo.Company;
import com.test.pdfgenerator.pojo.Machine;
import com.test.pdfgenerator.pojo.MachineCategory;
import com.test.pdfgenerator.pojo.PartType;
import com.test.pdfgenerator.pojo.Parts;
import com.test.pdfgenerator.pojo.PdfDetailsObject;

/**
 * 
 * @author jadhavk
 * <br><br>
 * <p>
 * Interface that provides methods to read the data from database, and also provides functions
 * for generation of pdf
 * </p>
 */
public interface PdfGeneratorService {

	/**
	 * 
	 * @param name
	 * @return {@link Company} object
	 * <p>
	 * Method returns the company object
	 * </p> 
	 */
	public Company getCompanyDetailsByName(String name);
	
	/**
	 * 
	 * 
	 * @return list of {@link Machine} objects
	 * <p>
	 * 	Method returns list of machine objects
	 * </p>
	 */
	public List<Machine> getMachineList();
	
	
	/**
	 * 
	 * @param machineId - database Id for machine collection
	 * @return list of {@link MachineCategory}
	 * <p> returns list of {@link MachineCategory} based on the {@link Machine} id passed</p>
	 */
	public List<MachineCategory> getMachineCategoryListByMachineId(String machineId);
	
	/**
	 * 
	 * @param categoryId - machine category id
	 * @param partType - PartType {@link PartType#DISCOUNTED} or {@link PartType#NONDISCOUNTED}
	 * @return list of {@link Parts}
	 */
	public List<Parts> getListOfPartsForCategoryBasedOnPartType(String categoryId , PartType partType);
	
	/**
	 * 
	 * @param pdfDetailsObject {@link PdfDetailsObject}- object holding details for pdf generation
	 * @return returns {@link Boolean} 
	 * 
	 * <br><br>
	 * <p>
	 * determines if pdf was generated sucessfully or no.
	 * </p>
	 */
	public boolean generatePdf(PdfDetailsObject pdfDetailsObject) ;
}
