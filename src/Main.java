import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào value để tìm kiếm: ");
        int value = scanner.nextInt();
        int[] arr = new int[]{1, 2, 5, 9, 8, 3, 4, 100, 3, 4, 8, 0, 11, 111, 444, 5, 777, 999, 10000, 888,999,22,2222,3333,444,7777,0000,6666,77};
        Arrays.sort(arr);
        System.out.println("sau khi sap xep " + Arrays.toString(arr));
        System.out.println("========================LINEAR SEARCH========================");
        long start1 = System.nanoTime();
        if (linearSearch(arr, value) == -1) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("Tìm thấy value " + value + " ở vị trí " + linearSearch(arr, value));
        }
        long end1 = System.nanoTime();
        System.out.println("TIME1 ----------> " + (end1 - start1));
        System.out.println("=========================BINARY SEARCH=======================");
        long start2 = System.nanoTime();
        if (binarySearch(arr, value) == -1) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("Tìm thấy value " + value + " ở vị trí " + binarySearch(arr, value));
        }
        long end2 = System.nanoTime();
        System.out.println("TIME2 ----------> " + (end2 - start2));
        System.out.println("==========================BINARY SEARCH RECURSIVE========================");
        long start3 = System.nanoTime();
        int low = 0;
        int high = arr.length-1;
        if (binarySearchRecursive(arr,low,high,value) == -1) {
            System.out.println("NOT FOUND!");
        } else {
            System.out.println("Tìm thấy value " + value + " ở vị trí " + binarySearchRecursive(arr,low,high,value));
        }
        long end3 = System.nanoTime();
        System.out.println("TIME3 ----------> " + (end3 - start3));
        System.out.println("=====================DO ĐỘ PHỨC TẠP FOR THƯỜNG O(1)=================================");
        long start4 = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            System.out.println("i ==== "+i);

        }
        long end4 = System.nanoTime();
        System.out.println("TIME4 ----------> " + (end4 - start4));
        System.out.println("=====================DO ĐỘ PHỨC TẠP FOR LỒNG O(n2) =================================");
        long start5 = System.nanoTime();
        for (int i = 0; i < 20; i++) {
            System.out.println("i ==== "+i);
            for (int j = 0; j < 20; j++) {
                System.out.println("j ============"+j);
            }
        }
        long end5 = System.nanoTime();
        System.out.println("TIME5 ----------> " + (end5 - start5));
    }
    public static int linearSearch(int arr[], int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[], int value) {
        int low = 0;
        int high = arr.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

   public static int binarySearchRecursive(int arr[], int low, int high, int value) {
        if (high >= low) {

            int mid = low + (high - low) / 2;
            if (arr[mid] == value){
                return mid;
            }
            if (arr[mid] > value){
                return binarySearchRecursive(arr, low, mid - 1, value);
            }
            return binarySearchRecursive(arr, mid + 1, high, value);
        }
        return -1;
    }

}