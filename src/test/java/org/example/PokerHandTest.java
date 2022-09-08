package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandTest {

    @Test
    void findCombinationHighCard() {
        assertEquals(Combination.HIGH_CARD, new PokerHand("KS 2H 5C JD TD").getCombination());
        assertEquals(Combination.HIGH_CARD, new PokerHand("AD 5S 9S TH JC").getCombination());
        assertEquals(Combination.HIGH_CARD, new PokerHand("2D 4S TS AC QH").getCombination());
        assertEquals(Combination.HIGH_CARD, new PokerHand("3H 5S 8C JH 7H").getCombination());
        assertEquals(Combination.HIGH_CARD, new PokerHand("4S 9H 6C QS AD").getCombination());
    }
    @Test
    void findCombinationPair() {
        assertEquals(Combination.PAIR, new PokerHand("KS 5H 5C JD TD").getCombination());
        assertEquals(Combination.PAIR, new PokerHand("KD KH 4H JH TC").getCombination());
        assertEquals(Combination.PAIR, new PokerHand("TS 2D 5C JC TH").getCombination());
        assertEquals(Combination.PAIR, new PokerHand("9S AH JS JD QD").getCombination());
        assertEquals(Combination.PAIR, new PokerHand("QC 2S 9S 2H 8H").getCombination());
    }
    @Test
    void findCombinationTwoPairs() {
        assertEquals(Combination.TWO_PAIRS, new PokerHand("KS 5H 5C KD TD").getCombination());
        assertEquals(Combination.TWO_PAIRS, new PokerHand("AS 8D 9S 8H AD").getCombination());
        assertEquals(Combination.TWO_PAIRS, new PokerHand("TS 3S QH 3H TC").getCombination());
        assertEquals(Combination.TWO_PAIRS, new PokerHand("5H 9C KD 5D KC").getCombination());
        assertEquals(Combination.TWO_PAIRS, new PokerHand("8C 2S AS AH 2D").getCombination());
    }
    @Test
    void findCombinationThree() {
        assertEquals(Combination.THREE, new PokerHand("2S 2H 2C JD TD").getCombination());
        assertEquals(Combination.THREE, new PokerHand("TS 2D TH TS 6S").getCombination());
        assertEquals(Combination.THREE, new PokerHand("AS 4S 8D 4D 4C").getCombination());
        assertEquals(Combination.THREE, new PokerHand("QS JS QH 7H QC").getCombination());
        assertEquals(Combination.THREE, new PokerHand("5H 5C 9C QD 5S").getCombination());
    }
    @Test
    void findCombinationStraight() {
        assertEquals(Combination.STRAIGHT, new PokerHand("2S 3H 4C 5D 6D").getCombination());
        assertEquals(Combination.STRAIGHT, new PokerHand("TS JC QD KS AH").getCombination());
        assertEquals(Combination.STRAIGHT, new PokerHand("3D 4D 5H 6S 7C").getCombination());
        assertEquals(Combination.STRAIGHT, new PokerHand("5C 9H 6S 8D 7S").getCombination());
        assertEquals(Combination.STRAIGHT, new PokerHand("8S TH 9S JD QC").getCombination());
    }
    @Test
    void findCombinationFlush() {
        assertEquals(Combination.FLUSH, new PokerHand("2S KS 4S 9S QS").getCombination());
        assertEquals(Combination.FLUSH, new PokerHand("5H QH AH 7H 4H").getCombination());
        assertEquals(Combination.FLUSH, new PokerHand("TD AD 3D 2D 8D").getCombination());
        assertEquals(Combination.FLUSH, new PokerHand("JC 5C 9C KC 2C").getCombination());
    }
    @Test
    void findCombinationFullHouse() {
        assertEquals(Combination.FULL_HOUSE, new PokerHand("4S 4H 4D TD TH").getCombination());
        assertEquals(Combination.FULL_HOUSE, new PokerHand("QS TS QH QD TH").getCombination());
        assertEquals(Combination.FULL_HOUSE, new PokerHand("9H 4S 9S 4H 9D").getCombination());
        assertEquals(Combination.FULL_HOUSE, new PokerHand("8D 8S AC AD AS").getCombination());
        assertEquals(Combination.FULL_HOUSE, new PokerHand("2S JH 2C 2D JS").getCombination());
    }
    @Test
    void findCombinationFour() {
        assertEquals(Combination.FOUR, new PokerHand("4S 4H 4D 4C AC").getCombination());
        assertEquals(Combination.FOUR, new PokerHand("KD 8H 8D 8C 8S").getCombination());
        assertEquals(Combination.FOUR, new PokerHand("TH TS 5S TC TD").getCombination());
        assertEquals(Combination.FOUR, new PokerHand("6D 6S 6C 3S 6H").getCombination());
        assertEquals(Combination.FOUR, new PokerHand("QS 7H QH QD QC").getCombination());
    }
    @Test
    void findCombinationStraightFlush() {
        assertEquals(Combination.STRAIGHT_FLUSH, new PokerHand("6H 7H 8H 9H TH").getCombination());
        assertEquals(Combination.STRAIGHT_FLUSH, new PokerHand("JS 7S 8S 9S TS").getCombination());
        assertEquals(Combination.STRAIGHT_FLUSH, new PokerHand("JC QC 8C 9C TC").getCombination());
        assertEquals(Combination.STRAIGHT_FLUSH, new PokerHand("JD QD 9D KD TD").getCombination());
        assertEquals(Combination.STRAIGHT_FLUSH, new PokerHand("3D 4D 5D 6D 2D").getCombination());
    }
    @Test
    void findCombinationRoyalFlush() {
        assertEquals(Combination.ROYAL_FLUSH, new PokerHand("TD JD QD KD AD").getCombination());
        assertEquals(Combination.ROYAL_FLUSH, new PokerHand("TH JH QH KH AH").getCombination());
        assertEquals(Combination.ROYAL_FLUSH, new PokerHand("TC JC QC KC AC").getCombination());
        assertEquals(Combination.ROYAL_FLUSH, new PokerHand("TS JS QS KS AS").getCombination());
    }
    @Test
    public void compareCombinationHighCard() {
        assertEquals(0, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("2H 5C JD KS TD")));
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("2S 2H 5C JD TD")));
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("3H 5S 8C JH 7H")));
        assertEquals(-1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("AD 5S 9S TH JC")));
    }
    @Test
    public void compareCombinationPair() {
        assertEquals(0, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("5H 5C JD KS TD")));
        assertEquals(-1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("KD KH 4H JH TC")));
        assertEquals(-1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("TS 2D 5C JC TH")));
        assertEquals(-1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("9S AH JS JD QD")));
    }
    @Test
    public void compareCombinationTwoPairs() {
        assertEquals(0, new PokerHand("KS 5H 5C KD TD").compareTo(new PokerHand("KS 5H 5C TD KD")));
        assertEquals(-1, new PokerHand("KS 5H 5C KD TD").compareTo(new PokerHand("8C 2S AS AH 2D")));
    }

    @Test
    public void compareCombinationThree() {
        assertEquals(0, new PokerHand("2S 2H 2C JD TD").compareTo(new PokerHand("2S TD 2H 2C JD")));
        assertEquals(-1, new PokerHand("2S 2H 2C JD TD").compareTo(new PokerHand("QS JS QH 7H QC")));
    }

    @Test
    public void compareCombinationStraight() {
        assertEquals(0, new PokerHand("2S 3H 4C 5D 6D").compareTo(new PokerHand("3H 2S 4C 5D 6D")));
        assertEquals(-1, new PokerHand("2S 3H 4C 5D 6D").compareTo(new PokerHand("8S TH 9S JD QC")));
    }

    @Test
    public void compareCombinationFlush() {
        assertEquals(0, new PokerHand("2S KS 4S 9S QS").compareTo(new PokerHand("2S KS 9S 4S QS")));
        assertEquals(1, new PokerHand("2S KS 4S 9S QS").compareTo(new PokerHand("JC 5C 9C KC 2C")));
    }

    @Test
    public void compareCombinationFullHouse() {
        assertEquals(0, new PokerHand("4S 4H 4D TD TH").compareTo(new PokerHand("4S TD 4H 4D TH")));
        assertEquals(-1, new PokerHand("4S 4H 4D TD TH").compareTo(new PokerHand("8D 8S AC AD AS")));
    }

    @Test
    public void compareCombinationFour() {
        assertEquals(0, new PokerHand("4S 4H 4D 4C AC").compareTo(new PokerHand("4S AC 4H 4D 4C")));
        assertEquals(-1, new PokerHand("4S 4H 4D 4C AC").compareTo(new PokerHand("TH TS 5S TC TD")));
    }

    @Test
    public void compareCombinationStraightFlush() {
        assertEquals(0, new PokerHand("6H 7H 8H 9H TH").compareTo(new PokerHand("6H TH 7H 8H 9H")));
        assertEquals(-1, new PokerHand("6H 7H 8H 9H TH").compareTo(new PokerHand("JD QD 9D KD TD")));
    }

    @Test
    public void compareCombinationRoyalFlush() {
        assertEquals(0, new PokerHand("TD JD QD KD AD").compareTo(new PokerHand("AD TD JD QD KD")));
        assertEquals(0, new PokerHand("TD JD QD KD AD").compareTo(new PokerHand("TS JS QS KS AS")));
    }

    @Test
    public void compareHighCardAndPair() {
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("KS 5H 5C JD TD")));
    }

    @Test
    public void compareHighCardAndTwoPairs() {
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("8C 2S AS AH 2D")));
    }

    @Test
    public void compareHighCardAndThree() {
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("2S 2H 2C JD TD")));
    }

    @Test
    public void compareHighCardAndStraight() {
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("2S 3H 4C 5D 6D")));
    }

    @Test
    public void compareHighCardAndFlush() {
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("JC 5C 9C KC 2C")));
    }

    @Test
    public void compareHighCardAndFullHouse() {
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("2S 2H KC KH KD")));
    }

    @Test
    public void compareHighCardAndFour() {
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("4S 4H 4D 4C AC")));
    }

    @Test
    public void compareHighCardAndStraightFlush() {
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("JD QD 9D KD TD")));
    }

    @Test
    public void compareHighCardAndRoyalFlush() {
        assertEquals(1, new PokerHand("KS 2H 5C JD TD").compareTo(new PokerHand("AD TD JD QD KD")));
    }

    @Test
    public void comparePairAndTwoPairs() {
        assertEquals(1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("8C 2S AS AH 2D")));
    }

    @Test
    public void comparePairAndThree() {
        assertEquals(1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("2S 2H 2C JD TD")));
    }

    @Test
    public void comparePairAndStraight() {
        assertEquals(1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("8S TH 9S JD QC")));
    }

    @Test
    public void comparePairAndFlush() {
        assertEquals(1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("JC 5C 9C KC 2C")));
    }

    @Test
    public void comparePairAndFullHouse() {
        assertEquals(1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("2S 2H KC KH KD")));
    }

    @Test
    public void comparePairAndFour() {
        assertEquals(1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("4S 4H 4D 4C AC")));
    }

    @Test
    public void comparePairAndStraightFlush() {
        assertEquals(1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("TS JS 9S KS QS")));
    }

    @Test
    public void comparePairAndRoyalFlush() {
        assertEquals(1, new PokerHand("KS 5H 5C JD TD").compareTo(new PokerHand("TS JS AS KS QS")));
    }

    @Test
    public void compareTwoPairsAndThree() {
        assertEquals(1, new PokerHand("8C 2S AS AH 2D").compareTo(new PokerHand("2S 2H 2C JD TD")));
    }

    @Test
    public void compareTwoPairsAndStraight() {
        assertEquals(1, new PokerHand("8C 2S AS AH 2D").compareTo(new PokerHand("8S TH 9S JD QC")));
    }

    @Test
    public void compareTwoPairsAndFlush() {
        assertEquals(1, new PokerHand("8C 2S AS AH 2D").compareTo(new PokerHand("JC 5C 9C KC 2C")));
    }

    @Test
    public void compareTwoPairsAndFullHouse() {
        assertEquals(1, new PokerHand("8C 2S AS AH 2D").compareTo(new PokerHand("2S 2H KC KH KD")));
    }

    @Test
    public void compareTwoPairsAndFour() {
        assertEquals(1, new PokerHand("8C 2S AS AH 2D").compareTo(new PokerHand("4S 4H 4D 4C AC")));
    }

    @Test
    public void compareTwoPairsAndStraightFlush() {
        assertEquals(1, new PokerHand("8C 2S AS AH 2D").compareTo(new PokerHand("TS JS 9S KS QS")));
    }

    @Test
    public void compareTwoPairsAndRoyalFlush() {
        assertEquals(1, new PokerHand("8C 2S AS AH 2D").compareTo(new PokerHand("TS JS AS KS QS")));
    }

    @Test
    public void compareThreeAndStraight() {
        assertEquals(1, new PokerHand("2S 2H 2C JD TD").compareTo(new PokerHand("8S TH 9S JD QC")));
    }

    @Test
    public void compareThreeAndFlush() {
        assertEquals(1, new PokerHand("2S 2H 2C JD TD").compareTo(new PokerHand("AD QD TD 7D 4D")));
    }

    @Test
    public void compareThreeAndFullHouse() {
        assertEquals(1, new PokerHand("2S 2H 2C JD TD").compareTo(new PokerHand("2S 2H KC KH KD")));
    }

    @Test
    public void compareThreeAndFour() {
        assertEquals(1, new PokerHand("2S 2H 2C JD TD").compareTo(new PokerHand("4S 4H 4D 4C AC")));
    }

    @Test
    public void compareThreeAndStraightFlush() {
        assertEquals(1, new PokerHand("2S 2H 2C JD TD").compareTo(new PokerHand("TS JS 9S KS QS")));
    }

    @Test
    public void compareThreeAndRoyalFlush() {
        assertEquals(1, new PokerHand("AC AS AD JH 4C").compareTo(new PokerHand("TS JS AS KS QS")));
    }

    @Test
    public void compareStraightAndFlush() {
        assertEquals(1, new PokerHand("8S TH 9S JD QC").compareTo(new PokerHand("AD QD TD 7D 4D")));
    }

    @Test
    public void compareStraightAndFullHouse() {
        assertEquals(1, new PokerHand("8S TH 9S JD QC").compareTo(new PokerHand("2S 2H KC KH KD")));
    }

    @Test
    public void compareStraightAndFour() {
        assertEquals(1, new PokerHand("8S TH 9S JD QC").compareTo(new PokerHand("4S 4H 4D 4C AC")));
    }

    @Test
    public void compareStraightAndStraightFlush() {
        assertEquals(1, new PokerHand("8S TH 9S JD QC").compareTo(new PokerHand("TS JS 9S KS QS")));
    }

    @Test
    public void compareStraightAndRoyalFlush() {
        assertEquals(1, new PokerHand("8S TH 9S JD QC").compareTo(new PokerHand("TS JS AS KS QS")));
    }

    @Test
    public void compareFlushAndFullHouse() {
        assertEquals(1, new PokerHand("8S TH 9S JD QC").compareTo(new PokerHand("2S 2H KC KH KD")));
    }

    @Test
    public void compareFlushAndFour() {
        assertEquals(1, new PokerHand("8S TH 9S JD QC").compareTo(new PokerHand("4S 4H 4D 4C AC")));
    }

    @Test
    public void compareFlushAndStraightFlush() {
        assertEquals(1, new PokerHand("8S TH 9S JD QC").compareTo(new PokerHand("TS JS 9S KS QS")));
    }

    @Test
    public void compareFlushAndRoyalFlush() {
        assertEquals(1, new PokerHand("2C AC 3C 4C 5C").compareTo(new PokerHand("TS JS AS KS QS")));
    }

    @Test
    public void compareFullHouseAndFour() {
        assertEquals(1, new PokerHand("2S 2H KC KH KD").compareTo(new PokerHand("4S 4H 4D 4C AC")));
    }

    @Test
    public void compareFullHouseAndStraightFlush() {
        assertEquals(1, new PokerHand("2S 2H KC KH KD").compareTo(new PokerHand("TS JS 9S KS QS")));
    }

    @Test
    public void compareFullHouseAndRoyalFlush() {
        assertEquals(1, new PokerHand("2S 2H KC KH KD").compareTo(new PokerHand("TS JS AS KS QS")));
    }

    @Test
    public void compareFourAndStraightFlush() {
        assertEquals(1, new PokerHand("4S 4H 4D 4C AC").compareTo(new PokerHand("TS JS 9S KS QS")));
    }

    @Test
    public void compareFourAndRoyalFlush() {
        assertEquals(1, new PokerHand("4S 4H 4D 4C AC").compareTo(new PokerHand("TS JS AS KS QS")));
    }

    @Test
    public void compareStraightFlushAndRoyalFlush() {
        assertEquals(1, new PokerHand("TS JS 9S KS QS").compareTo(new PokerHand("TS JS AS KS QS")));
    }
}