package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			String command = reader.readLine();

			if ("HARVEST".equalsIgnoreCase(command)) {
				break;
			}

			switch (command) {
				case "private":
					printAllPrivateFields();
					break;
				case "protected":
					printAllProtectedFields();
					break;
				case "public":
					printAllPublicFields();
					break;
				case "all":
					printAllFields();
					break;
			}
		}
	}

	private static void printAllFields() {
		Arrays.stream(RichSoilLand.class.getDeclaredFields())
				.forEach(field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
						field.getType().getSimpleName(), field.getName()));

	}

	private static void printAllPublicFields() {
		Arrays.stream(RichSoilLand.class.getDeclaredFields())
				.filter(field -> Modifier.isPublic(field.getModifiers()))
				.forEach(field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
						field.getType().getSimpleName(), field.getName()));
	}

	private static void printAllProtectedFields() {
		Arrays.stream(RichSoilLand.class.getDeclaredFields())
				.filter(field -> Modifier.isProtected(field.getModifiers()))
				.forEach(field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
						field.getType().getSimpleName(), field.getName()));
	}

	private static void printAllPrivateFields() {
		Arrays.stream(RichSoilLand.class.getDeclaredFields())
				.filter(field -> Modifier.isPrivate(field.getModifiers()))
				.forEach(field -> System.out.printf("%s %s %s%n", Modifier.toString(field.getModifiers()),
						field.getType().getSimpleName(), field.getName()));
	}
}
