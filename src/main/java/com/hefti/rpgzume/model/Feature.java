package com.hefti.rpgzume.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "features")
@Entity(name = "features")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // Cascata e remoção de órfãos
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;

    private String prerequisites;
    private String benefit;
    private String normal;
    private String special;
}
