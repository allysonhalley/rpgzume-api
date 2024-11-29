package com.hefti.rpgzume.service;

import com.hefti.rpgzume.model.Card;
import com.hefti.rpgzume.model.Feature;
import com.hefti.rpgzume.repository.CardRepository;
import com.hefti.rpgzume.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {
    @Autowired
    private FeatureRepository featureRepository;

    @Autowired
    private CardRepository cardRepository;  // Para associar uma feature a um card existente

    // Buscar todas as features
    public List<Feature> getAllFeatures() {
        return featureRepository.findAll();
    }

    public Feature createFeature(Feature feature) {
        return featureRepository.save(feature);
    }

    // Buscar uma feature pelo ID
    public Optional<Feature> getFeatureById(String id) {
        return featureRepository.findById(id);
    }

    // Atualizar uma feature
    public Feature updateFeature(Feature feature) {
        // Certifique-se de que o card associado existe
        Optional<Card> cardOptional = cardRepository.findById(feature.getCard().getId());
        if (cardOptional.isEmpty()) {
            throw new IllegalArgumentException("Card com ID " + feature.getCard().getId() + " não encontrado.");
        }
        feature.setCard(cardOptional.get());
        return featureRepository.save(feature);
    }

    // Excluir uma feature e a entidade Card associada
    public void deleteFeature(String id) {
        Optional<Feature> featureOptional = featureRepository.findById(id);
        if (featureOptional.isPresent()) {
            featureRepository.delete(featureOptional.get());
        } else {
            throw new IllegalArgumentException("Feature com ID " + id + " não encontrada.");
        }
    }

    // Buscar todas as features de um card específico
    public List<Feature> getFeaturesByCard(String cardId) {
        return featureRepository.findByCardId(cardId);
    }

    public Feature createFeatureWithCard(Feature feature) {
        Card card = feature.getCard();
        if (card != null) {
            card = cardRepository.save(card);
            feature.setCard(card);
        }
        return featureRepository.save(feature);
    }
}
