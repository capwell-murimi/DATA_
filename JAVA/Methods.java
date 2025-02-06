import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Methods {
    public static void main(String[] args) {

        factorial(5);
        prime(77);
        reverse("cow");

        int[] numbers = {1,2,3,6,7,45,67,69};
        findmax(numbers);

        add(1234);

        anogram("Kitchen", "Kitchen");
     
    }
    //factorial with loops
    static void factorial(int n){
        int factor = 1;
        for(int i = n; i > 0; i--){
            factor = factor * i;
        }
        System.out.println(factor);
    }

    //prime number
    static boolean prime(int n){
        if (n<=1){
            return false;
        }

        for(int i = 2; i <= java.lang.Math.sqrt(n); i++){
            if(n % i == 0){
                System.out.println("Not Prime");
                return false;
            }
        }
        
        System.out.println("Prime");
        return true;

    }


   //resverse a string
    static void reverse(String s){
        for (int i = s.length()-1; i >= 0; i--){
            String newword = "";
            newword = newword + s.charAt(i);
            System.out.print(newword);
        }
        System.out.println();
    }

    //find max in an array
    static void findmax(int[] numbers){
        int max = numbers[0];
        for(int i = 1; i < numbers.length; i++){
            if (numbers[i] > max){
                max = numbers[i];

            }
        }
        System.out.println("Max is: "+max);
    }


    //add digits of a number
    static void add(int n){
       List<Integer> numbers = new ArrayList<>();
       while(n > 0){
        int digit = n % 10;
        numbers.add(0,digit);
        n = n/10;
       }

       int sumn = 0;
       for(int i = 0; i < numbers.size(); i++){
        sumn = sumn + numbers.get(i);
       }
       System.out.println(sumn);
    }


    static void anogram(String s1, String s2){

        s1.toLowerCase();
        s2.toLowerCase();
        if(s1.length() != s2.length()){
            System.out.println("Hii sio anogram");
        }
        else{
            char[] s1array = s1.toCharArray();
            char[] s2array = s2.toCharArray();

            Arrays.sort(s1array);
            Arrays.sort(s2array);

            if(Arrays.equals(s1array, s2array)){
                System.out.println("Hii ni anogram");
            }
            else{
                System.out.println("Hii sio anogram");
            }
        }
    }
}
