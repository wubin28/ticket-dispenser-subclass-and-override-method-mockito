public class MockTurnNumberSequence extends TurnNumberSequence {
    private int nextTurnNumber;
    private int callCount;

    public MockTurnNumberSequence() {
        nextTurnNumber = 0;
        callCount = 0;
    }

    public void arrangeNextTurnNumber(int nextTurnNumber) {
        this.nextTurnNumber = nextTurnNumber;
    }

    @Override
    public int getNextTurnNumber() {
        this.callCount++;
        return this.nextTurnNumber;
    }

    public void verifyMethodGetNextTurnNumberIsCalledOnce() {
        if (this.callCount != 1) {
            throw new IllegalStateException("The method MockTurnNumberSequence.getNextTurnNumber() should be called once.");
        }
    }
}