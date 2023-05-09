@ValidarRelatorioDietasDia
@Relatorios
@RelatoriosDietas
@CNN_00095

Feature: Validar Relatorio Dietas Dia

    Scenario: CNN_00095_ValidarRelatorioDietasDia
        Given usuario esta na login page
        When preencher os campos corretamente
        And clicar em entrar
        And login e feito
        And clica em estoque
        And acessa o menu relatorios
        And acessa o submenu relatorios de dietas
        And clica em relatorio de dietas do dia
        And clica em baixar arquivo do relatorio
        Then valida que o relatorio de dietas do dia esta correto