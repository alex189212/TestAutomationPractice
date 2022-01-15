package automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.UI.FilterControlExtension;
import automation.UI.UIControlBase;

public class WomenCatagoryPage extends PageObjectBase {
	private final String url = "http://automationpractice.com/index.php?id_category=3&controller=category";
	private FilterControlExtension controller = new FilterControlExtension(this.driver);
	
	@FindBy(how=How.ID, using="layered_category_4")
	private WebElement topsCheckboxElement;
	
	@FindBy(how=How.ID, using="layered_category_8")
	private WebElement dressesCheckboxElement;
	
	@FindBy(how=How.CSS, using="#center_column > ul")
	private WebElement shownListElement;
	
	@FindBy(how=How.CSS, using="#center_column > ul > p")
	private WebElement listLoadingElement;
	
	public WomenCatagoryPage(WebDriver driver) {
		super(driver);
	}

	public String getURL() {
		return url;
	}
	
	public UIControlBase getController() {
		return this.controller;
	}
	
	public PageObjectBase navigate() {
		this.driver.navigate().to(url);
		return this;
	}

	public void selectTops() {
		topsCheckboxElement.click();
	}

	public boolean isUpdated() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(listLoadingElement));
		return (2 == shownListElement.findElements(By.className("ajax_block_product")).size());
	}
	
}