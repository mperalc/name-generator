package generator;

import com.victori.toolbox.tools.MathTools;
import com.victori.toolbox.utils.TextFile;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.ThreadLocalRandom.current;

public class NameGenerator {
	public static List<Name> generateUniqueNames(String language, int number, boolean male) throws IllegalArgumentException {
		return generateNames(language, number, male, true);
	}

	public static List<Name> generateNames(String language, int number, boolean male) throws IllegalArgumentException {
		return generateNames(language, number, male, true);
	}

	public static Name generateName(String language, boolean male) throws IllegalArgumentException {
		return generateNames(language, 1, male).get(0);
	}

	public static List<Name> generateNames(String language, int number, boolean male, boolean uniqueNames) throws IllegalArgumentException {

		if (number < 1) {
			throw new IllegalArgumentException("Number needs to be > 0");
		}
		List<Name> names;
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
		TextFile lastNames = new TextFile("last.txt", path);


		if (uniqueNames) {
			Set<Name> nameSet = new HashSet<>();
			while (nameSet.size() < number) {
				int fi = ThreadLocalRandom.current().nextInt(1, firstNames.getLinesNumber() + 1);
				int li = ThreadLocalRandom.current().nextInt(1, lastNames.getLinesNumber() + 1);

				String firstName = firstNames.getLine(fi);
				String lastName = lastNames.getLine(li);

				Name name = new Name(firstName, lastName, language, male);
				nameSet.add(name);
			}

			names = new ArrayList<>(nameSet);
		}

		else {
			int[] randomNumbersFirst = MathTools.genRandomIntegers(number, 1, firstNames.getLinesNumber());
			int[] randomNumbersLast = MathTools.genRandomIntegers(number, 1, lastNames.getLinesNumber());
			names = new ArrayList<>();
			for (int i = 0; i < number; i++) {
				String firstName = firstNames.getLine(randomNumbersFirst[i]);
				firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
				String lastName = lastNames.getLine(randomNumbersLast[i]);
				lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);

				Name name = new Name(firstName, lastName, language, male);
				names.add(name);
			}
		}
		return names;
	}

	/**
	 * Method that generates a list of names of mixed gender.
	 * @param language language of the names to get.
	 * @param number total number of names.
	 * @param uniqueNames true for non-repeated names.
	 * @param percentMale % of male names.
	 * @return a List of Names.
	 * @throws IllegalArgumentException if language file not found or if number < 1
	 */
	public static List<Name> generateMixedGenderNames(String language, int number, boolean uniqueNames, int percentMale) throws IllegalArgumentException {
		int numMale = (int) Math.round((double) ((percentMale * number)/100));

		System.out.println(Integer.toString(numMale));
		int numFemale = number - numMale;

		List<Name> males = generateNames(language, numMale, true, uniqueNames);
		List<Name> females = generateNames(language, numFemale, false, uniqueNames);
		males.addAll(females);
		return males;
	}

	public static List<Name> generateMixedGenderUniqueNames(String language, int number, int percentMale) throws IllegalArgumentException {
		return generateMixedGenderNames(language, number, true, percentMale);
	}
}