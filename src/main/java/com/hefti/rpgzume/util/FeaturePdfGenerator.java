package com.hefti.rpgzume.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FeaturePdfGenerator {

    @Autowired
    PdfGenerate pdfGenerate;

    public void generateFeaturePdf(JSONArray jsonArray) throws JSONException {
        pdfGenerate.generatePdf(jsonArray);
    }

}
