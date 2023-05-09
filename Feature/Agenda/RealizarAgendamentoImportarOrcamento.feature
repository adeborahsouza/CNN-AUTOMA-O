@RealizarAgendamentoImportarOrcamento
@Agenda
@CNN_00006

Feature: Agendamento consulta

  Scenario: CNN_00006_RealizarAgendamentoImportarOrcamento
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para a agenda page
		And clica em novo agendamento
    And preenche os dados de agendamento
    And clica em mais Procedimentos
    And clica em importar orcamento
    And seleciona orçamento
    And clica em importar
    And preenche a especialidade em importar
    And clica em salvar
    Then realiza o agendamento com sucesso