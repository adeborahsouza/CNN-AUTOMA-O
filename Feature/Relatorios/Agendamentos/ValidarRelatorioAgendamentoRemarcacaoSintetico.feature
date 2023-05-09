@ValidarRelatorioAgendamentoRemarcacaoSintetico
@Relatorios
@RelatoriosAgendamentos
@CNN_00034

Feature: Relatorio Agendamento Remarcacao Sintetico

  Scenario: CNN_00034_ValidarRelatorioAgendamentoRemarcacaoSintetico
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
    And clica em relatorios de agendamento remarcacao
    And seleciona o periodo inicio do mes
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de agendamento remarcacao esta correto