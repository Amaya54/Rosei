package Model;
import javax.servlet.http.HttpSession;
 public class BeanCreateUser{
	
      private String uid;
      private String name;
      private String add;
      private String gen;
      private int hash;
      private int salt ;
      private String con ;
      private String cid;
      private boolean valid;
      
     
      
      public void setValid(boolean newValid) {
          valid = newValid;
 	}	    
           
      public void setName(String newName) {
         name = newName;
	}	
    public void setUserid(String newUserid) {
         uid = newUserid;
			} 
    public void setAddress(String newAddress) {
           add= newAddress;
  			}
    public void setGender(String newGender) {
        gen = newGender;
	}	
   public void setContact(String newContact) {
        con = newContact;
			} 
   public void setClient(String newClient) {
       cid = newClient;
	}	
   public void setSalt(int newSalt) {
          salt= newSalt;
 			}
   public void setHash(int newHash) {
       hash= newHash;
			}
   public String getName() {
       return name;
	}	
  public String getUserid() {
       return uid;
			} 
  public String getAddress() {
         return add;
			}
  public String getGender() {
      return gen;
	}	
 public String getContact() {
      return con;
			} 
 public String getClient() {
     return cid;
	}	
 public int getSalt() {
        return salt;
			}
 public int getHash() {
     return hash;
			}
 public boolean getValid() {
     return valid;
}	
}