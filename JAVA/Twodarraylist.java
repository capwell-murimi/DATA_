import java.util.ArrayList;
public class Twodarraylist {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> cars = new ArrayList<ArrayList<String>>();

        ArrayList<String> toyota = new ArrayList<String>();
        toyota.add("Corolla");
        toyota.add("Vitz");
        toyota.add("Prado");

        ArrayList<String> nissan = new ArrayList<String>();
        nissan.add("Xtrail");
        nissan.add("Navara");
        nissan.add("Cube");

        ArrayList<String> ford = new ArrayList<String>();
        ford.add("Fiesta");
        ford.add("Focus");
        ford.add("Ranger");

        cars.add(toyota);
        cars.add(nissan);
        cars.add(ford);

        for ( int i = 0; i<cars.size();i++){
            System.out.println();
            for (int j = 0; j < cars.get(i).size(); j++){
                System.out.print(" "+cars.get(i).get(j)+" ");
            }
        }
    }
}
