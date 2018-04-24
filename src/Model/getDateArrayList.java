package Model;
import java.util.*;
import java.text.*;

public class getDateArrayList {
	int i=0;
	public  void getdt (BeanMessTransaction br,String f,String t)
	{
		 ArrayList<String> date1=new ArrayList<String>();
		
		try{
		 SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
	       Calendar c = Calendar.getInstance();
	       c.setTime(fd.parse(f));
	       
		  SimpleDateFormat td = new SimpleDateFormat("yyyy-MM-dd");
	      Calendar c1 = Calendar.getInstance();
	      c1.setTime(td.parse(t));
	     
	    
	    
	     i=(int)((c1.getTimeInMillis()-c.getTimeInMillis())/(24*60*60*1000));
	     
	     
	     //System.out.println("DAY LENGTH IS:"+i);
	     for(int k=0;k<=i;k++)
	     {
	    	 
	    	 date1.add(fd.format(c.getTime()));
	    	 c.add(Calendar.DATE, 1);
	    	 br.setValid(true);
	    }
	     br.setDate1(date1);
		
	    
		}
		catch (Exception e) {
		    System.out.println(e.getMessage());
		}
		finally{
	
		}
		
	}
	public int getLen()
	{
		return i;
	}
	
	
}

