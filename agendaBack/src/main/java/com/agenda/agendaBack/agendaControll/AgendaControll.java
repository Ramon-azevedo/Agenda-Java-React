package com.agenda.agendaBack.agendaControll;

import com.agenda.agendaBack.agenda.*;
import com.agenda.agendaBack.agendaRepository.*;
import com.agenda.agendaBack.agendaService.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agenda")
@CrossOrigin(origins = "*")
public class AgendaControll {

    @Autowired
    private AgendaService agendaService;
    @Autowired
    private AgendaRepository agendaRepository;

    @GetMapping("/getAgenda")
    public ResponseEntity<?> getAgenda() {
        return ResponseEntity.ok(agendaRepository.findAll());
    }

    @PostMapping("/postAgenda")
    public ResponseEntity<?> postAgenda(@RequestBody Agenda agenda) {
        return agendaService.postAgenda(agenda);
    }

    @PutMapping("/putAgenda/{id}")
    public ResponseEntity<?> putAgenda(@PathVariable Long id , @RequestBody Agenda agenda) {
        return agendaService.putAgenda(id,agenda);
    }

    @DeleteMapping("/deleteAgenda/{id}")
    public ResponseEntity<?> DeleteAgenda(@PathVariable Long id) {
        return agendaService.deleteAgenda(id);
    }
}

