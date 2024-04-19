public class Snail {

    /**
     * TODO 5
     * <p>
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     * <p>
     * Example:
     * <p>
     * Input:
     * <p>
     * {
     * {1,2,3},
     * {4,5,6},
     * {7,8,9}
     * }
     * <p>
     * Output:
     * <p>
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     * returns an empty array if array2d is not square.
     */
    static int horizontal = 0;
    static int vertical = 0;

    private static void rightVector() {
        horizontal = 1;
        vertical = 0;
    }

    //method to move right
    private static void downVector() {
        horizontal = 0;
        vertical = 1;
    }

    //method to move down
    private static void leftVector() {
        horizontal = -1;
        vertical = 0;
    }

    //method to move left
    private static void upVector() {
        horizontal = 0;
        vertical = -1;
    }
    //method to move up

    private static void nextVector() {
        if (horizontal==1 && vertical ==0) downVector();
        else if (horizontal==0 && vertical == 1) leftVector();
        else if (horizontal== -1&& vertical == 0) upVector();
        else rightVector();
    }

    private static boolean outOfBounds(int[][] array2d, int i, int j) {
        return array2d==null || array2d.length < 1 || i < 0 || j < 0 || i > array2d.length || j > array2d[0].length;
    }

    //boolean to track visited indexes, how to store

    public static int[] flattenSnail(int[][] array2d) {
        if (!isPerfectSquare(array2d)) {
            return new int[0];
        }

        boolean[][] visited = new boolean[array2d.length][array2d[0].length];

        int[] returnarray = new int[array2d.length * array2d.length];
        int i=0, j=0;
        rightVector();
        for (int g = 0; g < returnarray.length; g++){
            int nextH = i + horizontal;
            System.out.println(nextH);
            int nextV = j + vertical;
            System.out.println(nextV);

            if (outOfBounds(array2d, nextH, nextV) || visited[nextV][nextH]){
                nextVector();
                System.out.println(horizontal);
                System.out.println(vertical);
            }
            else {
                System.out.println(array2d[nextV][nextH]);
                returnarray[g] = array2d[nextV][nextH];
                visited[nextV][nextH] = true;

            }
        }




        print1dArray(returnarray);
        return returnarray;

    }





    //put in return of the final array return null;


    /**
     * TODO 6
     * <p>
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     * <p>
     * Example:
     * <p>
     * Input:
     * <p>
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     * <p>
     * Output:
     * <p>
     * {
     * {1,2,3,4,5},
     * {16,17,18,19,6},
     * {15,24,25,20,7},
     * {14,23,22,21,8},
     * {13,12,11,10,9},
     * }
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     * returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        boolean[][] visited = new boolean[array1d.length][array1d.length];

        int[][] returnarray = new int[array1d.length][array1d.length];

        int i = 0, j = 0; // placing it into the 2d array
        rightVector();
        if (isPerfectSquare(array1d)) {

            for (int index = 0; index < array1d.length; index++ ) {
                returnarray[0][0] = array1d[0];
                int nextH = i + horizontal;
                int nextV = j + vertical;
                if (nextV >= array1d.length || nextH >= array1d.length || visited[nextV][nextH]) {
                    nextVector();
                } else {
                    returnarray[j][i] = array1d[index];
                    visited[nextV][nextH] = true;

                }



            }

            print2dArray(returnarray);
            return returnarray;



        }
        return new int [0] [0];
    }

    /**
     * TODO 1
     * <p>
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int i = 0; i < array1d.length; i++) {
            System.out.println(array1d[i]);
        }
    }

    /**
     * TODO 2
     * <p>
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] row : array2d) {
            for (int col : row) {
                System.out.println(col + " ");
            }
            System.out.println();
        }
    }

    /**
     * TODO 3
     * <p>
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        for (int i = 1; i < 100; i++) {
            if (array1d.length % i == i) {
                return true;
            }
        }
        return false;
    }


    /**
     * TODO 4
     * <p>
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        if (array2d.length == array2d[0].length) {
            return true;
        }
        return false;
    }
}



