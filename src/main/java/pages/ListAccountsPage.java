package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListAccountsPage extends TestBase {
	WebDriver driver;

	NewAccountPage newAccountPage;

	public ListAccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[2]/div/div/div[1]")
	WebElement Manage_Accounts_Header_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]")
	WebElement Account_Creation_Status_Header_Element;

	public void validateManageAccountsPage(String expectedText) throws InterruptedException {
		Thread.sleep(1000);
		validateElement(Manage_Accounts_Header_Element.getText(), expectedText,
				"Manage Accounts Page is not avaialble!");
	}
	
	//Msg that is displayed is "Account Created Succesfully".  However, when used getText() on that
	//element it brings back "x/nAccount Created Succesfully".
	//x in the message is not a lower case x or upper case X.  So, just trimmed the first two and compared.
	public void validateAccountCreationMsg(String expectedText) throws InterruptedException {
		Thread.sleep(1000);
		validateElement((Account_Creation_Status_Header_Element.getText().substring(2)), expectedText,
				"New Account has not been created successfully!");
	}
	
	public void validateInsertedAccount() throws InterruptedException {
		String before_xpath = "//tbody//tr[";
		String after_xpath = "]//td";
		for(int i = 2; i <= 500; i++) { //Need to figure out how to let it know the record count instead of hardcode value
			String actualName = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			if(actualName.contains(NewAccountPage.getAccountTitle())){
				System.out.println("Account has been created successfully!");
				break;				
			}						
		}
	}

}
