package ACCESS_MODIFIERS.Package_1;

import ACCESS_MODIFIERS.Package_2.Asub;

public class A {
    public static void main(String[] args) {
        Asub sub = new Asub();
        System.out.println(sub.pub);

        B b = new B();
        System.out.println(b.proc);

        sub.priv();
        sub.proc();
   }

    
}
