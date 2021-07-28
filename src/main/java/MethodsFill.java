import java.util.Random;

public class MethodsFill {

    public static int fillPrice(){
        Random random = new Random();
        int price = random.nextInt(10 - 5 +1 ) + 5;
        price *= 100;
        return price;
    }
    public static int fillRAM() {
        Random random = new Random();
        int ram = random.nextInt(3 - 1 + 1) + 1;
        ram *= 4;
        return ram;
    }

    public static String fillName() {
        Random random = new Random();
        String name = null;
        int nameCase = random.nextInt(5 - 1 + 1) + 1;
        switch (nameCase) {
            case (1): name = "Lenuvo";
            break;
            case (2): name =  "Asos";
            break;
            case (3): name =  "MacNote";
            break;
            case (4): name =  "Eser";
            break;
            case (5): name =  "Xamiou";
            break;
        } return name;
    }



}
