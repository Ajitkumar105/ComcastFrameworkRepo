package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcelTest1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		//1.create the object of file input stream
			
		FileInputStream fis=new FileInputStream("./testscriptdata/data1.xlsx");
	             
		//2.open the work book in read mode
		
		Workbook wb=WorkbookFactory.create(fis);
		 //3.get the control of org sheet
		     Sheet sh= wb.getSheet("Sheet2");
		     
		// 4.Get the control of first row
		     
		  Row row=    sh.getRow(0);
		  
		   String column1Data  = row.getCell(0).toString();
		   String column2Data  = row.getCell(1).toString();
		   
		   System.out.println(column1Data);
		   System.out.println(column2Data);
		   
		   System.out.println(column1Data+ "\t" +column1Data) ;
		   
		   wb.close();
		   
		   

	}

}
