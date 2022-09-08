package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PokerHand> hands = new ArrayList<>();
        hands.add(new PokerHand("KS 2H 5C JD TD"));
        hands.add(new PokerHand("2C 3C AC 4C 5C"));
        hands.add(new PokerHand("2C 3C AC 3S 3D"));
        hands.add(new PokerHand("4S 4H 4D TD TH"));
        Collections.sort(hands);
        hands.forEach(System.out::println);
    }
}