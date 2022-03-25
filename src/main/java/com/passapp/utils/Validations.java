package com.passapp.utils;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class Validations {
	public boolean isEmailValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public boolean isPasswordValid(String password) {
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{6,20}$";
		Pattern pat = Pattern.compile(passwordRegex);
		if (password == null)
			return false;
		return pat.matcher(password).matches();
	}
}
