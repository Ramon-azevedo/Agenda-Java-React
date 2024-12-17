package com.agenda.agendaBack.agendaRepository;

import com.agenda.agendaBack.agenda.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda,Long> {
    Optional<Agenda> findByItem(String item);
}