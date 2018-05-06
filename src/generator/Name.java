package generator;

public class Name {
	private String firstName;
	private String lastName;
	private String language;
	private boolean male;

	public Name(String firstName, String lastName, String language, boolean male) {
		this.language = language;
		this.male = male;

		firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
		lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCompleteName() {
		return firstName + " " + lastName;
	}

	public boolean hasComplexFirstName() {
		String[] split = firstName.split(" ");
		return split.length>1;
	}

	public String getLanguage() {
		return language;
	}

	public boolean isMale() {
		return male;
	}

	@Override
	public String toString() {
		return getCompleteName();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Name) {
			Name name = (Name) o;
			return getCompleteName().equals(name.getCompleteName());
		}
		else {
			return false;
		}

	}
}
