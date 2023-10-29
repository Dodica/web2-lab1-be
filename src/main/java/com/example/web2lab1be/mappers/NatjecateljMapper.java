package com.example.web2lab1be.mappers;

import com.example.web2lab1be.entity.Natjecatelj;
import com.example.web2lab1be.extractors.NatjecateljSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NatjecateljMapper implements RowMapper<Natjecatelj> {

    public Natjecatelj mapRow(ResultSet rs, int rowNum) throws SQLException {
        NatjecateljSetExtractor natjecateljSetExtractor = new NatjecateljSetExtractor();
        return natjecateljSetExtractor.extractData(rs);
    }

}
