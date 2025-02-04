import java.util.ArrayList;
public class Arraylist {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();

        cars.add("Toyota");
        cars.add("Mistubishi");
        cars.add("Ford");

        cars.remove(0);
        cars.set(1, "Nissan");
        cars.clear();

        for (int i = 0; i < cars.size(); i++){
            System.out.println(cars.get(i));
        }
    }
}
