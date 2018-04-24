package Model;
import java.util.*;
import java.text.*;

public class getDateArray {
	int i=0;
	public  String[] getdt (String f,String t)
	{
		String[] dt=new String[7];
		
		try{
		 SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd-EEE");
	       Calendar c = Calendar.getInstance();
	       c.setTime(fd.parse(f));
	       
		  SimpleDateFormat td = new SimpleDateFormat("yyyy-MM-dd-EEE");
	      Calendar c1 = Calendar.getInstance();
	      c1.setTime(td.parse(t));
	     
	    
	    
	     i=(int)((c1.getTimeInMillis()-c.getTimeInMillis())/(24*60*60*1000));
	     
	     
	     //System.out.println("DAY LENGTH IS:"+i);
	     for(int k=0;k<=i;k++)
	     {
	    	 
	    	 dt[k]= fd.format(c.getTime());
	    	 c.add(Calendar.DATE, 1);
	    }
		
	    
		}
		catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		finally{
	
		}
		 return dt;
	}
	public int getLen()
	{
		return i;
	}
	
	
}
