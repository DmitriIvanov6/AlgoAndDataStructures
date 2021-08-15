import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int imbalanced = 0;
        int quantity = 20;
        for (int i = 1; i <= quantity; i++) {
            Tree<Integer> tree = new TreeImpl<>(4);
            for (int j = 0; j <= 16; j++) {
                tree.add(random.nextInt(25 + 25 + 1) - 25);
            }
            tree.display();
            if (!tree.balanceCheck()) {
                imbalanced++;
                System.out.println("Imbalanced");
            } else {
                System.out.println("Balanced");
            }

        }
        double proc = 100.0 * imbalanced / quantity;

        System.out.println(imbalanced);
        System.out.println("Процент несбалансированных деревьев: " + proc);
    }
}
