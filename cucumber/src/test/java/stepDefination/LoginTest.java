package stepDefination;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTest {
	public static WebDriver driver;
	PageObjects po;

	@Given("^Navigate to Home page$")
	public void NavigatetoHomepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		po = new PageObjects(driver);
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@When("^user enters username and pasword$")
	public void userentersusernameandpasword() throws Throwable {

		PageObjects.signin.click();
		PageObjects.username.sendKeys("lalitha");
		PageObjects.password.sendKeys("Password123");
		PageObjects.Login.click();
	}

	@Then("^user logged in successfully$")
	public void userloggedinsuccessfully() throws Throwable {
		System.out.println("user login successfull");

	}

	@When("^Lalitha searches below products in a search box:$")
	public void Lalitha_searches_below_products_in_a_searchbox(DataTable dt) {
		List<String> product= dt.asList(String.class);
		for(String s:product)
		{
			driver.findElement(By.name("products")).sendKeys(s);
			driver.findElement(By.xpath("//input[@value='FIND DETAILS']")).click();
			driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[1]")).click();
		}
		
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/a")).click();
	}

	@Then("^product should be added in the cart if available$")
	public void productshouldbeaddedinthecartifavailable() {
         
	}
	
	@When("^i enter \"([^\"])\" and \"([^\"]*)\"$")
	public void enterunamepwd123(String uname, String pwd) {
		po.signin.click();

		po.username.sendKeys(uname);

		po.password.sendKeys(pwd);

		po.Login.click();
		
		
	}
}