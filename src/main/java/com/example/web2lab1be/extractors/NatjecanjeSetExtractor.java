package com.example.web2lab1be.extractors;

import com.example.web2lab1be.entity.Natjecanje;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NatjecanjeSetExtractor implements ResultSetExtractor<Natjecanje> {

    @Override
    public Natjecanje extractData(ResultSet rs) throws SQLException, DataAccessException {
        Natjecanje natjecanje = new Natjecanje();

        natjecanje.setNatjecanjeid(rs.getInt("natjecanjeid"));
        natjecanje.setNaziv(rs.getString("naziv"));
        natjecanje.setBrojnatjecatelja(rs.getInt("brojNatjecatelja"));
        natjecanje.setListanatjecatelja(rs.getString("listanatjecatelja"));
        natjecanje.setListarezultata(rs.getString("listarezultata"));
        natjecanje.setPairing(rs.getString("pairing"));
        natjecanje.setBrojrunde(rs.getInt("brojrunde"));
        natjecanje.setFormat(rs.getString("format"));
        natjecanje.setUserid(rs.getInt("userid"));

        return natjecanje;
    }
}
