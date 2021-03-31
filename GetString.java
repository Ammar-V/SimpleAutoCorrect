package autocorrect;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GetString {
	public static ArrayList<Character> characters = new ArrayList<>();
	static Dictionary dict = new Dictionary();
	public static Set<String> suggestions = new HashSet<>();
	public static final char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void main(String[] args) {
		Check check = new Check();

		for (char element : chars) {
			characters.add(element);
		}
		dict.read();

		// Checks if word exists in the dictionary
		Scanner input = new Scanner(System.in);
		while (true) {
			suggestions.clear();
			String word = (input.next()).toLowerCase();
			if (word.equals("/")) {
				break;
			}
			if ((Dictionary.dictionaryList.contains(word))) {
				System.out.println(word + " is a word!");
			} else {
				System.out.println(word + " is NOT a word!");
				check.swapCheck(word);
				check.replaceCheck(word);
				check.addCheck(word);
				check.removeCheck(word);

				System.out.println("Suggestions: " + suggestions);
			}
		}
		input.close();
	}

	// Converting words into numbers using the alphabet index.
	public static String convert(String word) {
		word = word.toLowerCase();
		String converted;
		converted = Integer.toString(word.length());
		for (int j = 0; j < word.length(); j++) {
			char current = word.charAt(j);
			converted += " " + characters.indexOf(current);
		}
		return converted;
	}

}
