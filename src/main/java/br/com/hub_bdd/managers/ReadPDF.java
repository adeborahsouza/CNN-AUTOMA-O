package br.com.hub_bdd.managers;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPDF {
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
//
//	public static boolean validatePDFText2(String filePath, String expectedText2) {
//		try (PDDocument document = PDDocument.load(new File(filePath))) {
//			PDFTextStripper pdfStripper = new PDFTextStripper();
//			String text = pdfStripper.getText(document);
//			return text.contains(expectedText2);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
}