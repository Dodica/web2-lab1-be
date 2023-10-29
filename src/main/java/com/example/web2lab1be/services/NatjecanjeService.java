package com.example.web2lab1be.services;

import com.example.web2lab1be.DAO.NatjecanjeDAO;
import com.example.web2lab1be.entity.Natjecanje;
import com.example.web2lab1be.requests.CreateTournamentRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatjecanjeService {

    @Autowired
    NatjecanjeDAO natjecanjeDAO;

    public List<Natjecanje> showTournamentsById(Integer userid) {
        return natjecanjeDAO.showTournamentsById(userid);
    }

    public Natjecanje showTournamentById(Integer natjecanjeid) {
        return natjecanjeDAO.showTournamentById(natjecanjeid);
    }

    public Boolean insertNatjecanje(CreateTournamentRequestBody natjecanje) {
        return natjecanjeDAO.insertNatjecanje(natjecanje);
    }


    public Boolean editNatjecanje(Natjecanje natjecanje) {
        return natjecanjeDAO.editNatjecanje(natjecanje);
    }
}
