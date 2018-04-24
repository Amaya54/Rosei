package Model;

public class BeanUpdateMealPrice {
	private String day;
	private String category;
	private String updateveg;
	private String updatenv;
	private boolean valid;
    
    
    
    public void setValid(boolean newValid) {
        valid = newValid;
	}
    public void setDay(String newDay)
    {
    	day=newDay;
    }
    public void setCategory(String newCategory)
    {
    	category=newCategory;
    }
    public void setUpdateveg(String newUpdateveg)
    {
    	updateveg=newUpdateveg;
    }
    public void setUpdatenv(String newUpdatenv)
    {
    	updatenv=newUpdatenv;
    }
    public String getCategory()
    {
    	return category;
    }
    public String getDay()
    {
    	return day;
    }
    public String getUpdateveg()
    {
    	return updateveg;
    }
    public String getUpdatenv()
    {
    	return updatenv;
    }
    public boolean getValid()
    {
    	return valid;
    }
}
