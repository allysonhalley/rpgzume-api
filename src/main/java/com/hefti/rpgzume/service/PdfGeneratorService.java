package com.hefti.rpgzume.service;

import com.hefti.rpgzume.util.FeaturePdfGenerator;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PdfGeneratorService {

    @Autowired
    FeaturePdfGenerator featurePdfGenerator;

    // Método para chamar o gerador de PDF
    public void generateFeaturePdf(JSONArray featuresJSONArray)  throws JSONException {
        try {
           featurePdfGenerator.generateFeaturePdf(featuresJSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
