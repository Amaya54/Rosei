package Model;
import javax.servlet.http.HttpSession;
 public class BeanIssueCoupon{
	double bprice,lprice,dprice;
	int check;
	String bid;
	
	public void setcheck(int b)
	  {
	  check=b;
	  }
  public int getcheck()
  {
  	return check;
  }
	
	
	
    public void setBid(String b)
	  {
	  bid=b;
	  }
    public String getBid()
    {
    	return bid;
    }
	
     public void setBprice(double bfprice)
	  {
	  bprice=bfprice;
	  }
	  public void setLprice(double lunprice)
	  {
	  lprice=lunprice;
	  }
	  public void setDprice(double dinprice)
	  {
	  dprice=dinprice;
	  }
	  
	  public double getBprice()
	  {
	  return bprice;
	  }
	  public double getLprice()
	  {
	  return lprice;
	  }
	  public double getDprice()
	  {
	  return dprice;
	  }
	  
	  
	  
}