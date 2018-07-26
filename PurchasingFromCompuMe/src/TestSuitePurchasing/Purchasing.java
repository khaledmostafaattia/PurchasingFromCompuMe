package TestSuitePurchasing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Purchasing {

	static WebDriverWait wait = null;

	public static void Purchase() throws Exception {

		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://compume.com.eg/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Clicking on the New User link on the Home page
		driver.findElement(By.xpath("//*[@id=\"cme_hederbar\"]/div[2]/div/div/div/a")).click();

		// Fill mandatory input text fields
		driver.findElement(By.name("firstname")).sendKeys("Karim");
		driver.findElement(By.name("lastname")).sendKeys("Mahmoud");
		driver.findElement(By.xpath("//*[@id=\"register\"]/div[1]/table/tbody/tr[3]/td[2]/input"))
				.sendKeys("karimmahmoud18@gmail.com");
		driver.findElement(By.name("telephone")).sendKeys("00201110120146");
		driver.findElement(By.name("address_1")).sendKeys("Dokki");
		driver.findElement(By.name("city")).sendKeys("Giza");
		driver.findElement(By.xpath("//*[@id=\"register\"]/div[3]/table/tbody/tr[1]/td[2]/input")).sendKeys("kmkm7373");
		driver.findElement(By.xpath("//*[@id=\"register\"]/div[3]/table/tbody/tr[2]/td[2]/input")).sendKeys("kmkm7373");

		driver.findElement(By.name("zone_id"));
		WebElement objWeb1 = driver.findElement(By.name("zone_id"));
		Select objSelect1 = new Select(objWeb1);
		objSelect1.selectByValue("1008");

		driver.findElement(By.xpath("//*[@id=\"register\"]/div[6]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/a/span")).click();
		driver.get("https://compume.com.eg/");

		driver.findElement(By.xpath("//*[@id=\"carousel3\"]/div/div/div/ul/li[3]/div/div[6]/div[1]/a")).click();
		Thread.sleep(2000);
		driver.get("https://compume.com.eg/en/checkout/cart");

		driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div[2]/a")).click();

		if (!driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).isSelected()) {
			driver.findElement(By.xpath("//*[@id=\"button-payment-address\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"button-shipping-address\"]")).click();
		}

		driver.findElement(By.xpath("//*[@id=\"button-shipping-method\"]")).click();

		if (!driver.findElement(By.name("agree")).isSelected()) {
			driver.findElement(By.name("agree")).click();
		}

		driver.findElement(By.xpath("//*[@id=\"button-payment-method\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"button-confirm\"]")).click();
		Thread.sleep(5000);

		System.out.println("Automation Testing has been succeeded");

	}

}
