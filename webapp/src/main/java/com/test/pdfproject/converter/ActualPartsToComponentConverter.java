/**
 * 
 */
package com.test.pdfproject.converter;

import org.springframework.core.convert.converter.Converter;

import com.test.pdfgenerator.pojo.ActualParts;
import com.test.pdfproject.pojo.Component;

/**
 * @author jadhavk
 * Converters {@link ActualParts} to {@link Component}
 */
public class ActualPartsToComponentConverter implements
		Converter<ActualParts, Component> {

	public Component convert(ActualParts part) {
		Component c = new Component();
		c.setName(part.getName());
		c.setId(part.getId().toString());
		c.setRate(Integer.toString(part.getCost()));
		c.setDescription(part.getDescription());
		return c;
	}

}
