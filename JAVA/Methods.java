public class Methods {
    public static void main(String[] args) {

        factorial(5);
        prime(5);
        
    }
    //factorial with loops
    static void factorial(int n){
        int factor = 1;
        for(int i = n; i > 0; i--){
            factor = factor * i;
        }
        System.out.println(factor);
    }

    static boolean prime(int n){
        if (n<=1){
            return false;
        }

        for(int i = 2;i < n-1;i++){
            if(n % i == 0){
                System.out.println("Not prime");
                return false;
            }

            else{
                System.out.println("Prime");
                return true;
            }
        }

        return true;

    }
}
