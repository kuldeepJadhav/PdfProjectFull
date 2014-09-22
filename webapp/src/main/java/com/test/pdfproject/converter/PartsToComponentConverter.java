/**
 * 
 */
package com.test.pdfproject.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.test.pdfgenerator.pojo.ActualParts;
import com.test.pdfgenerator.pojo.Parts;
import com.test.pdfproject.pojo.Component;

/**
 * @author jadhavk
 * Converters {@link Parts} to {@link Component}
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
		List<ActualParts> actualParts = part.getActualParts();
		List<Component> subComponents = new ArrayList<Component>();
		
		if(actualParts!=null){
			for(ActualParts ap : actualParts) {
				Component component = new Component();
				component.setId(ap.getId().toString());
				component.setDescription(ap.getDescription());
				component.setName(ap.getName());
				component.setRate(Integer.toString(ap.getCost()));
				subComponents.add(component);
			}
		}
		c.setSubComponenets(subComponents);
		return c;
	}

}
