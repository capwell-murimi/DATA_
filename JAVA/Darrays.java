public class Darrays {
    public static void main(String[] args) {
        String cars[][] = new String[3][3];
        
        cars[0][0] = "Toyota";
        cars[0][1] = "Camaro";
        cars[0][2] = "Chevrolet";

        cars[1][0] = "Subaru";
        cars[1][1] = "Mistubishi";
        cars[1][2] = "Nissan";

        cars[2][0] = "Lamboghini";
        cars[2][1] = "BMW";
        cars[2][2] = "Audi";

        //iterate over 2d array

        for(int i = 0;i < cars.length;i++){
            System.out.println();
            for(int j = 0; j < cars[i].length;j++){
                System.out.println(cars[i][j]);
            }

        }
    }
}
