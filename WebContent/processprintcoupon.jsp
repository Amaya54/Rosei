<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;}</style>

</head>
<body>
<%@ page language="java" import="java.util.*,java.net.*,java.nio.channels.*,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%
    Connection con = null;

	
	String stdid=request.getParameter("id");
	System.out.println(stdid);
	String s=null;
	
    PreparedStatement stmt=null;
	String sql=null;
	String sql1=null;
	System.out.println("here");
	int i=0;
	String messid=(String)session.getAttribute("currentSessionUserId");
	System.out.println(messid);
    
    PreparedStatement ps=null;
    try{
    	Model.ConnectionManager cm=new Model.ConnectionManager();
    	con = cm.getConnection();
    	sql="select bookingid,printflag from prayas.booking where id='"+stdid+"' and messid='"+messid+"'";
    	System.out.println("here");
    stmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery();
    rs.last();
    s=rs.getString(1);
     System.out.println("s="+s);
      i=rs.getInt(2);
    
    
     rs.close(); 
    	 
}  catch (SQLException sqle) {
    out.println(sqle.getMessage());
} catch (Exception e) {
    out.println(e.getMessage());
} 

    try
    {
    	if(i==0)
        {
    		sql1="update prayas.booking set printflag=1 where bookingid='"+s+"'";
       	ps=con.prepareStatement(sql1);
       	boolean x=ps.execute();
       	if(x)
       	{	
       		
        }
        }
        else
       	 response.sendRedirect("http://172.16.2.2:8081/rosei/invalidprint.jsp");
     
    	ps.close();
    	  
    }  catch (SQLException sqle) {
        out.println(sqle.getMessage());
    } catch (Exception e) {
        out.println(e.getMessage());
    } finally {
        try {
            if ( con != null ) {
                con.close();
            }
        } catch (SQLException sqle) {
            out.println(sqle.getMessage());
        }
    }


	
%>
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/invalidLogin.jsp"); //error page
		}%> 
</body>
</html>