package main;

public class SquareMatrix {

    private int[][] matrix;
    private int size;

    SquareMatrix(int[][] matrix, int size) {
        this.matrix = matrix;
        this.size = size;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }


    public int getSize() {
        return this.size;
    }

    public int countElementsWithValueBiggerThanIndexSum() {
        int elements = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] > (i+j)) elements++;
            }
        }

        return elements;
    }


    public int[][] swapRows(int k1, int k2) {

        if (k1 >= size || k2 >= size || k1 < 0 || k2 < 0) throw new ArrayIndexOutOfBoundsException();

        int[] tempRow = matrix[k1];
        int[][] newMatrix = matrix.clone();
        newMatrix[k1] = newMatrix[k2];
        newMatrix[k2] = tempRow;

        return newMatrix;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                res.append(matrix[i][j]);
                res.append("\t");
            }
            res.append("\n");
        }

        return res.toString();
    }
}
