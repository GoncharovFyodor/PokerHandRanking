package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Перечисление номиналов карт
 */
public enum CardRank {
    TWO('2',10),
    THREE('3',11),
    FOUR('4',12),
    FIVE('5',13),
    SIX('6',14),
    SEVEN('7',15),
    EIGHT('8',16),
    NINE('9',17),
    TEN('T',18),
    JACK('J',19),
    QUEEN('Q',20),
    KING('K',21),
    ACE('A',22);
    /**
     * Соответствие между номиналом и его символьным обозначением
     */
    private static final Map<Character, CardRank> ranksCharMap = new HashMap<>();
    /**
     * Символьное обозначение номинала
     */
    private final char rankChar;
    private final int value;
    static{
        Arrays.stream(values()).forEach(rank -> ranksCharMap.put(rank.rankChar, rank));
    }
    CardRank(char rankChar, int value){
        this.rankChar=rankChar;
        this.value=value;
    }
    public static CardRank getRank(char rankChar){
        return ranksCharMap.get(rankChar);
    }
    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
