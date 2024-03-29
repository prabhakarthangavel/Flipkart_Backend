package com.flipkart.utils;

import org.springframework.stereotype.Component;

@Component
public class Utilities {	

	public boolean checkString(String input) {
	    String specialChars = "~`!@#$%^&*()-_=+\\|[{]};:'\",<.>/?";
	    char currentCharacter;
	    boolean numberPresent = false;
	    boolean upperCasePresent = false;
	    boolean lowerCasePresent = false;
	    boolean specialCharacterPresent = false;
	 
	    for (int i = 0; i < input.length(); i++) {
	        currentCharacter = input.charAt(i);
	        if (Character.isDigit(currentCharacter)) {
	            numberPresent = true;
	        } else if (Character.isUpperCase(currentCharacter)) {
	            upperCasePresent = true;
	        } else if (Character.isLowerCase(currentCharacter)) {
	            lowerCasePresent = true;
	        } else if (specialChars.contains(String.valueOf(currentCharacter))) {
	            specialCharacterPresent = true;
	        }
	    }
	    return numberPresent && upperCasePresent && lowerCasePresent && specialCharacterPresent;
	}
}
