import java.io.FileOutputStream;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
public class test {
    public static void main(String[] args) {
        try {
            PdfReader Read_PDF_To_Watermark = new PdfReader("C:/Documents and Settings/Administrator/workspace/rosei/coupons/m001.pdf");
            int number_of_pages = Read_PDF_To_Watermark.getNumberOfPages();
            PdfStamper stamp = new PdfStamper(Read_PDF_To_Watermark, new FileOutputStream("C:/Documents and Settings/Administrator/workspace/rosei/m002/m001.pdf"));
            int i = 0;
            Image watermark_image1 = Image.getInstance("C:/Documents and Settings/Administrator/workspace/rosei/123.jpg");
            Image watermark_image2 = Image.getInstance("C:/Documents and Settings/Administrator/workspace/rosei/123.jpg");
            Image watermark_image3 = Image.getInstance("C:/Documents and Settings/Administrator/workspace/rosei/123.jpg");
            Image watermark_image4 = Image.getInstance("C:/Documents and Settings/Administrator/workspace/rosei/123.jpg");
            Image watermark_image5 = Image.getInstance("C:/Documents and Settings/Administrator/workspace/rosei/123.jpg");
            Image watermark_image6 = Image.getInstance("C:/Documents and Settings/Administrator/workspace/rosei/123.jpg");
            Image watermark_image7 = Image.getInstance("C:/Documents and Settings/Administrator/workspace/rosei/123.jpg");
            Image watermark_image8 = Image.getInstance("C:/Documents and Settings/Administrator/workspace/rosei/123.jpg");
            watermark_image1.setAbsolutePosition(50,130);
            watermark_image2.setAbsolutePosition(350,130);
            watermark_image3.setAbsolutePosition(50,310);
            watermark_image4.setAbsolutePosition(350,310);
            watermark_image5.setAbsolutePosition(50,490);
            watermark_image6.setAbsolutePosition(350,490);
            watermark_image7.setAbsolutePosition(50,690);
            watermark_image8.setAbsolutePosition(350,690);
            PdfContentByte add_watermark;            
            while (i < number_of_pages) {
              i++;
              add_watermark = stamp.getUnderContent(i);
              add_watermark.addImage(watermark_image1);
              add_watermark.addImage(watermark_image2);
              add_watermark.addImage(watermark_image3);
              add_watermark.addImage(watermark_image4);
              add_watermark.addImage(watermark_image5);
              add_watermark.addImage(watermark_image6);
              add_watermark.addImage(watermark_image7);
              add_watermark.addImage(watermark_image8);
              
            }
            stamp.close();
        }
        catch (Exception i1) {
            i1.printStackTrace();
        }
    }
}