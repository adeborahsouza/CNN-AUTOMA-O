package br.com.hub_bdd.managers;

import br.com.hub_bdd.pageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;

    private HomePage homePage;

    private AgendaPage agendaPage;

    private RelatoriosAgendamentosPage relatoriosAgendamentosPage;

    private RelatoriosAtendimentosPage relatoriosAtendimentosPage;

    private LoginPage loginPage;

    private FinanceiroPage financeiroPage;

    private RelatoriosUsuariosPage relatoriosUsuariosPage;

    private RelatoriosPlanosConvenioPage relatoriosPlanosConvenioPage;

    private RelatoriosDietasPage relatoriosDietasPage;



    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }

    public HomePage getHome_Page() {

        return (homePage == null) ? homePage = new HomePage(driver) : homePage;

    }

    public LoginPage getLogin_Page() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public AgendaPage getAgenda_Page() {
        return (agendaPage == null) ? agendaPage = new AgendaPage(driver) : agendaPage;
    }

    public RelatoriosAgendamentosPage getRelatoriosAgendamentos_Page() {
        return (relatoriosAgendamentosPage == null)
                ? relatoriosAgendamentosPage = new RelatoriosAgendamentosPage(driver)
                : relatoriosAgendamentosPage;
    }

    public FinanceiroPage getFinanceiro_Page() {
        return (financeiroPage == null) ? financeiroPage = new FinanceiroPage(driver) : financeiroPage;
    }

    public RelatoriosAtendimentosPage getRelatoriosAtendimentos_Page() {
        return (relatoriosAtendimentosPage == null)
                ? relatoriosAtendimentosPage = new RelatoriosAtendimentosPage(driver)
                : relatoriosAtendimentosPage;
    }

    public RelatoriosUsuariosPage getRelatoriosUsuarios_Page() {
        return (relatoriosUsuariosPage == null)
                ? relatoriosUsuariosPage = new RelatoriosUsuariosPage(driver)
                : relatoriosUsuariosPage;
    }

    public RelatoriosPlanosConvenioPage getRelatoriosPlanosConvenio_Page() {
        return (relatoriosPlanosConvenioPage == null)
                ? relatoriosPlanosConvenioPage = new RelatoriosPlanosConvenioPage(driver)
                : relatoriosPlanosConvenioPage;
    }
    public RelatoriosDietasPage getRelatoriosDietas_Page() {
        return (relatoriosDietasPage == null)
                ? relatoriosDietasPage = new RelatoriosDietasPage(driver)
                : relatoriosDietasPage;
    }
}
