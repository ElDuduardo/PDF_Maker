package org.yourcompany.yourproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.HtmlConverter;

/*
 * Faz a converção de HTML para PDF
 */

public class CriadorPDF {

    public static void main(String[] args) throws Exception {
        
        // Define os endereços de entrada (HTML) e saida (PDF)
        String htmlInput = "Berimbau.html";
        String pdfOutput = "PDFs/PdfBerimbau.pdf";
        
        try {
            // Trata o HTML
            FileInputStream htmlInputStream = new FileInputStream(htmlInput);
            FileOutputStream pdfOutputStream = new FileOutputStream(pdfOutput);
            
            // Converte para PDF
            HtmlConverter.convertToPdf(htmlInputStream, pdfOutputStream);
            
            // Fecha os metodos de tranformação
            htmlInputStream.close();
            pdfOutputStream.close();

            // Chama o paginador
            Paginador.manipulatePdf("PDFs/PagPdfBerimbau.pdf", pdfOutput);
        } catch (IOException e) {
            System.err.println("Erro na conversão: " + e.getMessage());
        }


    }

}