/**
 * 
 */
package com.test.pdfgenerator.pojo;

import java.util.List;

/**
 * @author jadhavk
 *
 */
public class PdfDetailsObject {

	private String machineId;
	private String machineCategoryId;
	private List<String> selectedPartIds;
	/**
	 * @return the machineId
	 */
	public String getMachineId() {
		return machineId;
	}
	/**
	 * @param machineId the machineId to set
	 */
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	/**
	 * @return the machineCategoryId
	 */
	public String getMachineCategoryId() {
		return machineCategoryId;
	}
	/**
	 * @param machineCategoryId the machineCategoryId to set
	 */
	public void setMachineCategoryId(String machineCategoryId) {
		this.machineCategoryId = machineCategoryId;
	}
	/**
	 * @return the selectedPartIds
	 */
	public List<String> getSelectedPartIds() {
		return selectedPartIds;
	}
	/**
	 * @param selectedPartIds the selectedPartIds to set
	 */
	public void setSelectedPartIds(List<String> selectedPartIds) {
		this.selectedPartIds = selectedPartIds;
	}
	
	
	
}
