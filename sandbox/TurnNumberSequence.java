public class TurnNumberSequence {
    private int turnNumber;

    public TurnNumberSequence() {
    }

    public TurnNumberSequence(int startTurnNumber) {
        turnNumber = startTurnNumber;
    }

    public int getNextTurnNumber() {
        return turnNumber++;
    }
}