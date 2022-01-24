package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean even = false;
        while (index < data.length) {
            if (data[index] % 2 == 0) {
                even = true;
                break;
            }
            index++;
        }
        return even;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    public static void main(String[] args) {
        int[] it = new int[]{1, 2, 3, 4, 5, 6, 6};
        EvenNumbersIterator evenNumbersIterator = new EvenNumbersIterator(it);
        while (evenNumbersIterator.hasNext()) {
            System.out.println(evenNumbersIterator.next());
        }
    }
}
