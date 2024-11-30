package com.hefti.rpgzume.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "magic")
@Entity(name = "magic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Magic {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // Cascata e remoção de órfãos
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card; // Relacionamento com outra entidade chamada "Card"

    private String type;
    private String level;
    private String components;
    private String castTime;
    private String range;
    private String targetArea;
    private String duration;
    private String savingThrow;
    private String spellResistance;
    private String effect;
}
