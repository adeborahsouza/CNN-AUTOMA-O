@RealizarAgendamentoComRepeticaoDiariamente 
@Agenda
@CNN_00009

Feature: Agendamento consulta

  Scenario: CNN_00009_RealizarAgendamentoComRepeticaoDiariamente
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para a agenda page
		And clica em novo agendamento
    And preenche os dados de agendamento
    And preenche procedimento 
    And preenche a especialidade
    And clina na aba repetir
    And seleciona diariamente
    And configura termino repeticao
    And clica em salvar
    Then realiza o agendamento com sucesso