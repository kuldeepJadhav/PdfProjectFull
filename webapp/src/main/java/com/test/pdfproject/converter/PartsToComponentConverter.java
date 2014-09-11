/**
 * 
 */
package com.test.pdfproject.converter;

import org.springframework.core.convert.converter.Converter;

import com.test.pdfgenerator.pojo.Machine;
import com.test.pdfgenerator.pojo.Parts;
import com.test.pdfproject.pojo.Component;

/**
 * @author jadhavk
 * Converters {@link Machine} to {@link Component}
 */
public class PartsToComponentConverter implements
		Converter<Parts, Component> {

	public Component convert(Parts part) {
		Component c = new Component();
		c.setName(part.getName());
		c.setId(part.getId().toString());
		c.setRate(Integer.toString(part.getCost()));
		//TODO : need to add description in parts
		c.setDescription("This is a test part description");
		return c;
	}

}
