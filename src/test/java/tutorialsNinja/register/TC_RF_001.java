package tutorialsNinja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {

	@Test
	public  void verifyRegisterWithMandatoryFields() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Shubham");
		driver.findElement(By.id("input-lastname")).sendKeys("TEXT");
		driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("8888888830");
		driver.findElement(By.id("input-password")).sendKeys("TEST@1");
		driver.findElement(By.id("input-confirm")).sendKeys("TEST@1");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();	
		
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		
		String expectHeading = "Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectHeading);
		String properDetails1 ="Congratulations! Your new account has been successfully created!";
		String properDetails2 ="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String properDetails3="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String properDetails4 ="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		String expectedProperDetails= driver.findElement(By.id("content")).getText();
		Assert.assertTrue(expectedProperDetails.contains(properDetails1));
		Assert.assertTrue(expectedProperDetails.contains(properDetails2));
		Assert.assertTrue(expectedProperDetails.contains(properDetails3));
		Assert.assertTrue(expectedProperDetails.contains(properDetails4));
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
		
		}
	
	public String generateNewEmail()
	{
		/*
		 * Date date=new Date(); 
		 * String dateString =date.toString(); 
		 *String removeSpaceDate= dateString.replaceAll(" ",""); //or-------> "//s" 
		 * String noSpaceNocolong= removeSpaceDate.replaceAll("\\:",""); 
		 * String emailWithTimeStamp = noSpaceNocolong+"@gmail.com";
		 */
		return new Date().toString().replaceAll(" ","").replaceAll("\\:","")+"@gmail.com";
		
		
	}
	
	

}
