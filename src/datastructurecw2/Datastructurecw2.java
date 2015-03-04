package datastructurecw2;

/**
 *
 * @author ypf12pxu
 */
public class Datastructurecw2 {

   

    public static void main(String[] args) {
        int n = 2;
        System.out.println(g(n));
    }


    public static double g(int n) {
        return f(n, n);
    }

    public static double f(int i, int j) {

        if (i == 0 && j == 0) {
            return 0;
        }
        if (i == 0 || j == 0) {
            return 1;
        }

        return (f(i - 1, j) + f(i - 1, j - 1) + f(i, j - 1)) / 3;
    }

}
