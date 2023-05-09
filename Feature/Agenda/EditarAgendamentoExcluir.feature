@EditarAgendamentoExcluir
@Agenda
@CNN_00013

Feature: Agendamento consulta

  Scenario: CNN_00013_EditarAgendamentoExcluir
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para a agenda page
		And clica em um agendamento existente
		And clica em editar agendamento
		And clica em excluir agendamento
		And clica em excluir somente esta
		And confirma exclusao de agendamento
    Then valida que o agendamento foi excluido