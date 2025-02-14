package STREAM_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,5,7,8,9);

        Stream<Integer> data = nums.stream();

        Stream<Integer> mappedData = data.map(n -> n*2);
        mappedData.forEach(n -> System.out.println(n));




        List<Integer> new_nums = new ArrayList<>();
        for(int i =0; i < nums.size();i++){
           int twice = nums.get(i) * 2;
           new_nums.add(twice);
        }

        new_nums.forEach(n -> System.out.println(n));
    }
}
