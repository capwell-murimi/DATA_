package PREDICATE;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> p = i -> (i > 10);
        System.out.println(p.test(6));

        Predicate<String> l = s -> (s.length() > 4);
        System.out.println(l.test("cow"));

        String[] names = {"David","Scott","Smith","John","Mary"};


       for(int i = 0; i < names.length;i++){
            if (l.test(names[i])) {
                System.out.println(names[i]);
            }
        }
        

        for(String i: names){
            if(l.test(i)){
                System.out.println(i);
            }
        }
    }
}
;