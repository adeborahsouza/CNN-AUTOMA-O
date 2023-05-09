@ValidaAlertaAgendamentoProcedimentoEspecialidadeObrigatorio
@Agenda
@CNN_00005

Feature: Agendamento consulta

  Scenario: CNN_00005_ValidaAlertaAgendamentoProcedimentoEspecialidadeObrigatorio
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    When navega para a agenda page
		And clica em novo agendamento
    And preenche os dados de agendamento
    And preenche procedimento 
    And clica em salvar
    And valida alerta de especialidade obrigatoria
    And preenche a especialidade
    And clica em salvar
    Then realiza o agendamento com sucesso