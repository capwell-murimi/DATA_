public class Foreach {
    public static void main(String[] args) {
        //for each loop
        String[] cars = {"Toyota","Nissan","Ford"};
        for(String car: cars){
            System.out.println(car);
        }

        String[][] carModels = {
            {"Camry", "Corolla", "Prius"},
            {"Altima", "Sentra", "Maxima"},
            {"F-150", "Mustang", "Explorer"}
        };

        for(String carModelsrow[]: carModels){
            System.out.println();
            for(String carModel: carModelsrow){
                System.out.print(carModel);
            }

        }
    }

}
