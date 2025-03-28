package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheMultipleDataFromExcellSheet2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		//1.create the object of file input stream
			
		FileInputStream fis=new FileInputStream("./testscriptdata/data1.xlsx");
	             
		//2.open the work book in read mode
		
		Workbook wb=WorkbookFactory.create(fis);
		 //3.get the control of org sheet
		     Sheet sh= wb.getSheet("Sheet2");
		     
		  //4.getLastRowNum() method to count all the row from Excel
		     
		     int rowCount =sh.getLastRowNum();
		     
		     
		   //5.use for loop to iterate all row data from Excel sheet
		     
		     for(int i=0;i<=rowCount;i++)
		     {
		    	Row row  =sh.getRow(i);
		    	          
		    	         String column1Data=row.getCell(0).toString();
		    	         String column2Data=row.getCell(1).toString();
		    	         
		    	         System.out.println(column1Data+ "\t" + column2Data);
		    	
		    	
		     }
		     wb.close();
		     

	}

}
