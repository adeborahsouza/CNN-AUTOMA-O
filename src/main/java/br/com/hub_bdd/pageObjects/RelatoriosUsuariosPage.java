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

public class RelatoriosUsuariosPage {
    WebDriver driver;
    ConfigFileReader configFileReader;
    ReadPDF readPDF;
    AgendaPage agendaPage;
    private JavascriptExecutor js;
    private String primeiroUsuarioLista;

    public RelatoriosUsuariosPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title' and text()='Usuários']")
    private WebElement btn_submenuRelatorioUsuarios;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Relatório de usuários')]")
    private WebElement btn_relatorioUsuarios;

    @FindBy(how = How.XPATH, using = "(//select[contains(@class,'form-select custom-select form-control ')])[1]")
    private WebElement btn_listaStatusUsuarios;

    @FindBy(how = How.XPATH, using = "//label[@class='btn btn-outline btn-color-muted btn-active-primary  active']")
    private WebElement btn_opcaoStatusAtivos;

    @FindBy(how = How.XPATH, using = "//label[@class='btn btn-outline btn-color-muted btn-active-primary  '][contains(.,'Inativos')]")
    private WebElement btn_opcaoStatusInativo;

    @FindBy(how = How.XPATH, using = "//span[@class='menu-title'][contains(.,'Relatório de acessos')]")
    private WebElement btn_relatorioAcessosUsuarios;

    @FindBy(how = How.XPATH, using = "//span[@class='input-group-append input-group-text ']")
    private WebElement btn_relatorioUsuarioLupa;

    @FindBy(how = How.XPATH, using = "(//div[@tabindex='-1'])[3]")
    private WebElement btn_primeiroUsuarioLista;


    public void acessarSubmenuRelatorioUsuarios() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_submenuRelatorioUsuarios);
        btn_submenuRelatorioUsuarios.click();
    }

    public void clicarRelatorioUsuarios() {
        btn_relatorioUsuarios.click();
    }

    public void selecionarOpcaoAtivos() {
        btn_listaStatusUsuarios.click();
        btn_opcaoStatusAtivos.click();
    }

    public void validarRelatorioUsuariosAtivos() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = "Relatório de Usuários";
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

    public void selecionarOpcaoInativos() {
        btn_listaStatusUsuarios.click();
        btn_opcaoStatusInativo.click();
    }

    public void clicarRelatorioAcessoUsuarios() {
        JavascriptExecutorUtil.scrollIntoView(driver, btn_relatorioAcessosUsuarios);
        btn_relatorioAcessosUsuarios.click();
    }

    public void selecionarPrimeiroUsuarioLista() {
        btn_relatorioUsuarioLupa.click();
        this.primeiroUsuarioLista = btn_primeiroUsuarioLista.getText();
        btn_primeiroUsuarioLista.click();
    }

    public void validarRelatorioAcessoUsuarios() {
        String downloadFolderPath = System.getProperty("user.home") + "/Downloads";
        String filePath = PDFValidator.getLatestPDFFilePath(downloadFolderPath);

        if (filePath != null) {
            // Verificar se o arquivo PDF contém o texto esperado
            String expectedText = this.primeiroUsuarioLista;
            assertTrue("PDF não contém: " + expectedText, PDFValidator.validatePDFText(filePath, expectedText));
        } else {
            fail("Nenhum arquivo PDF encontrado na pasta de downloads.");
        }
    }

}