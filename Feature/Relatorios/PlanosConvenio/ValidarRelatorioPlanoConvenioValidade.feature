@ValidarRelatorioPlanoConvenioValidade
@Relatorios
@RelatoriosPlanosConvenio
@CNN_00083

Feature: Validar Relatorio Plano Convenio Validade

    Scenario: CNN_00083_ValidarRelatorioDadosPlanoConvenio
        Given usuario esta na login page
        When preencher os campos corretamente
        And clicar em entrar
        And login e feito
        And clica em estoque
        And acessa o menu relatorios
        And acessa o submenu relatorios de planos de convenio
        And clica em relatorio de plano de convenio validade
        And seleciona o periodo inicio do mes
        And clica em baixar arquivo do relatorio
        Then valida que o relatorio de validade plano de convenio esta correto