public class Arraysofobjects{
    public static void main(String[] args) {
        Vegetables[] veg = new Vegetables[3];

        Vegetables veg1 = new Vegetables("Carrot");
        Vegetables veg2 = new Vegetables("Onion");
        Vegetables veg3 = new Vegetables("Potato");

        veg[0] = veg1;
        veg[1] = veg2;
        veg[2] = veg3;

        for(int i = 0; i< veg.length;i++){
            System.out.println(veg[i].name);
        }

        for(Vegetables veggie: veg){
            System.out.println(veggie.name);
        }
    }
}