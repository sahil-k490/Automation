package baseUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	static int time=50;
	
	public void excel(String website) throws IOException {
		
	//Create an object of File class to open xlsx file
	File file = new File("C:\\Users\\anura\\eclipse-workspace\\Ecom\\Resource\\Book2.xlsx");
	
	FileInputStream inputstream = new FileInputStream(file);
	
	//Workbook
	Workbook wb = new XSSFWorkbook(inputstream);
	
	//Sheet
	Sheet sheet = wb.getSheet("Xpath");
	
	int row = sheet.getPhysicalNumberOfRows();
	int col = sheet.getRow(0).getLastCellNum();
	
	for(int i=0;i<=row;i++) 
	{	
		for(int j=0;j<=col;j++)
		{
			if(sheet.getRow(i).getCell(j).toString().equals(website)) {
				
			}			
		}
	}
	}
	
	public static void switchtab(WebDriver driver) {
		
		Set<String> id= driver.getWindowHandles();		
		Iterator<String> it = id.iterator();
		
		while(it.hasNext()) 
		{
		driver.switchTo().window(it.next());
		}
	}
	public static void waitForElementClickable(WebDriver driver, WebElement xPath) {	
		WebDriverWait wait= new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(xPath));
	}
	public static void waitForPresence(WebDriver driver, WebElement xPath) {	
		WebDriverWait wait= new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeSelected(xPath));
	}
	public static void waitForXpath(WebDriver driver, WebElement xPath) {	
		WebDriverWait wait= new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(xPath));
	}
}
