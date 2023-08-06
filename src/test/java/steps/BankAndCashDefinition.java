package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.DashboardPage;
import pages.ListAccountsPage;
import pages.LoginPage;
//import pages.ListAccountsPage;
import pages.NewAccountPage;
import pages.TestBase;

public class BankAndCashDefinition extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	NewAccountPage newAccountPage;
	ListAccountsPage listAccountsPage;
	
	static String expectedNewAccountHeaderText = "Add New Account";
	static String expectedManageAccountsHeaderText = "Manage Accounts";
	static String expectedAccountCreationStatusText = "Account Created Successfully";

	@Before
	public void setup() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		newAccountPage = PageFactory.initElements(driver, NewAccountPage.class);
		listAccountsPage = PageFactory.initElements(driver, ListAccountsPage.class);
		
	}

	@Given("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://www.techfios.com/billing/?ng=admin/");

	}

	@When("User enters the {string} in the {string} field")
	public void user_enters_the_in_the_field(String loginData, String field) {

		switch (field) {
		case "username":
			loginPage.enterUserName(loginData);
			break;

		case "password":
			loginPage.enterPassword(loginData);
			break;
		}
	}

	@When("User clicks on {string}")
	  public void user_clicks_on(String button) {
		  
		  switch(button) {
		  case "login":
			  	loginPage.clickSignInButton();
				break;
		  
		  case "bankCash":
		  	try {
		  		Thread.sleep(1000);
				dashboardPage.clickBankAndCashButton();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	break;
		  
	  	  case "newAccount":
		  	try {
		  		Thread.sleep(1000);
				dashboardPage.clickNewAccount();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	break;
	  	case "submit":
		  	 	newAccountPage.clickSubmitButton();
		  	break;
		  	
		  }
	}
	

	@Then("User should land on Dashboard page")
	public void user_should_land_on_dashboard_page() {
		try {
			Thread.sleep(2000);
			String expectedTitle = "Dashboard- iBilling";
			String actualTitle = loginPage.getPageTitle();
			Assert.assertEquals(expectedTitle, actualTitle);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@And ("User enters {string} in the {string} field in accounts page")
	public void user_enters_in_the_field_in_accounts_page(String newAccountData, String field) {

		switch (field) {
			case "accountTitle":
				newAccountPage.enterAccountTitle(newAccountData);
				break;
			case "description":
				newAccountPage.enterDescription(newAccountData);
				break;
			case "initialBalance":
				newAccountPage.enterInitialBalance(newAccountData);
				break;
			case "accountNumber":
				newAccountPage.enterAccountNumber(newAccountData);
				break;
			case "contactPerson":
				newAccountPage.enterContactPerson(newAccountData);
				break;
			case "Phone":
				newAccountPage.enterPhone(newAccountData);
				break;
			case "internetBankingURL":
				newAccountPage.enterInternetBankingUrl(newAccountData);
				break;
		}
	}
	
	@Then("User should be able to validate account created successfully")
	public void user_should_be_able_to_validate_account_created_successfully() {
		//listAccountsPage = PageFactory.initElements(driver, ListAccountsPage.class);
		
			try {
				listAccountsPage.validateManageAccountsPage(expectedManageAccountsHeaderText);
				try {
					listAccountsPage.validateAccountCreationMsg(expectedAccountCreationStatusText);
					try {
						listAccountsPage.validateInsertedAccount();  //Add this in here for practice purpose to go 
                										  			 //through the accounts created to validate 
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	@After 
	  public void tearDown() { 
		  driver.close(); 
		  driver.quit(); 
	  }
	
}
