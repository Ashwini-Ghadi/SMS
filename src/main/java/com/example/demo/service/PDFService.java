package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.RGBColor;

@Service
public class PDFService {

	private Logger logger = LoggerFactory.getLogger(PDFService.class);

	public ByteArrayInputStream createPDF() {

		logger.info("Create PDF Started");

		String title = "Welcome";
		String content = "This is test pdf download";

		ByteArrayOutputStream arrout = new ByteArrayOutputStream();

		Document document = new Document();

		PdfWriter.getInstance(document, arrout);

//		HeaderFooter footer = new HeaderFooter(true, new Phrase(" page"));
//        footer.setAlignment(Element.ALIGN_CENTER);
//        footer.setBorderWidthBottom(0);
//        document.setFooter(footer);
		
		document.open();

		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);

		Paragraph titlePara = new Paragraph(title, titleFont);
		document.add(titlePara);

		Font paraFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);

		Paragraph paraPara = new Paragraph(title, paraFont);
		for(int i=0;i<=50;i++) {
		document.add(paraPara);
		}
		
		
		
		document.close();
		
		return new ByteArrayInputStream(arrout.toByteArray()); 

	}
	
	public ByteArrayInputStream createPDF1(int red,int green,int blue) throws DocumentException, IOException {
        ByteArrayOutputStream arrout = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, arrout);
        document.open();
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20,new RGBColor(red,green,blue));
        Paragraph titlePara = new Paragraph("Invoice", titleFont);
        titlePara.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(titlePara);

        Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 10);
        Paragraph contentPara;

        // Customer details
        String customerName = "John Doe";
        String address = "123 Main St";
        String email = "john@example.com";
        String date = "2024-02-14";
        double amount = 100.00;

        contentPara = new Paragraph("Customer Name: " + customerName, paraFont);
        document.add(contentPara);
        contentPara = new Paragraph("Address: " + address, paraFont);
        document.add(contentPara);
        contentPara = new Paragraph("Email: " + email, paraFont);
        document.add(contentPara);
        contentPara = new Paragraph("Date: " + date, paraFont);
        document.add(contentPara);
        contentPara = new Paragraph("Amount: $" + amount, paraFont);
        document.add(contentPara);
        
        contentPara = new Paragraph("Customer Name: " + customerName, paraFont);
        contentPara.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(contentPara);
        contentPara = new Paragraph("Address: " + address, paraFont);
        contentPara.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(contentPara);
        
        contentPara = new Paragraph("Customer Name: " + customerName, paraFont);
        document.add(contentPara);
        contentPara = new Paragraph("Address: " + address, paraFont);
        document.add(contentPara);
        contentPara = new Paragraph("Email: " + email, paraFont);
        document.add(contentPara);
        contentPara = new Paragraph("Date: " + date, paraFont);
        contentPara.setSpacingAfter(10);
        document.add(contentPara);
        
        
        contentPara = new Paragraph("Amount: $" + amount, paraFont);
        document.add(contentPara);
        contentPara = new Paragraph("Customer Name: " + customerName, paraFont);
        document.add(contentPara);
        contentPara = new Paragraph("Address: " + address, paraFont);
        contentPara.setSpacingAfter(10);
        document.add(contentPara);
        
        //Table
        String[] bogusData = { "M0065920", "SL", "FR86000P", "PCGOLD",
                "119000" };
        int NumColumns = 5;

        PdfPTable datatable = new PdfPTable(NumColumns);
        int[] headerwidths = {9, 4, 8, 10, 8}; // percentage
        datatable.setWidths(headerwidths);
        datatable.setWidthPercentage(100); // percentage
        datatable.getDefaultCell().setPadding(3);
        datatable.getDefaultCell().setBorderWidth(2);
        datatable.getDefaultCell().setHorizontalAlignment(
                Element.ALIGN_CENTER);
        
        datatable.addCell("Clock #");
        datatable.addCell("Trans Type");
        datatable.addCell("Cusip");
        datatable.addCell("Long Name");
        datatable.addCell("Quantity");
        

        datatable.setHeaderRows(1); 

        datatable.getDefaultCell().setBorderWidth(1);
        for (int i = 1; i < 5; i++) {
            if (i % 2 == 1) {
                datatable.getDefaultCell().setGrayFill(0.9f);
            }
            for (int x = 0; x < NumColumns; x++) {
                datatable.addCell(bogusData[x]);
            }
            if (i % 2 == 1) {
                datatable.getDefaultCell().setGrayFill(1);
            }
        }
        document.add(datatable);
	
        

        Paragraph redText = new Paragraph("This is red text");        document.add(redText);
        
	        document.close();
	
	        return new ByteArrayInputStream(arrout.toByteArray());
	    }
	
		public void generatePDF() {
			String path="invoice.pdf";
			
		}

}
