@ValidarRelatorioSituacaoAgendamentoAnalitico
@Relatorios
@RelatoriosAgendamentos
@CNN_00021

Feature: Relatorio Situacao Agendamento Analitico

  Scenario: CNN_00021_ValidarRelatorioSituacaoAgendamentoAnalitico
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
    And seleciona a opcao analitico
    And marco a opcao mostrar procedimentos
    And marco a opcao mostrar valores
    And marco a opcao observacao
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de situacao do agendamento analitico esta correto