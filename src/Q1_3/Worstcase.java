/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worstcase;

/**
 *
 * @author ypf12pxu
 */
public class Worstcase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Record mean and std deviation of performing an operation
        // reps times
        int[] arraysize = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600,
            700, 800, 900, 1000, 2000, 3000, 4000};
        int reps = 100;
        double sum = 0, s = 0;
        double sumSquared = 0;
       
        for (int i = 0; i < arraysize.length; i++) {
            for (int j = 0; j < reps; j++) {
                int data[][] = generateArray(arraysize[i]);
                long t1 = System.nanoTime();
                //call FindElement method for an instance of size n
                findElement_D(data, -1);
               // findElement_D1(data,-1);
               //  findElement_D2(data,8);
                long t2 = System.nanoTime() - t1;
                //Recording it in milli seconds to make it more interprettable
                sum += (double) t2 / 1000000.0;
                sumSquared += (t2 / 1000000.0) * (t2 / 1000000.0);

            }

            double mean = sum / reps;
            double variance = sumSquared / reps - (mean * mean);
            double stdDev = Math.sqrt(variance);
            // System.out.println("Mean: " + mean + " stdDev: " + stdDev);
             System.out.println(stdDev);
        }

    }

    public static int[][] generateArray(int n) {
        int[][] data = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + i == 8) {
                    data[i][j] = 9;
                } else {
                    data[i][j] = j + i;
                }

            }

        }
        return data;
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
