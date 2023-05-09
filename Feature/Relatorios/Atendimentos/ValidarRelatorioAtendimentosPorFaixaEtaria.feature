@ValidarRelatorioAtendimentosFaixaEtaria
@Relatorios
@RelatoriosAtendimentos
@CNN_00043

Feature: Validar Relatorio Atendimentos Por Faixa Etaria

  Scenario: CNN_00043_ValidarRelatorioAtendimentosFaixaEtaria
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
    And clica em relatorio de atendimentos por faixa etaria
    And seleciona opcao Agrupar por tipo de consulta
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de atendimentos faixa etaria esta correto