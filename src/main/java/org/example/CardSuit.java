package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Перечисление мастей карт
 */
public enum CardSuit {
    SPADES('S'),
    HEARTS('H'),
    DIAMONDS('D'),
    CLUBS('C');

    /**
     * Соответствие между мастью и ее символьным обозначением
     */
    private static final Map<Character, CardSuit> suitsCharMap = new HashMap<>();
    private final char suitChar;
    static{
        Arrays.stream(values()).forEach(suit -> suitsCharMap.put(suit.suitChar, suit));
    }

    CardSuit(char suitChar){
        this.suitChar=suitChar;
    }
    public static CardSuit getSuit(char suitChar){
        return suitsCharMap.get(suitChar);
    }

    @Override
    public String toString() {
        return this.name();
    }
}
