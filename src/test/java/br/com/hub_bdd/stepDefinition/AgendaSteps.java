package br.com.hub_bdd.stepDefinition;

import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;

import br.com.hub_bdd.cucumber.TestContext;
import br.com.hub_bdd.pageObjects.AgendaPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AgendaSteps {
	WebDriver driver;
	TestContext testContext;
	AgendaPage agendaPage;

	public AgendaSteps(TestContext context) {
		this.driver = driver;
		testContext = context;
		agendaPage = testContext.getPageObjectManager().getAgenda_Page();
	}

	@When("^navega para a agenda page$")
	public void navega_para_a_agenda_page() {
		agendaPage.btnMenuAgenda();
		agendaPage.btnSubMenuAgenda();
		Log.info("Navegando para a pagina de agenda");
	}

	@And("^clica em novo agendamento$")
	public void clica_em_novo_agendamento() {
		agendaPage.btnNovoAgendamento();
		Log.info("Clicando em novo agendamento");
	}

	@And("^preenche os dados de agendamento$")
	public void preenche_os_dados_de_agendamento() {
		agendaPage.procurarPaciente();
		agendaPage.selecionarPaciente();
		agendaPage.selecionarConvenio();
		agendaPage.selecionarProfissional();
		Log.info("Preenchendo os dados de login");

	}

	@Then("^realiza o agendamento com sucesso$")
	public void realiza_o_agendamento_com_sucesso() throws InterruptedException {
		agendaPage.agendamentoRealizadoComSucesso();
		Log.info("Agendamento foi realizado com sucesso");
	}

	@Then("^realize o agendamento com falha$")
	public void realiza_o_agendamento_com_falha() throws InterruptedException {
		agendaPage.agendamentoRealizadoComFalha();
		
	}

	@And("^preenche procedimento$")
	public void preenche_procedimento() {
		agendaPage.procurarProcedimento();
		Log.info("Preenchendo o procedimento no agendamento");
	}

	@And("^clica em salvar$")
	public void clica_em_salvar() {
		agendaPage.salvarAgendamento();
		Log.info("Clicando em salvar agendamento");
	}

	@And("^clica em salvar agendamento para relatorio$")
	public void clica_em_salvar_agendamento_para_relatorio() {
		agendaPage.salvarAgendamentoParaRelatorio();
		Log.info("Clicando em fechar agendamento");
	}

	@And("^valida alerta de especialidade obrigatoria$")
	public void valida_alerta_de_especialidade_obrigatoria() {
		agendaPage.alertaEspecialidadeObrigatoria();
		Log.info("Validando alerta de especialidade obrigatoria");
	}

	@And("^preenche a especialidade$")
	public void preenche_a_especialidade() {
		agendaPage.setarEspecialidade();
		Log.info("Preenchendo especialidade no agendamento");
	}

	@And("^clica em mais Procedimentos$")
	public void clica_em_mais_Procedimentos() {
		agendaPage.maisProcedimentos();
		Log.info("Clicando na aba de mais procedimentos em agendamento");
	}

	@And("^clica em importar orcamento$")
	public void clica_em_importar_orcamento() {
		agendaPage.clicarImportarOrcamento();
		Log.info("Clicando em importar orçamento no agendamento");
	}

	@And("^seleciona orçamento$")
	public void seleciona_orçamento() {
		agendaPage.selecionarOrcamento();
		Log.info("Seelcionando orçamento no agendamento");
	}

	@And("^clica em importar$")
	public void clica_em_importar() {
		agendaPage.clicarImportar();
		Log.info("Clicando em importar no agendamento");
	}

	@And("^clica em importar pacote$")
	public void clica_em_importar_pacote() {
		agendaPage.clicarImportarPacote();
		Log.info("Clicando em importar pacote no agendamento");
	}

	@And("^seleciona pacote$")
	public void seleciona_pacote() {
		agendaPage.buscarPacote();
		Log.info("Selecioando pacote no agendamento");
	}

	@And("^clica em importar plano de tratamento$")
	public void clica_em_importar_plano_de_tratamento() {
		agendaPage.clicarImportarPlanoTratamento();
		Log.info("Clicando em importar plano de tratamento no agendamento");
	}

	@And("^seleciona plano de tratamento$")
	public void seleciona_plano_de_tratamento() {
		agendaPage.selecionarPlanoTratamento();
		Log.info("Selecionando plano de tratamento no agendamento");
	}

	@And("^seleciona procedimentos do plano de tratamento$")
	public void seleciona_procedimentos_do_plano_de_tratamento() {
		agendaPage.selecionarProcedimentosPlanoTratamentoImportar();
		Log.info("Selecionando procedimentos do plano de tratamento");
	}

	@And("^clina na aba repetir$")
	public void clina_na_aba_repetir() {
		agendaPage.tabRepetir();
		Log.info("Clicando em repetir");
	}

	@And("^seleciona diariamente$")
	public void seleciona_diariamente() {
		agendaPage.repeticao();
		Log.info("Selecionando repetir diariamente");
	}

	@And("^configura termino repeticao$")
	public void configura_termino_repeticao() {
		agendaPage.terminarEm();
		Log.info("Configurando termino de repeticao");
	}

	@And("^clica em um agendamento existente$")
	public void clica_em_um_agendamento_existente() {
		agendaPage.agendamentoExistente();
		Log.info("Clicando em um agendamento existente");
	}

	@And("^clica em editar agendamento$")
	public void clica_em_editar_agendamento() {
		agendaPage.editarAgendamento();
		Log.info("Clicando em editar agendamento");
	}

	@And("^altera o profissional$")
	public void altera_o_profissional() {
		agendaPage.editarProfissional();
		Log.info("Alterando profissional do agendamento");
	}

	@And("^clica em salvar edicao agenda$")
	public void clica_em_salvar_edicao_agenda() {
		agendaPage.salvarAgendaEditada();
		Log.info("Salvando edicao de agenda");
	}

	@Then("^altera o agendamento com sucesso$")
	public void altera_o_agendamento_com_sucesso() {
		agendaPage.agendamentoAlteradoComSucesso();
		Log.info("Agendamento alterado com sucesso");
	}

	@And("^altera o convenio$")
	public void altera_o_convenio() {
		agendaPage.editarConvenio();
		Log.info("Alterando o convenio no agendamento");
	}

	@And("^clica em confirmar alteracao$")
	public void clica_em_confirmar_alteracao() {
		agendaPage.simConfirmarAlteracaoConvenio();
		Log.info("Clicando em confimar alteracao de agendamento");
	}

	@And("^preenche a especialidade em importar$")
	public void preenche_a_especialidade_em_importar() {
		agendaPage.setarEspecialidadeImportar();
		Log.info("Preenchendo a especialidade em importar");
	}

	@And("^altera o procedimento$")
	public void altera_o_procedimento() throws InterruptedException {
		agendaPage.alterarProcedimento();
		Log.info("Alterando o procedimento no agendamento");
	}

	@And("^clica em excluir agendamento$")
	public void clica_em_excluir_agendamento() {
		agendaPage.clicarExcluirAgendamenro();
		Log.info("Clicando em excluir agendamento");
	}

	@And("^confirma exclusao de agendamento$")
	public void confirma_exclusao_de_agendamento() {
		agendaPage.confirmarExcluirAgendamento();
		Log.info("Confirmando exclusao de agendamento");
	}

	@And("^clica em excluir somente esta$")
	public void clica_em_excluir_somente_esta() {
		agendaPage.clicarExcluirSomenteEsta();
		Log.info("Clicando em excluir somente esta agenda");
	}

	@Then("^valida que o agendamento foi excluido$")
	public void valida_que_o_agendamento_foi_excluido() throws InterruptedException {
		agendaPage.agendamentoExcluidoComSucesso();
		Log.info("Validando que o agendamento foi excluido");
	}

	@And("^clica na lista do status$")
	public void clica_na_lista_do_status() {
		agendaPage.clicarStatusAgendamento();
		Log.info("Clicando na lista de status de agendamento");
	}

	@And("^altera o status$")
	public void altera_o_status() {
		agendaPage.alterarStatusAgendamento();
		Log.info("Alterando status do agendamento");
	}

	@Then("^valida que o status foi alterado$")
	public void valida_que_o_status_foi_alterado() throws InterruptedException {
		agendaPage.statusAlterado();
		Log.info("Validando status de agendamento alterado");
	}

}
