package br.com.hub_bdd.stepDefinition;

import br.com.hub_bdd.cucumber.TestContext;
import br.com.hub_bdd.pageObjects.RelatoriosDietasPage;
import br.com.hub_bdd.pageObjects.RelatoriosPlanosConvenioPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;

public class RelatoriosDietasSteps {
    WebDriver driver;
    TestContext testContext;
    RelatoriosDietasPage relatoriosDietasPage;

    public RelatoriosDietasSteps(TestContext context) {
        testContext = context;
        relatoriosDietasPage = testContext.getPageObjectManager().getRelatoriosDietas_Page();
    }
    @And("^acessa o submenu relatorios de dietas$")
    public void acessa_o_submenu_relatorios_de_dietas() throws Throwable {
        relatoriosDietasPage.clicarBtnSubmenuRelatorioDietas();
        Log.info("Clicando em relatorio de dietas");
    }

    @And("^clica em relatorio de dietas do dia$")
    public void clica_em_relatorio_de_dietas_do_dia() throws Throwable {
        relatoriosDietasPage.clicarBtnSubmenuRelatorioDietasDia();
        Log.info("Clicando em relatorio de dietas do dia");
    }


    @And("^clica em relatorio de dietas da semana$")
    public void clica_em_relatorio_de_dietas_da_semana() throws Throwable {
        relatoriosDietasPage.clicarBtnSubmenuRelatorioDietasSemana();
        Log.info("Clicando em relatorio de dietas da semana");
    }

    @And("^clica em relatorio resumo dietas semanal$")
    public void clica_em_relatorio_resumo_dietas_semanal() throws Throwable {
        relatoriosDietasPage.clicarBtnSubmenuRelatorioResumoDietasSemana();
        Log.info("Clicando em relatorio resumo de dietas da semana");
    }

    @Then("^valida que o relatorio de dietas do dia esta correto$")
    public void valida_que_o_relatorio_de_dietas_do_dia_esta_correto() throws Throwable {
        relatoriosDietasPage.validarRelatorioDietasDia();
        Log.info("Validando relatorio de dietas do dia");
    }

    @Then("^valida que o relatorio de dietas da semana esta correto$")
    public void valida_que_o_relatorio_de_dietas_da_semana_esta_correto() throws Throwable {
        relatoriosDietasPage.validarRelatorioDietasSemana();
        Log.info("Validando relatorio de dietas da semana");
    }

    @Then("^valida que o relatorio resumo de dietas semanal esta correto$")
    public void valida_que_o_relatorio_resumo_de_dietas_semanal_esta_correto() throws Throwable {
        relatoriosDietasPage.validarRelatorioResumoDietasSemanal();
        Log.info("Validando relatorio resumo de dietas semanal");
    }

}