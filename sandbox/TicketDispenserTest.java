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
        TurnNumberSequence turnNumberSequence = new TurnNumberSequence(0);
        TicketDispenser anotherDispenser = new TicketDispenser(turnNumberSequence);
        TicketDispenser dispenser = new TicketDispenser(turnNumberSequence);

        // When
        TurnTicket previousTicketFromAnotherDispenser = anotherDispenser.getTurnTicket();
        TurnTicket newTicket = dispenser.getTurnTicket();

        // Then
        assertEquals(1, newTicket.getTurnNumber() - 
            previousTicketFromAnotherDispenser.getTurnNumber());
    }

    @Test
    public void the_new_ticket_should_have_a_turn_number_when_the_number_is_given_to_the_dispenser() {
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
    public void the_new_ticket_should_have_a_turn_number_when_the_number_is_given_to_the_dispenser_using_mockito() {
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

    @Test
    public void the_turn_number_of_VIP_customers_starts_from_1001() {
        // Arrange
        TurnNumberSequence vipTurnNumberSequence = new TurnNumberSequenceVip(1001);
        TicketDispenser vipCustomerTicketDispenser = new TicketDispenser(vipTurnNumberSequence);

        // Act
        TurnTicket firstTicketOfVipCustomer = vipCustomerTicketDispenser.getTurnTicket();

        // Assert
        assertEquals(1001, firstTicketOfVipCustomer.getTurnNumber());
    }

    @Test
    public void the_turn_number_of_regular_customers_starts_from_2001() {
        // Arrange
        TurnNumberSequence regularTurnNumberSequence = new TurnNumberSequenceRegular(2001);
        TicketDispenser regularCustomerTicketDispenser = new TicketDispenser(regularTurnNumberSequence);

        // Act
        TurnTicket firstTicketOfRegularCustomer = regularCustomerTicketDispenser.getTurnTicket();

        // Assert
        assertEquals(2001, firstTicketOfRegularCustomer.getTurnNumber());
    }

    @Test
    public void the_dispensers_for_VIP_and_regular_customers_could_be_used_together() {
        // Arrange
        TurnNumberSequence turnNumberSequenceVip = new TurnNumberSequenceVip(1001);
        TicketDispenser ticketDispenserVip = new TicketDispenser(turnNumberSequenceVip);

        TurnNumberSequence turnNumberSequenceRegular = new TurnNumberSequenceRegular(2001);
        TicketDispenser ticketDispenserRegular = new TicketDispenser(turnNumberSequenceRegular);

        // Act
        TurnTicket firstTicketOfVipCustomer = ticketDispenserVip.getTurnTicket();
        TurnTicket firstTicketOfRegularCustomer = ticketDispenserRegular.getTurnTicket();

        // Assert
        assertEquals(1001, firstTicketOfVipCustomer.getTurnNumber());
        assertEquals(2001, firstTicketOfRegularCustomer.getTurnNumber());
    }
}

