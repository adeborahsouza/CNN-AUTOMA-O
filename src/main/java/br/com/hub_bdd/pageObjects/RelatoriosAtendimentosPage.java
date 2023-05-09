package br.com.hub_bdd.pageObjects;

import br.com.hub_bdd.dataProviders.ConfigFileReader;
import br.com.hub_bdd.managers.JavascriptExecutorUtil;
import br.com.hub_bdd.managers.PDFValidator;
import br.com.hub_bdd.managers.ReadPDF;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RelatoriosAtendimentosPage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    ReadPDF readPDF;
    AgendaPage agendaPage;
    private JavascriptExecutor js;

    public RelatoriosAtendimentosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Atendimentos')]")
    private WebElement btn_submenuRelatorioAtendimentos;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por duração de consulta')]")
    private WebElement btn_submenuTempoDuracaoConsulta;

    @FindBy(how = How.XPATH, using = "//span[contains(@data-type,'autocomplete-search')]")
    private WebElement btn_lupaProfissionalLista;

    @FindBy(how = How.CSS, using = ".ui-menu-item-wrapper")
    private WebElement btn_profissionalLista;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por tipo de atendimento')]")
    private WebElement btn_submenuRelatorioTipoAtendimento;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por faixa etária')]")
    private WebElement btn_submenuRelatorioFaixaEtaria;

    @FindBy(how = How.XPATH, using = "//input[contains(@id,'agruparPorTipoConsulta')]")
    private WebElement btn_agruparTipoConsulta;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Por CIDs diagnóstico')]")
    private WebElement btn_submenuRelatorioCidDiagnostico;

    @FindBy(how = How.XPATH, using = "//span[@class='input-group-append input-group-text' and @style='position: absolute; bottom: 0px; right: 0; height: 100%; border-radius: 0 0.475rem 0.475rem 0; cursor: pointer;']/i[@class='fa fa-icon fa-tags bigger-120']")
    private WebElement btn_lupaCID;

    @FindBy(how = How.XPATH, using = "(//div[contains(@mappedvalue,'1')])[1]")
    private WebElement btn_primeiroCidLista;

    @FindBy(how = How.XPATH, using = "(//span[@class='menu-title'][contains(.,'Escala de atendimento')])[1]")
    private WebElement btn_submenuEscalaAtendimento;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Extrato de teleconsulta')]")
    private WebElement btn_submenuExtratoTeleconsulta;

    @FindBy(how = How.XPATH, using = "(//span[@class='menu-title'][contains(.,'Pesquisa de satisfação')])[1]")
    private WebElement btn_submenuPesquisaSatisfacao;


    public void clicarBtnSubmenuRelatorioAtendimentos() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_submenuRelatorioAtendimentos);
        btn_submenuRelatorioAtendimentos.click();
    }

    public void clicarBtnSubmenuRelatorioAtendimentosDuracaoConsulta() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_submenuTempoDuracaoConsulta);
        btn_submenuTempoDuracaoConsulta.click();
    }

    public void clicarPrimeiroProfissionalLista() {
        btn_lupaProfissionalLista.click();
        btn_profissionalLista.click();
    }

    public void validarRelatorioAtendimentosDuracaoConsulta() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório por duração de consulta";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");

        }


//    public void clicarEmCamposRelatorioAgendamentos() {
//        btn_relatorioAgendamentosCampos.click();
//        btn_relatorioAgendamentosCancelar.click();
//        btn_relatorioAgendamentosCampos.click();
//    }
//
//    public void validarRelatorioAgendamentoSituacaoDinamico() {
//        assertTrue(lbl_relatorioAgendamentosCampos.isDisplayed());
//
    }

    public void validarRelatorioAtendimentosDuracaoConsultaAnalitico() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório analítico de duração de consulta";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");


        }
    }

    public void clicarRelatorioAtendimentosTipoAtendimento() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_submenuRelatorioTipoAtendimento);
        btn_submenuRelatorioTipoAtendimento.click();
    }

    public void validarRelatorioAtendimentosTipoAtendimento() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório por tipo de atendimento";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");


        }
    }

    public void clicarRelatorioAtendimentosFaixaEtaria() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_submenuRelatorioFaixaEtaria);
        btn_submenuRelatorioFaixaEtaria.click();
    }

    public void SelecionarOpcaoAgruparTipoConsulta() {
        btn_agruparTipoConsulta.click();
    }

    public void validarRelatorioAtendimentosFaixaEtaria() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Agrupados por tipo de consulta";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void ClicarRelatorioAtendimentosCIDDiagnostico() {
        btn_submenuRelatorioCidDiagnostico.click();
    }

    public void SelecionarUmCIDDiagnostico() {
        btn_lupaCID.click();
        btn_primeiroCidLista.click();
//        btn_primeiroCidLista.sendKeys(Keys.ENTER);
    }

    public void validarRelatorioAtendimentosCIDDiagnostico() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de atendimentos por CIDs diagnóstico";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }


    }

    public void validarRelatorioEscalaAtendimento() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de escalas de atendimento";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }

    }

    public void ClicarRelatorioEscalaAtendimento() {
        btn_submenuEscalaAtendimento.click();
    }

    public void ClicarRelatorioExtratoTeleconsulta() {
        btn_submenuExtratoTeleconsulta.click();
    }

    public void ValidarRelatorioExtratoTeleconsulta() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de extrato de teleconsulta";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }
}