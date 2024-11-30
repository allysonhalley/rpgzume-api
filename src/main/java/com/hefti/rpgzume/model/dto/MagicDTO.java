package com.hefti.rpgzume.model.dto;

public record MagicDTO(
        String id,
        CardDTO card,
        String type,
        String level,
        String components,
        String castTime,
        String range,
        String targetArea,
        String duration,
        String savingThrow,
        String spellResistance,
        String effect
) { }


