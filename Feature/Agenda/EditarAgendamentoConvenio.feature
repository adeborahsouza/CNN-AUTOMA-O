@EditarAgendamentoConvenio 
@Agenda
@CNN_00011

Feature: Agendamento consulta

  Scenario: CNN_00011_EditarAgendamentoConvenio
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para a agenda page
		And clica em um agendamento existente
		And clica em editar agendamento
		And altera o convenio
		And clica em confirmar alteracao
    And clica em salvar edicao agenda
    Then altera o agendamento com sucesso