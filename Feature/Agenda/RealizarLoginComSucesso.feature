@RealizarLoginComSucesso
@Login
@CNN_00001
Feature: Login no site

  Scenario: CNN_00001_LoginComFalha
   	Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    Then login e feito 