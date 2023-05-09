package br.com.hub_bdd.managers;

import com.cucumber.listener.Reporter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class AddHeaderToImage {

	public void addHeaderToScreenshot(String sourceImagePath, String destinationPath, String headerText) {
		try {
			// Carrega a imagem
			Image screenshotImage = Image.getInstance(sourceImagePath);

			// Define a escala da imagem para 50%
			screenshotImage.scalePercent(29);

			// Cria um novo documento PDF
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(destinationPath));
			document.open();

			// Adiciona o cabeçalho como um parágrafo antes da imagem
			document.add(new Paragraph(headerText));

			// Adiciona a imagem ao documento PDF
			document.add(screenshotImage);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
