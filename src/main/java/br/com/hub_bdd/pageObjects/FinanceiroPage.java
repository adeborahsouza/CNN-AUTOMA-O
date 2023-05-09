package br.com.hub_bdd.pageObjects;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.hub_bdd.dataProviders.ConfigFileReader;

public class FinanceiroPage {
	WebDriver driver;
	ConfigFileReader configFileReader;

	public FinanceiroPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader = new ConfigFileReader();
	}

	@FindBy(how = How.XPATH, using = "//a[@data-toggle='dropdown'][contains(.,'Financeiro')]")
	private WebElement btn_menuFinanceiro;

	@FindBy(how = How.XPATH, using = "(//a[contains(.,'Financeiro')])[2]")
	private WebElement btn_subMenuFinanceiro;

	@FindBy(how = How.XPATH, using = "//a[@href='#'][contains(.,'Operações')]")
	private WebElement btn_subMenuOperacoes;

	@FindBy(how = How.XPATH, using = "//a[@href='/app-cnn/faturacao/lista'][contains(.,'Faturar')]")
	private WebElement btn_subMenuFaturar;

	@FindBy(how = How.XPATH, using = "(//a[@class='btn btn-success btn-xs'])[1]")
	private WebElement btn_opcaoFaturar;

	@FindBy(how = How.XPATH, using = "//button[contains(@id,'salvar_form')]")
	private WebElement btn_salvarFaturar;

	@FindBy(how = How.XPATH, using = "//h4[@class='modal-title'][contains(.,'Lançamento salvo com sucesso.')]")
	private WebElement lbl_faturadoComSucesso;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'parcelar')]")
	private WebElement chbx_parcelar;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'pagar-agora')]")
	private WebElement btn_baixarModalLancamento;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'btn btn-primary')]")
	private WebElement btn_baixarTelaLancamento;

	@FindBy(how = How.XPATH, using = "//h4[@class='modal-title'][contains(.,'Recebimento salvo com sucesso.')]")
	private WebElement lbl_baixaComSucesso;

	public void clicarMenuFinanceiro() {
		btn_menuFinanceiro.click();
	}

	public void clicarSubMenuFinanceiro() {
		btn_subMenuFinanceiro.click();
	}

	public void clicarSubMenuOperacos() {
		btn_subMenuOperacoes.click();
	}

	public void clicarSubMenuFaturar() {
		btn_subMenuFaturar.click();
	}

	public void clicarOpcaoFaturar() {
		btn_opcaoFaturar.click();
	}

	public void clicarSalvar() {
		btn_salvarFaturar.click();
	}

	public void clicarParcelar() {
		chbx_parcelar.click();
	}

	public void clicarBaixarModal() {
		btn_baixarModalLancamento.click();
	}

	public void clicarBaixarTela() {
		btn_baixarTelaLancamento.click();
	}

	public void faturadoComSucesso() throws InterruptedException {
		Thread.sleep(5000);
		assertTrue(lbl_faturadoComSucesso.isDisplayed());
	}

	public void baixaComSucesso() throws InterruptedException {
		Thread.sleep(5000);
		assertTrue(lbl_baixaComSucesso.isDisplayed());
	}

}