package autocorrect;

import java.util.ArrayList;
import java.util.Collections;

public class Check {
	public void swapCheck(String word) {
		ArrayList<Character> reOrder = new ArrayList<>();
		for (int j = 0; j < word.length(); j++) {
			reOrder.add(word.charAt(j));
		}
		for (int i = 0; i < reOrder.size() - 1; i++) {
			ArrayList<Character> temp = new ArrayList<>();
			for (char d : reOrder) {
				temp.add(d);
			}
			Collections.swap(temp, i, i + 1);
			String newWord = "";
			for (char t : temp) {
				newWord += t;
			}
			if (Dictionary.dictionaryList.contains(newWord)) {
				GetString.suggestions.add(newWord);
			}
		}
	}

	public void replaceCheck(String word) {
		for (int j = 0; j < word.length(); j++) {
			char[] splitWord = new char[word.length()];
			for (int a = 0; a < word.length(); a++) {
				splitWord[a] = word.charAt(a);
			}
			for (int i = 0; i < GetString.chars.length; i++) {
				splitWord[j] = GetString.chars[i];
				String newWord = "";
				for (char c : splitWord) {
					newWord += c;
				}
				if (Dictionary.dictionaryList.contains(newWord)) {
					GetString.suggestions.add(newWord);
				}
			}
		}
	}

	public void addCheck(String word) {
		for (int j = 0; j < word.length() + 1; j++) {
			ArrayList<Character> splitWord = new ArrayList<>();
			for (int a = 0; a < word.length(); a++) {
				splitWord.add(word.charAt(a));
			}
			splitWord.add(j, ' ');
			for (int i = 0; i < GetString.chars.length; i++) {
				splitWord.set(j, GetString.chars[i]);
				String newWord = "";
				for (char c : splitWord) {
					newWord += c;
				}
				if (Dictionary.dictionaryList.contains(newWord)) {
					GetString.suggestions.add(newWord);
				}
			}
		}
	}

	public void removeCheck(String word) {
		for (int i = 0; i < word.length() - 1; i++) {
			ArrayList<Character> splitWord = new ArrayList<>();
			for (int j = 0; j < word.length(); j++) {
				splitWord.add(word.charAt(j));
			}
			splitWord.remove(i);
			String newWord = "";
			for (char c : splitWord) {
				newWord += c;
			}
			if (Dictionary.dictionaryList.contains(newWord)) {
				GetString.suggestions.add(newWord);
			}
		}
	}
}
