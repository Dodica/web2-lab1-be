package com.example.web2lab1be.DAO;

import com.example.web2lab1be.entity.Natjecanje;
import com.example.web2lab1be.mappers.NatjecanjeMapper;
import com.example.web2lab1be.requests.CreateTournamentRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NatjecanjeDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public static String getPairing(String players, int n, int rd) {
        StringBuilder pairings = new StringBuilder();
        if (n % 2 != 0) {
            n += 1;
            players += ",bye";
        }
        int[][] array;
        String[] playerlist = players.split(",");
        int[][] cyclicArray8 = {
                {1, 5, 2, 6, 3, 7, 4},
                {5, 2, 6, 3, 7, 4, 1},
                {2, 6, 3, 7, 4, 1, 5},
                {6, 3, 7, 4, 1, 5, 2},
                {3, 7, 4, 1, 5, 2, 6},
                {7, 4, 1, 5, 2, 6, 3},
                {4, 1, 5, 2, 6, 3, 7},
        };
        int[][] cyclicArray6 = {
                {1, 5, 2, 3, 4},
                {5, 2, 3, 4, 1},
                {2, 3, 4, 1, 5},
                {3, 4, 1, 5, 2},
                {4, 1, 5, 2, 3}
        };
        int[][] cyclicArray4 = {
                {1, 2, 3},
                {2, 3, 1},
                {3, 1, 2}
        };

        if (n == 6) {
            array = cyclicArray6;
        } else if (n == 8) {
            array = cyclicArray8;
        } else {
            array = cyclicArray4;
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (i == j && array[i][j] == rd) {
                    pairings.append(playerlist[i]).append(" - ").append(playerlist[n - 1]).append(", ");
                } else if (array[i][j] == rd) {
                    pairings.append(playerlist[i]).append(" - ").append(playerlist[j]).append(", ");
                }
            }
        }
        return pairings.toString();
    }


    public Boolean insertNatjecanje(CreateTournamentRequestBody natjecanje) {
        try {
            String pairing = getPairing(natjecanje.getListanatjecatelja(), natjecanje.getBrojnatjecatelja(), 1);
            pairing = pairing.substring(0, pairing.length() - 2);
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("naziv", natjecanje.getNaziv());
            parameters.addValue("brojnatjecatelja", natjecanje.getBrojnatjecatelja());
            parameters.addValue("listanatjecatelja", natjecanje.getListanatjecatelja());
            parameters.addValue("listarezultata", natjecanje.getListarezultata());
            parameters.addValue("pairing", pairing);
            parameters.addValue("brojrunde", 1);
            parameters.addValue("format", natjecanje.getFormat());
            parameters.addValue("userid", natjecanje.getUserid());
            jdbcTemplate.update("INSERT INTO natjecanje(naziv, brojnatjecatelja, listanatjecatelja, listarezultata, pairing, brojrunde, format, userid) VALUES(:naziv, :brojnatjecatelja, :listanatjecatelja, :listarezultata, :pairing, :brojrunde, :format, :userid);", parameters);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Natjecanje> showTournamentsById(Integer userid) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("userid", userid);
        return jdbcTemplate.query("SELECT s.natjecanjeid, s.naziv, s.brojnatjecatelja, s.listanatjecatelja, s.listarezultata, s.pairing, s.brojrunde, s.format, s.userid FROM natjecanje s NATURAL JOIN natjecatelj m WHERE m.userid = :userid", parameters, new NatjecanjeMapper());
    }

    public Natjecanje showTournamentById(Integer natjecanjeid) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("natjecanjeid", natjecanjeid);
        return jdbcTemplate.queryForObject("SELECT s.natjecanjeid, s.naziv, s.brojnatjecatelja, s.listanatjecatelja, s.listarezultata, s.pairing, s.brojrunde, s.format, s.userid FROM natjecanje s WHERE s.natjecanjeid = :natjecanjeid", parameters, new NatjecanjeMapper());
    }

    public Boolean editNatjecanje(Natjecanje natjecanje) {
        String pairing = getPairing(natjecanje.getListanatjecatelja(), natjecanje.getBrojnatjecatelja(), natjecanje.getBrojrunde());
        pairing = pairing.substring(0, pairing.length() - 2);
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("natjecanjeid", natjecanje.getNatjecanjeid());
        parameters.addValue("naziv", natjecanje.getNaziv());
        parameters.addValue("brojnatjecatelja", natjecanje.getBrojnatjecatelja());
        parameters.addValue("listanatjecatelja", natjecanje.getListanatjecatelja());
        parameters.addValue("listarezultata", natjecanje.getListarezultata());
        parameters.addValue("pairing", pairing);
        parameters.addValue("brojrunde", natjecanje.getBrojrunde());
        parameters.addValue("format", natjecanje.getFormat());
        parameters.addValue("userid", natjecanje.getUserid());
        try {
            jdbcTemplate.update("UPDATE natjecanje SET naziv = :naziv, brojnatjecatelja = :brojnatjecatelja, listanatjecatelja = :listanatjecatelja, listarezultata = :listarezultata, brojrunde = :brojrunde WHERE natjecanjeid = :natjecanjeid", parameters);
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // Print the exception for debugging
            return false;
        }
    }
}