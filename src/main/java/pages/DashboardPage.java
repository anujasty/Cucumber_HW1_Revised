package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),  'Dashboard ')]")
	WebElement Dashboard_Header_Element;
	@FindBy(how = How.XPATH, using = "//*[@id='side-menu']/li[3]/a/span[1]")

	WebElement Customers_Menu_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")
	WebElement Add_Customers_Menu_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")
	WebElement List_Customers_Menu_Element;

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a/span[1]")
	WebElement Bank_And_Cash_Menu_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	WebElement New_Account_Menu_Element;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[2]/a")
	WebElement List_Account_Menu_Element;

	public void clickCustomerButton() throws InterruptedException {
		Thread.sleep(1000);
		Customers_Menu_Element.click();
	}

	public void clickAddCustomerButton() throws InterruptedException {
		Thread.sleep(1000);
		Add_Customers_Menu_Element.click();
	}

	public void clickListCustomerButton() throws InterruptedException {
		Thread.sleep(1000);
		List_Customers_Menu_Element.click();
	}

	public void clickBankAndCashButton() throws InterruptedException {
		Thread.sleep(1000);
		Bank_And_Cash_Menu_Element.click();
	}

	public void clickNewAccount() throws InterruptedException {
		Thread.sleep(1000);
		New_Account_Menu_Element.click();
	}
	
	public void clickListAccount() throws InterruptedException {
		Thread.sleep(1000);
		List_Account_Menu_Element.click();
	}
}
