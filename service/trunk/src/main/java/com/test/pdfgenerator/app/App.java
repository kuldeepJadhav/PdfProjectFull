/**
 * 
 */
package com.test.pdfgenerator.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.pdfgenerator.pojo.ActualParts;
import com.test.pdfgenerator.pojo.Company;
import com.test.pdfgenerator.pojo.Machine;
import com.test.pdfgenerator.pojo.TestParts;
import com.test.pdfgenerator.repositories.ActualPartsRepository;
import com.test.pdfgenerator.repositories.CompanyRepository;
import com.test.pdfgenerator.repositories.MachineCategoryRepository;
import com.test.pdfgenerator.repositories.MachineRepository;
import com.test.pdfgenerator.repositories.PartsRepository;
import com.test.pdfgenerator.repositories.TestPartsRepository;

/**
 * @author jadhavk
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
		CompanyRepository companyRepo = ctx.getBean("companyRepository",CompanyRepository.class);
		MachineRepository machineRepo = ctx.getBean("machineRepository",MachineRepository.class);
		PartsRepository partsRepo = ctx.getBean("partsRepository",PartsRepository.class);
		MachineCategoryRepository machineCategoryRepo = ctx.getBean("machineCategoryRepository",MachineCategoryRepository.class);
		TestPartsRepository testPartsRepo = ctx.getBean("testPartsRepository",TestPartsRepository.class);
		ActualPartsRepository actualPartsRepo = ctx.getBean("actualPartsRepository",ActualPartsRepository.class);
		
		//Code to store entries in mongodb.....
		
		Company c = new Company();
		c.setDescription("Test Description");
		c.setLogoUrl("test Url");
		c.setName("Xyz Machine Works");
		//saving company
		//companyRepo.save(c);
		/* machine = new Machine();
		machine.setDescription("This is the test machine");
		machine.setImageUrl("machine Url");
		machine.setMachineBasePrice(2000);
		machine.setMachineName("Machine 1");
		//machine.setMachineCategory("MAchine1-250");
		
		
		List<MachineCategory> machineCategoryList = new ArrayList<MachineCategory>();
		MachineCategory machinecategory1 = new MachineCategory();
		machinecategory1.setDescription("This is test cat-1");
		machinecategory1.setMachineCategoryBasePrice(20000);
		machinecategory1.setName("cat-1");
		
		MachineCategory machinecategory2 = new MachineCategory();
		machinecategory2.setDescription("This is test cat-2");
		machinecategory2.setMachineCategoryBasePrice(20000);
		machinecategory2.setName("cat-2");
		
		List<Parts> parts = new ArrayList<Parts>();
		Parts p1 = new Parts();
		p1.setCost(200);
		p1.setName("Part 1");
		p1.setType(PartType.DISCOUNTED);
		
		
		Parts p2 = new Parts();
		p2.setCost(300);
		p2.setName("Part 2");
		p2.setType(PartType.NONDISCOUNTED);
		
		//saving parts
		partsRepo.save(p1);
		partsRepo.save(p2);
		
		//adding parts to category
		parts.add(p1);
		parts.add(p2);
		machinecategory1.setParts(parts);
		machinecategory2.setParts(parts);
		
		//saving machine category
		machineCategoryRepo.save(machinecategory1);
		machineCategoryRepo.save(machinecategory2);
		
		
		//saving category in machine
		machineCategoryList.add(machinecategory1);
		machineCategoryList.add(machinecategory2);
		machine.setMachineCategories(machineCategoryList);
		//saving machine
		machineRepo.save(machine);
		
		System.out.println("Save successfull....:)");
		
		*/
		
		
		
		/*Machine machine = machineRepo.findByMachineName("Xyz Machine Works");
		List<Machine> findAll = machineRepo.findAll();
		List<Machine> machineNameIdList = machineRepo.findAll();
		System.out.println(machine.getMachineName());
		*/
		ActualParts actualPart= actualPartsRepo.findByName("Part 12 - Part 2");
		System.out.println("ActualPart :" +actualPart.getName() + "Actual Cost :"+actualPart.getCost());
	    TestParts testPart=testPartsRepo.findByName("Part 12");
	    System.out.println("TestPart :" + testPart.getName() );
	    System.out.println("Actual Parts : " + testPart.getActualParts().size());
	}

}
