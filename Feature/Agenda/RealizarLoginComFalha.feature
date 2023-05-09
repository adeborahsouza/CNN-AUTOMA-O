@RealizarLoginComFalha
@Login
@CNN_00002
Feature: Login no site

  Scenario: CNN_00002_LoginComFalha
   	Given usuario esta na login page
    When preencher os campos incorretamente
    And clicar em entrar
    Then login nao e feito 