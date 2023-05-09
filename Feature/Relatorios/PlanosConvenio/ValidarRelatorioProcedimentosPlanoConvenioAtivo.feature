@ValidarRelatorioProcedimentosPlanoConvenioAtivo
@Relatorios
@RelatoriosPlanosConvenio
@CNN_00080

Feature: Validar Relatorio Procedimentos Plano Convenio

    Scenario: CNN_00080_ValidarRelatorioProcedimentosPlanoConvenio
        Given usuario esta na login page
        When preencher os campos corretamente
        And clicar em entrar
        And login e feito
        And clica em estoque
        And acessa o menu relatorios
        And acessa o submenu relatorios de planos de convenio
        And clica em relatorio de procedimentos por plano de convenio
        And seleciona um convenio no relatorio
        And seleciona opcao Ativos em relatorio de procedimentos por plano convenio
        And clica em baixar arquivo do relatorio
        Then valida que o relatorio de procedimentos plano de convenio ativos esta correto