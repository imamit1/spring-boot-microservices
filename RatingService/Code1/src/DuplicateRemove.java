import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DuplicateRemove {
    public static void main(String[] args) {


        int n[] = new int[]{4,5,7,11,9,13,8,12, 4, 4, 5, 6, 6};



        List<Integer> numbers = Arrays.stream(n).boxed().toList();

        List<Integer> onlyUnique = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println(onlyUnique);

        Long unique = numbers.stream().filter(num -> Collections.frequency(numbers, num) == 1).count();
        System.out.println(unique);

        Long duplicate = numbers.stream().filter(num -> Collections.frequency(numbers, num) > 1).collect(Collectors.toSet()).stream().count();
        System.out.println(duplicate);

        Map<Integer, Long> mapCounting = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(mapCounting);

        Map<Integer,Long> onlyDuplicates =  numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(item -> item.getValue() > 1)
                .collect(Collectors.toMap(e -> e.getKey(), e-> e.getValue()));
        System.out.println(onlyDuplicates);
    }

}
