package ACCESS_MODIFIERS.Package_2;

import ACCESS_MODIFIERS.Package_1.*;

public class Asub extends B{

     //default string only works on the same package - in this case package_2
    String defauString = "This is a default string";

    //A public string works kila mahali - on all packages
    public String pub = "This is a public string";

    //A private string can only be accessed on the same file - not even a file in the same package - lol
    //A private string can be accessed in other packages when put in a public function
    private String lindwa = "This is a private string";

    public void priv(){
        Asub sub = new Asub();
        System.out.println(sub.lindwa); 
    } 

   public void proc(){
        proc = "I have written the protected string again";
        System.out.println(proc);
    }
    
}
