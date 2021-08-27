package com.jpa.jwt;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jpa.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenUtil implements Serializable {

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	@Value("${jwt.secret}")
	private String secretKey;

	public User getUserFromToken(String token) {
		User user = new User();
		Claims body = getClaimsFromToken(token);
		user.setUserName(body.getSubject());
		user.setRole((String) body.get("role"));
		return user;
	}

	public Date getExpirationDateFromToken(String token) {
		Claims claims = getClaimsFromToken(token);
		return claims.getExpiration();
	}

	private Claims getClaimsFromToken(String token) {

		Claims claims = 
			Jwts.parser()
			    .setSigningKey(secretKey)
			    .parseClaimsJws(token)
			    .getBody();
		return claims;
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// generate token for user
	public String generateToken(User user) {

		Claims claims = Jwts.claims();
		claims.setSubject(user.getUserName());
		claims.put("role", user.getRole());

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secretKey)
				.compact();
	}

	// validate token
	public Boolean validateToken(String token) {
		return (!isTokenExpired(token));
	}
}