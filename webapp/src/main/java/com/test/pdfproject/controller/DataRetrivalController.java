/**
 * 
 */
package com.test.pdfproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.pdfgenerator.pojo.Machine;
import com.test.pdfgenerator.pojo.MachineCategory;
import com.test.pdfgenerator.pojo.PartType;
import com.test.pdfgenerator.pojo.Parts;
import com.test.pdfgenerator.pojo.PdfDetailsObject;
import com.test.pdfgenerator.service.PdfGeneratorService;
import com.test.pdfproject.pojo.Component;
import com.test.pdfproject.pojo.PdfGenerationDetails;

/**
 * @author jadhavk
 *
 * Controller which provides functions to 
 * 1) get the machine details
 * 2) get the machineCategory details
 * 3) get the part details
 */

@Controller
@RequestMapping("/pdfproject")
public class DataRetrivalController {
	
	@Autowired
	PdfGeneratorService pdfGeneratorService;
	
	@Autowired
	ConversionService conversionService;
	
	/**
	 * @return list of {@link Component}
	 * The method returns list of {@link Component} class which contains details
	 * about Machines @see {@link Machine} 
	 */
	@RequestMapping(value="/getmachinenamelist",method = RequestMethod.GET)
	@ResponseBody

	public List<Component> getMachineNameList() {
		List<Machine> machineList = pdfGeneratorService.getMachineList();
		List<Component> componentList = new ArrayList<Component>();
		for(Machine machine :  machineList){
			Component component = conversionService.convert(machine, Component.class);
			componentList.add(component);
		}
		
		return componentList;
	}

	/**
	 * @return list of {@link Component}
	 * The method returns list of {@link Component} class which contains details
	 * about Machines @see {@link MachineCategory} 
	 */
	@RequestMapping(value="/getmachinecategorylist",method = RequestMethod.GET)
	@ResponseBody
	public List<Component> getMachineCategoryListByMachineId( @RequestParam(value="machineId") String machineId) {
		
		List<MachineCategory> machineCategoryListByMachineId = pdfGeneratorService.getMachineCategoryListByMachineId(machineId);
		List<Component> componentList = new ArrayList<Component>();
		for(MachineCategory category :  machineCategoryListByMachineId){
			Component component = conversionService.convert(category, Component.class);
			componentList.add(component);
		}
		return componentList; 
	}
	
	/**
	 * @return list of {@link Component}
	 * The method returns list of {@link Component} class which contains details
	 * about Machines @see {@link MachineCategory} 
	 */
	@RequestMapping(value="/getpartslist",method = RequestMethod.GET)
	@ResponseBody
	public List<Component> getPartsListByMachineCategoryId( @RequestParam(value="machineCategoryId") String machineCategoryId) {
		
		List<Parts> listOfParts = pdfGeneratorService.getListOfPartsForCategoryBasedOnPartType(machineCategoryId, PartType.DISCOUNTED);
		List<Parts> listOfNonDiscountedParts = pdfGeneratorService.getListOfPartsForCategoryBasedOnPartType(machineCategoryId, PartType.NONDISCOUNTED);
		listOfParts.addAll(listOfNonDiscountedParts);
		List<Component> componentList = new ArrayList<Component>();
		for(Parts part :  listOfParts){
			Component component = conversionService.convert(part, Component.class);
			componentList.add(component);
		}
		return componentList; 
	}
	
	/**
	 * 
	 * @param pdfDetailsPbj
	 * @return
	 * The methods calls the service to generate the pdf
	 */
	@RequestMapping(value="/generatePdf",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> generatePdf(@RequestBody PdfGenerationDetails pdfDetailsObj) {
		PdfDetailsObject pdfDetailsObject = conversionService.convert(pdfDetailsObj, PdfDetailsObject.class);
		System.out.println(pdfDetailsObject.getMachineCategoryId());
		System.out.println(pdfDetailsObject.getMachineId());
		System.out.println(pdfDetailsObject.getSelectedPartIds().size());
		pdfGeneratorService.generatePdf(pdfDetailsObject);
		return null;
	}
	
	
	

}
