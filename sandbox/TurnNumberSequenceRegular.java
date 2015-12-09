public class TurnNumberSequenceRegular extends TurnNumberSequence {
    private static int turnNumber;

    public TurnNumberSequenceRegular(int startTurnNumber) {
        turnNumber = startTurnNumber;
    }

    @Override
    public int getNextTurnNumber() {
        return turnNumber++;
    }

}