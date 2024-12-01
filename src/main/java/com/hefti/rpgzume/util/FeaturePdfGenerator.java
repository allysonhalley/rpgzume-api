package com.hefti.rpgzume.util;

import com.hefti.rpgzume.service.FeatureService;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FeaturePdfGenerator {

    // Método para gerar o PDF
    public void generateFeaturePdf(JSONArray jsonArray) throws JSONException {
        // Parse o JSON de talentos a partir do FeatureService

        // Criar o documento PDF
        try (PDDocument document = new PDDocument()) {

            // Criar uma página no PDF
            PDPage page = new PDPage();
            document.addPage(page);

            // Criar um objeto para escrever conteúdo na página
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Definir a fonte
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);

            // Título do documento
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 750);
            contentStream.showText("Talentos de RPG");
            contentStream.endText();

            // Definir a fonte para a tabela
            contentStream.setFont(PDType1Font.HELVETICA, 10);

            // Iniciar a tabela
            float yPosition = 730;
            float margin = 50;
            float tableWidth = 500;
            float rowHeight = 15;

            // Cabeçalhos da tabela
            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition);
            contentStream.showText("Atributo");
            contentStream.newLineAtOffset(tableWidth / 2, 0);
            contentStream.showText("Detalhes");
            contentStream.endText();

            // Separação de cabeçalho e conteúdo
            yPosition -= rowHeight;

            // Preencher a tabela com os dados de talentos
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject talent = jsonArray.getJSONObject(i);
                JSONObject card = talent.getJSONObject("card");

                // Nome do Talento
                yPosition -= rowHeight;
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText("Nome:");
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText(card.getString("name"));
                contentStream.endText();

                // Resumo
                yPosition -= rowHeight;
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText("Resumo:");
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText(card.getString("resume"));
                contentStream.endText();

                // Descrição
                yPosition -= rowHeight;
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText("Descrição:");
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText(card.getString("description"));
                contentStream.endText();

                // Fonte (Livro e Página)
                yPosition -= rowHeight;
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText("Fonte:");
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText(card.getString("book") + " - Página " + card.getInt("page"));
                contentStream.endText();

                // Pré-requisitos
                yPosition -= rowHeight;
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText("Pré-requisitos:");
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText(talent.getString("prerequisites"));
                contentStream.endText();

                // Benefício
                yPosition -= rowHeight;
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText("Benefício:");
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText(talent.getString("benefit"));
                contentStream.endText();

                // Normal
                yPosition -= rowHeight;
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText("Normal:");
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText(talent.getString("normal"));
                contentStream.endText();

                // Especial
                yPosition -= rowHeight;
                contentStream.beginText();
                contentStream.newLineAtOffset(margin, yPosition);
                contentStream.showText("Especial:");
                contentStream.newLineAtOffset(tableWidth / 2, 0);
                contentStream.showText(talent.getString("special"));
                contentStream.endText();

                // Espaço entre talentos
                yPosition -= 2 * rowHeight;
            }

            // Fechar o fluxo de conteúdo
            contentStream.close();

            // Salvar o documento em um arquivo
            document.save(new File("pdf/features/talentos_rpg.pdf"));
            System.out.println("PDF gerado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
