package br.com.hub_bdd.stepDefinition;

import br.com.hub_bdd.cucumber.TestContext;
import br.com.hub_bdd.pageObjects.RelatoriosUsuariosPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.mortbay.log.Log;
import org.openqa.selenium.WebDriver;

public class RelatoriosUsuariosSteps {
    WebDriver driver;
    TestContext testContext;
    RelatoriosUsuariosPage relatoriosUsuariosPage;

    public RelatoriosUsuariosSteps(TestContext context) {
        testContext = context;
        relatoriosUsuariosPage = testContext.getPageObjectManager().getRelatoriosUsuarios_Page();
    }

//    @And("^acessa o submenu relatorios de atendimentos$")
//    public void acessa_o_submenu_relatorios_de_atendimentos() {
//        relatoriosUsuariosPage.clicarBtnSubmenuRelatorioAtendimentos();
//        Log.info("Clicando em relatorio de atendimentos");
//
//    }


    @And("^acessa o submenu relatorios de usuarios$")
    public void acessa_o_submenu_relatorios_de_usuarios() throws Throwable {
        relatoriosUsuariosPage.acessarSubmenuRelatorioUsuarios();
        Log.info("Acessando relatorios de usuarios");
    }

    @And("^clica em relatorio de usuarios$")
    public void clica_em_relatorio_de_usuarios() throws Throwable {
        relatoriosUsuariosPage.clicarRelatorioUsuarios();
        Log.info("Clicando no relatorios de usuarios");
    }

//    @And("^seleciona opcao Ativos$")
//    public void seleciona_opcao_Ativos() throws Throwable {
//        relatoriosUsuariosPage.selecionarOpcaoAtivos();
//        Log.info("Selecioando opcao usuarios ativos");
//    }

//    @And("^seleciona opcao Inativos")
//    public void seleciona_opcao_Inativos() throws Throwable {
//        relatoriosUsuariosPage.selecionarOpcaoInativos();
//        Log.info("Selecioando opcao usuarios inativos");
//    }

    @Then("^valida que o relatorio de usuarios ativos esta correto$")
    public void valida_que_o_relatorio_de_usuarios_ativos_esta_correto() throws Throwable {
        relatoriosUsuariosPage.validarRelatorioUsuariosAtivos();
        Log.info("Validando relatorios de usuarios ativos");
    }

    @And("^clica em relatorio de acesso usuarios$")
    public void clica_em_relatorio_de_acesso_usuarios() throws Throwable {
        relatoriosUsuariosPage.clicarRelatorioAcessoUsuarios();
        Log.info("Clicando relatorio de acessos de usuario");
    }

    @And("^seleciona primeiro usuario da lista$")
    public void seleciona_primeiro_usuario_da_lista() throws Throwable {
        relatoriosUsuariosPage.selecionarPrimeiroUsuarioLista();
        Log.info("Selecionando primeiro usuario da lista");;
    }

    @And("^seleciona opcao Ativos em relatorio de usuarios$")
    public void seleciona_opcao_Ativos_em_relatorio_de_usuarios() throws Throwable {
        relatoriosUsuariosPage.selecionarOpcaoAtivos();
        Log.info("Clicando na opcao ativo em procedimentos de plano de convenio");;
    }

    @And("^seleciona opcao Inativos em relatorio de usuarios$")
    public void seleciona_opcao_Inativos_em_relatoriode_usuarios() throws Throwable {
        relatoriosUsuariosPage.selecionarOpcaoInativos();
        Log.info("Clicando na opcao inativo em procedimentos de plano de convenio");
    }

    @Then("^valida que o relatorio de acesso usuarios esta correto$")
    public void valida_que_o_relatorio_de_acesso_usuarios_esta_correto() throws Throwable {
        relatoriosUsuariosPage.validarRelatorioAcessoUsuarios();
        Log.info("Validando relatorios acessos de usuario");
    }
}
