package com.example.web2lab1be;

import com.example.web2lab1be.requests.SignUpRequestBody;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JWTDecoder {

    public static SignUpRequestBody decodeJWT(String token) {
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String[] chunks = token.split("\\.");
        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));
        Map<String, String> resultMap = parseStringToMap(payload);
        SignUpRequestBody signUpRequestBody = new SignUpRequestBody(resultMap.get("given_name"), resultMap.get("family_name"), "1234", resultMap.get("email"));
        return signUpRequestBody;
    }

    public static Map<String, String> parseStringToMap(String input) {
        Map<String, String> resultMap = new HashMap<>();
        input = input.trim();
        if (input.startsWith("{") && input.endsWith("}")) {
            input = input.substring(1, input.length() - 1);
        }
        String[] pairs = input.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            if (keyValue.length == 2) {
                String key = keyValue[0].trim();
                if (key.startsWith("\"") && key.endsWith("\"")) {
                    key = key.substring(1, key.length() - 1);
                }
                String value = keyValue[1].trim();
                if (value.startsWith("\"") && value.endsWith("\"")) {
                    value = value.substring(1, value.length() - 1);
                }
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }
}
