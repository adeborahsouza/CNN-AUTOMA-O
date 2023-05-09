package br.com.hub_bdd.stepDefinition;

import org.openqa.selenium.WebDriver;

import br.com.hub_bdd.cucumber.TestContext;
import br.com.hub_bdd.pageObjects.FinanceiroPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FinanceiroSteps {
	WebDriver driver;
	TestContext testContext;
	FinanceiroPage financeiroPage;

	public FinanceiroSteps(TestContext context) {
		this.driver = driver;
		testContext = context;
		financeiroPage = testContext.getPageObjectManager().getFinanceiro_Page();
	}

	@When("^navega para o financeiro page$")
	public void navega_para_o_financeiro_page() {
		financeiroPage.clicarMenuFinanceiro();
		financeiroPage.clicarSubMenuFinanceiro();

	}

	@And("^clica em operacoes$")
	public void clica_em_operacoes() {
		financeiroPage.clicarSubMenuOperacos();
	}

	@And("^clica no submenu faturar$")
	public void clica_no_submenu_faturar() {
		financeiroPage.clicarSubMenuFaturar();
	}

	@And("^clica em faturar primeira conta disponivel$")
	public void clica_em_faturar_primeira_conta_disponivel() {
		financeiroPage.clicarOpcaoFaturar();
	}

	@And("^clica em salvar faturamento$")
	public void clica_em_salvar_faturamento() {
		financeiroPage.clicarSalvar();
	}

	@And("^clica em parcelar conta$")
	public void clica_em_parcelar_conta() {
		financeiroPage.clicarParcelar();
	}

	@Then("^valida que conta foi faturada com sucesso$")
	public void valida_que_conta_foi_faturada_com_sucesso() throws InterruptedException {
		financeiroPage.faturadoComSucesso();
	}

	@And("^clica em baixar no modal de faturamento$")
	public void clica_em_baixar_no_modal_de_faturamento() {
		financeiroPage.clicarBaixarModal();
	}

	@And("^clica em baixar na tela de faturamento$")
	public void clica_em_baixar_na_tela_de_faturamento() {
		financeiroPage.clicarBaixarTela();
	}

	@Then("^valida que a baixa foi realizada com sucesso$")
	public void valida_que_a_baixa_foi_realizada_com_sucesso() throws InterruptedException {
		financeiroPage.baixaComSucesso();
	}
}
