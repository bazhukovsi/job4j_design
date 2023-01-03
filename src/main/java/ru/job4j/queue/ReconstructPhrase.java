package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder output = new StringBuilder("");
        int sizeDeque = evenElements.size();
        for (int i = 0; i < sizeDeque; i++) {
            if (i % 2 == 0) {
                output.append(evenElements.pollFirst());
            } else {
                evenElements.pollFirst();
            }
        }
        return output.toString();
    }

    private String getDescendingElements() {
        StringBuilder output = new StringBuilder("");
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            output.append(iterator.next());
        }
        return output.toString();
    }

    public String getReconstructPhrase() {
        return  getEvenElements() + getDescendingElements();
    }
}
