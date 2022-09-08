package org.example;

import lombok.Data;

import java.util.Objects;

/**
 * Класс "Карта"
 */
@Data
public class Card implements Comparable<Card>{
    /**
    Номинал карты (от двойки до туза)
     */
    private final CardRank rank;
    /**
     * Масть карты
     */
    private final CardSuit suit;
    public Card(String card){
        rank = CardRank.getRank(card.charAt(0));
        suit = CardSuit.getSuit(card.charAt(1));
        if(rank==null||suit==null||card.length()!=2){
            throw new IllegalArgumentException("Invalid card: "+card);
        }
    }

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        if(rank==null||suit==null){
            throw new IllegalArgumentException("Invalid card: "+rank+" "+suit);
        }
    }

    /**
     * Вычисление порядкового номера карты (для сравнения при сортировке)
     * @return порядковый номер карты
     */
    private int getCardOrdinal(){
        return rank.ordinal()+(suit.ordinal())*100;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(getCardOrdinal(), o.getCardOrdinal());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
