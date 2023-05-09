@ValidarRelatorioAtendimentosEscalaAtendimento
@Relatorios
@RelatoriosAtendimentos
@CNN_00046

Feature: Validar Relatorio Atendimentos Escala Atendimento

  Scenario: CNN_00046_ValidarRelatorioAtendimentosEscalaAtendimento
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    #When navega para a agenda page
    #And clica em novo agendamento
    #And preenche os dados de agendamento
    #And preenche procedimento
    #And preenche a especialidade
    #And clica em salvar agendamento para relatorio
    And clica em estoque
    And acessa o menu relatorios
    And acessa o submenu relatorios de atendimentos
    And clica em relatorio de escalas de atendimento
    And seleciona o primeiro profissional da lista
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de escalas de atendimento esta correto