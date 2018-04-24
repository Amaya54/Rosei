<html>
<head>
<script src="Files/StudentIssueCoupon.js"></script>
<script></script>
<link rel="stylesheet" type="text/css" href="Files/StudentIssueCoupon.css"/>
<style>
@font-face{font-family: 'Nova Square'; src: url('Files/NovaSquare.ttf');}
body{font-family:'Nova Square';color:white;font-size:80%;}
</style>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<body onload="check()">
<!-- <body onload="javascript:parent.location.reload();">-->
<%	
  if(session.getAttribute("currentSessionUserId")==null)
		{
			response.sendRedirect("http://172.16.2.2:8081/rosei/invalidLogin.jsp"); //error page
		}

int ii=(Integer)session.getAttribute("issuecheck");
String mes=request.getParameter("mess");
System.out.println("here"+mes);
if(mes.equals("m001"))
	ii=1;
else
	ii=2;
int check=0;
check=ii;
session.setAttribute("issuecheck",ii);
System.out.println("In Issue:"+check);
%> 

<%@ page language="java" import="java.util.*,Model.status,java.text.*,java.util.Date,java.sql.*, java.io.*" %>
<%


    Connection con = null;
Connection con1 = null;
Model.ConnectionManager cm=new Model.ConnectionManager();
	con = cm.getConnection();
	con1 = cm.getConnection1();

	String sid=(String)session.getAttribute("currentSessionUserId");
	String s=null;
	int currentamount=(Integer)session.getAttribute("currentmoney");
    PreparedStatement stmt=null;
	String sql;
	String mid=request.getParameter("mess");
	session.setAttribute("messid",mid);
	System.out.println(mid);
	String mname=null;
	if(mid.equals("m001"))
		mname="Roseighara-1";
	if(mid.equals("m002"))
		mname="Roseighara-2";
	System.out.println("amy"+mname);
	sql="select * from prayas.createcoupon where messid='"+request.getParameter("mess")+"' order by from_date asc";
    String[] dt=new String[7];
    try{
    stmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery();
	rs.last();
        
		session.setAttribute("fd", rs.getString(2));
		
       s=rs.getString(2)+"-"+rs.getString(3) ;
        
        System.out.println(s);
       SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd-EEE");
       Calendar c = Calendar.getInstance();
       c.setTime(fd.parse(s));
        
       
      String t=rs.getString(4)+"-"+rs.getString(5) ;
       
       System.out.println(t);
      SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd-EEE");
      Calendar c1 = Calendar.getInstance();
      c1.setTime(ft.parse(t));
      c1.add(Calendar.DATE, 1);  
      t = ft.format(c1.getTime());
      System.out.println(t);
     int i=(int)((c1.getTimeInMillis()-c.getTimeInMillis())/(24*60*60*1000));
     System.out.println(i);
     session.setAttribute("daylength",i);
     
     for(int k=0;k<i;k++)
     {
    	 
    	 dt[k]= fd.format(c.getTime());
    	 c.add(Calendar.DATE, 1);
    }
     for(int k=i;k<7;k++)
     {
		 dt[k]= "NOT APPLICABLE";	 
	
 }
    	 
     
       rs.close();
}  catch (SQLException sqle) {
    out.println(sqle.getMessage());
} catch (Exception e) {
    out.println(e.getMessage());
}
 

    Model.status st=new Model.status();
System.out.println(mid+dt[0]);	
%>




<div id="veg">VEG</div>
<div id="nonveg">NON-VEG</div>
	
	
	<table id="Coupon"><!--table contains our selection for meal-->
						<tr><!--first row-->
							<th>Date</th>
							<th>Breakfast<!--/Mess2--></th>
							<th>Lunch<!--/Mess2--></th>
							<th>Dinner<!--/Mess2--></th>
						</tr>
						<tr><!--second row-->
							<th><%out.println(dt[0]);%></th><!--Naming od ids is <mess1 or mess2><breakfast or lunch or dinner><date column sl no>-->
							<td>
								<div id="mess1b1" onclick="change2(this)"><p><%out.println(st.getstatus(dt[0],'b',sid,con1));%></p></div>
								<!--<div id="mess2b1" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1l1"onclick="change2(this)"><p><%out.println(st.getstatus(dt[0],'l',sid,con1));%></p></div>
								<!--<div id="mess2l1" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1d1" onclick="change2(this)"><p><%out.println(st.getstatus(dt[0],'d',sid,con1));%></p></div>
								<!--<div id="mess2d1" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
						</tr>
						<tr><!--third row-->	
							<th><%out.println(dt[1]);%></th>
							<td>
								<div id="mess1b2" onclick="change2(this)"><p><%out.println(st.getstatus(dt[1],'b',sid,con1));%></p></div>
								<!--<div id="mess2b2" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1l2" onclick="change2(this)"><p><%out.println(st.getstatus(dt[1],'l',sid,con1));%></p></div>
								<!--<div id="mess2l2" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1d2" onclick="change2(this)"><p><%out.println(st.getstatus(dt[1],'d',sid,con1));%></p></div>
								<!--<div id="mess2d2" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
						</tr>
						<tr>
							<th><%out.println(dt[2]);%></th>
							<td>
								<div id="mess1b3" onclick="change2(this)"><p><%out.println(st.getstatus(dt[2],'b',sid,con1));%></p></div>
								<!--<div id="mess2b3" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1l3" onclick="change2(this)"><p><%out.println(st.getstatus(dt[2],'l',sid,con1));%></p></div>
								<!--<div id="mess2l3" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1d3" onclick="change2(this)"><p><%out.println(st.getstatus(dt[2],'d',sid,con1));%></p></div>
								<!--<div id="mess2d3" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
						</tr>
						<tr>
							<th><%out.println(dt[3]);%></th>
							<td>
								<div id="mess1b4" onclick="change2(this)"><p><%out.println(st.getstatus(dt[3],'b',sid,con1));%></p></div>
								<!--<div id="mess2b4" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1l4" onclick="change2(this)"><p><%out.println(st.getstatus(dt[3],'l',sid,con1));%></p></div>
								<!--<div id="mess2l4" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1d4" onclick="change2(this)"><p><%out.println(st.getstatus(dt[3],'d',sid,con1));%></p></div>
								<!--<div id="mess2d4" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
						</tr>
						<tr>
							<th><%out.println(dt[4]);%></th>
							<td>
								<div id="mess1b5" onclick="change2(this)"><p><%out.println(st.getstatus(dt[4],'b',sid,con1));%></p></div>
								<!--<div id="mess2b5" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1l5" onclick="change2(this)"><p><%out.println(st.getstatus(dt[4],'l',sid,con1));%></p></div>
								<!--<div id="mess2l5" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1d5" onclick="change2(this)"><p><%out.println(st.getstatus(dt[4],'d',sid,con1));%></p></div>
								<!--<div id="mess2d5" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
						</tr>
						<tr>
							<th><%out.println(dt[5]);%></th>
							<td>
								<div id="mess1b6" onclick="change2(this)"><p><%out.println(st.getstatus(dt[5],'b',sid,con1));%></p></div>
								<!--<div id="mess2b6" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1l6" onclick="change2(this)"><p><%out.println(st.getstatus(dt[5],'l',sid,con1));%></p></div>
								<!--<div id="mess2l6" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1d6" onclick="change2(this)"><p><%out.println(st.getstatus(dt[5],'d',sid,con1));%></p></div>
								<!--<div id="mess2d6" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
						</tr>
						<tr>
							<th><%out.println(dt[6]);%></th>
							<td>
								<div id="mess1b7" onclick="change2(this)"><p><%out.println(st.getstatus(dt[6],'b',sid,con1));%></p></div>
								<!--<div id="mess2b7" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1l7" onclick="change2(this)"><p><%out.println(st.getstatus(dt[6],'l',sid,con1));%></p></div>
								<!--<div id="mess2l7" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
							<td align="center">
								<div id="mess1d7" onclick="change2(this)"><p><%out.println(st.getstatus(dt[6],'d',sid,con1));%></p></div>
								<!--<div id="mess2d7" style="left:25px;" onclick="change2(this)">Mess 2</div>-->
							</td>
						</tr>
					</table>
							

	
	<form style="position:absolute;top:0px;z-index:1;" name="myForm"  action="Servlet/ControllerIssueCoupon" method="POST" enctype="application/x-www-form-urlencoded">
		<table style="visibility:hidden;z-index:1;">
		
			<tr>
				<th>DATE-DAY</th>
				<th>BREAKFAST</th>
				<th>LUNCH</th>
				<th>DINNER</th>
			</tr>
			<tr>
				<th><%out.println(dt[0]);%></th>
				<td>
					<input id="chkb1" type="checkbox" name=<%out.println((dt[0].substring(11,14)).toLowerCase()+"bf value="+mid+dt[0]);%>/>
					<%out.println("<select id=subb1 name="+(dt[0].substring(11,14)).toLowerCase()+"bfmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkl1" type="checkbox" name=<%out.println((dt[0].substring(11,14)).toLowerCase()+"lun value="+mid+dt[0]);%>/>
					<%out.println("<select id=subl1 name="+(dt[0].substring(11,14)).toLowerCase()+"lunmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkd1" type="checkbox" name=<%out.println((dt[0].substring(11,14)).toLowerCase()+"din value="+mid+dt[0]);%>/>
					<%out.println("<select id=subd1 name="+(dt[0].substring(11,14)).toLowerCase()+"dinmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
			</tr>
			<tr>
				<th><%out.println(dt[1]);%></th>
				<td>
					<input id="chkb2" type="checkbox" name=<%out.println((dt[1].substring(11,14)).toLowerCase()+"bf value="+mid+dt[1]);%>/>
					<%out.println("<select id=subb2 name="+(dt[1].substring(11,14)).toLowerCase()+"bfmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkl2" type="checkbox" name=<%out.println((dt[1].substring(11,14)).toLowerCase()+"lun value="+mid+dt[1]);%>/>
					<%out.println("<select id=subl2 name="+(dt[1].substring(11,14)).toLowerCase()+"lunmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkd2" type="checkbox" name=<%out.println((dt[1].substring(11,14)).toLowerCase()+"din value="+mid+dt[1]);%>/>
					<%out.println("<select id=subd2 name="+(dt[1].substring(11,14)).toLowerCase()+"dinmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
			</tr>
			<tr>
				<th><%out.println(dt[2]);%></th>
				<td>
					<input id="chkb3" type="checkbox" name=<%out.println((dt[2].substring(11,14)).toLowerCase()+"bf value="+mid+dt[2]);%>/>
					<%out.println("<select id=subb3 name="+(dt[2].substring(11,14)).toLowerCase()+"bfmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkl3" type="checkbox" name=<%out.println((dt[2].substring(11,14)).toLowerCase()+"lun value="+mid+dt[2]);%>/>
					<%out.println("<select id=subl3 name="+(dt[2].substring(11,14)).toLowerCase()+"lunmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkd3" type="checkbox" name=<%out.println((dt[2].substring(11,14)).toLowerCase()+"din value="+mid+dt[2]);%>/>
					<%out.println("<select id=subd3 name="+(dt[2].substring(11,14)).toLowerCase()+"dinmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
			</tr>
						<tr>
				<th><%out.println(dt[3]);%></th>
				<td>
					<input id="chkb4" type="checkbox" name=<%out.println((dt[3].substring(11,14)).toLowerCase()+"bf value="+mid+dt[3]);%>/>
					<%out.println("<select id=subb4 name="+(dt[3].substring(11,14)).toLowerCase()+"bfmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkl4" type="checkbox" name=<%out.println((dt[3].substring(11,14)).toLowerCase()+"lun value="+mid+dt[3]);%>/>
					<%out.println("<select id=subl4 name="+(dt[3].substring(11,14)).toLowerCase()+"lunmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkd4" type="checkbox" name=<%out.println((dt[3].substring(11,14)).toLowerCase()+"din value="+mid+dt[3]);%>/>
					<%out.println("<select id=subd4 name="+(dt[3].substring(11,14)).toLowerCase()+"dinmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
			</tr>
			<tr>
				<th><%out.println(dt[4]);%></th>
				<td>
					<input id="chkb5" type="checkbox" name=<%out.println((dt[4].substring(11,14)).toLowerCase()+"bf value="+mid+dt[4]);%>/>
					<%out.println("<select id=subb5 name="+(dt[4].substring(11,14)).toLowerCase()+"bfmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkl5" type="checkbox" name=<%out.println((dt[4].substring(11,14)).toLowerCase()+"lun value="+mid+dt[4]);%>/>
					<%out.println("<select id=subl5 name="+(dt[4].substring(11,14)).toLowerCase()+"lunmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkd5" type="checkbox" name=<%out.println((dt[4].substring(11,14)).toLowerCase()+"din value="+mid+dt[4]);%>/>
					<%out.println("<select id=subd5 name="+(dt[4].substring(11,14)).toLowerCase()+"dinmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
			</tr>
					<tr>
				<th><%out.println(dt[5]);%></th>
				<td>
					<input id="chkb6" type="checkbox" name=<%out.println((dt[5].substring(11,14)).toLowerCase()+"bf value="+mid+dt[5]);%>/>
					<%out.println("<select id=subb6 name="+(dt[5].substring(11,14)).toLowerCase()+"bfmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkl6" type="checkbox" name=<%out.println((dt[5].substring(11,14)).toLowerCase()+"lun value="+mid+dt[5]);%>/>
					<%out.println("<select id=subl6 name="+(dt[5].substring(11,14)).toLowerCase()+"lunmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkd6" type="checkbox" name=<%out.println((dt[5].substring(11,14)).toLowerCase()+"din value="+mid+dt[5]);%>/>
					<%out.println("<select id=subd6 name="+(dt[5].substring(11,14)).toLowerCase()+"dinmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
			</tr>
						<tr>
				<th><%out.println(dt[6]);%></th>
				<td>
					<input id="chkb7" type="checkbox" name=<%out.println((dt[6].substring(11,14)).toLowerCase()+"bf value="+mid+dt[6]);%>/>
					<%out.println("<select id=subb7 name="+(dt[6].substring(11,14)).toLowerCase()+"bfmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkl7" type="checkbox" name=<%out.println((dt[6].substring(11,14)).toLowerCase()+"lun value="+mid+dt[6]);%>/>
					<%out.println("<select id=subl7 name="+(dt[6].substring(11,14)).toLowerCase()+"lunmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
				<td>
					<input id="chkd7" type="checkbox" name=<%out.println((dt[6].substring(11,14)).toLowerCase()+"din value="+mid+dt[6]);%>/>
					<%out.println("<select id=subd7 name="+(dt[6].substring(11,14)).toLowerCase()+"dinmt>");%><option value="veg">Veg</option><option value="nonveg">Non-Veg</option></select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" name=<%out.println("check value="+check);%>/></td>
				<td>
					<input value="<%out.println(mname);%>" type="submit" id="submit" style="visibility:visible; position:absolute; top:420px;" onclick="javascript:document.body.style.cursor='wait';document.getElementById('process').style.visibility='visible';this.style.display='none';submit()"/>
					 
				</td>
				
			</tr>
		</table>
		<!-- <input id="submit" type="submit" onSubmit="window.parent.location.reload();" value="Submit">-->
			</form>

	<div id="process" style="visibility:hidden;height:100%;z-index:80;width:100%;background:white;color:black;position:absolute;top:0px;left:0px;"><div style="position:absolute;left:230px;top:120px;font-family:'Nova Square';"><center><h1>Processing </h1></center><center><img src="Files/loading.gif" alt="Process"/> </center><center><h3>Please wait</h3></center></div></div>





   	


<% con.close();System.out.println("In Issue:"+check); %>



	
</body>
</html>