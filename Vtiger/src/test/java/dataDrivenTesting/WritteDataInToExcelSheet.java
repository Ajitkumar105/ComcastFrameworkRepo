package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritteDataInToExcelSheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		// 1.create the object of file input stream

		FileInputStream fis = new FileInputStream("./testscriptdata/data1.xlsx");

		// 2.open the work book in read mode

		Workbook wb = WorkbookFactory.create(fis);
		// 3.get the control of org sheet
		Sheet sh = wb.getSheet("org");

		Row row = sh.getRow(1);

		Cell cell =row.createCell(4);
		 cell.setCellValue("PASS");

		
	
	
	FileOutputStream fos=new FileOutputStream("./testscriptdata/data1.xlsx");
      wb.write(fos);
      wb.close();
}
}