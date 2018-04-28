package generator;

public class Name {
	private String firstName;
	private String lastName;
	private boolean complexFirstName;
	private String language;
	private boolean male;

	public Name(String firstName, String lastName, boolean complexFirstName, String language, boolean male) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.complexFirstName = complexFirstName;
		this.language = language;
		this.male = male;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean hasComplexFirstName() {
		return complexFirstName;
	}

	public String getLanguage() {
		return language;
	}

	public boolean isMale() {
		return male;
	}
}
