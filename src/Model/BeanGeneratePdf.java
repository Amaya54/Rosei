package Model;
import javax.servlet.http.HttpSession;
 public class BeanGeneratePdf{
	
    
      private String sid;
      private boolean valid;
      private String fdt,tdt,fd,td;
      
     
    	
      public void setValid(boolean newValid) {
          valid = newValid;
 	}	    
           
      public void setId(String st) {
         sid = st;
	}
      
      public void setFdt(String st) {
          fdt = st;
 	} public void setTdt(String st) {
          tdt = st;
	} public void setFd(String st) {
        fd = st;
	} public void setTd(String st) {
        td = st;
	}
	
    public String getFdt() {
        return fdt;
	} 
    public String getTdt() {
        return tdt;
	} 
    public String getFd() {
        return fd;
	} 
    public String getTd() {
        return td;
	} 
	
     
       public String getId() {
           return sid;
  	}
        
         
        public boolean getValid() {
        	return valid;
        }
        
      
}