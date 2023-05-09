package br.com.hub_bdd.runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import br.com.hub_bdd.managers.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", glue = "br.com.hub_bdd.stepDefinition", tags = {
        "@RelatoriosDietas"}, plugin = {
        "com.cucumber.listener.ExtentCucumberFormatter:evidencias/report.html"})

public class TestRunner {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    }

}