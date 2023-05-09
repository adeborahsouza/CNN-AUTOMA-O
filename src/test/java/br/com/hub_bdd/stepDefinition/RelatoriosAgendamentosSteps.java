package br.com.hub_bdd.stepDefinition;

import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;

import br.com.hub_bdd.cucumber.TestContext;
import br.com.hub_bdd.pageObjects.RelatoriosAgendamentosPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class RelatoriosAgendamentosSteps {
    WebDriver driver;
    TestContext testContext;
    RelatoriosAgendamentosPage relatoriosAgendamentosPage;

    public RelatoriosAgendamentosSteps(TestContext context) {
        testContext = context;
        relatoriosAgendamentosPage = testContext.getPageObjectManager().getRelatoriosAgendamentos_Page();
    }

    @And("^clica em estoque$")
    public void clica_em_estoque() {
        relatoriosAgendamentosPage.clicarBtnMenuEstoque();
        Log.info("Clicando em estoque");

    }

    @And("^acessa o menu relatorios$")
    public void acessa_o_menu_relatorios() {
        relatoriosAgendamentosPage.clicarBtnMenuRelatorios();
        Log.info("Acessando o menu de relatorios");
    }

    @And("^acessa o submenu relatorios de agendamento$")
    public void acessa_o_submenu_relatorios_de_agendamento() {
        relatoriosAgendamentosPage.clicarSubMenuRelatoriosAgendamentos();
        Log.info("Acessando o submenu de relatorios de agendamentos");
    }

    @And("^clica em relatorios de agendamento por situacao$")
    public void clica_em_relatorios_de_agendamento_por_situacao() {
        relatoriosAgendamentosPage.clicarBtnRelatorioSituacaoAgendamento();
        Log.info("Clicando em relatorios de agendamento por situacao");
    }

    @And("^seleciona o periodo hoje$")
    public void seleciona_o_periodo_hoje() {
        relatoriosAgendamentosPage.selecionarPeriodoHoje();
        Log.info("Selecionando periodo no relatorio");
    }

    @And("^seleciona o periodo inicio do mes$")
    public void seleciona_o_periodo_inicio_do_mes() throws InterruptedException {
        relatoriosAgendamentosPage.selecionarPeriodoInicioMes();
        Log.info("Selecionando periodo no relatorio");
    }

    @And("^clica em baixar arquivo do relatorio$")
    public void clica_em_baixar_arquivo_do_relatorio() throws InterruptedException {
        relatoriosAgendamentosPage.clicarImprimirRelatorios();
        Log.info("Clicando em baixar arquivo do relatorio");
    }

    @Then("^valida que o relatorio de situacao do agendamento sintetico esta correto$")
    public void valida_que_o_relatorio_de_situacao_do_agendamento_sintetico_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioSituacaoAgendamentoSintetico();
        Log.info("Relatorio de situacao do agendamento sintetico esta correto");
    }

    @And("^seleciona a opcao analitico$")
    public void seleciona_a_opcao_analitico() throws InterruptedException {
        relatoriosAgendamentosPage.selecionarRelatorioAnalitico();
        Log.info("Selecionando a opcao relatorio analitico");
    }

    @And("^marco a opcao mostrar procedimentos$")
    public void marco_a_opcao_mostrar_procedimentos() {
        relatoriosAgendamentosPage.selecionarMostrarProcedimentos();
        Log.info("Marco a opcao mostrar procedimentos no relatorios");
    }

    @And("^marco a opcao mostrar valores$")
    public void marco_a_opcao_mostrar_valores() {
        relatoriosAgendamentosPage.selecionarMostrarValores();
        Log.info("Marco a opcao mostrar valores no relatorio");
    }

    @And("^marco a opcao observacao$")
    public void marco_a_opcao_observacao() {
        relatoriosAgendamentosPage.selecionarMostrarObservacao();
        Log.info("Marco a opcao exibir observacoes no relatorio");
    }

    @Then("^valida que o relatorio de situacao do agendamento analitico esta correto$")
    public void valida_que_o_relatorio_de_situacao_do_agendamento_analitico_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioSituacaoAgendamentoAnalitico();
        Log.info("Validando que o relatorio de situacao do agendamento analitico esta correto");
    }

    @And("^clica em relatorios de agendamento por plano de convenio$")
    public void clica_em_relatorios_de_agendamento_por_plano_de_convenio() {
        relatoriosAgendamentosPage.clicarRelatoriosAgendamentoPorPlanoConvenio();
        Log.info("Clicando em relatorios de agendamento por plano de convenio");
    }

    @And("^clica em relatorios de agendamento por agenda$")
    public void clica_em_relatorios_de_agendamento_por_agenda() {
        relatoriosAgendamentosPage.clicarRelatoriosAgendamentoPorAgenda();
        Log.info("Clicando em relatorios de agendamento por agenda");
    }

    @And("^seleciona um convenio no relatorio$")
    public void seleciona_um_convenio_no_relatorio() {
        relatoriosAgendamentosPage.selecionarConvenioRelatorioAgendamentosPorPlanoConvenio();
        Log.info("Selecionando um convenio em relatorios de agendamento por plano de convenio");
    }

    @And("^clica em relatorios de agendamento por criacao$")
    public void clica_em_relatorios_de_agendamento_por_criacao() {
        relatoriosAgendamentosPage.clicarRelatorioAgendamentoCriacao();
        Log.info("Clicando em relatorio de agendamento por criacao");
    }

    @And("^clica em relatorios de agendamento por procedimentos agendados$")
    public void clica_em_relatorios_de_agendamento_por_procedimentos_agendados() {
        relatoriosAgendamentosPage.clicarRelatorioAgendamentoPorProcedimentosAgendados();
        Log.info("Clicando em relatorio de agendamento por procedimentos agendados");
    }

//	@And("^clica em relatorios de agendamento por tempo de espera$")
//	public void clica_em_relatorios_de_agendamento_por_tempo_de_espera() {
//		relatoriosPage.clicarRelatorioAgendamentoTempoEspera();
//		Log.info("Clicando em relatorio de agendamento por tempo de espera");
//	}

    @And("^clica em relatorios de agendamento por cidade$")
    public void clica_em_relatorios_de_agendamento_por_cidade() {
        relatoriosAgendamentosPage.clicarRelatorioAgendamentoPorCidade();
        Log.info("Clicando em relatorio de agendamento por cidade");
    }

    @And("^clica em relatorios de agendamento com telefone do paciente$")
    public void clica_em_relatorios_de_agendamento_com_telefone_do_paciente() {
        relatoriosAgendamentosPage.clicarRelatorioAgendamentoTelefonePaciente();
        Log.info("Clicando em relatorio de agendamento com telefone do paciente");
    }

    @And("^clica em relatorios de agendamento por origem confirmacao$")
    public void clica_em_relatorios_de_agendamento_por_origem_confirmacao() {
        relatoriosAgendamentosPage.clicarRelatorioAgendamentoOrigemConfirmacao();
        Log.info("Clicando em relatorio de agendamento por origem de confirmação");
    }

    @And("^clica em relatorios de agendamento remarcacao$")
    public void clica_em_relatorios_de_agendamento_remarcacao() {
        relatoriosAgendamentosPage.clicarRelatorioAgendamentoRemarcacao();
        Log.info("Clicando em relatorio de agendamento remarcação");
    }

    @And("^clica em relatorios de agendamentos excluidos$")
    public void clica_em_relatorios_de_agendamentos_excluidos() {
        relatoriosAgendamentosPage.clicarRelatorioAgendamentosExcluidos();
        Log.info("Clicando em relatorio de agendamentos excluidos");
    }

    @And("^clica em relatorios de agendamento mensagens sms$")
    public void clica_em_relatorios_de_agendamento_mensagens_sms() {
        relatoriosAgendamentosPage.clicarRelatorioAgendamentoMensagensSMS();
        Log.info("Clicando em relatorio de agendamento mensagens sms");
    }

    @And("^clica em relatorios de agendamento por situacao dinamico$")
    public void clica_em_relatorios_de_agendamento_por_situacao_dinamico() {
        relatoriosAgendamentosPage.clicarRelatorioAgendamentoSituacaoDinamico();
        Log.info("Clicando em relatorio de agendamento por situação dinamico");
    }

    @And("^clica em pesquisar$")
    public void clica_em_pesquisar() {
        relatoriosAgendamentosPage.clicarPesquisarRelatorioAgendamentoDinamico();
        Log.info("Clicando em  pesaquisar");
    }

    @And("^clica em exportar para pdf$")
    public void clica_em_exportar_para_pdf() {
        relatoriosAgendamentosPage.clicarExportarPDF();
        Log.info("Clicando em  exportar para pdf");
    }

    @And("^clico em salvar relatorio$")
    public void clico_em_salvar_relatorio() {
        relatoriosAgendamentosPage.clicarSalvarRelatorio();
        Log.info("Clicando em  exportar para pdf");
    }

    @And("^clico em meus relatorios$")
    public void clico_em_meus_relatorios() throws InterruptedException {
        relatoriosAgendamentosPage.clicarEmMeusRelatorios();
        Log.info("Clicando em  meus relatorios");
    }

    @And("^clico em formatar celulas$")
    public void clico_em_formatar_celulas() {
        relatoriosAgendamentosPage.clicarFormatarCelulas();
        Log.info("Clicando em  formatar células");
    }

    @And("^clico em opçoes$")
    public void clico_em_opçoes() {
        relatoriosAgendamentosPage.clicarOpcoesRelatorioAgendamentos();
        Log.info("Clicando em  opcoes no relatorio de agendamentos");
    }

    @And("^clico em campos$")
    public void clico_em_campos() {
        relatoriosAgendamentosPage.clicarEmCamposRelatorioAgendamentos();
        Log.info("Clicando em  campos relatorios de agendamentos");
    }

    @Then("^valida que todos os botoes funcionam$")
    public void valida_que_todos_os_botoes_funcionam() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioAgendamentoSituacaoDinamico();
        Log.info("Validando que todos os botoes funcionam em relatorios de agendamento por situção dinamico");
    }

    @Then("^valida que o relatorio de agendamento mensagens sms esta correto$")
    public void valida_que_o_relatorio_de_agendamento_mensagens_sms_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioAgendamentoMensagensSMS();
        Log.info("Validando que o relatorio de agendamento mensagens sms esta correto");
    }

    @Then("^valida que o relatorio de agendamentos excluidos esta correto$")
    public void valida_que_o_relatorio_de_agendamentos_excluidos_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioAgendamentosExcluidos();
        Log.info("Validando que o relatorio de agendamentos excluidos esta correto");
    }

    @Then("^valida que o relatorio de agendamento remarcacao esta correto$")
    public void valida_que_o_relatorio_de_agendamento_remarcacao_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioAgendamentoRemarcacao();
        Log.info("Validando que o relatorio de agendamento remarcação esta correto");
    }

    @Then("^valida que o relatorio de agendamento por origem confirmacao foi baixado$")
    public void valida_que_o_relatorio_de_agendamento_por_origem_confirmacao_foi_baixado() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioAgendamentoOrigemConfirmacao();
        Log.info("Validando que o relatorio de agendamento por origem confirmação foi baixado");
    }

    @Then("^valida que o relatorio de agendamento com telefone do paciente esta correto$")
    public void valida_que_o_relatorio_de_agendamento_com_telefone_do_paciente_esta_correto()
            throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioAgendamentoTelefonePaciente();
        Log.info("Validando que o relatorio de agendamento com telefone do paciente esta correto");
    }

    @Then("^valida que o relatorio de criacao do agendamento sintetico esta correto$")
    public void valida_que_o_relatorio_de_criacao_do_agendamento_sintetico_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioCriacaoAgendamento();
        Log.info("Validando que o relatorio de criacao de agendamento esta correto");
    }

    @Then("^valida que o relatorio de criacao do agendamento analitico esta correto$")
    public void valida_que_o_relatorio_de_criacao_do_agendamento_analitico_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioCriacaoAgendamento();
        Log.info("Validando que o relatorio de criacao de agendamento analitico esta correto");
    }

    @Then("^valida que o relatorio do agendamento por plano de convenio esta correto$")
    public void valida_que_o_relatorio_do_agendamento_por_plano_de_convenio_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioAgendamentoPorPlanoConvenio();
        Log.info("Validando que o relatorio de criacao de agendamento por plano de convenio esta correto");
    }

    @Then("^valida que o relatorio de agendamento por agenda esta correto$")
    public void valida_que_o_relatorio_de_agendamento_por_agenda_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioPorAgenda();
        Log.info("Validando que o relatorio de criacao de agendamento por agenda esta correto");
    }

//	@Then("^valida que o relatorio do agendamento por tempo de espera esta correto$")
//	public void valida_que_o_relatorio_do_agendamento_por_tempo_de_espera_esta_correto() throws InterruptedException {
//		relatoriosPage.validarRelatorioPorTempoEseraSintetico();
//		Log.info("Validando que o relatorio de criacao de agendamento por tempo de espera esta correto");
//	}

    @Then("^valida que o relatorio de agendamento por procedimentos agendados esta correto$")
    public void valida_que_o_relatorio_de_agendamento_por_procedimentos_agendados_esta_correto()
            throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioPorProcedimentosAgendados();
        Log.info("Validando que o relatorio de criacao de agendamento por procedimentos agendados esta correto");
    }

    @Then("^valida que o relatorio de agendamento por cidade esta correto$")
    public void valida_que_o_relatorio_de_agendamento_por_cidade_esta_correto() throws InterruptedException {
        relatoriosAgendamentosPage.validarRelatorioPorCidade();
        Log.info("Validando que o relatorio de criacao de agendamento por cidade do agendamento esta correto");
    }

}
