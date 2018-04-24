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
import java.sql.Connection;
import java.util.*;
public class ControllerGenerateCouponPdf extends HttpServlet 
{
   
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
        {
    	Connection currentCon=null;
    	Connection currentCon1=null;
    	ConnectionManager cm=new ConnectionManager();
    	currentCon=cm.getConnection();
    	currentCon1=cm.getConnection1();
    	String mid=request.getParameter("id");
    	BeanGeneratePdf print=new BeanGeneratePdf();
    	
    	print.setId(mid);
        HttpSession session = request.getSession(true);
        String sid=(String)session.getAttribute("currentSessionUserId");
    	
    	DaoGeneratePdf dao=new DaoGeneratePdf();
    	
    	dao.getd(print,mid,currentCon);
    	System.out.println("after getd");
    	System.out.println(sid);
    	double amount=dao.balance(sid, mid,currentCon);
    	
    	String f=print.getFdt()+"-"+print.getFd();
    	String t=print.getTdt()+"-"+print.getTd();
    	System.out.println(f);
    	System.out.println(t);
    	
    	String[] dt=new String[7];
    	getDateArray gdt=new getDateArray();
    	dt=gdt.getdt(f,t);
    	
    	
    	//finally
    	String sname=dao.getStudentName(sid);
    	System.out.println("vicky student name is"+sid);
    	String mname=dao.getMessName(mid);
    	System.out.println("vicky mess name is"+mid);
    	getMealType getval=new getMealType();
    	
        response.setContentType("application/pdf"); // Code 1
        Rectangle pagesize = new Rectangle(330f, 250f);
        Document document = new Document(pagesize, 0f, 0f, 0f, 0f);
       
        try
                {
        	

            PdfWriter.getInstance(document, 
            response.getOutputStream()); // Code 2
            document.open();
            Paragraph pp1= new Paragraph (sname+" ("+sid+")");
            pp1.setAlignment(Element.ALIGN_CENTER);
    	      document.add (pp1);
    	     
    	    Paragraph pp3= new Paragraph ("\n");
    	      document.add (pp3); 
            // Code 3
            PdfPTable table = new PdfPTable(4);           
            table.addCell("Day");
            table.addCell("B.Fast");
            table.addCell("Lunch");
            table.addCell("Dinner");
            
            for(int j=0;j<=(gdt.getLen());j++)
            {
            	table.addCell(dt[j].substring(8,10)+"/"+dt[j].substring(5,7)+"/"+dt[j].substring(11,14));
            	table.addCell(getval.getb(dt[j],sid,mid,currentCon1));
            	table.addCell(getval.getl(dt[j],sid,mid,currentCon1));
            	table.addCell(getval.getd(dt[j],sid,mid,currentCon1));
            }
            
             
            // Code 4
            document.add(table);  
            Paragraph pp = new Paragraph ("ROSEI CASH AVAILABLE: RS."+amount+"\n");
            pp.setAlignment(Element.ALIGN_CENTER);
            document.add (pp);
  	      document.add(pp3);
  	    Paragraph pp2= new Paragraph (mname);
  	    pp2.setAlignment(Element.ALIGN_CENTER);
      	      document.add (pp2);
            
            
            document.close(); 
        }
                catch(DocumentException e)
                {
                    e.printStackTrace();
                    //out.println("Exception: "+e);
                }
    }
}
