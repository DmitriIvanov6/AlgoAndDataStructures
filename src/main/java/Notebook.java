public class Notebook {
    private final int price;
    private final String name;
    private final int RAM;

    public Notebook (int price, int RAM, String name){
        this.price = price;
        this.RAM = RAM;
        this.name = name;

    }

    public int getPrice() {
        return price;
    }

    public int getRAM() {
        return RAM;
    }

    public String getName() {
        return name;
    }
}
