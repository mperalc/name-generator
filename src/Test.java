import generator.Name;
import generator.NameGenerator;

import java.util.List;

import static generator.NameGenerator.generateMixedGenderUniqueNames;

public class Test {
	public static void main(String[] args) {
		List<Name> nombres = NameGenerator.generateMixedGenderUniqueNames("American",20, 60);

		for (Name nombre : nombres) {
			System.out.println(nombre);
		}
	}
}
