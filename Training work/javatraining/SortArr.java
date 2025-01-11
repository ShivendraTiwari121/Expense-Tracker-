
public class SortArr {

    public static void main(String[] args) {
        int arr1[] = {3, 7, 11, 1, 9, 24};
        System.out.println("Before Selection Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        selectionSort(arr1);

        System.out.println("After Selection Sort");
        for (int i : arr1) {
            System.out.print(i + " ");
        }

        maxMinNum(arr1);
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    private static void maxMinNum(int[] arr) {
        int max = arr[arr.length - 1]; // Initialize max with the last element after sorting
        int min = arr[0]; // Initialize min with the first element after sorting

        // Output the greatest and smallest number after sorting
        System.out.println("Greatest num is: " + max);
        System.out.println("Lowest num is: " + min);
    }
}
