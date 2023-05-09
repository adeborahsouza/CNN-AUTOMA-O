package br.com.hub_bdd.pageObjects;

import br.com.hub_bdd.dataProviders.ConfigFileReader;
import br.com.hub_bdd.managers.JavascriptExecutorUtil;
import br.com.hub_bdd.managers.PDFValidator;
import br.com.hub_bdd.managers.ReadPDF;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RelatoriosPlanosConvenioPage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    ReadPDF readPDF;
    AgendaPage agendaPage;
    private JavascriptExecutor js;
    private String primeiroConvenioLista;

    public RelatoriosPlanosConvenioPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    @FindBy(how = How.XPATH, using = "(//span[@class='menu-title'][contains(.,'Planos de convênio')])[1]")
    private WebElement btn_submenuRelatorioPlanosConvenio;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Procedimentos por plano de convênio')]")
    private WebElement btn_relatorioProcedimentosPlanosConvenio;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Dados do plano de convênio')]")
    private WebElement btn_relatorioDadosPlanosConvenio;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Planos de convênio por validade')]")
    private WebElement btn_relatorioPlanosConvenioValidade;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Carteirinhas de plano de convênio')]")
    private WebElement btn_relatorioPlanosConvenioCarteirinha;

    @FindBy(how = How.XPATH, using = "//label[contains(.,'Ativos')]")
    private WebElement btn_relatoriosPlanoConvenioAtivos;

    @FindBy(how = How.XPATH, using = "//label[contains(.,'Inativos')]")
    private WebElement btn_relatoriosPlanoConvenioInativos;

    @FindBy(how = How.XPATH, using = "//*[@id=\"ui-id-1\"]/li[1]")
    private WebElement btn_listConvenioRelatorioPlanoConvenio;


    public void clicarBtnSubmenuRelatorioPlanosConvenio() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_submenuRelatorioPlanosConvenio);
        btn_submenuRelatorioPlanosConvenio.click();
    }

    public void clicarRelatorioProcedimentosPlanosConvenio() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_relatorioProcedimentosPlanosConvenio);
        btn_relatorioProcedimentosPlanosConvenio.click();
    }

    public void validarRelatorioProcedimentosPlanoConvenio() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de procedimentos por plano de convênio";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void clicarInativoPlanosConvenio() {
        btn_relatoriosPlanoConvenioInativos.click();
    }

    public void clicaAtivoPlanosConvenio() {
        btn_relatoriosPlanoConvenioAtivos.click();
    }

    public void clicarBtnSubmenuRelatorioDadosPlanosConvenio() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_relatorioDadosPlanosConvenio);
        btn_relatorioDadosPlanosConvenio.click();
    }

    public void validarRelatorioDadosPlanoConvenio() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de dados do plano de convênio";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }


    }

    public void validarRelatorioValidadePlanoConvenio() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de planos de convênio por validade";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void clicarBtnSubmenuRelatorioValidadePlanosConvenio() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_relatorioPlanosConvenioValidade);
        btn_relatorioPlanosConvenioValidade.click();
    }

    public void clicarBtnSubmenuRelatorioCarteirinhaPlanosConvenio() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_relatorioPlanosConvenioCarteirinha);
        btn_relatorioPlanosConvenioCarteirinha.click();
    }

    public void validarRelatorioCarteirinhaPlanoConvenio() {
        this.primeiroConvenioLista = btn_listConvenioRelatorioPlanoConvenio.getText();

        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = this.primeiroConvenioLista;
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }
}
