package br.com.hub_bdd.pageObjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.hub_bdd.dataProviders.ConfigFileReader;

public class AgendaPage {
	WebDriver driver;
	ConfigFileReader configFileReader;

	public AgendaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader = new ConfigFileReader();
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(.,'Agenda')])[1]")
	private WebElement btn_menuAgenda;

	@FindBy(how = How.XPATH, using = "//*[@id='menu_agenda']/ul/li[1]/a")
	private WebElement btn_subMenuAgenda;

	@FindBy(how = How.XPATH, using = "//*[@id='agenda-botoes-lateral']/a[1]")
	private WebElement btn_novoAgendamento;

	@FindBy(how = How.XPATH, using = "(//div[@class='profile-activity clearfix no-padding no-hover'])[1]")
	private WebElement txt_paciente;

	@FindBy(how = How.XPATH, using = "//*[@id='paciente-complete-container']/div/div/div[1]/span[3]")
	private WebElement btn_lupa;

	@FindBy(how = How.XPATH, using = "(//div[@class='profile-activity clearfix no-padding no-hover'])[1]")
	private WebElement list_paciente;

	@FindBy(how = How.XPATH, using = "//span[@data-autocomplete-ref='convenio']")
	private WebElement btn_lupaConvenio;

	@FindBy(how = How.XPATH, using = "(//span[@class='abrevia-texto '])[1]")
	private WebElement list_convenio;

	@FindBy(how = How.XPATH, using = "(//i[contains(@class,'ace-icon fa fa-search bigger-110')])[6]")
	private WebElement btn_lupaProfissional;

	@FindBy(how = How.XPATH, using = "(//a[contains(@tabindex,'-1')])[1]")
	private WebElement list_profissional;

	@FindBy(how = How.XPATH, using = "//button[@id='saveAgenda']")
	private WebElement btn_salvarAgendamento;

	@FindBy(how = How.XPATH, using = "(//div[@class='messenger-message-inner'][contains(.,'Agendado com sucesso')])[1]")
	private WebElement lbl_agendamentoSalvoComSucesso;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div")
	private WebElement closeSearch;

	@FindBy(how = How.XPATH, using = "(//i[contains(@class,'ace-icon fa fa-search bigger-110')])[7]")
	private WebElement btn_lupaProcedimento;

	@FindBy(how = How.XPATH, using = "(//div[@class='profile-activity clearfix no-padding no-hover'])[14]")
	private WebElement list_procedimento;

	@FindBy(how = How.XPATH, using = "(//span[@class='abrevia-texto text-info'])[2]")
	private WebElement list_editarProcedimento;

	@FindBy(how = How.XPATH, using = "//select[@id='procedimentos-especialidade']")
	private WebElement btn_especialidade;

	@FindBy(how = How.XPATH, using = "//*[@id='procedimentos-especialidade']/option[2]")
	private WebElement list_especialidade;

	@FindBy(how = How.XPATH, using = "(//div[contains(.,'A especialidade dos procedimentos é obrigatória.')])[14]")
	private WebElement lbl_alertaEspecialidadeObrigatoria;

	@FindBy(how = How.XPATH, using = "//a[@href='#tab-procedimentos'][contains(.,'+ Procedimentos')]")
	private WebElement tab_procedimentos;

	@FindBy(how = How.XPATH, using = "//button[@type='button'][contains(.,'Importar procedimentos')]")
	private WebElement btn_importarProcedimentos;

	@FindBy(how = How.XPATH, using = "//input[@id='agenda-profissional']")
	private WebElement txt_profissionalSelecionado;

//	@FindBy(how = How.XPATH, using = "//a[contains(@onclick,'AgendaProcedimentos.mostrarOrcamentos();')]")
//	private WebElement list_importarOrcamento;
//
	@FindBy(how = How.XPATH, using = "//select[contains(@id,'orcamentos')]")
	private WebElement btn_selectOrcamento;

	@FindBy(how = How.XPATH, using = "//*[@id='orcamentos']/option[2]")
	private WebElement btn_primeiraOpcaoOrcamento;

	@FindBy(how = How.XPATH, using = "(//button[contains(.,'Importar')])[2]")
	private WebElement btn_importar;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Repetir')]")
	private WebElement tab_repetir;

	@FindBy(how = How.XPATH, using = "//select[contains(@id,'tipoRepeticao')]")
	private WebElement btn_tipoRepeticao;

	@FindBy(how = How.XPATH, using = "//*[@id='tipoRepeticao']/option[2]")
	private WebElement btn_diariamente;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'aposOcorrencias')]")
	private WebElement txt_terminarEm;

	@FindBy(how = How.XPATH, using = "(//div[@class='fc-content'])[1]")
	private WebElement btn_agendamentoExistente;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-sm pull-left btn-primary'][contains(.,'Editar')]")
	private WebElement btn_editarAgendamento;

	@FindBy(how = How.XPATH, using = "(//a[@class='abrevia-texto ui-corner-all'])[position()=last()]")
	private WebElement list_editarProfissional;

	@FindBy(how = How.XPATH, using = "(//div[@class='messenger-message-inner'][contains(.,'Agendamento alterado com sucesso')])[1]")
	private WebElement lbl_agendamentoAlteradoComSucesso;

	@FindBy(how = How.XPATH, using = "(//button[contains(@id,'alterarDireto')])[1]")
	private WebElement btn_salvarEdicaoAgenda;

	@FindBy(how = How.XPATH, using = "(//span[@class='abrevia-texto text-info'])[position()=last()]")
	private WebElement list_editarConvenio;

	@FindBy(how = How.XPATH, using = "//button[contains(@data-bb-handler,'confirm')]")
	private WebElement btn_simConfirmaAlteracaoConvenio;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-primary btn-xs'])")
	private WebElement btn_vincularConvenioPaciente;

	@FindBy(how = How.XPATH, using = "//a[@id='btn_show_orcamento']")
	private WebElement btn_importarOrcamento;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'btn_show_plano_tratamento')]")
	private WebElement btn_importarPlanoTratamento;

	@FindBy(how = How.XPATH, using = "//select[contains(@class,'form-control especialidade')]")
	private WebElement btn_especialidadeImportar;

	@FindBy(how = How.XPATH, using = "//*[@id='proc_esp_0']/select/option[2]")
	private WebElement list_especialidadeImportar;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'btn_show_pacotes')]")
	private WebElement btn_importarPacote;

	@FindBy(how = How.XPATH, using = "(//i[@class='ace-icon fa fa-search bigger-110'])[8]")
	private WebElement btn_lupaImportarPacote;

	@FindBy(how = How.XPATH, using = "/html/body/ul[8]/li")
	private WebElement list_pacotesImportar;

	@FindBy(how = How.XPATH, using = "//*[@id='select-planos']/option[2]")
	private WebElement list_planosTratamento;

	@FindBy(how = How.XPATH, using = "(//label[contains(@class,'checkbox checkbox-small no-padding')])[1]")
	private WebElement chbx_procedimentosPlanoTratamentoImportar;

	@FindBy(how = How.XPATH, using = "//div[@class='messenger-message-inner'][contains(.,'Agendamento excluído com sucesso')]")
	private WebElement lbl_agendamentoExcluidoComSucesso;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Excluir')]")
	private WebElement btn_excluirAgendamento;

	@FindBy(how = How.XPATH, using = "//button[contains(@id,'removerDireto')]")
	private WebElement btn_confirmarExcluir;

	@FindBy(how = How.XPATH, using = "//button[contains(@id,'removerSoEsta')]')]")
	private WebElement btn_excluirSomenteEsta;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-xs bigger btn-white dropdown-toggle btn-default']")
	private WebElement list_statusAgendamento;

	@FindBy(how = How.XPATH, using = "(//a[@class='changeStatus'])[1]")
	private WebElement list_opcaoStatusAgendamento;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'d-flex flex-column')]")
	private WebElement lbl_jaExisteAgendamento;

	@FindBy(how = How.XPATH, using = "(//button[@type='button'][contains(.,'×')])[1]")
	private WebElement btn_cancelarAgendamento;

	private String statusAnterior;
	private String opcaoLista;

//	public void close_Search() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.urlContains("search"));
//		JavascriptExecutor ex = (JavascriptExecutor) driver;
//		ex.executeScript("arguments[0].click();", closeSearch);
//	}

	public void btnMenuAgenda() {
		btn_menuAgenda.click();

	}

	public void btnSubMenuAgenda() {
		btn_subMenuAgenda.click();
	}

	public void btnNovoAgendamento() {
		btn_novoAgendamento.click();
	}

	public void procurarPaciente() {
		btn_lupa.click();
	}

	public void selecionarPaciente() {
		list_paciente.click();
	}

	public void selecionarConvenio() {
		btn_lupaConvenio.click();
		list_convenio.click();
		vincularConvenioPaciente();
	}

	public void selecionarProfissional() {
		btn_lupaProfissional.click();
		list_profissional.click();
	}

	public void salvarAgendamento() {
		btn_salvarAgendamento.click();
	}

	public void salvarAgendamentoParaRelatorio() {
		btn_salvarAgendamento.click();
		try {
			if (lbl_jaExisteAgendamento.isDisplayed()) {
				btn_cancelarAgendamento.click();
			}
		} catch (NoSuchElementException e) {
		}
	}

	public void agendamentoRealizadoComSucesso() {

		assertTrue(lbl_agendamentoSalvoComSucesso.isDisplayed());
	}

	public void agendamentoRealizadoComFalha() {
		assertFalse(lbl_agendamentoSalvoComSucesso.isDisplayed());
	}

	public void procurarProcedimento() {
		btn_lupaProcedimento.click();
		list_procedimento.click();
	}

	public void setarEspecialidade() {
		try {
			if (lbl_alertaEspecialidadeObrigatoria.isDisplayed()) {
				btn_especialidade.click();
				list_especialidade.click();
			}
		} catch (NoSuchElementException e) {
			// não é uma agenda com repetição
		}
	}

	public void alertaEspecialidadeObrigatoria() {
		assertEquals(lbl_alertaEspecialidadeObrigatoria.getText()
				.contains("A especialidade dos procedimentos é obrigatória."), true);
	}

	public void maisProcedimentos() {
		tab_procedimentos.click();
	}

	public void clicarImportarProcedimentos() {
		btn_importarProcedimentos.click();
	}

	public void selecionarOrcamento() {
		btn_selectOrcamento.click();
		btn_primeiraOpcaoOrcamento.click();
	}

	public void clicarImportar() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		btn_importar = wait.until(ExpectedConditions.elementToBeClickable(btn_importar));
		btn_importar.click();
	}

	public void tabRepetir() {
		tab_repetir.click();
	}

	public void repeticao() {
		btn_tipoRepeticao.click();
		btn_diariamente.click();
	}

	public void terminarEm() {
		txt_terminarEm.sendKeys("2");
	}

	public void agendamentoExistente() {
		btn_agendamentoExistente.click();
	}

	public void editarAgendamento() {
		btn_editarAgendamento.click();
	}

	public void editarProfissional() {
		btn_lupaProfissional.click();
		list_editarProfissional.click();
	}

	public void agendamentoAlteradoComSucesso() {
		assertTrue(lbl_agendamentoAlteradoComSucesso.isDisplayed());
	}

	public void salvarAgendaEditada() {
		try {
			if (btn_excluirSomenteEsta.isDisplayed()) {
				btn_excluirSomenteEsta.click();
			}
		} catch (NoSuchElementException e) {
			// não é uma agenda com repetição
		}
		btn_salvarEdicaoAgenda.click();
	}

	public void editarConvenio() {
		btn_lupaConvenio.click();
		list_editarConvenio.click();
	}

	public void simConfirmarAlteracaoConvenio() {
		vincularConvenioPaciente();
		btn_simConfirmaAlteracaoConvenio.click();

	}

	private void vincularConvenioPaciente() {
		try {
			if (btn_vincularConvenioPaciente.isDisplayed()) {
				btn_vincularConvenioPaciente.click();
			}
		} catch (NoSuchElementException e) {
			// modal vincular convenio não apareceu
		}
	}

	public void clicarImportarOrcamento() {
		btn_importarProcedimentos.click();
		btn_importarOrcamento.click();
	}

	public void setarEspecialidadeImportar() {
		try {
			WebElement especialidade = new WebDriverWait(driver, 10)
					.until(ExpectedConditions.elementToBeClickable(btn_especialidadeImportar));
			especialidade.click();
			list_especialidadeImportar.click();
			;
		} catch (Exception e) {
			// Especialidade não precisa ser setada.
		}
	}

	public void clicarImportarPacote() {
		btn_importarProcedimentos.click();
		btn_importarPacote.click();
	}

	public void buscarPacote() {
		btn_lupaImportarPacote.click();
		list_pacotesImportar.click();
	}

	public void selecionarPlanoTratamento() {
		list_planosTratamento.click();
	}

	public void selecionarProcedimentosPlanoTratamentoImportar() {
		chbx_procedimentosPlanoTratamentoImportar.click();
	}

	public void clicarImportarPlanoTratamento() {
		btn_importarProcedimentos.click();
		btn_importarPlanoTratamento.click();
	}

	public void alterarProcedimento() throws InterruptedException {
		Thread.sleep(5000);
		btn_lupaProcedimento.click();
		list_editarProcedimento.click();
	}

	public void clicarExcluirAgendamenro() {
		btn_excluirAgendamento.click();
	}

	public void clicarExcluirSomenteEsta() {
		try {
			if (btn_excluirSomenteEsta.isDisplayed()) {
				btn_excluirSomenteEsta.click();
			}
		} catch (NoSuchElementException e) {
			// não é uma agenda com repetição
		}
	}

	public void confirmarExcluirAgendamento() {
		btn_confirmarExcluir.click();
	}

	public void agendamentoExcluidoComSucesso() {
		assertTrue(lbl_agendamentoExcluidoComSucesso.isDisplayed());
	}

	public void clicarStatusAgendamento() {
		// guardando o status anterior
		statusAnterior = list_statusAgendamento.getText();
		list_statusAgendamento.click();
	}

	public void alterarStatusAgendamento() {
		// alterando o status pra primeira opcao da lista
		list_opcaoStatusAgendamento.click();
	}

	public String validarprofissionalSelecionado() {
		String profissionalSelecionado = txt_profissionalSelecionado.getText();
		return profissionalSelecionado;

	}

	public void statusAlterado() throws InterruptedException {
		// comparando o status anterior que eu guardei, com o primeiro valor da lista
		// atualizado, se for igual é pq deu certo
		Thread.sleep(3000);
		list_statusAgendamento.click();

		Thread.sleep(3000);
		opcaoLista = list_opcaoStatusAgendamento.getText();
		assertEquals(statusAnterior, opcaoLista);
	}
}