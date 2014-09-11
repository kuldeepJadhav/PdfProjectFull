/**
 * 
 */
package com.test.pdfgenerator.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.test.pdfgenerator.pojo.Company;
import com.test.pdfgenerator.pojo.Machine;
import com.test.pdfgenerator.pojo.MachineCategory;
import com.test.pdfgenerator.pojo.PartType;
import com.test.pdfgenerator.pojo.Parts;
import com.test.pdfgenerator.pojo.PdfDataDetails;
import com.test.pdfgenerator.pojo.PdfDetailsObject;
import com.test.pdfgenerator.repositories.CompanyRepository;
import com.test.pdfgenerator.repositories.MachineCategoryRepository;
import com.test.pdfgenerator.repositories.MachineRepository;
import com.test.pdfgenerator.repositories.PartsRepository;


/**
 * @author jadhavk
 * @see com.test.pdfgenerator.service.PdfGeneratorService
 */
@Service
public class PdfGeneratorServiceImpl implements PdfGeneratorService {
	
	@Autowired
	CompanyRepository companyRepo;
	
	@Autowired
	MachineRepository machineRepo;
	
	@Autowired
	MachineCategoryRepository machineCategoryRepo;
	
	@Autowired
	PartsRepository partsRepo;

	/* (non-Javadoc)
	 * @see com.test.pdfgenerator.service.PdfGeneratorService#getCompanyDetailsByName(java.lang.String)
	 */
	public Company getCompanyDetailsByName(String name) {
		return companyRepo.findByName(name);
	}

	/* (non-Javadoc)
	 * @see com.test.pdfgenerator.service.PdfGeneratorService#getMachineList()
	 */
	public List<Machine> getMachineList() {
		return machineRepo.findAll();
	}

	/* (non-Javadoc)
	 * @see com.test.pdfgenerator.service.PdfGeneratorService#getMachineCategoryListByMachineId(org.bson.types.ObjectId)
	 */
	public List<MachineCategory> getMachineCategoryListByMachineId(
			String machineId) {
		ObjectId id = new ObjectId(machineId);
		Machine machine = machineRepo.findOne(id);
		List<MachineCategory> machineCategories = machine.getMachineCategories();
		return machineCategories;
	}

	/* (non-Javadoc)
	 * @see com.test.pdfgenerator.service.PdfGeneratorService#getListOfPartsForCategoryBasedOnPartType(org.bson.types.ObjectId, com.test.pdfgenerator.pojo.PartType)
	 */
	public List<Parts> getListOfPartsForCategoryBasedOnPartType(
			String categoryId, PartType partType) {
		ObjectId id = new ObjectId(categoryId);
		MachineCategory machinecategory = machineCategoryRepo.findOne(id);
		List<Parts> parts = machinecategory.getParts();
		List<Parts> result = new ArrayList<Parts>();
		for(Parts p : parts){
			PartType type = p.getType();
			if(partType == type){
				result.add(p);
			}
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.test.pdfgenerator.service.PdfGeneratorService#generatePdf(PdfDetailsObject pdfDetailsObject)
	 */
	public boolean generatePdf(PdfDetailsObject pdfDetailsObject) {
		try{
			List<String> selectedPartIds = pdfDetailsObject.getSelectedPartIds();
			List<Parts> selectedParts = getSelectedParts(selectedPartIds);
			
			String machineCategoryId = pdfDetailsObject.getMachineCategoryId();
			MachineCategory machineCategory = machineCategoryRepo.findOne(new ObjectId(machineCategoryId));
			machineCategory.setParts(selectedParts);
			
			String machineId = pdfDetailsObject.getMachineId();
			Machine machine = machineRepo.findOne(new ObjectId(machineId));
			List<MachineCategory> machineCatList = new ArrayList<MachineCategory>();
			machineCatList.add(machineCategory);
			machine.setMachineCategories(machineCatList);
			
			PdfDataDetails details = new PdfDataDetails();
			Company company = getCompanyDetailsByName("Xyz Machine Works");
			details.setCompany(company);
			details.setMachine(machine);
			
			JAXBContext jaxbContext = JAXBContext.newInstance(PdfDataDetails.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            String fileName = "PDFDataDetails" + new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) +".xml";
            File xmlFilePath = new File("/Users/jadhavk/data/xmlfiles/"+fileName);
            jaxbMarshaller.marshal(details, xmlFilePath);
            generatePdfFileOnSystem("/Users/jadhavk/data/xmlfiles/"+fileName);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private String generatePdfFileOnSystem(String xmlFilePath) throws Exception{
		
		ClassPathResource cpr = new ClassPathResource("data2.xsl");
		File xsltfile = cpr.getFile();
		// the XML file from which we take the name
		//ClassPathResource cpr1 = new ClassPathResource(xmlFilePath);
		System.out.println("xmlFilePath is " + xmlFilePath);
		File xmlFile = new File(xmlFilePath);
		StreamSource source = new StreamSource(xmlFile);
		// creation of transform source
		StreamSource transformSource = new StreamSource(xsltfile);
		// create an instance of fop factory
		FopFactory fopFactory = FopFactory.newInstance();
		// a user agent is needed for transformation
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		// to store output
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		
		 String fileName = "/Users/jadhavk/data/xmlfiles/PDF" + new SimpleDateFormat("yyyyMMddhhmm'.txt'").format(new Date()) +".pdf";
		FileOutputStream pdfFile = new FileOutputStream(fileName);

		Transformer xslfoTransformer;
		try
		{
			TransformerFactory transfact = TransformerFactory.newInstance();
			xslfoTransformer = transfact.newTransformer(transformSource);
		        Fop fop;
			try
			{
				fop = fopFactory.newFop
					(MimeConstants.MIME_PDF, foUserAgent, outStream);
				// Resulting SAX events (the generated FO) 
				// must be piped through to FOP
		                Result res = new SAXResult(fop.getDefaultHandler());

				// Start XSLT transformation and FOP processing
				try
				{
				        // everything will happen here..
					xslfoTransformer.transform(source, res);
					// to write the content to out put stream
					byte[] pdfBytes = outStream.toByteArray();
					pdfFile.write(pdfBytes);     
				}
				catch (TransformerException e) {
					throw e;
				}
			}
			catch (FOPException e) {
				throw e;
			}
		}
		catch (TransformerConfigurationException e)
		{
			throw e;
		}
		catch (TransformerFactoryConfigurationError e)
		{
			throw e;
		}
		
		return null;
	}
	
	private List<Parts> getSelectedParts(List<String> selectedPartIds) {
		List<ObjectId> selectedPartObjectIds = new ArrayList<ObjectId>();
		for(String id : selectedPartIds) {
			ObjectId objectId = new ObjectId(id);
			selectedPartObjectIds.add(objectId);
		}
		Iterable<Parts> parts = partsRepo.findAll(selectedPartObjectIds);
		List<Parts> selectedPartList = Lists.newArrayList(parts);
		return selectedPartList;
	}

}
