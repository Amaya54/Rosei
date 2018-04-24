
package LoginPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */


public class LoginServlet extends HttpServlet{


public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, java.io.IOException {
System.out.println("called");

try
{	 
	String uid=request.getParameter("un") ;
	String pwd=request.getParameter("pw") ;
	
	int hashval,chash,salt;
     UserBean user = new UserBean();
     user.setUserid(uid);
     
     UserDAO ud=new UserDAO();
	salt=ud.getSalt(user);  
	chash=hashing.getHash(pwd,salt);
	hashval=ud.getHash(user);
	System.out.println(chash+"\n");
	System.out.println(hashval+"\n");
    /*if(chash==-18)
    	response.sendRedirect("http://172.16.2.2:8081/rosei/fuckYou.jsp"); //error page*/
	int in;
	char st;
	for(int l=0;l<pwd.length()-1;l++)
	{
    st= pwd.charAt(l);
    in =(int)st;
    if(in==39 || in==61)
    {
    	response.sendRedirect("http://172.16.2.2:8081/rosei/fuckYou.jsp"); //error page*/
	break;
    }
	}
    		
   
    if(hashval==chash)
        {
        	user=ud.login(user);
        	System.out.println(user.getusId());
        	 System.out.println("HII I am here\t"+hashval+'\t'+chash);  
            HttpSession session = request.getSession(true);	    
            session.setAttribute("currentSessionUsername",user.getName());
            session.setAttribute("currentSessionUserId",uid);
            session.setAttribute("currentSessionUserType",user.getusId());
            response.sendRedirect("http://172.16.2.2:8081/rosei/userLogged"+user.getusId()+".jsp"); //logged-in page      		
            System.out.println(user.getusId());
        }
	        
   else 
        response.sendRedirect("http://172.16.2.2:8081/rosei/invalidUser.jsp"); //error page
    

		
}		
catch (Throwable theException) 	    
{
   System.out.println(theException); 
}
}
}
