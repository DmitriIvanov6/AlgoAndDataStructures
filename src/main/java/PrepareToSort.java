public class PrepareToSort {
    public static String getArticle(int price, int ram, String name){
        switch (name) {
            case ("Lenuvo"): name = "1";
                break;
            case ("Asos"): name = "2" ;
                break;
            case ("MacNote"): name = "3" ;
                break;
            case ("Eser"): name = "4" ;
                break;
            case ("Xamiou"): name = "5" ;
                break;
        }
        switch (ram) {
            case (4): ram = 1;
                break;
            case (8): ram = 2 ;
                break;
            case (12): ram = 3 ;
        }
        return Integer.toString(price) + Integer.toString(ram) + name;
    }


}
