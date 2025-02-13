package STREAM_API;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,5,7,8,9);

        Stream<Integer> data = nums.stream();

        long count = data.count();
        System.out.println(count);

        data.forEach(n -> System.out.println(n));
    }
}
