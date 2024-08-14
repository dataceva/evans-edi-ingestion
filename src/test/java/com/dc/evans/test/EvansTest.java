package com.dc.evans.test;

import java.io.FileReader;
import java.time.LocalDateTime;

import javax.edi.bind.EDIUnmarshaller;
 
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dc.evans.edi.model.x12.edi204.v4010.Shipment;
import com.dc.evans.jobhandler.TransplaceEDIJobHandler;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvansTest {

	private static final Logger LOG = LoggerFactory.getLogger(EvansTest.class);
	
	ObjectMapper mapper = new ObjectMapper();

	//@Test
	public void testReadEDI204() throws Exception {
		//new TransplaceEDIJobHandler().downloadMessage();
//		List<String> fileList = new TransplaceEDIJobHandler().downloadFiles();
//		for(String file : fileList) {
//			FileReader isr = new FileReader(file);
//			LocalDateTime start = LocalDateTime.now();
//			System.out.println(start);
//			Shipment edi= EDIUnmarshaller.unmarshal(Shipment.class, isr);
//			mapper.setSerializationInclusion(Include.NON_NULL);
//			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(edi));
//			LocalDateTime end = LocalDateTime.now();
//			System.out.println(end);
//			System.out.println(ChronoUnit.MILLIS.between(start, end));
//			
//			TransplaceEDIJobHandler job = new TransplaceEDIJobHandler();
//			job.generateMercuryGateXML(edi);
//			//LOG.debug("Marshalled: "+sw.toString());
//		}
		
		//String files[] = new String[] {"204.edi","204{4A4CC1CE-47CC-4DFE-A8A1-23A90493CDA5}.02.EVTW.edi","20240415104843321.410077016","EDI_204_1037353978","EDI_204_1037496715","EDI_204_1037546982"};
		String files[] = new String[] {"204.edi"};
		//String files[] = new String[] {"204{4A4CC1CE-47CC-4DFE-A8A1-23A90493CDA5}.02.EVTW.edi"};
		for(String fileName : files) {
			try {
			FileReader isr = new FileReader("D:\\Projects\\DataCeva\\Evan-EDIAdapter\\src\\test\\resources\\"+fileName);
			LocalDateTime start = LocalDateTime.now();
			System.out.println(start);
			Shipment edi= EDIUnmarshaller.unmarshal(Shipment.class, isr);
			mapper.setSerializationInclusion(Include.NON_NULL);
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(edi));
			LocalDateTime end = LocalDateTime.now();
			//System.out.println(end);
			//System.out.println(ChronoUnit.MILLIS.between(start, end)); 
			
			TransplaceEDIJobHandler job = new TransplaceEDIJobHandler();
			job.generateMercuryGateXML(edi);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error in file: " + fileName);
				
			}
			//LOG.debug("Marshalled: "+sw.toString());
		}
		
		
		//LOG.debug("Marshalled: "+sw.toString());
	}
	
	public static void main(String [] args) throws Exception {
		new EvansTest().testReadEDI204();
	}
}
