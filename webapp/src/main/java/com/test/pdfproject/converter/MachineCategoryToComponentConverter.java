/**
 * 
 */
package com.test.pdfproject.converter;

import org.springframework.core.convert.converter.Converter;

import com.test.pdfgenerator.pojo.MachineCategory;
import com.test.pdfproject.pojo.Component;

/**
 * @author jadhavk
 * Converters {@link MachineCategory} to {@link Component}
 */
public class MachineCategoryToComponentConverter implements
		Converter<MachineCategory, Component> {

	
	public Component convert(MachineCategory machineCategory) {
		Component c = new Component();
		c.setDescription(machineCategory.getDescription());
		c.setId(machineCategory.getMachineCategoryId().toString());
		c.setName(machineCategory.getName());
		//c.setUrl(machineCategory.get);
		return c;
	}

}
