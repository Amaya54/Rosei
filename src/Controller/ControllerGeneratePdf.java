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
public class ControllerGeneratePdf extends HttpServlet 
{
   
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
        {
    	int i;
    	double amount,amount1;
    	int b,l,d;
    	Connection currentCon=null;
    	ConnectionManager cm=new ConnectionManager();
    	currentCon=cm.getConnection();
    	getStudentArray gsa=new getStudentArray();
    	ArrayList<String> stid=null;
    	
    	String course=request.getParameter("course");
    	String batch=request.getParameter("batch");
    	String branch=request.getParameter("branch");
    	String p=course+branch+batch;
    	String sid,mname,sname,k,gen;
    	
    	BeanGeneratePdf print=new BeanGeneratePdf();
    	
    	
        HttpSession session = request.getSession(true);
        String mid=(String)session.getAttribute("currentSessionUserId");
    	
    	DaoGeneratePdf dao=new DaoGeneratePdf();
    	
    	dao.getd(print,mid,currentCon);
    	System.out.println("after getd");
    	
    	
    	
    	String f=print.getFdt()+"-"+print.getFd();
    	String t=print.getTdt()+"-"+print.getTd();
    	System.out.println(f);
    	System.out.println(t);
    	
    	String[] dt=new String[7];
    	getDateArray gdt=new getDateArray();
    	dt=gdt.getdt(f,t);
    	getMealType getval=new getMealType();
    	
    	//finally
    	stid=gsa.getStId(p,mid);
    	int len=gsa.getLen();
    	
    	
        response.setContentType("application/pdf"); // Code 1
       // Rectangle pagesize = new Rectangle(330f, 250f);
        Document document = new Document(PageSize.A4, 5f, 5f, 5f, 5f);
       
        try
                {
        	

            PdfWriter.getInstance(document, 
            response.getOutputStream()); // Code 2
            document.open();
            
        
            PdfPTable table1 = new PdfPTable(2);
            
            table1.setWidthPercentage(100f);
            
            for(i=0;i<len;i++)
            {
            	
            	sid=stid.get(i);
            	print.setId(sid);
            	sname=dao.getStudentName(sid);
            	System.out.println("vicky student name is"+sid);
            	mname=dao.getMessName(mid);
            	gen=dao.getgen();
            	amount1=dao.balance(sid, mid,currentCon);
            	amount=0;
            	b=0;
            	l=0;
            	d=0;
            	k=null;
            Paragraph pp1= new Paragraph (mname+"       "+sname+" ("+sid+")");
            
                        	
           // Code 3
            PdfPTable table = new PdfPTable(4); 
            table.setWidthPercentage(46f);
	
    
            PdfPCell cell = new PdfPCell();
            
            cell.setColspan(4);
            cell.addElement(pp1);
            table.addCell(cell);
            table.addCell("Day");
            table.addCell("B.Fast");
            table.addCell("Lunch");
            table.addCell("Dinner");
            
            for(int j=0;j<=(gdt.getLen());j++)
            {
            	table.addCell(dt[j].substring(8,10)+"/"+dt[j].substring(5,7)+"/"+dt[j].substring(11,14));
            	k=getval.getb(dt[j],sid,mid,currentCon);
            	table.addCell(k);
            	if(k!="****")
            		b++;
            	k=getval.getl(dt[j],sid,mid,currentCon);
            	table.addCell(k);
            	if(k!="****")
            		l++;
            	k=getval.getd(dt[j],sid,mid,currentCon);
            	table.addCell(k);
            	if(k!="****")
            		d++;
            	
            }
            
            amount=(b*10)+(l*25)+(d*25);
            PdfPCell footer = new PdfPCell();
            Paragraph pp2= new Paragraph ("Amount to be paid...RS."+amount+"\t\t"+amount1+"                         ("+gen.substring(0,1)+")");
            
            footer.setColspan(4);
            footer.addElement(pp2);
            table.addCell(footer);
         
            if(amount!=0 && amount!=amount1)
            table1.addCell(table);
            }
            
            
            
            
            
               table1.addCell(" ");
             
            document.add(table1);
            
            
            document.close(); 
           
            stid=null;
            
        }
                catch(DocumentException e)
                {
                    e.printStackTrace();
                    //out.println("Exception: "+e);
        }
    }
}
