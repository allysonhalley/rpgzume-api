package com.hefti.rpgzume.util;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class PdfGenerate {

    @Autowired
    LatexGenerate latexGenerate;

    public void generatePdf(JSONArray jsonArray) {
        try {
            // Gerar o código LaTeX
            String latexCode = latexGenerate.generateLatexFile(jsonArray, "pdf/features/talentos_rpg.tex").toString();

            // Configurar a chamada à API de conversão
            RestTemplate restTemplate = new RestTemplate();
            String apiUrl = "https://latexonline.cc/compile?text=".concat(latexCode);

            // Montar o corpo da requisição
            var requestBody = new org.springframework.util.LinkedMultiValueMap<String, String>();
            requestBody.add("latex", latexCode);

            // Enviar o pedido para a API
            var response = restTemplate.postForObject(apiUrl, requestBody, byte[].class);

            if (response != null) {
                // Salvar o PDF em um arquivo local (se necessário)
                try (FileOutputStream fos = new FileOutputStream("pdf/features/talentos_rpg.pdf")) {
                    fos.write(response);
                }
                System.out.println("PDF gerado com sucesso!");
            } else {
                System.err.println("Falha ao gerar o PDF: resposta da API é nula.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao gerar o PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
