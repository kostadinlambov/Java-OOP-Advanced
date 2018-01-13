package app.models.actions;

import app.contracts.Targetable;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class OneVsOneTest {
    private static final String NOT_TWO_PARTICIPANTS = "There should be exactly 2 participants for OneVsOne!";

    private OneVsOne action;
    private List<Targetable> participants;

    @Before
    public void setUp() {
        this.action = new OneVsOne();
        this.participants = new ArrayList<>();
    }

    // Test for invalid count of warriors
    @Test
    public void executeActionShouldFailForInvalidCountOfWarriors() {
        // Act
        String actual = this.action.executeAction(this.participants);
        String expected = NOT_TWO_PARTICIPANTS;

        // Assert
        Assert.assertEquals(expected, actual);
    }

    // Test for valid count of warriors
    @Test
    public void executeActionShouldSucceedForSecondWarrior() {
        // Arrange
        Warrior victor = Mockito.mock(Warrior.class);
        Warrior looser = Mockito.mock(Warrior.class);
        Mockito.doNothing().when(victor).levelUp();
        Mockito.doNothing().when(looser).levelUp();
        Mockito.when(victor.attack(looser)).thenReturn("");
        Mockito.when(looser.attack(victor)).thenReturn("");
        Mockito.when(victor.isAlive()).thenReturn(true);
        Mockito.when(victor.getName()).thenReturn("Victor");
        Mockito.when(looser.isAlive()).thenReturn(false);
        Mockito.when(looser.getName()).thenReturn("Looser");

        this.participants.add(looser);
        this.participants.add(victor);

        //Act
        String result = this.action.executeAction(this.participants).trim();

        // Assert
        Assert.assertTrue(result, result.startsWith(victor.getName()));
    }
}
