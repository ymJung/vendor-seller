package com.weone.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ASPasswordEncoder implements PasswordEncoder {
	private static final String EMPTY_STRING = "";
	@Value("${pass_salt}")
	private String SALT = "+SALT";
	
	private String getHash(CharSequence input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(input.toString().getBytes());
			return Base64.encodeBase64String(md.digest());
		} catch (NoSuchAlgorithmException ne) {
			return EMPTY_STRING;
		}
	}

	@Override
	public String encode(CharSequence rawPassword) {
		return getHash(rawPassword + SALT);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String encodePwd = encode(rawPassword);
		return encodedPassword.equals(encodePwd);
	}
}
