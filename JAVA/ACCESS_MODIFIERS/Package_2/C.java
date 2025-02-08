package ACCESS_MODIFIERS.Package_2;
import ACCESS_MODIFIERS.Package_1.*;

@SuppressWarnings("unused")
public class C {
    public static void main(String[] args) {
        Asub sub = new Asub();
        System.out.println(sub.defauString);
        sub.priv();
    }
}
