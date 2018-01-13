package p03_High_Quality_Mistakes;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Arrays.stream(p02_Getters_and_Setters.Reflection.class.getDeclaredFields())
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.println(field.getName() + " must be private!"));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> !Modifier.isPublic(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(x -> System.out.println(x.getName() + " have to be public!"));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set"))
                .filter(method -> !Modifier.isPrivate(method.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(x -> System.out.println(x.getName() + " have to be private!"));
    }
}
