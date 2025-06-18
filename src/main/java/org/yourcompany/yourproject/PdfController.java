
/* Código gerado pelo DeepSeek (com alterações) */
/* https://chat.deepseek.com/a/chat/s/fd0624dd-56d9-455e-bdb3-fd301acca63d */



package org.yourcompany.yourproject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.html2pdf.HtmlConverter;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> generatePdf(@RequestBody PdfRequest request) throws IOException {
        
        // 1. Gerar HTML a partir dos dados JSON
        String htmlContent = generateHtmlFromJson(request);
        
        // 2. Converter HTML para PDF
        byte[] pdfBytes = convertHtmlToPdfBytes(htmlContent);
        
        // 3. Retornar PDF como resposta
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=documento.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

    private String generateHtmlFromJson(PdfRequest request) {
        // Customize seu HTML com os dados do JSON
        return "<html><body><h1>" + request.getTitulo() + "</h1><p>" + request.getConteudo() + "</p></body></html>";
    }

    private byte[] convertHtmlToPdfBytes(String html) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(html, outputStream);
        return outputStream.toByteArray();
    }
}

// Classe DTO para a requisição
class PdfRequest {
    private String titulo;
    private String conteudo;
    
    // Getters e Setters (Obrigatórios para desserialização)
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
}