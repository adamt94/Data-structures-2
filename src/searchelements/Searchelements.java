/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchelements;

/**
 *
 * @author adam
 */
public class Searchelements {

    /**
     * @param args the command line arguments
     */
    static int array[][] = {
        {1, 3, 7, 8, 8, 9,  12},
        {2, 4, 8, 9, 10, 30, 38},
        {4, 5, 10, 20, 29, 50, 60},
        {8, 10, 11, 30, 50, 60, 61},
        {11, 12, 40, 80, 90, 100, 111},
        {13, 15, 50, 100, 110, 112, 120},
        {22, 27, 61, 112, 119, 138, 153}};

    public static void main(String[] args) {
        int findelement[] = {4, 12, 110, 5, 6, 111};

        for (int i = 0; i < findelement.length; i++) {
            boolean j = findElement_D(array, findelement[i]);
            boolean u = findElement_D1(array, findelement[i]);
            boolean t = findElement_D2(array, findelement[i]);
            System.out.println("D: " + j + " D1: " + u + " D2: " + t);
        }

    }

    public static boolean findElement_D(int array[][], int element) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == element) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findElement_D1(int array[][], int element) {

        for (int[] data1 : array) {
            int low = 0;
            int high = array.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (element < data1[mid]) {
                    high = mid - 1;
                } else if (element > data1[mid]) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean findElement_D2(int data[][], int element) {
        int counter = data.length - 1;
        for (int i = 0; i < data.length; i++) {
            for (int j = counter; j >= 0; j--) {
                if (element == data[i][j]) {
                    return true;
                }
                if (element > data[i][j]) {
                    counter = j;
                    break;
                }

            }
        }
        return false;
    }

}
