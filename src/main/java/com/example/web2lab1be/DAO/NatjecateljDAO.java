package com.example.web2lab1be.DAO;

import com.example.web2lab1be.entity.Natjecatelj;
import com.example.web2lab1be.mappers.NatjecateljMapper;
import com.example.web2lab1be.requests.SignUpRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Repository
public class NatjecateljDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Natjecatelj findByEmail(String email) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("email", email);
        try {
            Natjecatelj natjecatelj = jdbcTemplate.queryForObject(
                    "select u.userid, u.ime, u.prezime, u.password, u.email from natjecatelj u where u.email = :email", parameters, new NatjecateljMapper());
            return natjecatelj;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean insertUser(SignUpRequestBody u) {
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource();
            parameters.addValue("ime", u.getFirstName());
            parameters.addValue("prezime", u.getLastName());
            parameters.addValue("password", u.getPassword());
            parameters.addValue("email", u.getEmail());
            jdbcTemplate.update("insert into natjecatelj(ime,prezime,email,password) values(:ime,:prezime,:email,:password)", parameters);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
