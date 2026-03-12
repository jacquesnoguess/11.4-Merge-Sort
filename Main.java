public class Main {
    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Before sorting:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("After sorting:");
        printArray(numbers);
    }

    public static void mergeSort(int[] array) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);
        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
            array[k++] = left[i] < right[j] ? left[i++] : right[j++];
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
