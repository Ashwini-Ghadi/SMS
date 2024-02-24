package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;


@Service
public class PdfService2 {

	public ByteArrayInputStream generatePdf(Map<String, Object> requestData) {
		requestData.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });
	    ByteArrayOutputStream arrout = new ByteArrayOutputStream();
	    
	    String path = "C:\\BrightLink\\Practice Sets\\SpringBoot\\Assets LeadManagement\\invoice.pdf";
	    try {
	        PdfWriter pdfWriter = new PdfWriter(arrout); // Writing to the ByteArrayOutputStream
	        
	        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
	        pdfDocument.setDefaultPageSize(PageSize.A4);
	        Document document = new Document(pdfDocument);
	        
	        float tcol1=285f;
	        float tcol2=tcol1+150f;
	        float tcolwidth[]= {tcol2,tcol1};
	        
	        //Heading
	        Paragraph heading=new Paragraph();
	        heading.setTextAlignment(TextAlignment.CENTER);
	        heading.setFontSize(20f);
	        heading.add("Quotation");
	        heading.setMarginBottom(20f);
	        document.add(heading);
	        
	        //Our Information
	        String ourName="Sanket Zende";
	        String ourAddressLine1="Kothrud Pune";
	        String ourAddressLine2="Maharashtra India";
	        String ourPhone="9860088475";
	        String ourEmail="sanket@gmail.com";
	      	        
	        Paragraph ourInfo = new Paragraph();
	        ourInfo.setTextAlignment(TextAlignment.LEFT);
	        ourInfo.add(ourName+"\n");
	        ourInfo.add(ourAddressLine1+"\n");
	        ourInfo.add(ourAddressLine2+"\n");
	        ourInfo.add(ourPhone+"\n");
	        ourInfo.add(ourEmail+"\n");
	        
	        Table head=new Table(tcolwidth);
	        head.addCell(new Cell().add(ourInfo).setBorder(Border.NO_BORDER));
	        head.addCell(new Cell().setBorder(Border.NO_BORDER));
	        document.add(head);
	        
	        /*
	        Image img = new Image(ImageDataFactory.create("C:\\BrightLink\\Practice Sets\\SpringBoot\\Assets LeadManagement\\errorPDF.png"));
	        img.setHorizontalAlignment(HorizontalAlignment.RIGHT);
	        img.setAutoScale(true);
	        */
	        
	        //Normal Information
	        Paragraph dateAndId = new Paragraph();
	        dateAndId.setTextAlignment(TextAlignment.RIGHT);
	        dateAndId.add("Date : 02-02-2024\n");
	        dateAndId.add("Quotation Id : 02Q2024\n");
	        
	        Table normalInfo=new Table(tcolwidth);
	        normalInfo.addCell(new Cell().setBorder(Border.NO_BORDER));
	        normalInfo.addCell(new Cell().add(dateAndId).setBorder(Border.NO_BORDER));
	        document.add(normalInfo);
	        
	      //Customer Information
	        String costumerName="Kartik Sir";
	        String costumerAddressLine1="Kothrud-Depo Pune";
	        String costumerAddressLine2="Maharashtra India";
	        String costumerPhone="9876543210";
	        String costumerEmail="kartik@gmail.com";
	        
	        Paragraph customerInfo = new Paragraph();
	        customerInfo.setTextAlignment(TextAlignment.LEFT);
	        customerInfo.add(costumerName+"\n");
	        customerInfo.add(costumerAddressLine1+"\n");
	        customerInfo.add(costumerAddressLine2+"\n");
	        customerInfo.add(costumerPhone+"\n");
	        customerInfo.add(costumerEmail+"\n");
	        
	        Table cInfo=new Table(tcolwidth);
	        cInfo.addCell(new Cell().add(customerInfo).setBorder(Border.NO_BORDER));
	        cInfo.addCell(new Cell().setBorder(Border.NO_BORDER));
	        document.add(cInfo);
	        
	        //Subject Information
	        String subject="It is demo subject for quotation using manual";
	        
	        Paragraph subjectPara=new Paragraph();
	        subjectPara.setTextAlignment(TextAlignment.LEFT);
	        subjectPara.setFontSize(15f);
	        subjectPara.add("Subject : "+subject);
	        subjectPara.setMarginBottom(2f);
	        document.add(subjectPara);
	        
	        //Message Information
	        String message="It is demo message for quotation manual";
	        Paragraph messagePara=new Paragraph();
	        messagePara.setTextAlignment(TextAlignment.LEFT);
	        messagePara.add("Message : "+message);
	        messagePara.setMarginBottom(5f);
	        document.add(messagePara);
	        
	        //Product Information
	        
	        Table table = new Table(UnitValue.createPercentArray(new float[]{1,1,1,1,1}));
	        table.setWidth(UnitValue.createPercentValue(100));
	        table.addCell(new Cell().add("Sr No").setBackgroundColor(Color.YELLOW));
	        table.addCell(new Cell().add("Product Description"));
	        table.addCell(new Cell().add("Qty"));
	        table.addCell(new Cell().add("Price/unit"));
	        table.addCell(new Cell().add("Total Price"));
	        
	        table.addCell(new Cell().add("1"));
	        table.addCell(new Cell().add("Salad"));
	        table.addCell(new Cell().add("3"));
	        table.addCell(new Cell().add("100"));
	        table.addCell(new Cell().add("300"));
	        
	        table.addCell(new Cell().add("2"));
	        table.addCell(new Cell().add("Salad"));
	        table.addCell(new Cell().add("3"));
	        table.addCell(new Cell().add("100"));
	        table.addCell(new Cell().add("300"));
	        
	        table.addCell(new Cell().add("3"));
	        table.addCell(new Cell().add("Salad"));
	        table.addCell(new Cell().add("3"));
	        table.addCell(new Cell().add("100"));
	        table.addCell(new Cell().add("300"));
	        
	        table.addCell(new Cell().add("4"));
	        table.addCell(new Cell().add("Salad"));
	        table.addCell(new Cell().add("3"));
	        table.addCell(new Cell().add("100"));
	        table.addCell(new Cell().add("300"));
	        
	        table.addCell(new Cell().add("5"));
	        table.addCell(new Cell().add("Salad"));
	        table.addCell(new Cell().add("3"));
	        table.addCell(new Cell().add("100"));
	        table.addCell(new Cell().add("300"));
	        table.setMarginBottom(5f);
	        document.add(table);
	        
	        //Grand PRice Calculation
	        float subTotal= 123f;
	        float taxes=13;
	        float shippingCharges=123;
	        float grandTotal=1234;
	        
	        Paragraph grandPrice = new Paragraph();
	        grandPrice.setTextAlignment(TextAlignment.LEFT);
	        grandPrice.add("SubTotal : "+subTotal+"\n");
	        grandPrice.add("Taxes : "+taxes+"\n");
	        grandPrice.add("Shipping Charges : "+shippingCharges+"\n");
	        grandPrice.add("Grand Total : "+grandTotal+"\n");
	        
	        Table priceCalc=new Table(tcolwidth);
	        priceCalc.addCell(new Cell().setBorder(Border.NO_BORDER));
	        priceCalc.addCell(new Cell().add(grandPrice));
	        document.add(priceCalc);
	        
	        Table terms = new Table(UnitValue.createPercentArray(new float[]{1,1,1,1,1}));
	        terms.setWidth(UnitValue.createPercentValue(200));
	        terms.addCell(new Cell().add(ourInfo).setBorder(Border.NO_BORDER));
	        document.add(terms);
	        document.add(terms);
	        
	        Paragraph yourInfo = new Paragraph();
	        yourInfo.setTextAlignment(TextAlignment.RIGHT);
	        yourInfo.add("Date : 02-02-2024\n");
	        yourInfo.add("Quotation Id : 02Q2024\n");
	        
	        Table yInfo=new Table(tcolwidth);
	        yInfo.addCell(new Cell().setBorder(Border.NO_BORDER));
	        yInfo.addCell(new Cell().add(dateAndId).setBorder(Border.NO_BORDER));
	        document.add(yInfo);
	        
	        document.close();
	        
	        return new ByteArrayInputStream(arrout.toByteArray());
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null; 
	    }
	}
	
}
