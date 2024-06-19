package com.unla.grupo36.helpers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderHelper {

	public static String encodePassword(String password) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		return pe.encode(password);
	}
	
}
