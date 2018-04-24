
import java.text.SimpleDateFormat;
import java.util.*;

public class hash {

	public static void main(String args[])
	
	{
		String input="abcd";
		int s=0;
		Random r=new Random();
		int salt=r.nextInt(100);
		for (int j=0;j<=input.length()-1;j++)
		{
		char c1=input.charAt(j);
		int k=(int)c1;
		s=s+k;
		System.out.println(k);
		System.out.println("\n"+salt);
		}

	int h=(s*9*salt)-(18+salt);
	System.out.println("\n"+h);
	Calendar cal = Calendar.getInstance();
	cal.set(2011, 02, 28);
	System.out.println(cal.get(Calendar.DAY_OF_WEEK));
	System.out.println(new SimpleDateFormat("EEE").format(cal.getTime())); 

	}
}