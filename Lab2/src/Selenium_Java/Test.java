package Selenium_Java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
    
public static void main(String[] args) throws IOException {
                             
	XSSFWorkbook wb = null;
	Row row = null;
	File excelFile = new File("C:\\Users\\Administrator\\Desktop\\软件测试/软件测试名单.xlsx"); //替换你文档地址
    try {
        wb = new XSSFWorkbook(new FileInputStream(excelFile));
    } catch (IOException e) {
        e.printStackTrace();
    }
    Sheet sheet = wb.getSheetAt(0);
    int rownum = sheet.getPhysicalNumberOfRows();
    
    System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox/geckodriver.exe"); 
    

    for(int i=2;i<rownum;i++) {
    	row = sheet.getRow(i);
    	String Name = row.getCell(2).getStringCellValue(); 
    	System.out.println(Name);
    	Cell c = row.getCell(1);
    	c.setCellType(Cell.CELL_TYPE_STRING);
    	String StudentID = c.getStringCellValue();
    	String StudentPwd = c.getStringCellValue().substring(4, 10); 
    	String GithubURL = row.getCell(3).getStringCellValue();
    
    	WebDriver driver = new FirefoxDriver(); 
    	driver.get("http://121.193.130.195:8800/");
    	WebElement element_name = driver.findElement(By.name("id")); 
    	element_name.clear();
    	element_name.sendKeys(StudentID); 
    	WebElement element_pwd = driver.findElement(By.name("password"));
    	element_pwd.clear();
    	element_pwd.sendKeys(StudentPwd);
    	WebElement element_submit = driver.findElement(By.id("btn_login")); 
    	element_submit.click();
    
    	WebElement webName =driver.findElement(By.id("student-name"));
    	WebElement webStudentID =driver.findElement(By.id("student-id"));
    	WebElement webGithubURL =driver.findElement(By.id("student-git"));
    
    	if ((Name.equals(webName.getText().toString())) && (StudentID.equals(webStudentID.getText().toString())) 
    			&& (GithubURL.equals(webGithubURL.getText().toString())))
        	{System.out.println("信息一致");}
    	else {
    		System.out.println(StudentID + "信息不一致");}
    	driver.close();
    }
    
}

}
