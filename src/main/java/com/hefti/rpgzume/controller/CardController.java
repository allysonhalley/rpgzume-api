package com.hefti.rpgzume.controller;

import com.hefti.rpgzume.model.Card;
import com.hefti.rpgzume.repository.CardRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards") // Prefixo REST comum
public class CardController {

    private final CardRepository cardRepository;

    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    // Endpoint para listar todos os cards
    @GetMapping
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // Endpoint para buscar um card pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable String id) {
        return cardRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo card
    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        return ResponseEntity.ok(cardRepository.save(card));
    }

    @PostMapping("/addlist")
    public ResponseEntity<List<Card>> createCards(@RequestBody List<Card> cards) {
        // Salvando os cards recebidos
        cardRepository.saveAll(cards);
        return ResponseEntity.ok(cards);
    }

    // Endpoint para atualizar um card pelo ID
    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable String id, @RequestBody Card cardDetails) {
        return cardRepository.findById(id)
                .map(card -> {
                    card.setName(cardDetails.getName());
                    card.setResume(cardDetails.getResume());
                    card.setDescription(cardDetails.getDescription());
                    card.setBook(cardDetails.getBook());
                    card.setPage(cardDetails.getPage());
                    return ResponseEntity.ok(cardRepository.save(card));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para deletar um card pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCard(@PathVariable String id) {
        return cardRepository.findById(id)
                .map(card -> {
                    cardRepository.delete(card);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
