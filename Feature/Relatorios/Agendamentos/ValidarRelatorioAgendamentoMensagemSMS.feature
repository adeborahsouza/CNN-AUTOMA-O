@ValidarRelatorioAgendamentoMensagensSMS
@Relatorios
@RelatoriosAgendamentos
@CNN_00037

Feature: Relatorio Agendamento Mensagens SMS

  Scenario: CNN_00037_ValidarRelatorioAgendamentoMensagensSMS
    Given usuario esta na login page
    When preencher os campos corretamente
    And clicar em entrar
    And login e feito
    #When navega para a agenda page
#		And clica em novo agendamento
    #And preenche os dados de agendamento
    #And preenche procedimento
    #And preenche a especialidade
    #And clica em salvar agendamento para relatorio
    And clica em estoque
    And acessa o menu relatorios
    And acessa o submenu relatorios de agendamento
    And clica em relatorios de agendamento mensagens sms
    And seleciona o periodo inicio do mes
    And clica em baixar arquivo do relatorio
    Then valida que o relatorio de agendamento mensagens sms esta correto