import javax.servlet.*;
import javax.servlet.http.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.*;
import java.util.*;
public class generatepdf extends HttpServlet 
{
    public void init(ServletConfig config) throws ServletException
        {
        super.init(config);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
        {
        response.setContentType("application/pdf"); // Code 1
        Document document = new Document();
        try
                {
            PdfWriter.getInstance(document, 
            response.getOutputStream()); // Code 2
            document.open();
            // Code 3
            PdfPTable table = new PdfPTable(2);
            table.addCell("1");
            table.addCell("2");
            table.addCell("3");
            table.addCell("4");
            table.addCell("5");
            table.addCell("6");     
            // Code 4
            document.add(table);        
            document.close(); 
        }
                catch(DocumentException e)
                {
                    e.printStackTrace();
                    //out.println("Exception: "+e);
        }
    }
}