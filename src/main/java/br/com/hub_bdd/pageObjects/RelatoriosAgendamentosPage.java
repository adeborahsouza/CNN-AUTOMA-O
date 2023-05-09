package br.com.hub_bdd.pageObjects;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.hub_bdd.dataProviders.ConfigFileReader;
import br.com.hub_bdd.managers.PDFValidator;
import br.com.hub_bdd.managers.ReadPDF;

public class RelatoriosAgendamentosPage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    ReadPDF readPDF;
    AgendaPage agendaPage;
    private JavascriptExecutor js;

    public RelatoriosAgendamentosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    @FindBy(how = How.XPATH, using = "//a[@href='/app-cnn/estoque/movimento/lista'][contains(.,'Estoque')]")
    private WebElement btn_menuEstoque;

    @FindBy(how = How.CSS, using = "#menu-relatorios > span > span.menu-title")
    private WebElement btn_menuRelatorios;

    @FindBy(how = How.XPATH, using = "(//span[@class='menu-title'][contains(.,'Agendamentos')])[2]")
    private WebElement btn_submenuRelatoriosAgendamentos;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por situação do agendamento')]")
    private WebElement btn_relatorioSituacaoAgendamento;

    @FindBy(how = How.XPATH, using = "//input[(contains(@class, 'form-control') and @name='inicio') or @id='dataInicial']")
    private WebElement btn_dataInicial;

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'dataFinal')]")
    private WebElement btn_dataFinal;

    @FindBy(how = How.CSS, using = ".datepicker-days tfoot .today")
    private WebElement btn_hoje;

    @FindBy(how = How.XPATH, using = "//select[contains(@id,'tipo-relatorio')]")
    private WebElement btn_tipoRelatorio;

    @FindBy(how = How.XPATH, using = "//button[@id='btn-imprimir-relatorios']")
    private WebElement btn_imprimirRelatorio;

    @FindBy(how = How.XPATH, using = "//a[@class='menu-link px-3'][contains(.,'PDF')]")
    private WebElement btn_PDFRelatorios;

    @FindBy(how = How.XPATH, using = "//a[@class='menu-link px-3'][contains(.,'PDF')]")
    private WebElement lbl_zeroAgendamentos;

    @FindBy(how = How.XPATH, using = "//*[@id='tipo-relatorio']/option[2]")
    private WebElement btn_analitico;

    @FindBy(how = How.XPATH, using = "//input[@id='mostrarProcedimentos']")
    private WebElement input_mostrarProcedimentos;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'comValor')]")
    private WebElement input_mostrarValores;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'comObservacao')]")
    private WebElement input_mostrarObservacao;

    @FindBy(how = How.XPATH, using = "(//td[contains(@class,'old day')])[1]")
    private WebElement btn_primeiroDiaCalendario;

    @FindBy(how = How.XPATH, using = "(//i[contains(@class,'fa fa-search')])[1]")
    private WebElement btn_lupaConvenioRelatorioPlanoConvenio;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-id-1\"]/li[1]")
    private WebElement btn_listConvenioRelatorioPlanoConvenio;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por plano de convênio')]")
    private WebElement btn_relatorioAgendamentoPorPlanoConvenio;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por criação do agendamento')]")
    private WebElement btn_relatorioCriacaoAgendamento;

    @FindBy(how = How.XPATH, using = "//img[@src='data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjwhLS0gR2VuZXJhdG9yOiBBZG9iZSBJbGx1c3RyYXRvciAxNi4wLjAsIFNWRyBFeHBvcnQgUGx1Zy1JbiAuIFNWRyBWZXJzaW9uOiA2LjAwIEJ1aWxkIDApICAtLT4NCjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+DQo8c3ZnIHZlcnNpb249IjEuMSIgaWQ9IkxheWVyXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4Ig0KCSB3aWR0aD0iNjRweCIgaGVpZ2h0PSI2NHB4IiB2aWV3Qm94PSIwIDAgNjQgNjQiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDY0IDY0IiB4bWw6c3BhY2U9InByZXNlcnZlIiBmaWxsPSIjZmZmIj4NCjxnIGlkPSJET1dOTE9BRF8xXyIgZW5hYmxlLWJhY2tncm91bmQ9Im5ldyAgICAiPg0KCTxnIGlkPSJET1dOTE9BRCI+DQoJCTxnPg0KCQkJPHBhdGggZD0iTTIwLjc3LDI5LjAwN2w5LDEwbDAsMEMzMC4zMTksMzkuNjE2LDMxLjExNSw0MCwzMiw0MHMxLjY4LTAuMzg0LDIuMjMtMC45OTNsMCwwbDktMTBsMCwwDQoJCQkJQzQzLjcwOCwyOC40NzUsNDQsMjcuNzcyLDQ0LDI3YzAtMS42NTctMS4zNDMtMy0zLTNjLTAuODg1LDAtMS42ODIsMC4zODMtMi4yMywwLjk5M2wwLDBMMzUsMjkuMTgyVjExYzAtMS42NTctMS4zNDMtMy0zLTMNCgkJCQlzLTMsMS4zNDMtMywzdjE4LjE4MmwtMy43Ny00LjE4OWwwLDBDMjQuNjgxLDI0LjM4NCwyMy44ODUsMjQsMjMsMjRjLTEuNjU3LDAtMywxLjM0My0zLDNDMjAsMjcuNzcyLDIwLjI5MiwyOC40NzUsMjAuNzcsMjkuMDA3DQoJCQkJTDIwLjc3LDI5LjAwN3ogTTU1LDM1Yy0xLjY1NywwLTMsMS4zNDMtMywzdjEySDEyVjM4YzAtMS42NTctMS4zNDMtMy0zLTNzLTMsMS4zNDMtMywzdjE1YzAsMS42NTcsMS4zNDMsMywzLDNoMjIuOTk3DQoJCQkJYzAuMDAxLDAsMC4wMDIsMCwwLjAwMywwczAuMDAyLDAsMC4wMDMsMEg1NWMxLjY1NywwLDMtMS4zNDMsMy0zVjM4QzU4LDM2LjM0Myw1Ni42NTcsMzUsNTUsMzV6Ii8+DQoJCTwvZz4NCgk8L2c+DQo8L2c+DQo8L3N2Zz4NCg==']")
    private WebElement btn_baixarRelatorio;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por agenda')]")
    private WebElement btn_relatorioPorAgenda;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por procedimentos agendados')]")
    private WebElement btn_relatorioPorProcedimentosAgendados;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por cidade do agendamento')]")
    private WebElement btn_relatorioPorCidade;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Agendamentos + telefone paciente')]")
    private WebElement btn_relatorioAgendamentoTelefonePaciente;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por origem de confirmação')]")
    private WebElement btn_origemConfirmacao;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Remarcações')]")
    private WebElement btn_relatorioRemarcacao;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Agendamentos Excluídos')]")
    private WebElement btn_relatorioAgendamentosExcluidos;

    @FindBy(how = How.XPATH, using = "//span[contains(.,'Mensagens SMS')]")
    private WebElement btn_relatorioAgendamentosMensagemSMS;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por situação (Dinâmico)')]")
    private WebElement btn_relatorioAgendamentosSituacaodinamica;


    @FindBy(how = How.XPATH, using = "//button[@type='button'][contains(.,'Pesquisar')]")
    private WebElement btn_relatorioAgendamentosPesquisar;

    @FindBy(how = How.CSS, using = "#wdr-tab-export a")
    private WebElement btn_relatorioAgendamentosExportar;

    @FindBy(how = How.CSS, using = "#wdr-tab-export-pdf a")
    private WebElement btn_relatorioAgendamentosParaPDF;

    @FindBy(how = How.XPATH, using = "//a[@href='javascript:void(0)'][contains(.,'Aplicar')]")
    private WebElement btn_relatorioAgendamentosAplicar;

    @FindBy(how = How.CSS, using = "#wdr-tab-save-config a")
    private WebElement btn_relatorioAgendamentosSalvar;

    @FindBy(how = How.XPATH, using = "//input[@id='configuracao-nome']")
    private WebElement txt_nomeRelatorio;

    @FindBy(how = How.XPATH, using = "(//a[contains(.,'Salvar')])[2]")
    private WebElement btn_relatorioAgendamentosSalvarNomeRelatorio;

    @FindBy(how = How.XPATH, using = "(//div[@class='toastr-message'][contains(.,'Configuração salva com sucesso.')])[1]")
    private WebElement lbl_relatorioAgendamentosAlertaNomeSalvo;

    @FindBy(how = How.XPATH, using = "//span[contains(.,'O nome é obrigatório e deve ser informado.')]")
    private WebElement lbl_relatorioAgendamentosAlertaNomeVazio;

    @FindBy(how = How.XPATH, using = "(//i[@class='fas fa-trash'])[2]")
    private WebElement btn_relatorioAgendamentosExcluir;

    @FindBy(how = How.CSS, using = ".radio")
    private WebElement btn_relatorioAgendamentosSelecionar;

    @FindBy(how = How.XPATH, using = "//a[contains(.,'Carregar relatório')]")
    private WebElement btn_relatorioAgendamentosCarregar;

    @FindBy(how = How.XPATH, using = "//div[@class='toastr-message'][contains(.,'Relatório excluído com sucesso!')]")
    private WebElement lbl_relatorioAgendamentosExcluidoComSucesso;

    @FindBy(how = How.XPATH, using = "//a[contains(.,'Carregar relatório')]")
    private WebElement lbl_relatorioAgendamentosAlertaAlteradoPadrão;

    @FindBy(how = How.XPATH, using = "//input[contains(@class,'ace ace-switch ace-switch-7 configuracao-padrao')]")
    private WebElement btn_relatorioAgendamentosAlterarPadrao;

    @FindBy(how = How.CSS, using = ".wdr-svg-icon")
    private WebElement btn_relatorioAgendamentosFormatar;

    @FindBy(how = How.XPATH, using = "//span[contains(.,'Formatar células')]")
    private WebElement btn_relatorioAgendamentosFormatarCelulas;

    @FindBy(how = How.CSS, using = "#wdr-tab-options")
    private WebElement btn_relatorioAgendamentosOpcoes;

    @FindBy(how = How.XPATH, using = "//label[@for='wdr-lt-1'][contains(.,'Formulário compacto')]")
    private WebElement btn_relatorioAgendamentosCompacto;

    @FindBy(how = How.CSS, using = "#wdr-tab-fields")
    private WebElement btn_relatorioAgendamentosCampos;

    @FindBy(how = How.XPATH, using = "(//span[contains(.,'Campos')])[2]")
    private WebElement lbl_relatorioAgendamentosCampos;

    @FindBy(how = How.CSS, using = "#wdr-tab-open-config a")
    private WebElement btn_relatorioAgendamentosMeusRelatorios;

    @FindBy(how = How.XPATH, using = "//a[@class='wdr-ui-element wdr-ui wdr-ui-btn'][contains(.,'Cancelar')]")
    private WebElement btn_relatorioAgendamentosCancelar;


    public void clicarBtnMenuEstoque() {
        btn_menuEstoque.click();
    }

    public void clicarBtnMenuRelatorios() {
        WebElement menuLateral = driver.findElement(By.cssSelector("#kt_app_sidebar_menu_wrapper"));
        WebElement btn_relatorios = menuLateral
                .findElement(By.cssSelector("#menu-relatorios > span > span.menu-title"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", btn_relatorios);
        btn_relatorios.click();
//
//		
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("window.scrollBy(0,100)");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement btn_menuRelatorios = new WebDriverWait(driver, 10).until(ExpectedConditions
//				.visibilityOfElementLocated(By.cssSelector("#menu-relatorios > span > span.menu-title")));
//		js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
//		btn_menuRelatorios.click();
    }

    public void clicarSubMenuRelatoriosAgendamentos() {
        btn_submenuRelatoriosAgendamentos.click();
    }

    public void clicarBtnRelatorioSituacaoAgendamento() {
        btn_relatorioSituacaoAgendamento.click();
    }

    public void clicarRelatoriosAgendamentoPorPlanoConvenio() {
        btn_relatorioAgendamentoPorPlanoConvenio.click();
    }

    public void selecionarPeriodoHoje() {
        btn_dataInicial.click();
        btn_hoje.click();
        btn_dataFinal.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_hoje = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("today")));
        js.executeScript("arguments[0].scrollIntoView();", btn_hoje);
        btn_hoje.click();
    }

    public void selecionarPeriodoInicioMes() throws InterruptedException {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("PT-br"));
        String hoje = formmat1.format(ldt);

        btn_dataInicial.click();
        btn_primeiroDiaCalendario.click();
        btn_dataFinal.clear();
        btn_dataFinal.sendKeys(hoje);
        btn_dataFinal.sendKeys(Keys.ENTER);
        // Thread.sleep(3000);

    }

    public void clicarImprimirRelatorios() throws InterruptedException {
        btn_imprimirRelatorio.click();
        btn_PDFRelatorios.click();
        btn_baixarRelatorio.click();
        Thread.sleep(2000);
    }

    public void validarRelatorioSituacaoAgendamentoSintetico() throws InterruptedException {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "0 agendamento(s) contabilizado(s).";
            assertFalse("PDF contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }

    }

    public void selecionarRelatorioAnalitico() throws InterruptedException {
        btn_tipoRelatorio.click();
        Thread.sleep(3000);
        btn_analitico.click();
    }

    public void selecionarMostrarProcedimentos() {
        input_mostrarProcedimentos.click();
    }

    public void selecionarMostrarValores() {
        input_mostrarValores.click();
    }

    public void selecionarMostrarObservacao() {

        input_mostrarObservacao.click();

    }

    public void validarRelatorioSituacaoAgendamentoAnalitico() throws InterruptedException {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Total Geral: 0";
            assertFalse("PDF contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void selecionarConvenioRelatorioAgendamentosPorPlanoConvenio() {
        btn_lupaConvenioRelatorioPlanoConvenio.click();
        btn_listConvenioRelatorioPlanoConvenio.click();
    }

    public void validarRelatorioAgendamentoPorPlanoConvenio() throws InterruptedException {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "0 agendamento(s) contabilizado(s).";
            assertFalse("PDF contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void clicarRelatorioAgendamentoCriacao() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='menu-title'][contains(.,'Por criação do agendamento')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_relatorioCriacaoAgendamento.click();

    }

    public void validarRelatorioCriacaoAgendamento() throws InterruptedException {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "0 agendamento(s) contabilizado(s).";
            assertFalse("PDF contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void clicarRelatoriosAgendamentoPorAgenda() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[@class='menu-title'][contains(.,'Por agenda')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_relatorioPorAgenda.click();
    }

    public void validarRelatorioPorAgenda() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Agenda";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");

        }
    }

    public void clicarRelatorioAgendamentoPorProcedimentosAgendados() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(.,'Por procedimentos agendados')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_relatorioPorProcedimentosAgendados.click();

    }

    public void validarRelatorioPorProcedimentosAgendados() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Nenhum registro encontrado";
            assertFalse("PDF contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void clicarRelatorioAgendamentoPorCidade() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='menu-title'][contains(.,'Por cidade do agendamento')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_menuRelatorios.click();

    }

    public void validarRelatorioPorCidade() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Nenhum agendamento encontrado";
            assertFalse("PDF contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }

    }

    public void clicarRelatorioAgendamentoTelefonePaciente() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='menu-title'][contains(.,'Agendamentos + telefone paciente')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_relatorioAgendamentoTelefonePaciente.click();
    }

    public void validarRelatorioAgendamentoTelefonePaciente() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de agendamentos com telefones do paciente";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }

    }

    public void clicarRelatorioAgendamentoOrigemConfirmacao() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='menu-title'][contains(.,'Por origem de confirmação')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_origemConfirmacao.click();
    }

    public void validarRelatorioAgendamentoOrigemConfirmacao() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Origem";
            assertTrue("O texto esperado não deve estar presente no PDF",
                    PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }

    }

    public void clicarRelatorioAgendamentoRemarcacao() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[@class='menu-title'][contains(.,'Remarcações')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_relatorioRemarcacao.click();
    }

    public void validarRelatorioAgendamentoRemarcacao() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de remarcações";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }

    }

    public void clicarRelatorioAgendamentosExcluidos() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='menu-title'][contains(.,'Agendamentos Excluídos')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_relatorioAgendamentosExcluidos.click();
    }

    public void validarRelatorioAgendamentosExcluidos() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de agendamentos excluídos";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }

    }

    public void clicarRelatorioAgendamentoMensagensSMS() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Mensagens SMS')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_relatorioAgendamentosMensagemSMS.click();
    }

    public void validarRelatorioAgendamentoMensagensSMS() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de mensagens SMS";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }

    }

    public void clicarPesquisarRelatorioAgendamentoDinamico() {
        btn_relatorioAgendamentosPesquisar.click();
    }

    public void clicarRelatorioAgendamentoSituacaoDinamico() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='menu-title'][contains(.,'Por situação (Dinâmico)')]")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_relatorioAgendamentosSituacaodinamica.click();
    }

    public void clicarExportarPDF() {
        btn_relatorioAgendamentosExportar.click();
        btn_relatorioAgendamentosParaPDF.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement btn_menuRelatorios = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[@id='wdr-btn-apply']")));
        js.executeScript("arguments[0].scrollIntoView();", btn_menuRelatorios);
        btn_relatorioAgendamentosAplicar.click();
    }

    public void clicarEmMeusRelatorios() throws InterruptedException {
        btn_relatorioAgendamentosMeusRelatorios.click();
        btn_relatorioAgendamentosSelecionar.click();
        btn_relatorioAgendamentosAlterarPadrao.click();
        assertTrue(lbl_relatorioAgendamentosAlertaAlteradoPadrão.isDisplayed());
        Thread.sleep(4000);
        btn_relatorioAgendamentosExcluir.click();
        assertTrue(lbl_relatorioAgendamentosExcluidoComSucesso.isDisplayed());
        btn_relatorioAgendamentosCarregar.click();

    }

    public void clicarSalvarRelatorio() {
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("PT-br"));
        String hoje = formmat1.format(ldt);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, -250);");

        btn_relatorioAgendamentosSalvar.click();
        btn_relatorioAgendamentosSalvarNomeRelatorio.click();
        assertTrue(lbl_relatorioAgendamentosAlertaNomeVazio.isDisplayed());
        txt_nomeRelatorio.sendKeys(hoje);
        btn_relatorioAgendamentosSalvarNomeRelatorio.click();
        assertTrue(lbl_relatorioAgendamentosAlertaNomeSalvo.isDisplayed());
    }

    public void clicarFormatarCelulas() {
        btn_relatorioAgendamentosFormatar.click();
        btn_relatorioAgendamentosFormatarCelulas.click();
        btn_relatorioAgendamentosAplicar.click();
    }

    public void clicarOpcoesRelatorioAgendamentos() {
        btn_relatorioAgendamentosOpcoes.click();
        btn_relatorioAgendamentosAplicar.click();
    }

    public void clicarEmCamposRelatorioAgendamentos() {
        btn_relatorioAgendamentosCampos.click();
        btn_relatorioAgendamentosCancelar.click();
        btn_relatorioAgendamentosCampos.click();
    }

    public void validarRelatorioAgendamentoSituacaoDinamico() {
        assertTrue(lbl_relatorioAgendamentosCampos.isDisplayed());
    }
}