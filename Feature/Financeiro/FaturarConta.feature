@FaturarConta
@Financeiro
@CNN_00017

Feature: Faturar conta

  Scenario: CNN_00017_FaturarConta
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para o financeiro page
		And clica em operacoes
		And clica no submenu faturar
		And clica em faturar primeira conta disponivel
		And clica em salvar faturamento
    Then valida que conta foi faturada com sucesso