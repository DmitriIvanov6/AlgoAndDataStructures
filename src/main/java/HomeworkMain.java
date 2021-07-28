public class HomeworkMain {
    public static void main(String[] args) {
        Notebook[] notebooks = new Notebook[5000];
        int[][] sortArray = new int[5000][2];
        for (int i = 0; i < notebooks.length; i++) {
            notebooks[i] = new Notebook(MethodsFill.fillPrice(), MethodsFill.fillRAM(), MethodsFill.fillName());
        }
        for (int i = 0; i < notebooks.length; i++) {

            sortArray[i][0] = Integer.parseInt(PrepareToSort.getArticle(notebooks[i].getPrice(), notebooks[i].getRAM(), notebooks[i].getName())) ;
            sortArray[i][1] = i;

        }

        for (int i = 0; i < notebooks.length; i++) {
            QuickSort.quickSort(sortArray, 0, sortArray.length -1);
        }

        Notebook[] temp = new Notebook[notebooks.length];
        for (int i = 0; i < notebooks.length; i++){
            temp[i] = notebooks[sortArray[i][1]];
        }
        System.arraycopy(temp, 0, notebooks, 0, notebooks.length);
        for (Notebook notebook : notebooks) {
            System.out.println("price: " + notebook.getPrice() + " RAM: " + notebook.getRAM() + " name:" + notebook.getName());
        }
    }
}
