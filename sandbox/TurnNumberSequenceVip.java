public class TurnNumberSequenceVip extends TurnNumberSequence {
    private static int turnNumber;

    public TurnNumberSequenceVip(int startTurnNumber) {
        turnNumber = startTurnNumber;
    }

    @Override
    public int getNextTurnNumber() {
        return turnNumber;
    }
}