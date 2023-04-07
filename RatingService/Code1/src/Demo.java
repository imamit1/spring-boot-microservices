import java.util.*;


public class Demo {
    public static void main(String[] args) {

        TreeMap<Integer, Integer> integerTreeMap = new TreeMap();
        integerTreeMap.put(1, null);
        integerTreeMap.put(2, null);
        System.out.println(integerTreeMap);

        Set<String> integers = new TreeSet<>();
        integers.add("Mohit");
        integers.add("Amit");

        for(String obj : integers) {
            System.out.println(obj);
        }
    }
}
