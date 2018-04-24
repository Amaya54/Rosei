package Model;
import javax.servlet.http.HttpSession;
 public class BeanCreateCoupon{
	
      private String fday;
      private String tday;
      private String fdate;
      private String tdate;
      private String date;
      private boolean valid;
      
     
      
      public void setValid(boolean newValid) {
          valid = newValid;
 	}	    
           
      public void setFday(String newDay) {
         fday = newDay;
	}	
      public void setTday(String newDay) {
          tday = newDay;
 	}
      public void setFdate(String newDate) {
          fdate = newDate;
 	}	
       public void setTdate(String newDate) {
           tdate = newDate;
  	}
       public void setDate(String newDate) {
           date = newDate;
  	} 
       public String getDate() {
           return date;
    	}	
       public String getFdate()	 {
           return fdate;
       }
       public String getFday() {
           return fday;
	}
       public String getTdate() {
               return tdate;
    	}
       public String getTday() {
           return tday;
	}
 public boolean getValid() {
     return valid;
}	
}