package Model;
import javax.servlet.http.HttpSession;
 public class BeanRecharge
 {
	
      private String account_no ;
      private int amount;
      private String std_id;
      private String date;
      private String messname;
      private boolean valid;
      private int famt;
     
      
      public void setFamt(int k) {
        famt=k;
      }
 	
      public void setValid(boolean newValid) {
          valid = newValid;
 	}	    
           
      public void setStudentId(String st) {
         std_id = st;
	}
      public void setAccountNo(String st) {
          account_no = st;
 	}
      public void setMessName(String mn) {
          messname = mn;
 	}
      
      public void setAmount(int at) {
          amount = at;
 	}
  
       public void setDate(String newDate) {
           date = newDate;
  	} 
       public String getDate() {
           return date;
    	}	
     
       public String getStudentId() {
           return std_id;
  	}
     
       public String getAccountNo() {
           return account_no;
  	}
        
     
        public int getAmount() {
            return amount;
   	}
    
        public boolean getValid() {
        	return valid;
        }
        
        public String getMessName() {
            return messname;
     
       }
        
        public int getFamt() {
            return famt;
   	}
}