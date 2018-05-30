package org.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Demo {

	public static void main(String[] args) {
		BCryptPasswordEncoder bcry = new BCryptPasswordEncoder();
		System.out.println(bcry.encode("acmesecret"));
	}

}
