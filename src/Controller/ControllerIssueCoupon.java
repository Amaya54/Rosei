	package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.*;

import java.util.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.*;
import java.sql.*;
import java.util.Date;

public class ControllerIssueCoupon extends HttpServlet{


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException 

{
	HttpSession session = request.getSession(true);
	System.out.println(request.getParameter("check"));
	int check=Integer.parseInt(request.getParameter("check"));
	int ii=(Integer)session.getAttribute("issuecheck");
	
	System.out.println("Hello Neha\t"+ii+check);
		
	if(check==ii)
	{
	DaoIssueCoupon dic=new DaoIssueCoupon();
	double totalprice=0;
	double bfprice=0;
	double lunprice=0;
	double dinprice=0;
	boolean x=false;
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();
	String dt=dateFormat.format(date);
	
    String sid=(String)session.getAttribute("currentSessionUserId");
	String bid=sid+dt;
	int ctr=0;
	
	Connection currentCon = null;
	Connection currentCon1 = null;
	ConnectionManager cm=new ConnectionManager();
    currentCon = cm.getConnection();
    currentCon1=cm.getConnection1();
	
		String monbf=request.getParameter("monbf");
		String monlun=request.getParameter("monlun");
		String mondin=request.getParameter("mondin");
		System.out.println(monbf);
		System.out.println(monlun);
		System.out.println(mondin);
		String tuebf=request.getParameter("tuebf");
		String tuelun=request.getParameter("tuelun");
		String tuedin=request.getParameter("tuedin");
		
		String wedbf=request.getParameter("wedbf");
		String wedlun=request.getParameter("wedlun");
		String weddin=request.getParameter("weddin");
		
		String thubf=request.getParameter("thubf");
		String thulun=request.getParameter("thulun");
		String thudin=request.getParameter("thudin");
		
		String fribf=request.getParameter("fribf");
		String frilun=request.getParameter("frilun");
		String fridin=request.getParameter("fridin");
		
		String satbf=request.getParameter("satbf");
		String satlun=request.getParameter("satlun");
		String satdin=request.getParameter("satdin");
		
		String sunbf=request.getParameter("sunbf");
		String sunlun=request.getParameter("sunlun");
		String sundin=request.getParameter("sundin");
		
		String[] tb=new String[21];
	
	try{
	if(monbf!=null)
	{	
		
		String dat=monbf.substring(4,14);
		String monbfmt=request.getParameter("monbfmt");	
		Global.monbf=monbfmt;
		String mess=monbf.substring(3,4);
		String t="b"+mess+monbf.substring(9,11)+monbf.substring(6,8)+monbfmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		System.out.println("Issue "+x);
		String day="mon";
		String pc="b"+monbf.substring(3,4)+monbfmt.substring(0,1);
		System.out.println("BF PRICE Column:"+pc);
		bfprice=bfprice+dic.getprice(day,pc,currentCon);
		System.out.println("BF PRICE Column:"+bfprice);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
	}
	if(monlun!=null)
	{
		
		String dat=monlun.substring(4,14);
		String monlunmt=request.getParameter("monlunmt");	
		Global.monlun=monlunmt;
		String mess=monlun.substring(3,4);
		String t="l"+mess+monlun.substring(9,11)+monlun.substring(6,8)+monlunmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="mon";
		String pc="l"+monlun.substring(3,4)+monlunmt.substring(0,1);
		lunprice=lunprice+dic.getprice(day,pc,currentCon);
		System.out.println("Lunch:"+lunprice);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(mondin!=null)
	{
		String dat=mondin.substring(4,14);
		String mondinmt=request.getParameter("mondinmt");	
		Global.mondin=mondinmt;
		String mess=mondin.substring(3,4);
		String t="d"+mess+mondin.substring(9,11)+mondin.substring(6,8)+mondinmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="mon";
		String pc="d"+mondin.substring(3,4)+mondinmt.substring(0,1);
		System.out.println("Lunch PRICE Column:"+pc);
		dinprice=dinprice+dic.getprice(day,pc,currentCon);
		System.out.println("Dinner Price"+dinprice);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	
	if(tuebf!=null)
	{
		String dat=tuebf.substring(4,14);
		String tuebfmt=request.getParameter("tuebfmt");	
		Global.tuebf=tuebfmt;
		String mess=tuebf.substring(3,4);
		String t="b"+mess+tuebf.substring(9,11)+tuebf.substring(6,8)+tuebfmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="tue";
		String pc="b"+tuebf.substring(3,4)+tuebfmt.substring(0,1);
		bfprice=bfprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(tuelun!=null)
	{
		String dat=tuelun.substring(4,14);
		String tuelunmt=request.getParameter("tuelunmt");	
		Global.tuelun=tuelunmt;
		String mess=tuelun.substring(3,4);
		String t="l"+mess+tuelun.substring(9,11)+tuelun.substring(6,8)+tuelunmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="tue";
		String pc="l"+tuelun.substring(3,4)+tuelunmt.substring(0,1);
		lunprice=lunprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(tuedin!=null)
	{
		String dat=tuedin.substring(4,14);
		String tuedinmt=request.getParameter("tuedinmt");	
		Global.tuedin=tuedinmt;
		String mess=tuedin.substring(3,4);
		String t="d"+mess+tuedin.substring(9,11)+tuedin.substring(6,8)+tuedinmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="tue";
		String pc="d"+tuedin.substring(3,4)+tuedinmt.substring(0,1);
		dinprice=dinprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	
	if(wedbf!=null)
	{
		String dat=wedbf.substring(4,14);
		String wedbfmt=request.getParameter("wedbfmt");	
		Global.wedbf=wedbfmt;
		String mess=wedbf.substring(3,4);
		String t="b"+mess+wedbf.substring(9,11)+wedbf.substring(6,8)+wedbfmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="wed";
		String pc="b"+wedbf.substring(3,4)+wedbfmt.substring(0,1);
		bfprice=bfprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(wedlun!=null)
	{
		String dat=wedlun.substring(4,14);
		String wedlunmt=request.getParameter("wedlunmt");
		Global.wedlun=wedlunmt;
		String mess=wedlun.substring(3,4);
		String t="l"+mess+wedlun.substring(9,11)+wedlun.substring(6,8)+wedlunmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="wed";
		String pc="l"+wedlun.substring(3,4)+wedlunmt.substring(0,1);
		lunprice=lunprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(weddin!=null)
	{
		String dat=weddin.substring(4,14);
		String weddinmt=request.getParameter("weddinmt");	
		Global.weddin=weddinmt;
		String mess=weddin.substring(3,4);
		String t="d"+mess+weddin.substring(9,11)+weddin.substring(6,8)+weddinmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="wed";
		String pc="d"+weddin.substring(3,4)+weddinmt.substring(0,1);
		dinprice=dinprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	
	if(thubf!=null)
	{
		String dat=thubf.substring(4,14);
		String thubfmt=request.getParameter("thubfmt");	
		Global.thubf=thubfmt;
		String mess=thubf.substring(3,4);
		String t="b"+mess+thubf.substring(9,11)+thubf.substring(6,8)+thubfmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="thu";
		String pc="b"+thubf.substring(3,4)+thubfmt.substring(0,1);
		bfprice=bfprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(thulun!=null)
	{
		String dat=thulun.substring(4,14);
		String thulunmt=request.getParameter("thulunmt");	
		Global.thulun=thulunmt;
		String mess=thulun.substring(3,4);
		String t="l"+mess+thulun.substring(9,11)+thulun.substring(6,8)+thulunmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="thu";
		String pc="l"+thulun.substring(3,4)+thulunmt.substring(0,1);
		lunprice=lunprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(thudin!=null)
	{
		String dat=thudin.substring(4,14);
		String thudinmt=request.getParameter("thudinmt");
		Global.thudin=thudinmt;
		String mess=thudin.substring(3,4);
		String t="d"+mess+thudin.substring(9,11)+thudin.substring(6,8)+thudinmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="thu";
		String pc="d"+thudin.substring(3,4)+thudinmt.substring(0,1);
		dinprice=dinprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	
	if(fribf!=null)
	{
		String dat=fribf.substring(4,14);
		String fribfmt=request.getParameter("fribfmt");
		Global.fribf=fribfmt;
		String mess=fribf.substring(3,4);
		String t="b"+mess+fribf.substring(9,11)+fribf.substring(6,8)+fribfmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="fri";
		String pc="b"+fribf.substring(3,4)+fribfmt.substring(0,1);
		bfprice=bfprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(frilun!=null)
	{
		String dat=frilun.substring(4,14);
		String frilunmt=request.getParameter("frilunmt");
		Global.frilun=frilunmt;
		String mess=frilun.substring(3,4);
		String t="l"+mess+frilun.substring(9,11)+frilun.substring(6,8)+frilunmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="fri";
		String pc="l"+frilun.substring(3,4)+frilunmt.substring(0,1);
		lunprice=lunprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(fridin!=null)
	{
		String dat=fridin.substring(4,14);
		String fridinmt=request.getParameter("fridinmt");	
		Global.fridin=fridinmt;
		String mess=fridin.substring(3,4);
		String t="d"+mess+fridin.substring(9,11)+fridin.substring(6,8)+fridinmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="fri";
		String pc="d"+fridin.substring(3,4)+fridinmt.substring(0,1);
		dinprice=dinprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	
	if(satbf!=null)
	{
		String dat=satbf.substring(4,14);
		String satbfmt=request.getParameter("satbfmt");	
		Global.satbf=satbfmt;
		String mess=satbf.substring(3,4);
		String t="b"+mess+satbf.substring(9,11)+satbf.substring(6,8)+satbfmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="sat";
		String pc="b"+satbf.substring(3,4)+satbfmt.substring(0,1);
		bfprice=bfprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
		
    }
	if(satlun!=null)
	{
		String dat=satlun.substring(4,14);
		String satlunmt=request.getParameter("satlunmt");	
		Global.satlun=satlunmt;
		String mess=satlun.substring(3,4);
		String t="l"+mess+satlun.substring(9,11)+satlun.substring(6,8)+satlunmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="sat";
		String pc="l"+satlun.substring(3,4)+satlunmt.substring(0,1);
		lunprice=lunprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(satdin!=null)
	{
		String dat=satdin.substring(4,14);
		String satdinmt=request.getParameter("satdinmt");
		Global.satdin=satdinmt;
		String mess=satdin.substring(3,4);
		String t="d"+mess+satdin.substring(9,11)+satdin.substring(6,8)+satdinmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="sat";
		String pc="d"+satdin.substring(3,4)+satdinmt.substring(0,1);
		dinprice=dinprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	
	if(sunbf!=null)
	{
		String dat=sunbf.substring(4,14);
		String sunbfmt=request.getParameter("sunbfmt");	
		Global.sunbf=sunbfmt;
		String mess=sunbf.substring(3,4);
		String t="b"+mess+sunbf.substring(9,11)+sunbf.substring(6,8)+sunbfmt.substring(0,1);
		System.out.println(t);
		
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="sun";
		String pc="b"+sunbf.substring(3,4)+sunbfmt.substring(0,1);
		
		bfprice=bfprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(sunlun!=null)
	{
		String dat=sunlun.substring(4,14);
		String sunlunmt=request.getParameter("sunlunmt");	
		Global.sunlun=sunlunmt;
		String mess=sunlun.substring(3,4);
		String t="l"+mess+sunlun.substring(9,11)+sunlun.substring(6,8)+sunlunmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="sun";
		String pc="l"+sunlun.substring(3,4)+sunlunmt.substring(0,1);
		lunprice=lunprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	if(sundin!=null)
	{
		String dat=sundin.substring(4,14);
		String sundinmt=request.getParameter("sundinmt");
		Global.sundin=sundinmt;
		String mess=sundin.substring(3,4);
		String t="d"+mess+sundin.substring(9,11)+sundin.substring(6,8)+sundinmt.substring(0,1);
		System.out.println(t);
		x=dic.issue(request,response,t,bid,sid,dat,currentCon1);
		String day="sun";
		String pc="d"+sundin.substring(3,4)+sundinmt.substring(0,1);
		dinprice=dinprice+dic.getprice(day,pc,currentCon);
		tb[ctr]=t;
		ctr++;
		while(x)
		break;
    }
	
	}
	
   catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   } 
	BeanIssueCoupon bean=new BeanIssueCoupon();
	bean.setBid(bid);
	bean.setBprice(bfprice);
	bean.setLprice(lunprice);
	bean.setDprice(dinprice);
	totalprice=(bfprice+lunprice+dinprice);
	System.out.println(totalprice);
	session.setAttribute("bprice",bean.getBprice());
	session.setAttribute("lprice",bean.getLprice());
	session.setAttribute("dprice",bean.getDprice());
	session.setAttribute("bid",bid);
	BookingAmount ba=new BookingAmount();
	ba.book(response,(String)session.getAttribute("fd"),totalprice,sid,(String)session.getAttribute("messid"));
	// String name=generatepdf.generate(request,response,bean);
	//amy int amt=(Integer)session.getAttribute("amt"+(String)session.getAttribute("messid"));
	//amy if(totalprice<=amt)
	//amy response.sendRedirect("http://172.16.2.2:8081/rosei/processingissuecoupon.jsp");
	//amy else
	//amy  {
	//amy	for(int k=0;k<ctr;k++)
	//amy	dic.delete(request, response, tb[k], bid, sid);
	//amy	response.sendRedirect("http://172.16.2.2:8081/rosei/insufficientamount.jsp");
	//amy  }
	}
	else
		response.sendRedirect("http://172.16.2.2:8081/rosei/invalidissue.jsp"); //error page
    }
}

