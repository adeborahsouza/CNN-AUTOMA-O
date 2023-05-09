@RealizarAgendamentoImportarPlanoDeTratamento
@Agenda
@CNN_00008

Feature: Agendamento consulta

  Scenario: CNN_00008_RealizarAgendamentoImportarPlanoDeTratamento
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para a agenda page
		And clica em novo agendamento
    And preenche os dados de agendamento
    And clica em mais Procedimentos
    And clica em importar plano de tratamento
    And seleciona plano de tratamento
    And seleciona procedimentos do plano de tratamento
    And clica em importar
    And preenche a especialidade em importar
    And clica em salvar
    Then realiza o agendamento com sucesso