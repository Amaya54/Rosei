package Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.*;

import Model.*;

import java.util.*;
import java.text.*;
public class ControllerEmergencyPrint extends HttpServlet{
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
System.out.println("called");

	 

String dat=request.getParameter("dt") ;
String yr=dat.substring(0, 4);
String mn=dat.substring(5,7);
String dy0=dat.substring(8,10);
String dat0=yr+mn+dy0;
System.out.println(yr+mn+dy0);

int i;
double amount;
int b,l,d;
getemergencystudent gsa=new getemergencystudent();
ArrayList<String> stid=null;

String sid,mname,sname,k,gen;

BeanGeneratePdf print=new BeanGeneratePdf();

Connection currentCon=null;
ConnectionManager cm=new ConnectionManager();
currentCon = cm.getConnection();

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
stid=gsa.getStId(dat0,mid);
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
    	//amount=dao.balance(sid, mid);
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
    Paragraph pp2= new Paragraph ("Amount to be paid...RS."+amount+"                         ("+gen.substring(0,1)+")");
    
    footer.setColspan(4);
    footer.addElement(pp2);
    table.addCell(footer);
 
    if(amount!=0)
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
