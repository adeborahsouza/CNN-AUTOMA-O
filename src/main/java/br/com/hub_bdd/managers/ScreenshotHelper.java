package br.com.hub_bdd.managers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import br.com.hub_bdd.selenium.Wait;

public class ScreenshotHelper {

	public static void takeScreenshot(WebDriver driver, String scenarioName) throws IOException {
		Wait.waitForPageLoad(driver);
		Wait.untilJqueryIsDone(driver);
		Wait.untilPageLoadComplete(driver);

		String screenshotName = scenarioName.replaceAll(" ", "_");
		File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir") + "/target/" + screenshotName + ".png");

		Files.copy(sourcePath.toPath(), destinationPath.toPath());
	}

}
