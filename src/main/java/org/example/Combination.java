package org.example;

/**
 * Комбинации в техасском холдеме
 * (кикер, пара, две пары, сет, стрит, флеш, "три плюс два", каре, стрит-флеш, роял-флеш
 */
public enum Combination {
    HIGH_CARD(0),
    PAIR(1),
    TWO_PAIRS(2),
    THREE(3),
    STRAIGHT(4),
    FLUSH(5),
    FULL_HOUSE(6),
    FOUR(7),
    STRAIGHT_FLUSH(8),
    ROYAL_FLUSH(9);

    /**
     * Ценность комбинации
     */
    private final int score;

    Combination(int score) {
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
