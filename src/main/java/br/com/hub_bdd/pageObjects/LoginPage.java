package br.com.hub_bdd.pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.hub_bdd.dataProviders.ConfigFileReader;
import br.com.hub_bdd.managers.FileReaderManager;

public class LoginPage {
	WebDriver driver;
	ConfigFileReader configFileReader;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader = new ConfigFileReader();
	}

	@FindBy(how = How.XPATH, using = "//*[@id='username']")
	private WebElement xtbx_userName;

	@FindBy(how = How.XPATH, using = "//*[@id='password']")
	private WebElement xtbx_senha;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Entrar']")
	private WebElement btn_entrar;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div[1]/p")
	private WebElement loginNaoRealizado;

	@FindBy(how = How.XPATH, using = "//a[@href='/app-cnn/relatorios/index'][contains(.,'Relatórios')]")
	private WebElement loginRealizado;

	public void enter_Email(String email) {
		xtbx_userName.sendKeys(email);
	}

	public void enter_Senha(String senha) {
		xtbx_senha.sendKeys(senha);
		xtbx_senha.click();
	}

	public void btnEntrar() {
		xtbx_senha.sendKeys(Keys.ENTER);
	}

	public void fill_LoginInformation() {
		enter_Email("dramos@bionexo.com");
		enter_Senha("@Cnn2021");
	}

	public void fill_LoginInformationIncorrect() {
		enter_Email("automacaoCNN@bionexo.com");
		enter_Senha("321654654646");
	}

	public void navigateTo_LoginPage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}

	public void loginRealizadoComFalha() {
		assertEquals(loginNaoRealizado.getText().contains("Usuário ou senha inválidos."), true);
	}

	public void loginRealizadoComSucesso() {
		assertEquals(loginRealizado.getText().contains("Relatórios"), true);
	}
}