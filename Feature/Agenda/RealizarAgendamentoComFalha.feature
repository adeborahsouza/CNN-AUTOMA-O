@RealizarAgendamentoComFalha
@Agenda
@CNN_00004

Feature: Agendamento consulta

  Scenario: CNN_00004_AgendamentoConsultaComFalha
   	Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para a agenda page
    And clica em novo agendamento
    And preenche os dados de agendamento incorretamente
    Then realize o agendamento com falha
