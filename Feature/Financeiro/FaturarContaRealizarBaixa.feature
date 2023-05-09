@FaturarConta
@Financeiro
@CNN_00019

Feature: Faturar conta

  Scenario: CNN_00019_FaturarContaRealizarBaixa
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
    And clica em baixar no modal de faturamento
    And clica em baixar na tela de faturamento
    Then valida que a baixa foi realizada com sucesso