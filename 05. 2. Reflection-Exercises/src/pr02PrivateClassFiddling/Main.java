package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException,
			NoSuchMethodException, InstantiationException, NoSuchFieldException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Class blackBoxIntClass = BlackBoxInt.class;

		Constructor constructor = blackBoxIntClass.getDeclaredConstructor();
		constructor.setAccessible(true);

		BlackBoxInt blackBoxIntInstance = (BlackBoxInt) constructor.newInstance();

		Method[] methods = blackBoxIntClass.getDeclaredMethods();

		while (true) {
			String[] tokens = reader.readLine().split("_");
			if ("End".equalsIgnoreCase(tokens[0])) {
				break;
			}

			String command = tokens[0];
			int methodParameterValue = Integer.parseInt(tokens[1]);

			for (Method method : methods) {
				String methodName = method.getName();
				if (methodName.equals(command)) {
					method.setAccessible(true);
					method.invoke(blackBoxIntInstance, methodParameterValue);
				}
			}

			Field returnField = blackBoxIntClass.getDeclaredField("innerValue");
			returnField.setAccessible(true);
			Integer returnValue = (Integer) returnField.get(blackBoxIntInstance);
			System.out.println(returnValue);
		}
	}
}
