package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.PDFService;
import com.example.demo.service.PdfService2;
import com.lowagie.text.DocumentException;

@Controller
@RequestMapping("/pdf")
public class PDFController {

	@Autowired
	private PDFService pdfService;
	@Autowired
	private PdfService2 pdfService2;
	private Logger logger = LoggerFactory.getLogger(PDFController.class);
	
	@GetMapping("/test1")
	public String getTest() {
		logger.info("Inside test..!");
		
		return "home";
	}
	
	@GetMapping("/createPDF")
	public ResponseEntity<InputStreamResource> createPDF() {
	
		ByteArrayInputStream arrin=pdfService.createPDF();
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("Content-Disposition","Inline;file=document.pdf");
		return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(arrin));
		
	}
	
	@GetMapping("/createPDF1")
	public ResponseEntity<InputStreamResource> createPDF1(@RequestParam("abc") String color) {
	
		if (color.startsWith("#")) {
            color = color.substring(1);
        }

        // Parse hexadecimal values for red, green, and blue
        int red = Integer.parseInt(color.substring(0, 2), 16);
        int green = Integer.parseInt(color.substring(2, 4), 16);
        int blue = Integer.parseInt(color.substring(4, 6), 16);
		System.out.println("red="+red);
		ByteArrayInputStream arrin=null;
		try {
			arrin = pdfService.createPDF1(red,green,blue);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("Content-Disposition","Inline;file=document.pdf");
		return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(arrin));
		
	}
	
	@GetMapping("/display")
	public String getColor(@RequestParam("abc") String color) {
	
		
		return "index";
	}
	@PostMapping("/demo")
	public ResponseEntity<InputStreamResource>  demo(@RequestBody Map<String, Object> requestData){
		
		
		
		pdfService2.generatePdf(requestData);
		
		ByteArrayInputStream arrin=null;
		try {
			arrin = pdfService2.generatePdf(requestData);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("Content-Disposition","Inline;file=document.pdf");
		return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(arrin));
		
	}
	
}
