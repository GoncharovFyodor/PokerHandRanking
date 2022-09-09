package org.example;

import lombok.Data;

import java.util.*;

@Data
public class PokerHand implements Comparable<PokerHand>{
    private final Combination combination;
    private final List<Card> cards;
    private final long sameScore;
    public PokerHand(String hand){
        cards = getCardsFromString(hand);
        List<CardRank> ranks = getRanksFromCardsList(cards);
        List<CardSuit> suits = getSuitsFromCardsList(cards);
        //Максимальное число карт одного номинала
        int maxDuplicateCardsCount = findMaxDuplicatesCount(ranks);
        combination = findCombination(ranks, suits, maxDuplicateCardsCount);
        sameScore = findSameScore(getRanksMap(ranks), maxDuplicateCardsCount);
    }

    private Map<Integer, Integer> getRanksMap(List<CardRank> ranks) {
        Map<Integer,Integer> ranksMap = new LinkedHashMap<>();
        ranks.forEach(rank->ranksMap.merge(rank.getValue(), 1,Integer::sum));
        return ranksMap;
    }

    private List<Card> getCardsFromString(String hand) {
        List<Card> cards = new ArrayList<>();
        Arrays.stream(hand.split(" ")).forEach(card->cards.add(new Card(card)));
        if(cards.size()!=5)
            throw new IllegalArgumentException("Illegal poker hand size");
        Collections.sort(cards);
        return cards;
    }

    private List<CardSuit> getSuitsFromCardsList(List<Card> cards) {
        List<CardSuit> suits = new ArrayList<>();
        cards.forEach(card ->suits.add(card.getSuit()));
        return suits;
    }

    private List<CardRank> getRanksFromCardsList(List<Card> cards) {
        List<CardRank> ranks = new ArrayList<>();
        cards.forEach(card ->ranks.add(card.getRank()));
        Collections.sort(ranks);
        return ranks;
    }

    private int findMaxDuplicatesCount(List<CardRank> ranks) {
        int last = ranks.get(0).getValue();
        int max = 0;
        int current = 1;
        for (int i = 1; i < ranks.size(); i++) {
            if(ranks.get(i).getValue()==last){
                current++;
            }else{
                max = Math.max(max,current);
                current=1;
            }
            last = ranks.get(i).getValue();
        }
        return Math.max(max,current);
    }

    public Combination findCombination(List<CardRank> ranks, List<CardSuit> suits, int maxDuplicateCardsCount) {
        switch ((int)ranks.stream().distinct().count()){
            case 5:
                boolean straight = (ranks.get(4).getValue()-ranks.get(0).getValue())==4;
                boolean flush = suits.get(4)==suits.get(3)&&suits.get(3)==suits.get(2)&&suits.get(2)==suits.get(1)&&suits.get(1)==suits.get(0);
                if(straight&&flush)
                    return ranks.contains(CardRank.ACE)?Combination.ROYAL_FLUSH:Combination.STRAIGHT_FLUSH;
                else if(flush)
                    return Combination.FLUSH;
                else if(straight)
                    return Combination.STRAIGHT;
                else
                    return Combination.HIGH_CARD;
            case 4:
                return Combination.PAIR;
            case 3:
                return maxDuplicateCardsCount ==3?Combination.THREE:Combination.TWO_PAIRS;
            case 2:
                return maxDuplicateCardsCount ==3?Combination.FULL_HOUSE:Combination.FOUR;
            default:
                return Combination.HIGH_CARD;
        }
    }

    private long findSameScore(Map<Integer,Integer> ranksMap,int maxDuplicateCardsCount) {
        StringBuilder sameScore = new StringBuilder();
        int max = 0;
        while(true){
            if(ranksMap.containsValue(maxDuplicateCardsCount)){
                for(Map.Entry<Integer,Integer> rank : ranksMap.entrySet()){
                    if(rank.getValue().equals(maxDuplicateCardsCount)){
                        max=Math.max(max,rank.getKey());
                    }
                }
                sameScore.append(max);
                ranksMap.remove(max);
                max=0;
            }else{
                maxDuplicateCardsCount--;
                if(maxDuplicateCardsCount<=0)
                    break;
            }
        }
        return Long.parseLong(sameScore.toString());
    }

    @Override
    public int compareTo(PokerHand o) {
        int comparison = -Integer.compare(combination.getScore(),o.combination.getScore());
        return comparison==0?Long.compare(sameScore,o.sameScore):comparison;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokerHand pokerHand = (PokerHand) o;
        return sameScore == pokerHand.sameScore && combination == pokerHand.combination && Objects.equals(cards, pokerHand.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(combination, cards, sameScore);
    }
}
