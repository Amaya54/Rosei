<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,javax.servlet.http.HttpSession,java.sql.*,Model.BeanviewRecharge" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>@font-face{font-family: Nova Square; src: url('Files/NovaSquare.ttf');}
body{font-family:Nova Square;color:white;}
table{position:absolute;  overflow:hidden; box-shado:0px 3px 10px rgb(0,50,0); top:0px; left:0px; min-height:410px; min-width:600px; height:85%; width:55%; borde:1px solid black;z-index:3;}
table tr td{position:relative; borde:1px solid black; heigh:55px; width:20%; text-align:center; background:rgba(2,96,119,0.3);}
table tr th{borde:1px solid black; heigh:30px; background:rgba(2,96,119,0.5);}
table tr td div{position:relative; cursor:pointer; lef:0px; float:left; height:38px; width:130px; padding:7px; background:rgba(2,96,119,0.5); borde:1px solid black; 

</style>
</head>
<body>
<%



  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}%> 




<% 
ArrayList<String> adt=BeanviewRecharge.getadt();
ArrayList<Integer> amt=BeanviewRecharge.getamt();

%>
<table>

<tr><th>Transaction Date</th><th>Transaction Amount</th></tr>
<%try {
	for(int i=0;i<adt.size();i++){

out.println("<tr><td>"+adt.get(i)+"</td><td>"+amt.get(i)+"</td></tr>");	
}
	BeanviewRecharge.adt1=null;
	BeanviewRecharge.amt1=null;
}
catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
 }
 


%>





</table>


</body>
</html>