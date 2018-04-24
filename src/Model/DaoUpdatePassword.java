package Model;
import java.sql.*;

public class DaoUpdatePassword {
	 Connection currentCon = null;
	   
	
	
	   public BeanUpdatePassword create(BeanUpdatePassword bean) {
		   
		   
		   String sql="update prayas.login set salt='"+bean.getSalt()+"', hashvalue='"+bean.getHash()+"' where id ='"+bean.getUserid()+"'" ;
		   try 
		   {
			   ConnectionManager cm=new ConnectionManager();
			   currentCon = cm.getConnection();
			   Statement statement  = currentCon.createStatement();
			   int x=statement.executeUpdate(sql);
			   if(x==1){
				   bean.setValid(true);
				     } 
				   else
				   {
					   bean.setValid(false);
				   }
		
		   }
		   
		   catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally {
			        try {
			            
			            
			                currentCon.close();
			        } catch (SQLException e) {}
			  
		 }
		   return bean;
	   }
		
	

}
