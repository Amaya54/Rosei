package Model;

import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.text.DateFormatSymbols;
import java.util.GregorianCalendar;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.*;

public class day{
  public static String getday(String dt) {
	  
	 int yr=Integer.parseInt(dt.substring(6, 10));
	 int mn=Integer.parseInt(dt.substring(0, 2));
	 int dd=Integer.parseInt(dt.substring(3,5));
	 

    GregorianCalendar d = new GregorianCalendar(yr, mn, dd);
    
    String[] weekdays = new DateFormatSymbols().getWeekdays(); // Get day names
    String dy=weekdays[d.get(DAY_OF_WEEK)];
    return dy;
  }
}