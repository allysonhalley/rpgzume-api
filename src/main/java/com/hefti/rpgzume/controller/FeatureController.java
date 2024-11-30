package com.hefti.rpgzume.controller;

import com.hefti.rpgzume.model.Feature;
import com.hefti.rpgzume.model.dto.CardDTO;
import com.hefti.rpgzume.model.dto.FeatureDTO;
import com.hefti.rpgzume.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    // Endpoint para obter todos os features
    @GetMapping
    public List<FeatureDTO> getAllFeatures() {
        List<Feature> features = featureService.getAllFeatures();
        return features.stream().map(feature -> {
            CardDTO cardDTO = feature.getCard() == null ? null : new CardDTO(
                    feature.getCard().getId(),
                    feature.getCard().getName(),
                    feature.getCard().getResume(),
                    feature.getCard().getDescription(),
                    feature.getCard().getBook(),
                    feature.getCard().getPage()
            );

            return new FeatureDTO(
                    feature.getId(),
                    cardDTO,
                    feature.getPrerequisites(),
                    feature.getBenefit(),
                    feature.getNormal(),
                    feature.getSpecial()
            );
        }).collect(Collectors.toList());
    }

    // Endpoint para criar um novo feature
    @PostMapping
    public ResponseEntity<Feature> createFeature(@RequestBody Feature feature) {
        return ResponseEntity.ok(featureService.createFeature(feature));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feature> getFeatureById(@PathVariable String id) {
        Optional<Feature> feature = featureService.getFeatureById(id);
        return feature.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeature(@PathVariable String id) {
        featureService.deleteFeature(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/fullfeature")
    public ResponseEntity<Feature> createFeatureWithCard(@RequestBody Feature feature) {
        return ResponseEntity.ok(featureService.createFeatureWithCard(feature));
    }

    @PostMapping("/addfulllist")
    public ResponseEntity<List<Feature>> createFeatures(@RequestBody List<Feature> features) {
        return ResponseEntity.ok(featureService.createFeatures(features));
    }

}
