
package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.DocumentException;

import Model.*;

import java.util.*;
import java.text.*;


public class ControllerMessTransaction extends HttpServlet{
	
public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
System.out.println("called");
String from_date=request.getParameter("fd") ;
String to_date=request.getParameter("td") ;

int l;
ArrayList<Double> bf=new ArrayList<Double>();
ArrayList<Double> lun=new ArrayList<Double>();
ArrayList<Double> din=new ArrayList<Double>();
ArrayList<String> date1=new ArrayList<String>();
ArrayList<Integer> money=new ArrayList<Integer>();
HttpSession session = request.getSession(true);
String mid=(String)session.getAttribute("currentSessionUserId");
String dt=null;
BeanMessTransaction bean=new BeanMessTransaction();
getDateArrayList gdal=new getDateArrayList();
gdal.getdt(bean,from_date,to_date);
int k=gdal.getLen();
System.out.println(k);
date1=bean.getDate1();
getTransactionMoney gtm=new getTransactionMoney();

try
{
	
for(l=0;l<=k;l++)
{
dt=date1.get(l);
bf.add(gtm.getbv(bean,dt,mid)+gtm.getbn(bean,dt,mid));
lun.add(gtm.getlv(bean,dt,mid)+gtm.getln(bean,dt,mid));
din.add(gtm.getdv(bean,dt,mid)+gtm.getdn(bean,dt,mid));
money.add(gtm.getmoney(bean,dt,mid));

System.out.println(dt+"    "+bf.get(l)+"       "+lun.get(l)+"           "+din.get(l));
}
bean.setLoop(k);
bean.setbf(bf);
bean.setlun(lun);
bean.setdin(din);
bean.setMoney(money);
if(bean.getValid())
{
	response.sendRedirect("http://172.16.2.2:8081/rosei/viewmesstransactionsuccessful.jsp"); //logged-in page      		
}

else 
response.sendRedirect("http://172.16.2.2:8081/rosei/viewmesstransactionunsuccessful.jsp"); //error page 

}
catch (Throwable theException) 	    
{
   System.out.println(theException); 
}

}
}
