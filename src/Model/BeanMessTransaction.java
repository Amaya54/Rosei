package Model;

import java.util.ArrayList;

public class BeanMessTransaction {
	
	private boolean valid;
	public static ArrayList<String> dt1=null;
	public static ArrayList<Double> bf=null,lun=null,din=null;
	public static ArrayList<Integer> money;
	public static int k=0;
	
	public void setLoop(int m)
	{
		k=m;
		
	}
	
	public static int getLoop()
	{
		return k;
	}
	 public void setValid(boolean newValid) {
         valid = newValid;
	}	  
	
	
      public boolean getValid() {
    	  return valid;
 	}
     
      
      public void setDate1(ArrayList<String> adt) {
          dt1= adt;
 	}
  
      public static ArrayList<String> getDate1() {
          return dt1;
 	}
 
      public  void setbf(ArrayList<Double> adt) {
          bf= adt;
 	}
      
      
      public  void setMoney(ArrayList<Integer> adt) {
          money= adt;
 	}
      
      public static ArrayList<Integer> getmoney() {
          return money;
 	}
      
      public static ArrayList<Double> getbf() {
          return bf;
 	}
      
      public void setlun(ArrayList<Double> adt) {
          lun= adt;
 	}
  
      public static ArrayList<Double> getlun() {
          return lun;
 	}
      
      public void setdin(ArrayList<Double> adt) {
          din= adt;
 	}
  
      public static ArrayList<Double> getdin() {
          return din;
 	}
 
}
