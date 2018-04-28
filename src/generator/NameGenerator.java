package generator;

import com.victori.toolbox.utils.TextFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NameGenerator {
	public static List<Name> generateNames(String language, int number, boolean male) throws IllegalArgumentException{

		List<Name> names = new ArrayList<>();
				language = language.toLowerCase().trim();
		File langDir = new File("./res/" + language + "/");
		if (!langDir.isDirectory()) {
			throw new IllegalArgumentException("Language not found");
		}
		String path = langDir.getPath() + "/";
		String firstNameFilename;
		if (male) {
			firstNameFilename = "male-first.txt";
		}
		else {
			firstNameFilename = "female-first.txt";
		}

		TextFile firstNames = new TextFile(firstNameFilename, path);

		System.out.println(firstNames.getLine(3));

		return names;
	}

}
