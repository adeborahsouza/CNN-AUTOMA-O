@ValidarRelatorioAgendamentoSituacaoDinamico
@Relatorios
@RelatoriosAtendimentos
@CNN_00038

Feature: Relatorio Agendamento Situacao Dinamico

  Scenario: CNN_00038_ValidarRelatorioAgendamentoSituacaoDinamico
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
#    When navega para a agenda page
#    And clica em novo agendamento
#    And preenche os dados de agendamento
#    And preenche procedimento
#    And preenche a especialidade
#    And clica em salvar agendamento para relatorio
    And clica em estoque
    And acessa o menu relatorios
    And acessa o submenu relatorios de agendamento
    And clica em relatorios de agendamento por situacao dinamico
    And seleciona o periodo inicio do mes
    And clica em pesquisar
    And clica em exportar para pdf
    And clico em salvar relatorio
    And clico em meus relatorios
    And clico em formatar celulas
    And clico em opçoes
    And clico em campos
    And clico em campos
    Then valida que todos os botoes funcionam