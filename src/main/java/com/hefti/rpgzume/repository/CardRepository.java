package com.hefti.rpgzume.repository;

import com.hefti.rpgzume.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
}
