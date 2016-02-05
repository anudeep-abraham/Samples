package com.leetspeak;

public class LeetSpeak {

	/*
	 * Converts the given word to "Leet Speak"
	 * 
	 * @param wordIn
	 * 
	 * @return wordOut
	 */
	public String generateLeetSpeak(String wordIn) {
		String wordOut = "";
		for (int index = 0; index < wordIn.length(); index++) {
			switch (wordIn.charAt(index)) {
			case 'a':
			case 'A':
				wordOut += "4";
				break;
			case 'e':
			case 'E':
				wordOut += "3";
				break;
			case 'i':
			case 'I':
				wordOut += "1";
				break;
			case 'o':
			case 'O':
				wordOut += "0";
				break;
			case 's':
			case 'S':
				wordOut += "5";
				break;
			case 't':
			case 'T':
				wordOut += "7";
				break;
			default:
				wordOut += wordIn.charAt(index);
			}
		}
		return wordOut;
	}

}
