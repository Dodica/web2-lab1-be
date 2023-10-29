package com.example.web2lab1be.extractors;

import com.example.web2lab1be.entity.Natjecatelj;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NatjecateljSetExtractor implements ResultSetExtractor<Natjecatelj> {

    @Override
    public Natjecatelj extractData(ResultSet rs) throws SQLException, DataAccessException {
        Natjecatelj natjecatelj = new Natjecatelj();
        natjecatelj.setId(rs.getInt("userid"));
        natjecatelj.setEmail(rs.getString("email"));
        natjecatelj.setFirstName(rs.getString("ime"));
        natjecatelj.setLastName(rs.getString("prezime"));
        natjecatelj.setPassword(rs.getString("password"));

        return natjecatelj;
    }
}
