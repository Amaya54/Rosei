package Model;
import javax.servlet.http.HttpSession;
import java.text.*;
import java.util.*;
import java.sql.*;
 public class BeanviewBookingDetail{
	
      private String table1,table2,sid;
      private boolean valid;
      public ArrayList<String> dt1=null;
      public ArrayList<String> dt2=null;
      public void setValid(boolean newValid) {
          valid = newValid;
 	}	  
           
      public void setTable1(String st) {
         table1= st;
	}
      public void setTable2(String st) {
          table2= st;
 	}
      public void setStudentId(String st) {
          sid= st;
 	}
      public String getStudentId() {
          return sid;
 	}
      public String getTable1() {
          return table1;
 	}
       public String getTable2() {
           return table2;
  	}
           public boolean getValid() {
    	  return valid;
 	}
           public void setDate1(ArrayList<String> adt) {
               dt1= adt;
      	}
           public void setDate2(ArrayList<String> amt) {
               dt2= amt;
      	} 
           public  ArrayList<String> getDate1() {
               return dt1;
      	}
           public  ArrayList<String> getDate2() {
               return dt2;
      	}
      }
