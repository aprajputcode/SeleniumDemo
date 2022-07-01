package com.orange.TEstCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class commanclass {
	
public static WebDriver driver;
	
	
	public static WebDriver driverset(String path)
	{
		
			switch(path) {
			case "chrome":
				driver=new ChromeDriver();
				break;
				
			case "edge":
				driver=new EdgeDriver();
				break;
				}
			return driver;


}
	
	public static void screenshot(String methodname) throws IOException {
		TakesScreenshot sc=((TakesScreenshot)driver);
		File DestFile=new File("./ScreenShort\\"+methodname+".png");
		File SrcFile=sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(SrcFile, DestFile);
	}
	
	
	public static void writeExcel(String Excelpath,int sheetnumber, int rowindex ,int cellindex) throws IOException
	{
		FileInputStream fc=new FileInputStream(Excelpath);
		XSSFWorkbook workbook=new XSSFWorkbook(fc); 
		XSSFSheet sheetdata=workbook.getSheetAt(sheetnumber);
		Row row = sheetdata.createRow(rowindex);
		Cell cell = row.createCell(cellindex);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("SoftwareTestingMaterial.com");
		FileOutputStream fos = new FileOutputStream(Excelpath);
		workbook.write(fos);
		fos.close();
		System.out.println("END OF WRITING DATA IN EXCEL");
	}
	
	public static Object[][]  readExcelSheetd(String Excelpath,int sheetnumber) throws IOException
	{
		
		FileInputStream fc=new FileInputStream(Excelpath);
		XSSFWorkbook hb=new XSSFWorkbook(fc); 
		XSSFSheet sheetdata=hb.getSheetAt(sheetnumber);
		int row=sheetdata.getLastRowNum();
		Object[][] data = new Object[row][2];
		for(int i=0;i<row;i++)
		{
				data[i][0]=sheetdata.getRow(i).getCell(0).getStringCellValue();
				data[i][1]=sheetdata.getRow(i).getCell(1).getStringCellValue();
			}
		
		for(int i=0;i<row;i++)
		{
			System.out.println(i+" )username:-"+data[i][0]+"or password:-"+data[i][1]);
		}
		return data;
		
	}
	
	public static Object[][]  readExcelSheetWithContainFind(String Excelpath,int sheetnumber ) throws IOException
	{
		
		FileInputStream fc=new FileInputStream(Excelpath);
		XSSFWorkbook workbook=new XSSFWorkbook(fc); 
		XSSFSheet sheetdata=workbook.getSheetAt(sheetnumber);
		int row=sheetdata.getLastRowNum();
		int count=0;
		for(int i=0;i<row;i++)
		{ 
			if((sheetdata.getRow(i).getCell(2).getStringCellValue()).equalsIgnoreCase("Y"))
			{
				count++;
			}
		}
		Object[][] data = new Object[count][2];
		count=0;
		for(int i=0;i<row;i++)
		{
			
			if((sheetdata.getRow(i).getCell(2).getStringCellValue()).equalsIgnoreCase("Y"))
			{
				data[count][0]=sheetdata.getRow(i).getCell(0).getStringCellValue();
				data[count][1]=sheetdata.getRow(i).getCell(1).getStringCellValue();
				count++;
				
			}
			}
		return data;
		
	}
	
	
	public void changeCellBackgroundColorWithPattern(Cell cell) {
	 CellStyle cellStyle = cell.getCellStyle();
	    if(cellStyle == null) {
	        cellStyle = cell.getSheet().getWorkbook().createCellStyle();
	    }
	    cellStyle.setFillBackgroundColor(IndexedColors.BLACK.index);
	    cellStyle.setFillPattern(FillPatternType.BIG_SPOTS);
	    cellStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
	    cell.setCellStyle(cellStyle);
	}
	
	
	
public static void checkingUsernameAndPassword() throws IOException {
		
		
		try
		{
			WebElement userdetails=driver.findElement(By.xpath("//a[contains(@id,'menu_admin_viewAdminModule')]/b"));
			if(userdetails.isDisplayed())
			{
				System.out.println("username and password is valid");
				
			}
			
		}
		catch (Exception e) {
			System.out.println("username and password is not valid");
			WebElement message=driver.findElement(By.xpath("//span[contains(@id,'spanMessage')]"));
			Assert.assertTrue(message.isDisplayed(),"error message is not displayed");
		}
		
		
	}

	
	
	
}
