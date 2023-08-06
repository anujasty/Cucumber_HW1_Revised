package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewAccountPage extends TestBase {
	WebDriver driver;

	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement Account_Title_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
	WebElement Description_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"balance\"]")
	WebElement Intial_Balance_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account_number\"]")
	WebElement Account_Number_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_person\"]")
	WebElement Contact_Person_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_phone\"]")
	WebElement Phone_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"ib_url\"]")
	WebElement Internet_Banking_Url_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")
	WebElement Submit_Button_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement Zip_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]")
	WebElement New_Account_Header_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]")
	WebElement Manage_Element;

	//Validating that the landing page is NewAccount page
	public void validateNewAccountPage(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
		validateElement(New_Account_Header_Element.getText(), 
						expectedText, 
						"Add New Account Page is not avaialble!");
	}

	
	//Declared following variable and a getter method in case if we have to search 
	//for the inserted AccountName
	static String insertedAccountTitle; 

	public static String getAccountTitle() {
		return insertedAccountTitle;
	}

	public void enterAccountTitle(String accountTitle) {
		insertedAccountTitle = accountTitle + randomNumGenerator(999);
		Account_Title_ELEMENT.sendKeys(insertedAccountTitle);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterDescription(String description) {
		Description_Element.sendKeys(description);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterInitialBalance(String initialBalance) {
		Intial_Balance_Element.sendKeys(initialBalance);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterAccountNumber(String accountNumber) {
		Account_Number_Element.sendKeys(accountNumber + randomNumGenerator(999));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterContactPerson(String contactPerson) {
		Contact_Person_Element.sendKeys(contactPerson);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPhone(String phone) {
		Phone_Element.sendKeys(phone + randomNumGenerator(999));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterInternetBankingUrl(String internetBankingUrl) {
		Internet_Banking_Url_Element.sendKeys(internetBankingUrl);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSubmitButton() {
		Submit_Button_Element.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
