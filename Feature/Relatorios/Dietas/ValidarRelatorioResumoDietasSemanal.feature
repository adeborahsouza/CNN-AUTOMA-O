@ValidarRelatorioResumoDietasSemanal
@Relatorios
@RelatoriosDietas
@CNN_00097

Feature: Validar Relatorio Resumo Dietas Semanal

    Scenario: CNN_00097_ValidarRelatorioResumoDietasSemanal
        Given usuario esta na login page
        When preencher os campos corretamente
        And clicar em entrar
        And login e feito
        And clica em estoque
        And acessa o menu relatorios
        And acessa o submenu relatorios de dietas
        And clica em relatorio resumo dietas semanal
        And clica em baixar arquivo do relatorio
        Then valida que o relatorio resumo de dietas semanal esta correto