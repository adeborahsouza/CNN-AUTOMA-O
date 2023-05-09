package br.com.hub_bdd.stepDefinition;

import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;

import br.com.hub_bdd.cucumber.TestContext;
import br.com.hub_bdd.pageObjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver;
	TestContext testContext;
	LoginPage loginPage;

	public LoginSteps(TestContext context) {
		this.driver = driver;
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLogin_Page();
	}

	@Given("^usuario esta na login page$")
	public void Usuario_esta_na_login_page() {
		loginPage.navigateTo_LoginPage();
		Log.info("Usuario esta na login page");
	}

	@When("^preencher os campos corretamente$")
	public void preencher_os_campos_corretamente() {
		loginPage.fill_LoginInformation();
		Log.info("Preenchendo campos de login corretamente");
	}

	@When("^preencher os campos incorretamente$")
	public void preencher_os_campos_incorretamente() {
		loginPage.fill_LoginInformationIncorrect();
	}

	@And("^clicar em entrar$")
	public void clicar_em_entrar() {
		loginPage.btnEntrar();
		Log.info("Clicando em entrar");
	}

	@Then("^login nao e feito$")
	public void login_nao_e_feito() throws InterruptedException {
		loginPage.loginRealizadoComFalha();
	}

	@Then("^login e feito$")
	public void login_e_feito() throws InterruptedException {
		loginPage.loginRealizadoComSucesso();
		Log.info("Login realizado com sucesso");
	}
}