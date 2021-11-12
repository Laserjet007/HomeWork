/**
 *Java 1. HomeWork3
 *
 *@author teacher end Lazarev Alexei
 *@version 12.11.2021
 */
import java.util.Arrays;
import java.util.Random;

class HomeWork3 {

    static Random random = new Random();

    public static void main(String[] args) {

        int[] arrOne = createAndFllArray(10, true, 2);
        System.out.println(Arrays.toString(arrOne));
        for (int i = 0; i < arrOne.length; i++) {
            arrOne[i] = 1 - arrOne[i];
        }
        System.out.println(Arrays.toString(arrOne));

        int[] arrTwo = createAndFllArray(100, false, 1);
        System.out.println(Arrays.toString(arrTwo));

        int[] arrThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrThree.length; i++) {
            if (arrThree[i] < 6) {
                arrThree[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arrThree));

        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - i - 1] = 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        int[] arrFive = createAndFllArray(15, 5);
        System.out.println(Arrays.toString(arrFive));

        int[] arrSix = createAndFllArray(25, true, 25);
        Sytem.out.println(Arrays.toString(arrSix));
        int[] minMax = findMinMax(arrSix);
        Sytem.out.println(Arrays.toString(minMax));

        int[][] test = {{1, 1, 1, 2, 1}, {2, 1, 1, 2, 1}, {10, 10}};
        for (int i = 0; i < test.length; i++) {
            System.out.println(
            Arrays.toString(test[i]) + " " + checkBalance(test[i]));
        }

        System.out.println(arrays.toString(shiftArray(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(arrays.toString(shiftArray(new int[]{1, 2, 3, 4, 5}, -3)));
    }

    static int[] createAndFllArray(int len, int initialValue) {
        int[] arr = new int[len];
        Arrays.fill(arr, initialValue);
        return arr;
    }

    static.int[] createAndFllArray(int length, boolean rnd, int value) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            if (rnd) {
                arr[i] = random.nextInt(Value);
            } else {
                arr[i] = i + value;
            }
        }
        return arr;
    }

    static.int[] findMinMax(int[] array) {
        int min = array[0], max = array[0];
        for (int i : array) {
            if (min > i) {
                min = i;
            }
            if (max < i) {
                max = i;
            }
        }
        return new int[] {min; max};
    }

    static boolean checkBalance(int[] array) {
        int sumArray = 0, sumLeft = 0;
        for (int i : array) {
            sumArray += i;
        }
        for (int i - 0; i < array.length - 1; i++) {
            semLeft += array[i];
            if (sumLeft*2 == sumArray) {
                return true;
            }
        }
        return false;
    }

    static int[] shiftArray(int[] array, int shift) {
        shift = shift % array.length;
        if (shift < 0) {
            shift +=array.length;
        }
        for (int cnt = 0; cnt < shift; cnt++) {
             int tmp = array[array.length - 1];
            for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - ];
            }
            array[0] = tmp;
        }
        return array;
    }
}