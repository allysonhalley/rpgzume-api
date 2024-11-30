package com.hefti.rpgzume.model.dto;

public record FeatureDTO(
        String id,
        CardDTO card,
        String prerequisites,
        String benefit,
        String normal,
        String special
) { }

