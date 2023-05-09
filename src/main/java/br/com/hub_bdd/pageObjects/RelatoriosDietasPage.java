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

public class RelatoriosDietasPage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    ReadPDF readPDF;
    AgendaPage agendaPage;
    private JavascriptExecutor js;
    private String primeiroConvenioLista;

    public RelatoriosDietasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    @FindBy(how = How.XPATH, using = "(//span[@class='menu-title'][contains(.,'Dietas')])[1]")
    private WebElement btn_submenuRelatorioDietas;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Dietas do dia')]")
    private WebElement btn_relatorioDietasDia;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Dietas da semana')]")
    private WebElement btn_relatorioDietasSemana;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Resumo de dietas semanal')]")
    private WebElement btn_relatorioResumoDietasSemanal;

    public void clicarBtnSubmenuRelatorioDietas() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_submenuRelatorioDietas);
        btn_submenuRelatorioDietas.click();
    }

    public void clicarBtnSubmenuRelatorioDietasDia() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_relatorioDietasDia);
        btn_relatorioDietasDia.click();
    }

    public void validarRelatorioDietasDia() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de dietas do dia";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void validarRelatorioDietasSemana() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de dietas da semana";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void validarRelatorioResumoDietasSemanal() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Resumo de dietas semanal";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void clicarBtnSubmenuRelatorioDietasSemana() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_relatorioDietasSemana);
        btn_relatorioDietasSemana.click();
    }

    public void clicarBtnSubmenuRelatorioResumoDietasSemana() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_relatorioResumoDietasSemanal);
        btn_relatorioResumoDietasSemanal.click();
    }
}
