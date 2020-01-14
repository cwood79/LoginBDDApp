package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition {

	/*Scenario: Successful Login with Valid Credentials
 	Given User is on Home Page
 	When User Navigate to LogIn Page
 	And User enters UserName and Password
 	And User clicks login button
 	Then Page Title is Github
 
	Scenario: Successful LogOut
 	When User LogOut from the Application
 	Then Page Title is not Github
 */

	WebDriver dr;
	
    @Given("^User is on Home Page$")
    public void user_is_on_home_page() throws Throwable {
    	System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
    	dr=new ChromeDriver();
        dr.get("http://www.github.com");
        
    }

    @When("^User Navigate to LogIn Page$")
    public void user_navigate_to_login_page() throws Throwable {
    	System.out.println("Home page");
    	WebElement login = dr.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div[2]/a[1]"));
    	login.click();
    }

    @When("^User LogOut from the Application$")
    public void user_logout() throws Throwable {
    	// throws null pointer exception for some reason
    	WebElement logout = dr.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/form/button"));
    	logout.click();
    	
    }
    
    @Then("^Page Title is GitHub$")
    public void user_login_successfully() throws Throwable {
       String expectedTitle="GitHub";
       String actualTitle=dr.getTitle();
       
       Assert.assertEquals(expectedTitle,actualTitle);
    }
    
    @Then("^Page Title is not GitHub$")
    public void message_displayed_logout_successfully() throws Throwable {
    	String expectedTitle="The world’s leading software development platform · GitHub";
    	String actualTitle=dr.getTitle();
    	Assert.assertEquals(expectedTitle,actualTitle);
    }

    @And("^User enters UserName and Password$")
    public void user_enters_username_and_password() throws Throwable {
    		WebElement username=dr.findElement(By.id("login_field"));
    		WebElement password=dr.findElement(By.id("password"));

    		// put username and password here
    		username.sendKeys("");
    		password.sendKeys("");
    		
    		
    }
    @And("^User clicks login button$")
    public void user_clicks_login_button() throws Throwable {
    	WebElement loginButton = dr.findElement(By.name("commit"));
    	loginButton.click();
    	
    }
    

}