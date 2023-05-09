package br.com.hub_bdd.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.hub_bdd.dataProviders.ConfigFileReader;
import br.com.hub_bdd.managers.FileReaderManager;

public class HomePage {
	WebDriver driver;
	ConfigFileReader configFileReader;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader = new ConfigFileReader();
	}

	@FindBy(how = How.ID, using = "menuUser")
	private WebElement btn_menuUser;

	@FindBy(how = How.XPATH, using = "//*[@id='mostra-graficos']")
	private WebElement btn_register;

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement btn_search;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement btn_complete;

	@FindBy(how = How.ID, using = "tabletsImg")
	private WebElement img_prod;

	@FindBy(how = How.XPATH, using = "//*[@id=\"details_10\"]")
	private WebElement prod_folio;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div")
	private WebElement closeSearch;
	
	@FindBy(how = How.NAME, using = "save_to_cart")
	private WebElement btn_cart;
	
	

	public void close_Search() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains("search"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].click();", closeSearch);
	}


	public void menuUser() {
		btn_menuUser.click();
	}

	public void btnRegister() {
		btn_register.sendKeys(Keys.ENTER);
	}

	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void clickMenuSearch() {
		btn_search.click();
	}

	public void enterComplete(String complete) {
		btn_complete.sendKeys(complete);
		btn_complete.sendKeys(Keys.ENTER);
	}

	public void fill_search() {
		enterComplete("HP ElitePad 1000 G2 Tablet");
	}

	public void fill_search_invalido() {
		enterComplete("Televisão");
	}

	public void ImagemProduto() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", img_prod);
		
	}

	public void ProdutoFolio() {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", prod_folio);
	}
	
	public void btn_cart() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(btn_cart));
	}
	

}