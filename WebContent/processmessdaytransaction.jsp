<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Mess Contracter Booking Derails</title>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}
#Coupon{position:absolute; font-size:23px;colo:rgb(183,132,13); box-shadow:0px 3px 10px rgb(0,50,0);  min-height:400px; min-width:600px; height:65%; width:55%; borde:1px solid black;z-index:3;}
#Coupon tr td{borde:1px solid black; height:25%; left:35px; width:25%;}
#Coupon tr th{position:relative; border:1px solid black; height:20%; background:rgba(65,170,7,0.5); box-shadow:0px 0px 10px black;}
#Coupon tr td div{position:relative; lef:0%; float:left; height:px; font-size:40px; height:80%; width:78%; box-shadow:0px 0px 10px black; text-align:center; padding:20px; background:rgba(65,170,7,0.5); border:1px solid black; z-index:10;}

</style>
</head>
<body>
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/invalidLogin.jsp"); //error page
		}%> 
<%@ page language="java" import="java.util.*,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%
Connection con = null;
Statement stmt1 = null;
Statement stmt2 = null;
Statement stmt3 = null;
Statement stmt4 = null;
Statement stmt5 = null;
Statement stmt6 = null;
Statement stmt7 = null;
Statement stmt8 = null;
Statement stmt9 = null;
Statement stmt10 = null;
Statement stmt11 = null;
Statement stmt12 = null;
Statement stmt13= null;
Statement stmt14= null;
Statement stmt15= null;

int totalbfamt=0;
int totallunamt=0;
int totaldinamt=0;
int totalamt=0;
int availmoney=0;
int totalcol=0;
int rest=0;
String dt=request.getParameter("dt");
System.out.println("Here its is"+dt);



String mid=null;
String sql="select * from prayas.account";
int begavailmoney=0;
int amt=0;
try{
	Model.ConnectionManager cm=new Model.ConnectionManager();
	con=cm.getConnection();

PreparedStatement ps = con.prepareStatement(sql);
ResultSet rs = ps.executeQuery();

while(rs.next())
{
	
	mid=rs.getString(1).substring(7,11);
	System.out.println(mid);
	String cid=(String)session.getAttribute("currentSessionUserId");
	System.out.println(cid);
	if(mid.equals(cid))
	{
		begavailmoney=begavailmoney+rs.getInt(2);
		System.out.println(begavailmoney);
	}
	
	
}


String dy =(Model.day.getday(dt)).toLowerCase();

        String sql1=null;
		 String sql2=null;
		  String sql3=null;
		   String sql4=null;
		    String sql5=null;
			 String sql6=null;
			  String sql7=null;
			   String sql8=null;
			   String sql9=null;
		 String sql10=null;
		  String sql11=null;
		   String sql12=null;
		    String sql13=null;
			 String sql14=null;
			 String sql15=null;
			 String sql16=null;
			 
			 
			 String yr=dt.substring(2,4);
			 String mon=dt.substring(5,7);
			 String i=((String)session.getAttribute("currentSessionUserId")).substring(3,4);
			 String v=i+mon+yr;
			 
			 
			
			 
			 
       sql1="select count(*) from prayas.B"+v+"V where date='"+dt+"'";
	   sql2="select count(*) from prayas.B"+v+"N where date='"+dt+"'";
	   sql3="select count(*) from prayas.L"+v+"V where date='"+dt+"'";
	   sql4="select count(*) from prayas.L"+v+"N where date='"+dt+"'";
	   sql5="select count(*) from prayas.D"+v+"V where date='"+dt+"'";
	   sql6="select count(*) from prayas.D"+v+"N where date='"+dt+"'";
	   
	   sql7="select B"+i+"V from prayas.mealprice where day='"+dy+"'";
	   sql8="select B"+i+"N  from prayas.mealprice where day='"+dy+"'";
	   sql9="select L"+i+"V from prayas.mealprice where day='"+dy+"'";
	   sql10="select L"+i+"N from prayas.mealprice where day='"+dy+"'";
	   sql11="select D"+i+"V from prayas.mealprice where day='"+dy+"'";
	   sql12="select D"+i+"N from prayas.mealprice where day='"+dy+"'";
	   
	   sql14="select * from prayas.account_deposite where transaction_date='"+dt+"' and messid='"+(String)session.getAttribute("currentSessionUserId")+"'";
	   sql16="insert into prayas.mess_transaction_history values(?,?,?,?,?,?)";
	   System.out.println(dy);
        //ps.setString(1,t3);
        stmt1 = con.createStatement();
		stmt2 = con.createStatement();
		stmt3 = con.createStatement();
		stmt4 = con.createStatement();
		stmt5 = con.createStatement();
		stmt6 = con.createStatement();
		
		stmt7 = con.createStatement();
		stmt8 = con.createStatement();
		stmt9 = con.createStatement();
		stmt10 = con.createStatement();
		stmt11 = con.createStatement();
		stmt12 = con.createStatement();
		
		stmt14 = con.createStatement();
		
        ResultSet rs1 = stmt1.executeQuery(sql1);
		ResultSet rs2= stmt2.executeQuery(sql2);
		ResultSet rs3= stmt3.executeQuery(sql3);
		ResultSet rs4= stmt4.executeQuery(sql4);
		ResultSet rs5= stmt5.executeQuery(sql5);
		ResultSet rs6= stmt6.executeQuery(sql6);
		
		ResultSet rs7 = stmt7.executeQuery(sql7);
		ResultSet rs8= stmt8.executeQuery(sql8);
		ResultSet rs9= stmt9.executeQuery(sql9);
		ResultSet rs10= stmt10.executeQuery(sql10);
		ResultSet rs11= stmt11.executeQuery(sql11);
		ResultSet rs12= stmt12.executeQuery(sql12);
		
		
		ResultSet rs14= stmt14.executeQuery(sql14);
		
		int bv=0;
		int bn=0;
		int lv=0;
		int ln=0;
		int dv=0;
		int dn=0;
		
		int b0v=0;
		int b0n=0;
		int l0v=0;
		int l0n=0;
		int d0v=0;
		int d0n=0;
		
       
	   while(rs1.next())
	   {
	   bv=rs1.getInt(1);
	   System.out.println("BreakFAST="+bv);
	   }
	    while(rs2.next())
	   {
	   bn=rs2.getInt(1);
	   
	   
	   }
	    while(rs3.next())
	   {
	   lv=rs3.getInt(1);
	   System.out.println("Lunch="+lv);
	   }
	    while(rs4.next())
	   {
	   ln=rs4.getInt(1);
	   }
	    while(rs5.next())
	   {
	   dv=rs5.getInt(1);
	   }
	    while(rs6.next())
	   {
	   dn=rs6.getInt(1);
	   }
	   while(rs7.next())
	   {
	   b0v=rs7.getInt(1);
	   System.out.println("BF PRICE"+b0v);
	   }
	    while(rs8.next())
	   {
	   b0n=rs8.getInt(1);
	   }
	    while(rs9.next())
	   {
	   l0v=rs9.getInt(1);
	   }
	    while(rs10.next())
	   {
	   l0n=rs10.getInt(1);
	   }
	    while(rs11.next())
	   {
	   d0v=rs11.getInt(1);
	   }
	    while(rs12.next())
	   {
	   d0n=rs12.getInt(1);
	   }
	   
	   while(rs14.next())
	   {
	  totalcol=totalcol+rs14.getInt(1);
	  System.out.println("totalcollection:"+totalcol);
	   }
         
        rs.close();
        rs1.close();
		rs2.close();
		rs3.close();
		rs4.close();
		rs5.close();
		rs6.close();
		rs7.close();
		rs8.close();
		rs9.close();
		rs10.close();
		rs11.close();
		rs12.close();
		
		rs14.close();
		
		
		totalbfamt=(bv*b0v)+(bn*b0n);
		System.out.println("Breakfast:"+totalbfamt);
		totallunamt=(lv*l0v)+(ln*l0n);
		System.out.println("Lunch:"+totallunamt);
		totaldinamt=(dv*d0v)+(dn*d0n);
		System.out.println("Dinner:"+totaldinamt);
		totalamt=totalbfamt+totallunamt+totaldinamt;
		System.out.println("Total:"+totalamt);
		rest=begavailmoney+totalcol-totalamt;
		
		
		PreparedStatement ps1=con.prepareStatement(sql16);
		   ps1.setString(1,dt);
		   ps1.setInt(2,begavailmoney);
		   ps1.setInt(3,totalcol);
		   ps1.setInt(4,totalamt);
		   ps1.setInt(5,rest);
		   ps1.setString(6,i);
		   ps1.execute();
		
    

%>
<table id="Coupon" >
		<tr>
			<th>Balance at Beginning</th>
			<th>Collection</th>
			<th>Booked Amount</th>
			<th>Balance Now</th>
		</tr>
		<tr>
			<td><div><%out.println(begavailmoney);%></div></td>
			<td><div><%out.println(totalcol);%></div></td>
			<td><div><%out.println(totalamt);%></div></td>
			<td><div><%out.println(rest);%></td></div>
		</tr>
	</table>
	<%
   }  
	catch (SQLException sqle) {
        out.println(sqle.getMessage());
    } catch (Exception e) {
        out.println(e.getMessage());
    } 
finally {
        try {
            if ( con != null ) {
                con.close();
            }
        } catch (SQLException sqle) {
            out.println(sqle.getMessage());
        }
    }

    %>
</body>
</html>