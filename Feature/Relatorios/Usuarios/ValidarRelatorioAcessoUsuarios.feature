@ValidarRelatorioAcessoUsuarios
@Relatorios
@RelatoriosUsuarios
@CNN_00079

Feature: Validar Relatorio Acesso Usuarios

  Scenario: CNN_00079_ValidarRelatorioAcessoUsuarios
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    And clica em estoque
    And acessa o menu relatorios
    And acessa o submenu relatorios de usuarios
    And clica em relatorio de acesso usuarios
    And seleciona primeiro usuario da lista
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de acesso usuarios esta correto