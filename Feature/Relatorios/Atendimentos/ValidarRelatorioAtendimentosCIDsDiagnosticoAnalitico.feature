@ValidarRelatorioAtendimentosCIDsDiagnosticoAnalitico
@Relatorios
@RelatoriosAtendimentos
@CNN_00045

Feature: Validar Relatorio Atendimentos CIDs Diagnostico Analitico

  Scenario: CNN_00045_ValidarRelatorioAtendimentosCIDsDiagnosticoAnalitico
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
    And clica em relatorio de atendimentos por CID diagnostico
    And seleciona o periodo inicio do mes
    And seleciona a opcao analitico
    And seleciona um CID em relatorio de atendimento
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de atendimentos CID diagnostico esta correto