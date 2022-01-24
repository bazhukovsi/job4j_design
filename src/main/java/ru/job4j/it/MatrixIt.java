package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
        this.row = data.length;
    }

    @Override
    public boolean hasNext() {
        return row < data.length && column < data[row].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column == data[row].length) {
            row++;
            column = 0;
        }
        return data[row][column++];
    }

    public static void main(String[] args) {
        int[][] in = {
                {1, 2, 3},
                {4, 5, 6}
        };
        MatrixIt matrixIt = new MatrixIt(in);
        while (matrixIt.hasNext()) {
            System.out.println(matrixIt.next());
        }
    }
}
