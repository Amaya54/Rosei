package LoginPackage;
import java.util.*;

public class hash {

	public static void main (String args[])
	
	{
		String input="sairam";
		int s=0;
		int salt=54;
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
	
	}
}