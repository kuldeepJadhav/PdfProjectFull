/**
 * 
 */
package com.test.pdfproject.converter;

import org.springframework.core.convert.converter.Converter;

import com.test.pdfgenerator.pojo.PdfDetailsObject;
import com.test.pdfproject.pojo.PdfGenerationDetails;

/**
 * @author jadhavk
 * Converters {@link PdfGenerationDetails} to {@link PdfDetailsObject}
 */
public class PdfGenerationUIToPdfGenerationServiceConverter implements
		Converter< PdfGenerationDetails, PdfDetailsObject> {

	public PdfDetailsObject convert(PdfGenerationDetails pdfGenerationUIObject) {
		PdfDetailsObject pdfDetailsObject = new PdfDetailsObject();
		pdfDetailsObject.setMachineCategoryId(pdfGenerationUIObject.getMachineCategoryId());
		pdfDetailsObject.setMachineId(pdfGenerationUIObject.getMachineId());
		pdfDetailsObject.setSelectedPartIds(pdfGenerationUIObject.getSelectedPartIds());
		return pdfDetailsObject;
	}

}
