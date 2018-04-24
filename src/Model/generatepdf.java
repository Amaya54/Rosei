package Model; 

import java.io.FileOutputStream;

import java.util.*;
import java.text.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.sql.*;
import java.io.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;

public class generatepdf {
 public static String generate(HttpServletRequest request, HttpServletResponse response,BeanIssueCoupon bean) 
         throws ServletException, java.io.IOException
	  {
 Connection con = null;

	
int i=0;
String name=null;
	String s=null;
	System.out.println("IN GENERATE PDF");
    PreparedStatement stmt=null;
	String sql;
	HttpSession session = request.getSession(true);
	
    String[] dt=new String[7];
    try{
    	ConnectionManager cm=new ConnectionManager();
    	con = cm.getConnection();
    	sql="select * from prayas.createcoupon where messid='"+(String)session.getAttribute("messid")+"'";
    stmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet rs = stmt.executeQuery();
	rs.last();
        System.out.println("TODAY:"+(String)session.getAttribute("messid"));
  
       s=rs.getString(2)+"-"+rs.getString(3) ;
        // Start date
        System.out.println("TODAY:"+s);
       SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd-EEE");
       Calendar c = Calendar.getInstance();
       c.setTime(fd.parse(s));
         // dt is now the new date
       
      String t=rs.getString(4)+"-"+rs.getString(5) ;
       // Start date
       System.out.println(t);
      SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd-EEE");
      Calendar c1 = Calendar.getInstance();
      c1.setTime(ft.parse(t));
      c1.add(Calendar.DATE, 1);  // number of days to add
      t = ft.format(c1.getTime());  // dt is now the new date
      System.out.println(t);
     i=(int)((c1.getTimeInMillis()-c.getTimeInMillis())/(24*60*60*1000));
     System.out.println(i);
     
     
     for(int k=0;k<i;k++)
     {
    	   
    	 dt[k]= fd.format(c.getTime());
    	 c.add(Calendar.DATE, 1);
    	 
     }
     
       rs.close();
}  catch (SQLException sqle) {
    
} catch (Exception e) {
    
} finally {
    try {
        if ( con != null ) {
            con.close();
        }
    } catch (SQLException sqle) {
       
    }
}

	 
	 
	    Document document = new Document();

	    try {
	    	String bid=bean.getBid();
	    	String path="C:/Documents and Settings/Administrator/workspace/rosei/WebContent/coupons";
	    	name=path+"/"+bid+".pdf";
	      PdfWriter.getInstance(document, new FileOutputStream(name));
	      System.out.println("After Generation");
	      document.open();
	      String id=(String)session.getAttribute("currentSessionUserId");
	      String uname=(String)session.getAttribute("currentSessionUsername");
	      Paragraph pp = new Paragraph ("ID:"+id+"\nNAME:"+uname+"\nBOOKING ID:"+bid+"\n\n");
	      document.add (pp);
	          
	      PdfPTable table = new PdfPTable(4);
	     
	      PdfPCell c1 = new PdfPCell(new Phrase("DAY"));
	      c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      table.addCell(c1);

	      c1 = new PdfPCell(new Phrase("BREAKFAST"));
	      c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      table.addCell(c1);

	      c1 = new PdfPCell(new Phrase("LUNCH"));
	      c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      table.addCell(c1);
		  
		  c1 = new PdfPCell(new Phrase("DNNER"));
	      c1.setHorizontalAlignment(Element.ALIGN_LEFT);
	      table.addCell(c1);
	      System.out.println(Global.monbf);
	      System.out.println("loop count:"+i);
	     for(int l=0;l<i;l++)
		 {
		 String day=(dt[l].substring(11,14)).toLowerCase();
		 
	      table.addCell(day);
		  String valb=null;
		  String vall=null;
		  String vald=null;
		  
		  if(day.equals("mon"))
		  {
		  valb=Global.monbf;
		  vall=Global.monlun;
		  vald=Global.mondin;
		  if(valb!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(valb);
		  Global.monbf=null;
		  }
		  else 	
		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
		  } 
		  if(vall!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vall);
		  Global.monlun=null;
		  }
		  else 		  
		  	  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vald!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vald);
		  Global.mondin=null;
		  }
		  else 		  
		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
		 } 
	}
		  else if(day.equals("tue"))
		  {
		  valb=Global.tuebf;
		  vall=Global.tuelun;
		  vald=Global.tuedin;
		  if(valb!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(valb);
		  Global.tuebf=null;
		  }
		  else 		  
		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
		  } 
		  if(vall!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vall);
		  Global.tuelun=null;
		  }
		  else 		 
		  	  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vald!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vald);
		  Global.tuedin=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
	}
		  else if(day.equals("wed"))
		  {
		  valb=Global.wedbf;
		  vall=Global.wedlun;
		  vald=Global.weddin;
		  if(valb!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(valb);
		  Global.wedbf=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vall!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vall);
		  Global.wedlun=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vald!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vald);
		  Global.weddin=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
	}
		  else if(day.equals("thu"))
		  {
		  valb=Global.thubf;
		  vall=Global.thulun;
		  vald=Global.thudin;
		  if(valb!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(valb);
		  Global.thubf=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vall!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vall);
		  Global.thulun=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vald!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vald);
		  Global.thudin=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
	}
		  else if(day.equals("fri"))
		  {
		  valb=Global.fribf;
		  vall=Global.frilun;
		  vald=Global.fridin;
		  if(valb!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(valb);
		  Global.fribf=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vall!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vall);
		  Global.frilun=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  
			  } 
		  if(vald!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vald);
		  Global.fridin=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
	}
		  else if(day.equals("sat"))
		  {
		  valb=Global.satbf;
		  vall=Global.satlun;
		  vald=Global.satdin;
		  if(valb!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(valb);
		  Global.satbf=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vall!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vall);
		  Global.satlun=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vald!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vald);
		  Global.satdin=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
	}
		  else if(day.equals("sat"))
		  {
		  valb=Global.satbf;
		  vall=Global.satlun;
		  vald=Global.satdin;
		  if(valb!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(valb);
		  Global.sunbf=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vall!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vall);
		  Global.satlun=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vald!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vald);
		  Global.satdin=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
	}
		  else if(day.equals("sun"))
		  {
		  valb=Global.sunbf;
		  vall=Global.sunlun;
		  vald=Global.sundin;
		  if(valb!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(valb);
		  Global.sunbf=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vall!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vall);
		  Global.sunlun=null;
		  }
		  else 		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
		  if(vald!=null)
		  {
		  c1.setBackgroundColor(BaseColor.WHITE);
		  table.addCell(vald);
		  Global.sundin=null;
		  }
		  else		  {
			  c1.setBackgroundColor(BaseColor.BLACK);
			  table.addCell("NOT AVAILABLE");
			  } 
	}
		  
		     }
		      document.add(table);
		      System.out.println("After addition of table");
		      document.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return name;
		  }
		}

