@ValidarRelatorioDietasSemana
@Relatorios
@RelatoriosDietas
@CNN_00096

Feature: Validar Relatorio Dietas Semana

    Scenario: CNN_00096_ValidarRelatorioDietasSemana
        Given usuario esta na login page
        When preencher os campos corretamente
        And clicar em entrar
        And login e feito
        And clica em estoque
        And acessa o menu relatorios
        And acessa o submenu relatorios de dietas
        And clica em relatorio de dietas da semana
        And clica em baixar arquivo do relatorio
        Then valida que o relatorio de dietas da semana esta correto