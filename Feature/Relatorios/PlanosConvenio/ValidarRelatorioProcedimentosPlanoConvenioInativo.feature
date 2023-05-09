@ValidarRelatorioProcedimentosPlanoConvenioAtivo
@Relatorios
@RelatoriosPlanosConvenio
@CNN_00081

Feature: Validar Relatorio Procedimentos Plano Convenio Inativo

    Scenario: CNN_00081_ValidarRelatorioProcedimentosPlanoConvenioInativo
        Given usuario esta na login page
        When preencher os campos corretamente
        And clicar em entrar
        And login e feito
        And clica em estoque
        And acessa o menu relatorios
        And acessa o submenu relatorios de planos de convenio
        And clica em relatorio de procedimentos por plano de convenio
        And seleciona um convenio no relatorio
        And seleciona opcao Inativos em relatorio de procedimentos por plano convenio
        And clica em baixar arquivo do relatorio
        Then valida que o relatorio de procedimentos plano de convenio ativos esta correto