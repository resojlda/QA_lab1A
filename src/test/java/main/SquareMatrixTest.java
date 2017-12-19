package main;

import org.junit.Assert;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SquareMatrixTest {
    @org.junit.Test(expected = NullPointerException.class)
    public void testGetMatrix_MatrixIsNull_ReturnsNull() {
        int size = 2;
        int[][] matrix = null;

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);
        assertTrue(squareMatrix.getMatrix().equals(null));
    }

    @org.junit.Test
    public void testGetMatrix_MatrixHasData_ReturnsMatrix() {
        int size = 2;
        int[][] matrix = {
                {0, 0},
                {0, 0}
        };

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);
        assertTrue(Arrays.equals(squareMatrix.getMatrix(), matrix));
    }

    @org.junit.Test
    public void testCountElements_NoElementsAreBiggerThanIndexCount_ReturnsZero() {
        int size = 2;
        int[][] matrix = {
                {0, 0},
                {0, 0}
        };

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);

        int count = squareMatrix.countElementsWithValueBiggerThanIndexSum();

        assertEquals(count, 0);
    }

    @org.junit.Test
    public void testCountElements_SomeElementsAreBiggerThanIndexCount_ReturnsSomeElementsCount() {
        int size = 2;
        int[][] matrix = {
                {0, 2},
                {5, 0}
        };

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);

        int count = squareMatrix.countElementsWithValueBiggerThanIndexSum();

        assertEquals(count, 2);
    }

    @org.junit.Test
    public void testCountElements_AllElementsAreBiggerThanIndexCount_ReturnsElementsCount() {
        int size = 2;
        int[][] matrix = {
                {5, 5},
                {5, 5}
        };

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);

        int count = squareMatrix.countElementsWithValueBiggerThanIndexSum();

        assertEquals(count, squareMatrix.getSize()*2);
    }

    @org.junit.Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSwapElements_K1IsOutOfBounds_ReturnsNull() {
        int size = 2;
        int[][] matrix = {
                {5, 5},
                {5, 5}
        };

        int k1 = -1;
        int k2 = 0;

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);
        squareMatrix.swapRows(k1, k2);
    }

    @org.junit.Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testSwapElements_K2IsOutOfBounds_ReturnsNull() {
        int size = 2;
        int[][] matrix = {
                {5, 5},
                {5, 5}
        };

        int k1 = 0;
        int k2 = -1;

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);
        squareMatrix.swapRows(k1, k2);
    }

    @org.junit.Test
    public void testSwapElements_K1AndK2IsInBoundsAndK1DoesNotEqualK2_ReturnsMatrixWithSwappedRow() {
        int size = 2;
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int[][] swappedMatrix = {
                {3, 4},
                {1, 2}
        };

        int k1 = 0;
        int k2 = 1;

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);

        assertTrue(Arrays.deepEquals(swappedMatrix, squareMatrix.swapRows(k1, k2)));
    }

    @org.junit.Test
    public void testSwapElements_K1AndK2IsInBoundsAndK1EqualsK2_ReturnsMatrixWithSwappedRow() {
        int size = 2;
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        int k1 = 0;
        int k2 = 0;

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);

        assertTrue(Arrays.deepEquals(matrix, squareMatrix.swapRows(k1, k2)));
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void testToString_MatrixIsNull_ThrowsException() {
        SquareMatrix m = null;
        m.toString();
    }

    @org.junit.Test
    public void testToString_MatrixIsValid_ReturnString() {
        int size = 2;
        int[][] matrix = {
                {5, 5},
                {5, 5}
        };

        SquareMatrix squareMatrix = new SquareMatrix(matrix, size);
        Assert.assertEquals(squareMatrix.toString(), "5\t5\t\n5\t5\t\n");
    }
}
