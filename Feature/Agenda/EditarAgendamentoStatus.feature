@EditarAgendamentoConvenio 
@Agenda
@CNN_00015

Feature: Agendamento consulta

  Scenario: CNN_00015_EditarAgendamentoStatus
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para a agenda page
		And clica em um agendamento existente
		And clica na lista do status
		And altera o status
		Then valida que o status foi alterado