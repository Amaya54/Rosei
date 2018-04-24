package Model;
import javax.servlet.http.HttpSession;
import java.text.*;
import java.util.*;
import java.sql.*;
 public class BeanviewRecharge{
	
      private String account;
      private boolean valid;
     
     public static ArrayList<String> adt1=null;
     public static ArrayList<Integer> amt1=null;
      public void setValid(boolean newValid) {
          valid = newValid;
 	}	  
           
      public void setAccountno(String st) {
         account= st;
	}
      public void setadt(ArrayList<String> adt) {
          adt1= adt;
 	}
      public void setamt(ArrayList<Integer> amt) {
          amt1= amt;
 	} 
      public static ArrayList<String> getadt() {
          return adt1;
 	}
      public static ArrayList<Integer> getamt() {
          return amt1;
 	}
     
      public String getAccountno() {
          return account;
 	}
      public boolean getValid() {
    	  return valid;
 	}	
      }