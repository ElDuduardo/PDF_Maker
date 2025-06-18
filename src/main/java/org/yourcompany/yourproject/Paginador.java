package org.yourcompany.yourproject;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.VerticalAlignment;

/*
 * Pega um PDF já existente e adiciona um paginador
 */

public class Paginador {

    protected static void manipulatePdf(String dest, String src) throws Exception {

        // Cria a variavel informando onde esta o original e para onde vai o novo
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        // Cria um laco de repeticao para paginar as paginas individualmente
        int numberOfPages = pdfDoc.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {

            // Seleciona a pagina para se trabalhar
            PdfPage page = pdfDoc.getPage(i);
            PdfCanvas pdfCanvas = new PdfCanvas(page);
            
            // Cria o texto do paginador
            String pagAtual = Integer.toString(i) + " / " + Integer.toString(numberOfPages);
            Paragraph prgPagAtual = new Paragraph(pagAtual);

            // Coloca o paginador no centro
            prgPagAtual.setTextAlignment(TextAlignment.CENTER);

            // Adiciona o retangulo no topo da página
            Rectangle rectangle = new Rectangle(
                0, 0, 
                page.getPageSize().getWidth(), 
                page.getPageSize().getHeight());
            pdfCanvas.rectangle(rectangle);

            
            Canvas canvas = new Canvas(pdfCanvas, rectangle);

            // Configura layout centralizado vertical e horizontalmente
            canvas.setProperty(Property.VERTICAL_ALIGNMENT, VerticalAlignment.MIDDLE);
            canvas.setProperty(Property.HORIZONTAL_ALIGNMENT, HorizontalAlignment.CENTER);
            
            // Remover todas as bordas
            canvas.setBorder(Border.NO_BORDER);

            // Adiona o Canvas e fecha a pagina
            canvas.add(prgPagAtual);
            canvas.close();

        }

        doc.close();
    }
}
