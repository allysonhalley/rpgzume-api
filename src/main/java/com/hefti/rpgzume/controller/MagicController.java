package com.hefti.rpgzume.controller;

import com.hefti.rpgzume.model.Magic;
import com.hefti.rpgzume.service.MagicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/magics")
public class MagicController {
    @Autowired
    private MagicService magicService;

    // Endpoint para obter todos os magics
    @GetMapping
    public Iterable<Magic> getAllMagics() {
        return magicService.getAllMagics();
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



}
