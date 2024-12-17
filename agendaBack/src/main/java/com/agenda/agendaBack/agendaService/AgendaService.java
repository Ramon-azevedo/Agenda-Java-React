package com.agenda.agendaBack.agendaService;

import com.agenda.agendaBack.agenda.*;
import com.agenda.agendaBack.agendaRepository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    //Post Agenda
    public ResponseEntity<?> postAgenda(@RequestBody Agenda agenda) {
        return ResponseEntity.ok(agendaRepository.save(agenda));
    }

    // Put Agenda
    public ResponseEntity<?> putAgenda(Long id, Agenda agenda) {
        Optional<Agenda> itemExistente = agendaRepository.findById(id);

        if (itemExistente.isPresent()) {
            agenda.setId(id);
            Agenda itemAtualizado = agendaRepository.save(agenda);
            return ResponseEntity.ok(itemAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado!");
        }
    }

    // Delete Agenda
    public ResponseEntity<?> deleteAgenda(Long id) {
        Optional<Agenda> itemExistente = agendaRepository.findById(id);

        if (itemExistente.isPresent()) {
            agendaRepository.deleteById(id);
            return ResponseEntity.ok().body("{\"message\": \"Item deletado com sucesso!\"}"); // Retorno JSON
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\": \"Item não encontrado!\"}");
        }
    }

}

