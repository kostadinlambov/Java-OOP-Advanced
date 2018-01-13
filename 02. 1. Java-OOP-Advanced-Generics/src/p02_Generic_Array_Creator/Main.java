package p02_Generic_Array_Creator;

public class Main {
    public static void main(String[] args) {

        Object[] integers =  ArrayCreator.create(5, 1);
        Integer[] integers2 =  ArrayCreator.create(Integer.class, 6, 1);
//        for (Integer integer : integers2) {
//            System.out.println(integer);
//        }
//        System.out.println(String.join(", ", new CharSequence[]{integers2.toString()}));
    }
}
