@ValidarRelatorioCarteirinhasPlanoConvenio
@Relatorios
@RelatoriosPlanosConvenio
@CNN_00084

Feature: Validar Relatorio Carteirinhas Plano Convenio

    Scenario: CNN_00084_ValidarRelatorioCarteirinhasPlanoConvenio
        Given usuario esta na login page
        When preencher os campos corretamente
        And clicar em entrar
        And login e feito
        And clica em estoque
        And acessa o menu relatorios
        And acessa o submenu relatorios de planos de convenio
        And clica em relatorio de carteirinhas por plano de convenio
        And seleciona um convenio no relatorio
        And clica em baixar arquivo do relatorio
        Then valida que o relatorio de carteirinha plano de convenio esta correto