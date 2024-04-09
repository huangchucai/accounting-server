package com.hcc.accounting.utils;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public final class JWTUtil {
    public static final int ONE_DAY = 24 * 60 * 60 * 1000;


    /**
     * Generate JWT.
     * @param username 用户名
     * @return 生产的JWT
     */
    public static String generateToken(String username) {
        SecretKey key = Jwts.SIG.HS256.key().build();

        return Jwts.builder()
                   .subject(username)
                   .issuedAt(new Date())
                   .expiration(new Date(System.currentTimeMillis() + ONE_DAY))
                   .signWith(key)
                   .compact();

    }
}
