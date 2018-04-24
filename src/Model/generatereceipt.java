package Model;

import javax.servlet.*;
import javax.servlet.http.*;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.PageSize;
import java.io.*;
import java.util.*;

public class generatereceipt {
	
	public void rechargereceipt(BeanRecharge receipt,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
	String sid=receipt.getStudentId();
	String mname=receipt.getMessName();
	String date=receipt.getDate();
    int amt=receipt.getAmount();
    int famt=receipt.getFamt();
    String accno=receipt.getAccountNo();
    
    
	
	
	
    response.setContentType("application/pdf"); // Code 1
    Rectangle pagesize = new Rectangle(240f, 245f);
    Document document = new Document(pagesize, 20f, 5f, 0f, 5f);
   
    try
            {
    	

        PdfWriter.getInstance(document, 
        response.getOutputStream()); // Code 2
        document.open();
        Paragraph p1= new Paragraph (date);
	      document.add (p1);
	    
        Paragraph pp1= new Paragraph (sid);
	      document.add (pp1);
	    
	      Paragraph p2= new Paragraph ("Account no:"+accno);
	      document.add (p2);
	      
	      Paragraph p3= new Paragraph ("Amount Recharged:RS."+amt);
	      document.add (p3);
	      
	      
	      
	      
	    Paragraph pp3= new Paragraph ("\n");
	      document.add (pp3); 
        // Code 3
       Paragraph pp = new Paragraph ("ROSEI CASH AVAILABLE: RS."+famt+"\n");
	      document.add (pp);
	      document.add(pp3);
	      document.add(pp3);
	      Paragraph pp2= new Paragraph(mname);
	    pp2.setAlignment(Element.ALIGN_RIGHT);
  	      document.add (pp2);
  	    Paragraph p4 = new Paragraph ("Recharge Successful \n Thank You Visit Again");
  	   p4.setAlignment(Element.ALIGN_CENTER);
	      document.add (p4);
	    
        
        document.close(); 
    }
            catch(DocumentException e)
            {
                e.printStackTrace();
                //out.println("Exception: "+e);
    }

	}
}
