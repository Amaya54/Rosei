package LoginPackage;
import javax.servlet.http.HttpSession;
 public class UserBean{
	
      private String userid;
      
      private String name;
     
      private String usid;
      
      
	
	
      public String getName() {
         return name;
	}

      public void setName(String newName) {
         name = newName;
	}	
      public String getUserid() {
         return userid;
			}

      public void setUserid(String newUserid) {
         userid = newUserid;
			}
      

      
       public String getusId() {
           return usid;
  			}

        public void setusId(String newusId) {
           usid= newusId;
  			}
      
}