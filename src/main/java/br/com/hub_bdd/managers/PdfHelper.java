package br.com.hub_bdd.managers;

import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfHelper {
	public static void createPdf(ArrayList<String> screenshots) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("screenshots.pdf"));
			document.open();
			addScreenshotsToPdf(document, screenshots);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addScreenshotsToPdf(Document document, ArrayList<String> screenshots) {
		try {
			if (document == null) {
				document = new Document();
			}
			PdfWriter.getInstance(document, new FileOutputStream("screenshots.pdf"));
			document.open();
			for (String screenshot : screenshots) {
				Image image = Image.getInstance(screenshot);
				document.add(image);
			}
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
