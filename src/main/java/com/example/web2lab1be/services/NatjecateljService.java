package com.example.web2lab1be.services;

import com.example.web2lab1be.DAO.NatjecateljDAO;
import com.example.web2lab1be.entity.Natjecatelj;
import com.example.web2lab1be.requests.SignUpRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class NatjecateljService {

    @Autowired
    NatjecateljDAO natjecateljDAO;

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

    public Boolean createUser(SignUpRequestBody natjecatelj) {
        return natjecateljDAO.insertUser(natjecatelj);
    }

    public Integer loginUser(String email, String password) {
        Natjecatelj natjecatelj = natjecateljDAO.findByEmail(email);
        if (natjecatelj != null) {
            if (password.equals(natjecatelj.getPassword())) {
                return natjecatelj.getId();
            }
        }
        return 0;
    }

}
