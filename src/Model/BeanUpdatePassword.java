package Model;

public class BeanUpdatePassword {
	
	 private String uid;
	 private int hash;
     private int salt ;
     private boolean valid;
     
    
     
     public void setValid(boolean newValid) {
         valid = newValid;
	}	    
          
    	
   public void setUserid(String newUserid) {
        uid = newUserid;
			} 
   	
  public void setSalt(int newSalt) {
         salt= newSalt;
			}
  public void setHash(int newHash) {
      hash= newHash;
			}
 
 public String getUserid() {
      return uid;
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
