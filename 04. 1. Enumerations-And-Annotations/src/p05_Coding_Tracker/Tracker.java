package p05_Coding_Tracker;


import java.lang.reflect.Method;
import java.util.*;

public class Tracker {
     private static Map<String, List<String>> map = new LinkedHashMap<>();


    @Author(name = "Pesho")
    public  void run(){

    }

    @Author(name = "Gosho")
    public void runAgain(){

    }

    public static void printMethodsByAuthor(Class<?> cl) {
        Method[] arr = cl.getDeclaredMethods();
        for (Method method : arr) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                String methodName = method.getName() + "()";
                String annotationValue = annotation.name();
                map.putIfAbsent(annotationValue, new ArrayList<>());
                map.get(annotationValue).add(methodName);
            }
        }

        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            System.out.println(stringListEntry.getKey() + ": " + String.join(", ", stringListEntry.getValue()));
        }
     }
}
