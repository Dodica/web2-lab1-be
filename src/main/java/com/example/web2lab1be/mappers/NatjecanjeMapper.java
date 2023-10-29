package com.example.web2lab1be.mappers;

import com.example.web2lab1be.entity.Natjecanje;
import com.example.web2lab1be.extractors.NatjecanjeSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NatjecanjeMapper implements RowMapper<Natjecanje> {

    public Natjecanje mapRow(ResultSet rs, int rowNum) throws SQLException {
        NatjecanjeSetExtractor natjecateljSetExtractor = new NatjecanjeSetExtractor();
        return natjecateljSetExtractor.extractData(rs);
    }

}
