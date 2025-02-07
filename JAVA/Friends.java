public class Friends {
    String name;
    static int friendlist = 0;

    static  int toys = 0;

    Friends(String name){
        this.name = name;
        friendlist++;
    }

    static void addtoys(){
        toys++;
        System.out.println(toys);
    }
}
