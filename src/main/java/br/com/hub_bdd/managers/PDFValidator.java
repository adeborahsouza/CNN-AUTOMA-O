package br.com.hub_bdd.managers;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class PDFValidator {
	public static boolean validatePDFText(String filePath, String expectedText) {
		try (PDDocument document = PDDocument.load(new File(filePath))) {
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String text = pdfStripper.getText(document);
			return text.contains(expectedText);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static String getLatestPDFFilePath(String downloadFolderPath) {
		File downloadFolder = new File(downloadFolderPath);

		// Listar todos os arquivos na pasta de downloads em ordem cronológica inversa
		File[] files = downloadFolder.listFiles();
		if (files != null) {
			Arrays.sort(files, Comparator.comparingLong(File::lastModified).thenComparing(File::getName)
					.thenComparingLong(File::length).reversed());

		}
		// Encontrar o primeiro arquivo PDF na lista
		for (File file : files) {
			if (file.getName().endsWith(".pdf")) {
				return file.getAbsolutePath();
			}
		}

		return null;
	}
}
