package br.com.hub_bdd.stepDefinition;

import br.com.hub_bdd.cucumber.TestContext;
import br.com.hub_bdd.pageObjects.RelatoriosAgendamentosPage;
import br.com.hub_bdd.pageObjects.RelatoriosAtendimentosPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;

public class RelatoriosAtendimentosSteps {
    WebDriver driver;
    TestContext testContext;
    RelatoriosAtendimentosPage relatoriosAtendimentosPage;

    public RelatoriosAtendimentosSteps(TestContext context) {
        testContext = context;
        relatoriosAtendimentosPage = testContext.getPageObjectManager().getRelatoriosAtendimentos_Page();
    }

    @And("^acessa o submenu relatorios de atendimentos$")
    public void acessa_o_submenu_relatorios_de_atendimentos() {
        relatoriosAtendimentosPage.clicarBtnSubmenuRelatorioAtendimentos();
        Log.info("Clicando em relatorio de atendimentos");

    }
//
//    @And("^clica em relatorio de atendimentos finalizados$")
//    public void clica_em_relatorio_de_atendimentos_finalizados() {
//        relatoriosAtendimentosPage.clicarRelatoroAtendimentosFinalizados();
//        Log.info("Clicando em relatorio de atendimentos finalizados");
//
//    }
//
//    @And("^seleciona o primeiro convenio da lista$")
//    public void seleciona_o_primeiro_convenio_da_lista() {
//        relatoriosAtendimentosPage.clicarPrimeiroConvenioLista();
//        Log.info("Clicando no primeiro convenio da lista");
//
//    }
//
//    @And("^seleciona o primeiro profissional da lista$")
//    public void seleciona_o_primeiro_profissional_da_lista() {
//        relatoriosAtendimentosPage.clicarPrimeiroProfissionalLista();
//        Log.info("Clicando no primeiro profissional da lista");
//
//    }


    @And("^clica em relatorio de atendimentos duracao consulta sintetico$")
    public void clica_em_relatorio_de_atendimentos_duracao_consulta_sintetico() throws Throwable {
        relatoriosAtendimentosPage.clicarBtnSubmenuRelatorioAtendimentosDuracaoConsulta();
        Log.info("Clicando em relatorio de atendimentos");

    }

    @And("^seleciona o primeiro profissional da lista$")
    public void seleciona_o_primeiro_profissional_da_lista() throws Throwable {
        relatoriosAtendimentosPage.clicarPrimeiroProfissionalLista();
        Log.info("selecionando primeiro profissional da lista");
    }

    @And("^clica em relatorio de atendimentos por tipo de atendimento$")
    public void clica_em_relatorio_de_atendimentos_por_tipo_de_atendimento() throws Throwable {
        relatoriosAtendimentosPage.clicarRelatorioAtendimentosTipoAtendimento();
        Log.info("clicando em relatorio de atendimentos por tipo de atendimento");
    }

    @And("^clica em relatorio de atendimentos por faixa etaria$")
    public void clica_em_relatorio_de_atendimentos_por_faixa_etaria() throws Throwable {
        relatoriosAtendimentosPage.clicarRelatorioAtendimentosFaixaEtaria();
        Log.info("clicando em relatorio de atendimentos por faixa etaria");
    }

    @And("^seleciona opcao Agrupar por tipo de consulta$")
    public void seleciona_opcao_Agrupar_por_tipo_de_consulta() throws Throwable {
        relatoriosAtendimentosPage.SelecionarOpcaoAgruparTipoConsulta();
        Log.info("selecionando opcao Agrupar por tipo de consulta");
    }

    @And("^clica em relatorio de atendimentos por CID diagnostico$")
    public void clica_em_relatorio_de_atendimentos_por_CID_diagnostico() throws Throwable {
        relatoriosAtendimentosPage.ClicarRelatorioAtendimentosCIDDiagnostico();
        Log.info("clicando relatorio de atendimento CID diagnostico");
    }

    @And("^seleciona um CID em relatorio de atendimento$")
    public void seleciona_um_CID_em_relatorio_de_atendimento() throws Throwable {
        relatoriosAtendimentosPage.SelecionarUmCIDDiagnostico();
        Log.info("selecionando um cid diagnostico");
    }

    @And("^clica em relatorio de escalas de atendimento$")
    public void clica_em_relatorio_de_escalas_de_atendimento() throws Throwable {
        relatoriosAtendimentosPage.ClicarRelatorioEscalaAtendimento();
        Log.info("clicando relatorio escala de atendimento");
    }

    @And("^clica em relatorio de extrato de teleconsulta$")
    public void clica_em_relatorio_de_extrato_de_teleconsulta() throws Throwable {
        relatoriosAtendimentosPage.ClicarRelatorioExtratoTeleconsulta();
        Log.info("clicando relatorio extrato de teleconsulta");
    }

    @Then("^valida que o relatorio de extratode teleconsulta esta correto$")
    public void valida_que_o_relatorio_de_extratode_teleconsulta_esta_correto() throws Throwable {
        relatoriosAtendimentosPage.ValidarRelatorioExtratoTeleconsulta();
        Log.info("validando relatorio extrato de teleconsulta esta correto");
    }

    @Then("^valida que o relatorio de atendimentos CID diagnostico esta correto$")
    public void valida_que_o_relatorio_de_atendimentos_CID_diagnostico_esta_correto() throws Throwable {
        relatoriosAtendimentosPage.validarRelatorioAtendimentosCIDDiagnostico();
        Log.info("Validando que relatorio de atendimentos CID diagnostico esta correto");
    }

    @Then("^valida que o relatorio de atendimentos duracao consulta esta correto$")
    public void valida_que_o_relatorio_de_atendimentos_duracao_consulta_esta_correto() throws Throwable {
        relatoriosAtendimentosPage.validarRelatorioAtendimentosDuracaoConsulta();
        Log.info("Validando que relatorio de atendimentos por duração da consulta esta correto");
    }

    @Then("^valida que o relatorio de atendimentos duracao consulta analitico esta correto$")
    public void valida_que_o_relatorio_de_atendimentos_duracao_consulta_analitico_esta_correto() throws Throwable {
        relatoriosAtendimentosPage.validarRelatorioAtendimentosDuracaoConsultaAnalitico();
        Log.info("Validando que relatorio de atendimentos por duração da consulta analitico por duracao");
    }

    @Then("^valida que o relatorio de atendimentos tipo atendimento esta correto$")
    public void valida_que_o_relatorio_de_atendimentos_tipo_atendimento_esta_correto() throws Throwable {
        relatoriosAtendimentosPage.validarRelatorioAtendimentosTipoAtendimento();
        Log.info("Validando que relatorio de atendimentos por tipo atendimento esta correto");
    }

    @Then("^valida que o relatorio de atendimentos faixa etaria esta correto$")
    public void valida_que_o_relatorio_de_atendimentos_faixa_etaria_esta_correto() throws Throwable {
        relatoriosAtendimentosPage.validarRelatorioAtendimentosFaixaEtaria();
        Log.info("Validando que relatorio de atendimentos por faixa etaria esta correto");
    }

    @Then("^valida que o relatorio de escalas de atendimento esta correto$")
    public void valida_que_o_relatorio_de_escalas_de_atendimento_esta_correto() throws Throwable {
        relatoriosAtendimentosPage.validarRelatorioEscalaAtendimento();
        Log.info("Validando que relatorio de escala de atendimentos esta correto");
    }
}
