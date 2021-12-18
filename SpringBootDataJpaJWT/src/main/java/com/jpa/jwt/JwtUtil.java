package com.jpa.jwt;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jpa.entity.User;
import com.jpa.exceptions.InvalidTokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Service
public class JwtUtil implements Serializable {

	public static final long JWT_TOKEN_VALIDITY =  15 * 60 * 1000;   

	@Value("${jwt.secret}")
	private String secretKey;
	
	// generate token for user
	public String generateToken(User user) {

		Claims claims = Jwts.claims();
		claims.setSubject(user.getUserName());
		claims.put("role", user.getRole());

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				.signWith(SignatureAlgorithm.HS512 ,secretKey)
				.compact();
	}

	// validate and extract User details from header
	public User validateTokenAndGetUserDetails(String token) {
		
		
		try {
			Claims claims =Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
			User user = new User();
			user.setUserName(claims.getSubject());
			user.setRole((String) claims.get("role"));
			return user;
		} catch (SignatureException ex) {
			throw new InvalidTokenException("Token Signature not valid");
			
		} catch (ExpiredJwtException ex) {
			throw new InvalidTokenException("Token expired. Login again");
		}
		catch (IllegalArgumentException | MalformedJwtException ex) {
			throw new InvalidTokenException("Token is invalid");
		}
	
	}
}