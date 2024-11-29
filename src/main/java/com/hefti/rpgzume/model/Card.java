package com.hefti.rpgzume.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cards")
@Entity(name = "cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String resume;
    private String description;
    private String book;
    private Integer page;

    @OneToOne
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

}
