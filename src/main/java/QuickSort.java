class QuickSort {

    static void swap(int[][] arr, int i, int j) {
        int tempArticle = arr[i][0];
        int tempIndex = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = tempArticle;
        arr[j][1] = tempIndex;
    }

    static int partition(int[][] arr, int low, int high) {

        int pivot = arr[high][0];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j][0] < pivot) {

                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[][] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


}