public class Objectpassing {
    public static void main(String[] args) {
        Cars car1 = new Cars("BMW");
        Cars car2 = new Cars("Audi");

        Garage garage = new Garage();
        garage.park(car1);
        garage.park(car2);
    }
}
