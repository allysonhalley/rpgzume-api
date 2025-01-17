package com.hefti.rpgzume.controller;

import com.hefti.rpgzume.model.Magic;
import com.hefti.rpgzume.model.dto.CardDTO;
import com.hefti.rpgzume.model.dto.MagicDTO;
import com.hefti.rpgzume.service.MagicService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/magics")
public class MagicController {
    @Autowired
    private MagicService magicService;

    // Endpoint para obter todos os magics
    @GetMapping
    public List<MagicDTO> getAllMagics() {
        List<Magic> magics = magicService.getAllMagics();
        return magics.stream().map(magic -> {
            CardDTO cardDTO = magic.getCard() == null ? null : new CardDTO(
                    magic.getCard().getId(),
                    magic.getCard().getName(),
                    magic.getCard().getResume(),
                    magic.getCard().getDescription(),
                    magic.getCard().getBook(),
                    magic.getCard().getPage()
            );

            return new MagicDTO(
                    magic.getId(),
                    cardDTO,
                    magic.getType(),
                    magic.getLevel(),
                    magic.getComponents(),
                    magic.getCastTime(),
                    magic.getRange(),
                    magic.getTargetArea(),
                    magic.getDuration(),
                    magic.getSavingThrow(),
                    magic.getSpellResistance(),
                    magic.getEffect()
            );
        }).collect(Collectors.toList());
    }

    // Endpoint para criar um novo magic
    @PostMapping
    public ResponseEntity<Magic> createMagic(@RequestBody Magic magic) {
        return ResponseEntity.ok(magicService.createMagic(magic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Magic> getMagicById(@PathVariable String id) {
        Optional<Magic> magic = magicService.getMagicById(id);
        return magic.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMagic(@PathVariable String id) {
        magicService.deleteMagic(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/fullmagic")
    public ResponseEntity<Magic> createMagicWithCard(@RequestBody Magic magic) {
        return ResponseEntity.ok(magicService.createMagicWithCard(magic));
    }

    @PostMapping("/addfulllist")
    public ResponseEntity<List<Magic>> createMagics(@RequestBody List<Magic> magics) {
        return ResponseEntity.ok(magicService.createMagics(magics));
    }

    @GetMapping("/pdf")
    public ResponseEntity<Object> getPdf()  throws JSONException {
        magicService.generatePdfAllMagics();
        return ResponseEntity.ok("PDF Gerado!");
    }



}
