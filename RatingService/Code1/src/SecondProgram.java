import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SecondProgram {
    public static void main(String[] args) {

        int n[] = new int[]{4,5,7,11,9,13,8,12, 4, 4, 5, 6, 6};
        List<Integer> nn = Arrays.
                stream(n).boxed().collect(Collectors.toList());

        Map<Integer, Long> counting = nn.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(counting);

        Set<Integer> dupl = nn.stream().filter(item -> Collections.frequency(nn, item) > 1)
                                            .collect(Collectors.toSet());

        System.out.println(dupl);



    }
}
