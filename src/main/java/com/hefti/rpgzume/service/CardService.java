package com.hefti.rpgzume.service;

import com.hefti.rpgzume.model.Card;
import com.hefti.rpgzume.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardById(String id) {
        return cardRepository.findById(id);
    }

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> createCards(List<Card> cards){
        return cardRepository.saveAll(cards);
    }

    public Optional<Card> updateCard(String id, Card cardDetails) {
        return cardRepository.findById(id)
                .map(card -> {
                    card.setName(cardDetails.getName());
                    card.setResume(cardDetails.getResume());
                    card.setDescription(cardDetails.getDescription());
                    card.setBook(cardDetails.getBook());
                    card.setPage(cardDetails.getPage());
                    return cardRepository.save(card);
                });
    }

    // Card não pode ser deletado diretamente
    public void deleteCard(String id) {
        throw new UnsupportedOperationException("Cards só podem ser deletados através da exclusão da Feature associada.");
    }

}
