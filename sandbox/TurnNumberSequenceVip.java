public class TurnNumberSequenceVip extends TurnNumberSequence {
    private int turnNumber;

    public TurnNumberSequenceVip(int startTurnNumber) {
        turnNumber = startTurnNumber;
    }

    @Override
    public int getNextTurnNumber() {
        return turnNumber++;
    }
}