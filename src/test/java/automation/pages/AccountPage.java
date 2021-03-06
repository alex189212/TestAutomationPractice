package automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import automation.UI.ActionsCtrlExtn;
import automation.framework.PageObjectBase;

public class AccountPage extends PageObjectBase {
	private String url = "http://invenauto.tech/index.php?controller=my-account";
	@FindBy (how = How.CSS, using=".account span")
	private WebElement accountNameElement;
	@FindBy (how = How.CSS, using="a.home")
	private WebElement navigationHomeElement;
	@FindBy (how = How.CSS, using="a[title='Orders'] span")
	private WebElement orderHistory;
	@FindBy (how = How.CSS, using="a[title='Addresses']")
	private WebElement myAddressesElement;

	
	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getAccountName() {
		return accountNameElement.getText();
	}
	
	public HomePage returnHome() {
		navigationHomeElement.click();
		return new HomePage(this.driver);
	}
	
	public OrderHistoryPage clickOnOrderHistory() {
		
		new ActionsCtrlExtn(this.orderHistory,this.driver).clickOnOrderHistory();
		return new OrderHistoryPage(this.driver);
	}
	
	public MyAddressesPage goToAddresses() {
		myAddressesElement.click();
		return new MyAddressesPage(driver);
	}
}
