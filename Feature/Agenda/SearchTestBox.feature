Feature: Pesquisa pela lupa

  Scenario: Pesquisa lupa com sucesso
    Given Usuario esta na home page
    When procurar por um produto existente na lupa
    Then pesquisa e feita

  Scenario: Pesquisa lupa com Falha
    Given Usuario esta na home page
    When procurar por um produto inexistente na lupa
    Then  pesquisa nao e feita
