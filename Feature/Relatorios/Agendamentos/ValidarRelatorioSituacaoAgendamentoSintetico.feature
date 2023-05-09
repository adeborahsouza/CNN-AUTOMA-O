@ValidarRelatorioSituacaoAgendamentoSintetico 
@Relatorios
@RelatoriosAgendamentos
@CNN_00020

Feature: Relatorio Situacao Agendamento Sintetico

  Scenario: CNN_00020_ValidarRelatorioSituacaoAgendamentoSintetico
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    #When navega para a agenda page
#		And clica em novo agendamento
    #And preenche os dados de agendamento
    #And preenche procedimento
    #And preenche a especialidade
    #And clica em salvar agendamento para relatorio
    And clica em estoque
    And acessa o menu relatorios
    And acessa o submenu relatorios de agendamento
    And clica em relatorios de agendamento por situacao
    And seleciona o periodo hoje
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de situacao do agendamento sintetico esta correto