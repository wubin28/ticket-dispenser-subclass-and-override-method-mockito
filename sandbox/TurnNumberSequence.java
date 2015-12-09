public class TurnNumberSequence {
    private static int _turnNumber = 0;

    public int getNextTurnNumber()
    {
        return _turnNumber++;
    }
}
