@ValidarRelatorioUsuariosAtivos
@Relatorios
@RelatoriosUsuarios
@CNN_00077

Feature: Validar Relatorio Usuarios Ativos

  Scenario: CNN_00077_ValidarRelatorioUsuariosAtivos
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    And clica em estoque
    And acessa o menu relatorios
    And acessa o submenu relatorios de usuarios
    And clica em relatorio de usuarios
    And seleciona opcao Ativos em relatorio de usuarios
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de usuarios ativos esta correto