package Controller;

import javax.servlet.*;
import javax.servlet.http.*;

import Model.*;

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
public class ControllerContractorBooking extends HttpServlet 
{
   
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
        {
    	
    	
    	BeanContractorBookingDetail print=new BeanContractorBookingDetail();
        HttpSession session = request.getSession(true);
        String mid=(String)session.getAttribute("currentSessionUserId");
    	
    	DaoContractorBookingDetail dao=new DaoContractorBookingDetail();
    	
      

    	dao.getd(print,mid);
    	String f=print.getFdt()+"-"+print.getFd();
    	String t=print.getTdt()+"-"+print.getTd();
    	
    	String[] dt=new String[7];
    	getDateArray gdt=new getDateArray();
    	dt=gdt.getdt(f,t);
    	
    	
    	//finally
    	
    	String mname=dao.getMessName(mid);
    	
    	getCount getval=new getCount();
    	
        response.setContentType("application/pdf"); // Code 1
        
        Document document = new Document(PageSize.A4, 10, 10, 10, 10);
       
        try
                {
        	

            PdfWriter.getInstance(document, 
            response.getOutputStream()); // Code 2
            document.open();
            
            Paragraph pp1= new Paragraph (mname);
            pp1.setAlignment(Element.ALIGN_CENTER);
    	      document.add (pp1);
    	      Paragraph pp2= new Paragraph ("FROM: "+f.substring(8,10)+"/"+f.substring(5,7)+"/"+f.substring(0,4)+"                       TO:"+t.substring(8,10)+"/"+t.substring(5,7)+"/"+t.substring(0,4));
    	      pp2.setAlignment(Element.ALIGN_CENTER);
      	      document.add (pp2);
      	    Paragraph pp3= new Paragraph ("\n");      
    	      document.add (pp3);
            // Code 3
            PdfPTable table = new PdfPTable(7); 
            table.setSpacingBefore(100);
            
            table.addCell("Date-Day");
            table.addCell("B.Fast Veg");
            table.addCell("B.Fast NonVeg");
            table.addCell("Lunch Veg");
            table.addCell("Lunch NonVeg");
            table.addCell("Dinner Veg");
            table.addCell("Dinner NonVeg");
            
            
            for(int j=0;j<=(gdt.getLen());j++)
            {
            	table.addCell(dt[j].substring(8,10)+"/"+dt[j].substring(5,7)+"/"+dt[j].substring(11,14));
            	table.addCell(getval.getbv(dt[j],mid));
            	table.addCell(getval.getbn(dt[j],mid));
            	table.addCell(getval.getlv(dt[j],mid));
            	table.addCell(getval.getln(dt[j],mid));
            	table.addCell(getval.getdv(dt[j],mid));
            	table.addCell(getval.getdn(dt[j],mid));
            }
            
             
            // Code 4
            document.add(table); 
            
            document.close(); 
                }
        
        
                catch(DocumentException e)
                {
                    e.printStackTrace();
                    //out.println("Exception: "+e);
                  }
        

    	
    	
    }
}
