public class TurnNumberSequence {
    private int turnNumber;

    public TurnNumberSequence() {
        this(0);
    }

    public TurnNumberSequence(int startTurnNumber) {
        turnNumber = startTurnNumber;
    }

    public int getNextTurnNumber() {
        return turnNumber++;
    }
}