import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TicketDispenserTest {

    @Test
    public void a_new_ticket_should_have_the_turn_number_subsequent_to_the_previous_one() {
        // Given
        TicketDispenser dispenser = new TicketDispenser();

        // When
        TurnTicket previousTicket = dispenser.getTurnTicket();
        TurnTicket newTicket = dispenser.getTurnTicket();

        // Then
        assertEquals(1, newTicket.getTurnNumber() - previousTicket.getTurnNumber());
    }

    @Test
    public void a_new_ticket_should_have_the_turn_number_subsequent_to_the_previous_one_from_another_dispenser() {
        // Given
        TicketDispenser anotherDispenser = new TicketDispenser();
        TicketDispenser dispenser = new TicketDispenser();

        // When
        TurnTicket previousTicketFromAnotherDispenser = anotherDispenser.getTurnTicket();
        TurnTicket newTicket = dispenser.getTurnTicket();

        // Then
        assertEquals(1, newTicket.getTurnNumber() - 
            previousTicketFromAnotherDispenser.getTurnNumber());
    }

    @Test
    public void the_new_ticket_should_have_the_next_turn_number_when_the_number_is_given_to_the_dispenser() {
        // Given
        MockTurnNumberSequence mockTurnNumberSequence = new MockTurnNumberSequence();
        mockTurnNumberSequence.arrangeNextTurnNumber(11);
        TicketDispenser dispenser = new TicketDispenser(mockTurnNumberSequence);

        // When
        TurnTicket newTicket = dispenser.getTurnTicket();

        // Then
        assertEquals(11, newTicket.getTurnNumber());
        mockTurnNumberSequence.verifyMethodGetNextTurnNumberIsCalledOnce();
    }

    @Test
    public void the_new_ticket_should_have_the_next_turn_number_when_the_number_is_given_to_the_dispenser_using_mockito() {
        // Given
        TurnNumberSequence mockTurnNumberSequence = mock(TurnNumberSequence.class);
        when(mockTurnNumberSequence.getNextTurnNumber()).thenReturn(11);
        TicketDispenser ticketDispenser = new TicketDispenser(mockTurnNumberSequence);

        // When
        TurnTicket newTicket = ticketDispenser.getTurnTicket();

        // Then
        assertEquals(11, newTicket.getTurnNumber());
        verify(mockTurnNumberSequence).getNextTurnNumber();
    }
}
