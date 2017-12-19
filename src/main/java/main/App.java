package main;

import java.util.Scanner;

public class App
{

    public static void main( String[] args )
    {
        System.out.print("Input matrix size:");

        Scanner in = new Scanner(System.in, "UTF-8");

        int n = in.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        SquareMatrix squareMatrix = new SquareMatrix(matrix, n);

        System.out.println("Elements with value bigger than index sum count: " + squareMatrix.countElementsWithValueBiggerThanIndexSum());

        System.out.println(squareMatrix);

        int k1;
        int k2;

        System.out.println("Input k1: ");
        k1 = in.nextInt();
        System.out.println("Input k2: ");
        k2 = in.nextInt();

        squareMatrix = new SquareMatrix(squareMatrix.swapRows(k1, k2), squareMatrix.getSize());
        System.out.println(squareMatrix);

    }
}
