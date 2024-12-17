package com.agenda.agendaBack.agenda;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agenda")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
}

