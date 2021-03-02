/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorioos;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author LAB
 */
public class ManipuladorPDF {

    public static void relatorioPDF(ArrayList<Relatorio> relatorio,String nome) throws FileNotFoundException, DocumentException {
        Document document = new Document(PageSize.A4, 0, 0, 0, 0);
        PdfWriter.getInstance(document, new FileOutputStream("C:\\NTS\\Relatorio_"+nome.replace(" ", "")+".pdf"));
        document.open();
        PdfPTable table = new PdfPTable(100);

        table.setWidthPercentage(100);
        table.setSpacingBefore(0f);
        table.setSpacingAfter(0f);

        // first row
        PdfPCell cell = new PdfPCell(new Phrase("Relatorio de OS por Funcionario",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20.0f)));
        cell.setColspan(100);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(30.0f);
        table.addCell(cell);

        PdfPCell header_id_os = new PdfPCell(new Phrase("OS",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14.0f)));
        header_id_os.setPadding(10.0f);
        header_id_os.setColspan(10);
        header_id_os.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header_id_os);

        PdfPCell header_lancamento = new PdfPCell(new Phrase("Data",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14.0f)));
        header_lancamento.setPadding(10.0f);
        header_lancamento.setColspan(13);
        header_lancamento.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header_lancamento);

        PdfPCell header_descricao = new PdfPCell(new Phrase("Descrição",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14.0f)));
        header_descricao.setPadding(10.0f);
        header_descricao.setColspan(50);
        header_descricao.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header_descricao);

        PdfPCell header_valor = new PdfPCell(new Phrase("Valor ",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14.0f)));
        header_valor.setPadding(10.0f);
        header_valor.setColspan(10);
        header_valor.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header_valor);

        PdfPCell header_funcionario = new PdfPCell(new Phrase("Funcionario",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14.0f)));
        header_funcionario.setPadding(10.0f);
        header_funcionario.setColspan(17);
        header_funcionario.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header_funcionario);

        for (Relatorio r : relatorio) {
            PdfPCell celula1 = new PdfPCell(new Phrase(r.getId(),
                    FontFactory.getFont(FontFactory.HELVETICA, 11.0f)));
            celula1.setColspan(10);
            celula1.setPadding(4.0f);
            //celula1.setBorder(Rectangle.NO_BORDER);
            celula1.setHorizontalAlignment(Element.ALIGN_CENTER);
            celula1.setVerticalAlignment(Element.ALIGN_CENTER);

            PdfPCell celula2 = new PdfPCell(new Phrase(r.getData_lancamento(),
                    FontFactory.getFont(FontFactory.HELVETICA, 11.0f)));
            celula2.setColspan(13);
            celula2.setPadding(4.0f);
            //celula2.setBorder(Rectangle.NO_BORDER);
            celula2.setHorizontalAlignment(Element.ALIGN_CENTER);
            celula2.setVerticalAlignment(Element.ALIGN_CENTER);

            PdfPCell celula3 = new PdfPCell(new Phrase(r.getDescricao(),
                    FontFactory.getFont(FontFactory.HELVETICA, 11.0f)));
            celula3.setColspan(50);
            celula3.setPadding(4.0f);
            //celula3.setBorder(Rectangle.NO_BORDER);
            celula3.setHorizontalAlignment(Element.ALIGN_CENTER);
            celula3.setVerticalAlignment(Element.ALIGN_CENTER);

            PdfPCell celula4 = new PdfPCell(new Phrase(r.getValor_servico(),
                    FontFactory.getFont(FontFactory.HELVETICA, 11.0f)));
            celula4.setColspan(10);
            celula4.setPadding(4.0f);
            //celula4.setBorder(Rectangle.NO_BORDER);
            celula4.setHorizontalAlignment(Element.ALIGN_CENTER);
            celula4.setVerticalAlignment(Element.ALIGN_CENTER);

            PdfPCell celula5 = new PdfPCell(new Phrase(r.getFuncionario(),
                    FontFactory.getFont(FontFactory.HELVETICA, 11.0f)));
            celula5.setColspan(17);
            celula5.setPadding(4.0f);
            //celula5.setBorder(Rectangle.NO_BORDER);
            celula5.setHorizontalAlignment(Element.ALIGN_CENTER);
            celula5.setVerticalAlignment(Element.ALIGN_CENTER);

            table.addCell(celula1);
            table.addCell(celula2);
            table.addCell(celula3);
            table.addCell(celula4);
            table.addCell(celula5);
        }

        PdfPCell total = new PdfPCell(new Phrase("TOTAL: ",
                FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18.0f)));
        total.setPadding(15.0f);
        total.setColspan(73);
        total.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell total_vlr = new PdfPCell(new Phrase(Relatorio.total.toString(),
                FontFactory.getFont(FontFactory.HELVETICA, 18.0f)));
        total_vlr.setPadding(15.0f);
        total_vlr.setColspan(27);
        total_vlr.setHorizontalAlignment(Element.ALIGN_CENTER);

        table.addCell(total);
        table.addCell(total_vlr);

        document.add(table);
        document.close();
    }

}
