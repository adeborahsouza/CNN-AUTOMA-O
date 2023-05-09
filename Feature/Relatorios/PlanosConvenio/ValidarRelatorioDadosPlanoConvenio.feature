@ValidarRelatorioDadosPlanoConvenio
@Relatorios
@RelatoriosPlanosConvenio
@CNN_00082

Feature: Validar Relatorio Dados Plano Convenio

    Scenario: CNN_00082_ValidarRelatorioDadosPlanoConvenio
        Given usuario esta na login page
        When preencher os campos corretamente
        And clicar em entrar
        And login e feito
        And clica em estoque
        And acessa o menu relatorios
        And acessa o submenu relatorios de planos de convenio
        And clica em relatorio de dados por plano de convenio
        And seleciona o periodo inicio do mes
        And seleciona um convenio no relatorio
        And clica em baixar arquivo do relatorio
        Then valida que o relatorio de dados plano de convenio esta correto