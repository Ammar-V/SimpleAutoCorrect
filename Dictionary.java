package autocorrect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	public static ArrayList<String> dictionaryList = new ArrayList<>();

	public void read() {
		Scanner scan = null;
		try {
			File directory = new File(getClass().getResource("english3.txt").getPath().replace("%20", " "));
			scan = new Scanner(directory);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scan.hasNext()) {
			String word = scan.nextLine();
			dictionaryList.add(word);
		}
	}
}
