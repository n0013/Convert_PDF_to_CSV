import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
public class ReadPdf2
{
    public static void main(String args[]) throws IOException
    {
        System.out.println("Go!");
        try
        {
            PrintWriter csvFile = new PrintWriter("D:\\Java Project\\Convert pdf to cvs\\files\\data.csv");
            PDDocument document = PDDocument.load(new File("D:\\Java Project\\Convert pdf to cvs\\files\\2.pdf"));// here file1.pdf is the name of pdf file which we want to read....

            document.getClass();
            if (!document.isEncrypted())
            {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper Tstripper = new PDFTextStripper();
                String str = Tstripper.getText(document);

                Scanner scnLine = null;
                scnLine = new Scanner(str);

                String line="";
                String strDate="";
                String strDay="";
                String strTotalProfit="";
                String strDailyProfit="";

                while (scnLine.hasNextLine())
                {
                    line = scnLine.nextLine();
                    Scanner scnWord = new Scanner(line);
                    strDate=scnWord.next();
                    strDay=scnWord.next();
                    strTotalProfit=scnWord.next();
                    strDailyProfit=scnWord.next();
                    csvFile.println(strDailyProfit+";"+strDay+";"+strTotalProfit+";"+strDailyProfit);
                }
            }
            document.close();
            csvFile.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}