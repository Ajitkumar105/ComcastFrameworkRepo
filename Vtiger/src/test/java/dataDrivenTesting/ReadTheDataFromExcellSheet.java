package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcellSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		
	//1.create the object of file input stream 
		
	FileInputStream fis=new FileInputStream("./testscriptdata/data1.xlsx");
             
	//2.open the work book in read mode
	
	Workbook wb=WorkbookFactory.create(fis);
	 //3.get the control of org sheet
	     Sheet sh= wb.getSheet("org");
	     
	// 4.Get the control of first row
	     
	  Row row=    sh.getRow(1);
	  
	//5.Get the control of 2nd column(cell) read the String data
	  
	  Cell cell=row.getCell(2);
	   String data        =cell.getStringCellValue();
	    
	   System.out.println(data);
	   
	   wb.close();
	  
	     
	 
	
	
	
	}

}
