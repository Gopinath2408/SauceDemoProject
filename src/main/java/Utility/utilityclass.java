package Utility;

import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import POM.UserCredentials;

public class utilityclass {

	public static String FileName = "Data.xlsx";

	public WebDriver load(String url) {

		WebDriver dr = new EdgeDriver();

		dr.get(url);

		return dr;

	}

	public HashMap<Integer, UserCredentials> readFromExcel() throws IOException {

		HashMap<Integer, UserCredentials> val = new HashMap<>();

		FileInputStream fs = new FileInputStream(FileName);
		XSSFWorkbook book = new XSSFWorkbook(fs);
		XSSFSheet sheet = book.getSheet("Sheet1");
		XSSFRow rw;

		for (int i = 1; i < 2; i++)
			val.put(1,
					new UserCredentials(sheet.getRow(i).getCell(0).toString(), sheet.getRow(i).getCell(1).toString()));

		return val;

	}

}
