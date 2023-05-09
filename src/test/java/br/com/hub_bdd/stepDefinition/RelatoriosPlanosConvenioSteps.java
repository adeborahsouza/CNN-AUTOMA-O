package br.com.hub_bdd.stepDefinition;

import br.com.hub_bdd.cucumber.TestContext;
import br.com.hub_bdd.pageObjects.RelatoriosPlanosConvenioPage;
import br.com.hub_bdd.pageObjects.RelatoriosUsuariosPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;

public class RelatoriosPlanosConvenioSteps {
    WebDriver driver;
    TestContext testContext;
    RelatoriosPlanosConvenioPage relatoriosPlanosConvenioPage;

    public RelatoriosPlanosConvenioSteps(TestContext context) {
        testContext = context;
        relatoriosPlanosConvenioPage = testContext.getPageObjectManager().getRelatoriosPlanosConvenio_Page();
    }


    @And("^acessa o submenu relatorios de planos de convenio$")
    public void acessa_o_submenu_relatorios_de_planos_de_convenio() throws Throwable {
        relatoriosPlanosConvenioPage.clicarBtnSubmenuRelatorioPlanosConvenio();
        Log.info("Clicando em relatorio de planos convenio");
    }

    @And("^clica em relatorio de procedimentos por plano de convenio$")
    public void clica_em_relatorio_de_procedimentos_por_plano_de_convenio() throws Throwable {
        relatoriosPlanosConvenioPage.clicarRelatorioProcedimentosPlanosConvenio();
        Log.info("Clicando em relatorio de procedimentos planos convenio");
    }

    @And("^seleciona opcao Inativos em relatorio de procedimentos por plano convenio$")
    public void seleciona_opcao_Inativos_em_relatorio_de_procedimentos_por_plano_convenio() throws Throwable {
        relatoriosPlanosConvenioPage.clicarInativoPlanosConvenio();
        Log.info("Clicando em inativos em relatorio de procedimentos planos convenio");
    }

    @And("^seleciona opcao Ativos em relatorio de procedimentos por plano convenio$")
    public void seleciona_opcao_Ativos_em_relatorio_de_procedimentos_por_plano_convenio() throws Throwable {
        relatoriosPlanosConvenioPage.clicaAtivoPlanosConvenio();
        Log.info("Clicando em ativos relatorio de procedimentos planos convenio");    }


    @And("^clica em relatorio de dados por plano de convenio$")
    public void clica_em_relatorio_de_dados_por_plano_de_convenio() throws Throwable {
        relatoriosPlanosConvenioPage.clicarBtnSubmenuRelatorioDadosPlanosConvenio();
        Log.info("Clicando em relatorio de dados planos convenio");
    }

    @Then("^valida que o relatorio de dados plano de convenio esta correto$")
    public void valida_que_o_relatorio_de_dados_plano_de_convenio_esta_correto() throws Throwable {
        relatoriosPlanosConvenioPage.validarRelatorioDadosPlanoConvenio();
        Log.info("Validando que relatorio de dados planos convenio esta correto");

    }

    @Then("^valida que o relatorio de procedimentos plano de convenio ativos esta correto$")
    public void valida_que_o_relatorio_de_procedimentos_plano_de_convenio_ativos_esta_correto() throws Throwable {
        relatoriosPlanosConvenioPage.validarRelatorioProcedimentosPlanoConvenio();
        Log.info("Validando que relatorio de procedimentos planos convenio esta correto");
    }

    @And("^clica em relatorio de carteirinhas por plano de convenio$")
    public void clica_em_relatorio_de_carteirinhas_por_plano_de_convenio() throws Throwable {
        relatoriosPlanosConvenioPage.clicarBtnSubmenuRelatorioCarteirinhaPlanosConvenio();
        Log.info("Clicando em relatorio de carteirinha planos convenio");
    }

    @Then("^valida que o relatorio de carteirinha plano de convenio esta correto$")
    public void valida_que_o_relatorio_de_carteirinha_plano_de_convenio_esta_correto() throws Throwable {
        relatoriosPlanosConvenioPage.validarRelatorioCarteirinhaPlanoConvenio();
        Log.info("Validando que relatorio de carteirinha planos convenio esta correto");


    }

    @And("^clica em relatorio de plano de convenio validade$")
    public void clica_em_relatorio_de_plano_de_convenio_validade() throws Throwable {
        relatoriosPlanosConvenioPage.clicarBtnSubmenuRelatorioValidadePlanosConvenio();
        Log.info("Clicando em relatorio de validade planos convenio");

    }

    @Then("^valida que o relatorio de validade plano de convenio esta correto$")
    public void valida_que_o_relatorio_de_validade_plano_de_convenio_esta_correto() throws Throwable {
        relatoriosPlanosConvenioPage.validarRelatorioValidadePlanoConvenio();
        Log.info("Validando que relatorio de validade planos convenio esta correto");

    }


}