package p06_Custom_Enum_Annotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String ENUM_PACKAGE_PATH = "p06_Custom_Enum_Annotation.";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String token = reader.readLine();

        Class<?> enumClass = Class.forName(ENUM_PACKAGE_PATH + token);

        MyAnnotation myAnnotation = (MyAnnotation) enumClass.getAnnotation(MyAnnotation.class);

        System.out.println("Type = " + myAnnotation.type() +
                ", Description = " + myAnnotation.description());
    }
}
