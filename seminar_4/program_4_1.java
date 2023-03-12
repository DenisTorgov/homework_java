package seminar_4;

import java.util.Random;

public class program_4_1 {
    public static void printarr (int[] xa) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < xa.length; i++) {
            sb.append(xa[i] + "| ");
        }
        System.out.println(sb);
    }
    public static int[] randArray(int x) {
        int[] arr = new int[x];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(0, 100);
        }
        return arr;
    }
    public static int[] heap(int[] arr, int step) {
        int temp =0;
        for (int i = arr.length - 1 - step; i > 0 ; i -= 2) {
            if (arr[i] > arr[(i - 2)/2]) {
                temp = arr[(i - 2)/2];
                arr[(i - 2)/2] = arr[i];
                arr[i] = temp; 
            }
            if (arr[i - 1] > arr[(i - 2)/2]) {
                temp = arr[(i - 2)/2];
                arr[(i - 2)/2] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
        printarr(arr);
        step += 1;
        arr = swap(arr, step);
        return arr;
    }
    public static int[] swap (int[] arr, int j) {
        if (j == arr.length) {
            return arr;
        }
        int temp1 = 0;
        temp1 = arr[0] ;
        arr[0] = arr[arr.length - j];
        arr[arr.length - j] = temp1;
        
        printarr(arr);
        System.out.println("Swap");
        return heap(arr, j);
    }
    public static void main (String[] arg) {
        // int[] unsortedarr = new int[] {8, 3, 2, 7, 9, 1, 4};
        int[] unsortedarr = randArray(10);
        printarr(unsortedarr);
        printarr(heap(unsortedarr, 0));
    }
}
