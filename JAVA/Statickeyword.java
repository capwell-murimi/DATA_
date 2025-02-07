public class Statickeyword {
    public static void main(String[] args) {
        Friends friend1 = new Friends("Capwell");
        Friends friend2 = new Friends("Kim");
        Friends friend3 = new Friends("John");

        System.out.println("You have " +Friends.friendlist+ " Friends");

        Friends.addtoys();
    }
}
