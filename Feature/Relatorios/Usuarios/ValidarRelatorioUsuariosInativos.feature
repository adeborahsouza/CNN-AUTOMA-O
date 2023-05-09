@ValidarRelatorioUsuariosInativos
@Relatorios
@RelatoriosUsuarios
@CNN_00078

Feature: Validar Relatorio Usuarios Inativos

  Scenario: CNN_00078_ValidarRelatorioUsuariosInativos
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    And clica em estoque
    And acessa o menu relatorios
    And acessa o submenu relatorios de usuarios
    And clica em relatorio de usuarios
    And seleciona opcao Inativos em relatorio de usuarios
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de usuarios ativos esta correto