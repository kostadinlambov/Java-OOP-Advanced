package p00_Reflection_Demo;

import p00_Reflection_Demo.annotation.Command;
import p00_Reflection_Demo.interfaces.Executable;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File[] commnads = new File("src/p00_Reflection_Demo/commands").listFiles();
//        for (File file : files) {
//            System.out.println(file.getName());
//        }

        while (true) {
            String command = reader.readLine();

            for (File file : commnads) {
                Class c = Class.forName("p00_Reflection_Demo.commands." + file.getName().replaceAll("\\.java", ""));
                Command a = (Command) c.getDeclaredAnnotation(Command.class);
                String value = a.value();

                Executable executable = (Executable) c.newInstance();

                if (value.equalsIgnoreCase(command)) {
                    executable.execute();
                }
            }
        }
    }
}
