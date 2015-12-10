public class TurnNumberSequenceRegular extends TurnNumberSequence {
    private int turnNumber;

    public TurnNumberSequenceRegular(int startTurnNumber) {
        turnNumber = startTurnNumber;
    }

    @Override
    public int getNextTurnNumber() {
        return turnNumber++;
    }

}