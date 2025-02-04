public class Arrays {
    public static void main(String[] args) {
        String[] cars = {"Toyota", "Covette", "Tesla"};
        
        cars[0] = "Ford";
        System.out.println(cars[0]);


        int[] numbers = new int[3];

        for (int i = 0;i < numbers.length;i++){
            numbers[i] = i+1;
        }
        System.out.println(numbers[0]);



        //use the for loop to iterate over the elements of an array
        for(int i = 0;i < cars.length;i++){
            System.out.println(cars[i]);
        }
    }
}
