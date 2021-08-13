public class SearchElement {

    public static double search(int[] arr) {
        int num = 1;
        int start = 0;
        int end = arr.length - 1;
        double density = 1.0 * (end - start) / (arr[end] - arr[start]);
        int base = (int)(start + 1.0 * (end - start) / (arr[end] - arr[start] * (num - arr[start])));
        return density;

    }


}
