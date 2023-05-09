@RealizarAgendamentoComSucesso 
@Agenda
@CNN_00003

Feature: Agendamento consulta

  Scenario: CNN_00003_AgendamentoConsultaComSucesso
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para a agenda page
		And clica em novo agendamento
    And preenche os dados de agendamento
    And preenche procedimento
    And preenche a especialidade
    And clica em salvar
    Then realiza o agendamento com sucesso