/**
 * 
 */
package com.test.pdfproject.converter;

import org.springframework.core.convert.converter.Converter;

import com.test.pdfgenerator.pojo.Machine;
import com.test.pdfproject.pojo.Component;

/**
 * @author jadhavk
 * Converters {@link Machine} to {@link Component}
 */
public class MachineToComponentConverter implements
		Converter<Machine, Component> {

	public Component convert(Machine machine) {
		Component c = new Component();
		c.setDescription(machine.getDescription());
		c.setId(machine.getMachineId().toString());
		c.setName(machine.getMachineName());
		c.setUrl(machine.getImageUrl());
		return c;
	}

}
