package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelTestData 
{
	@DataProvider(name="loginData")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] testdata=new Object[1][2];
		FileInputStream fis=new FileInputStream("C:\\Users\\anuna\\GroTechMinds-Automation Projects\\Project01_AmazonApplication\\test-output\\ExcelSheet\\ExcelTestData.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet("LoginData");
		DataFormatter formatter=new DataFormatter();
		for(int i=1;i<3;i++) //row
		{
			for(int j=0;j<2;j++) //column
			{
				testdata[i-1][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		return testdata;
	}
	@DataProvider(name="validLoginData")
	public Object[][] getValidData() throws EncryptedDocumentException, IOException
	{
		Object[][] testdata=new Object[1][2];
		FileInputStream fis=new FileInputStream("C:\\Users\\anuna\\GroTechMinds-Automation Projects\\Project01_AmazonApplication\\test-output\\ExcelSheet\\ExcelTestData.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet("ValidLoginData");
		DataFormatter formatter=new DataFormatter();
		for(int i=1;i<2;i++) //row
		{
			for(int j=0;j<2;j++) //column
			{
				testdata[i-1][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		return testdata;
	}
	@DataProvider(name="invalidLoginData")
	public Object[][] getInvalidData() throws EncryptedDocumentException, IOException
	{
		Object[][] testdata=new Object[1][2];
		FileInputStream fis=new FileInputStream("C:\\Users\\anuna\\GroTechMinds-Automation Projects\\Project01_AmazonApplication\\test-output\\ExcelSheet\\ExcelTestData.xlsx");
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet("InvalidLoginData");
		DataFormatter formatter=new DataFormatter();
		for(int i=1;i<2;i++) //row
		{
			for(int j=0;j<2;j++) //column
			{
				testdata[i-1][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		return testdata;
	}
}
