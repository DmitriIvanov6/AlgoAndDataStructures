package Homework5;

public class Main {
    public static void main(String[] args) {

//        System.out.println(Exponentiation.expon(2, 3));


        Item item1 = new Item("book", 1, 600);
        Item item2 = new Item("binoculars", 2, 5000);
        Item item3 = new Item("medkit", 4, 1500);
        Item item4 = new Item("notebook", 2, 40000);
        Item item5 = new Item("pot", 1, 500);

        BagTask bagTask = new BagTask(7);

        System.out.println(bagTask.findSuited(item1, item2, item3, item4, item5));







    }


}
