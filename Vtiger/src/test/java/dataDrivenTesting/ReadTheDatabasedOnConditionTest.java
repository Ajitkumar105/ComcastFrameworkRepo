package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDatabasedOnConditionTest {
	
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 String data=" ";
			String expectedTest="tc_02";

		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\Ajit\\\\Desktop\\\\New folder\\\\data1.xlsx");
        
		//2.open the work book in read mode
		
		Workbook wb=WorkbookFactory.create(fis);
		 //3.get the control of org sheet
		     Sheet sh= wb.getSheet("org");
		     
		  //4.getLastRowNum() method to count all the row from Excel
		     
		     int rowCount =sh.getLastRowNum();
		     
		     
		   //5.use for loop to iterate all row data from Excel sheet
		     
		     for(int i=0;i<=rowCount;i++)
		     {
		    	try
		    	{
		    	 
		            data=sh.getRow(i).getCell(0).toString();
		     } 
		   
		     catch(Exception e)
		    	{
		    	 
		    	}
			System.out.println(data);

		     }
	
		     wb.close();
	}

}

