package ru.job4j.stream;

import java.util.stream.Stream;

public class DeckOfCards {
    public static void main(String[] args) {
        Suit[] suits = Suit.values();
        Value[] values = Value.values();
        Stream.of(suits)
                .flatMap(value -> Stream.of(values)
                        .map(suit -> new Card(value, suit)))
                .forEach((card) -> System.out.println(card.getValue() + " " + card.getSuit()));
    }
}
