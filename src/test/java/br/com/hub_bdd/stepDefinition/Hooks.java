package br.com.hub_bdd.stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import br.com.hub_bdd.cucumber.TestContext;
import br.com.hub_bdd.managers.AddHeaderToImage;
import br.com.hub_bdd.managers.WebDriverManager;
import br.com.hub_bdd.selenium.Wait;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	WebDriver driver;
	TestContext testContext;
	WebDriverManager manager;

	public Hooks(TestContext context) {
		testContext = context;
		manager = testContext.getWebDriverManager();
		driver = manager.getDriver();
	}

	@Before
	public void BeforeSteps() {
		manager.getDriver();
	}

	@After(order = 1)
	public void afterScenarioReport(Scenario scenario) throws IOException, InterruptedException {
		Wait.waitForPageLoad(driver);
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);

		String screenshotName = scenario.getName().replaceAll(" ", "_");
		File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
				.getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir") + "/target/" + screenshotName + ".png");

		Files.copy(sourcePath, destinationPath);

		Reporter.addScreenCaptureFromPath(destinationPath.toString());
	}

	@After(order = 2)
	public void afterScenario(Scenario scenario) throws IOException, InterruptedException {
		// Espera a página carregar completamente
		Wait.waitForPageLoad(driver);
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);

		Thread.sleep(3000);
		// Define o nome do arquivo de captura de tela como o nome do cenário com
		// espaços substituídos por underscores
		// importando o timestamp do JAVA e adicionando + ao nome do print
		String screenshotTimestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + screenshotTimestamp;

		// Tira a captura de tela da página atual
		File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
				.getScreenshotAs(OutputType.FILE);

		// Define o caminho da pasta de evidências do cenário como "evidencias/[success
		// ou failure]/[nome do cenário com espaços substituídos por underscores]"
		LocalDate currentDate = LocalDate.now();
		String currentDateFormatted = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String screenshotsFolderPath = System.getProperty("user.dir") + "/evidencias/" + currentDateFormatted;

		String scenarioResultFolderName = scenario.isFailed() ? "failure" : "success";
		String scenarioFolderPath = screenshotsFolderPath + "/" + scenarioResultFolderName + "/"
				+ scenario.getName().replaceAll(" ", "_");
		File scenarioFolder = new File(scenarioFolderPath);

		if (!scenarioFolder.exists()) {
			scenarioFolder.mkdirs();
		}

		// Define o nome do arquivo de captura de tela como o nome do cenário com
		// espaços substituídos por underscores
		// importando o timestamp do JAVA e adicionando + ao nome do print
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
		String screenshotNameWithUnderscores = scenario.getName().replaceAll(" ", "_") + "_" + timestamp;

		// Define o caminho do arquivo de captura de tela como "[caminho da pasta de
		// evidências do cenário]/[nome do arquivo de captura de tela]"
		String screenshotNameWithoutSpaces = scenario.getName().replaceAll(" ", "") + "" + timestamp;
		File destinationPath = new File(scenarioFolderPath + "/" + screenshotNameWithoutSpaces + ".pdf");

		// Adiciona o cabeçalho à captura de tela em PDF
		AddHeaderToImage addHeader = new AddHeaderToImage();
		// Define o conteúdo do cabeçalho da captura de tela com base no resultado do
		// cenário
		String header = "Cenário: " + scenario.getName();
		if (scenario.isFailed()) {
			header += " | Falha";
		} else {
			header += " | Sucesso";
		}
		header += " | URL: " + driver.getCurrentUrl();
		addHeader.addHeaderToScreenshot(sourcePath.getAbsolutePath(), destinationPath.getAbsolutePath(), header);
	}

	@After(order = 0)
	public void afterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}
}