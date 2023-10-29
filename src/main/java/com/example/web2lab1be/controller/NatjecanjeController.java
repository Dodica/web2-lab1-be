package com.example.web2lab1be.controller;

import com.example.web2lab1be.entity.Natjecanje;
import com.example.web2lab1be.requests.CreateTournamentRequestBody;
import com.example.web2lab1be.services.NatjecanjeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8081/")
@RequestMapping("tournament")
public class NatjecanjeController {

    private final NatjecanjeService natjecanjeService;

    public NatjecanjeController(NatjecanjeService natjecanjeService) {
        this.natjecanjeService = natjecanjeService;
    }


    @GetMapping("tournaments")
    List<Natjecanje> showTournamentsById(@RequestParam Integer userid) {
        return natjecanjeService.showTournamentsById(userid);
    }

    @GetMapping("")
    Natjecanje showTournamentById(@RequestParam Integer natjecanjeid) {
        return natjecanjeService.showTournamentById(natjecanjeid);
    }

    @PutMapping("edit")
    Boolean editTournament(@RequestBody Natjecanje natjecanje) {
        return natjecanjeService.editNatjecanje(natjecanje);
    }

    @PostMapping("create")
    Boolean insertTournament(@RequestBody CreateTournamentRequestBody natjecanje) {
        return natjecanjeService.insertNatjecanje(natjecanje);
    }


}
