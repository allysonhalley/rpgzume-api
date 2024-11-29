package com.hefti.rpgzume.controller;

import com.hefti.rpgzume.model.Card;
import com.hefti.rpgzume.repository.CardRepository;
import com.hefti.rpgzume.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cards") // Prefixo REST comum
public class CardController {

    @Autowired
    private CardService cardService;

    // Endpoint para listar todos os cards
    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    // Endpoint para buscar um card pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable String id) {
        Optional<Card> card = cardService.getCardById(id);
        return card.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo card
    @PostMapping
    public ResponseEntity<Card> create(@RequestBody Card card) {
        Card savedCard = cardService.createCard(card);
        return ResponseEntity.ok(savedCard);
    }

    @PostMapping("/addlist")
    public ResponseEntity<List<Card>> createCards(@RequestBody List<Card> cards) {
        // Salvando os cards recebidos
        return ResponseEntity.ok(cardService.createCards(cards));
    }

    // Endpoint para atualizar um card pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable String id, @RequestBody Card cardDetails) {
        return cardService.getCardById(id)
                .map(card -> {
                    card.setName(cardDetails.getName());
                    card.setResume(cardDetails.getResume());
                    card.setDescription(cardDetails.getDescription());
                    card.setBook(cardDetails.getBook());
                    card.setPage(cardDetails.getPage());
                    return ResponseEntity.ok(cardService.createCard(card));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para deletar um card pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCard(@PathVariable String id) {
        return ResponseEntity.badRequest().body("Cards só podem ser deletados através da exclusão da Feature associada.");
    }
}
