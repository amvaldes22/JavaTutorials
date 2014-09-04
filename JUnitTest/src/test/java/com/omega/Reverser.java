package com.omega;

public class Reverser {
	public String sbReverser(String str) {
		String reverse = new StringBuilder(str).reverse().toString();
		return reverse;
	}

	public String charReverser(String str) {
		StringBuffer buffer = new StringBuffer();

		for (int i = str.length()-1; i >= 0; i--) {
			buffer.append(str.charAt(i));
		}

		return buffer.toString();
	}
}
