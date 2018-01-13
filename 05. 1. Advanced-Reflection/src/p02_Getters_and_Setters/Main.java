package p02_Getters_and_Setters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {


        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(x -> System.out.println(x.getName() + " will return " + x.getReturnType()));

        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(x -> System.out.println(x.getName() + " and will set field of " + x.getParameterTypes()[0]));
    }
}
