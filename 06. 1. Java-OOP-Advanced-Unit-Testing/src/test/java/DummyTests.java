import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DummyTests {
    private static final int DUMMY_INITIAL_HEALTH = 2;
    private static final int DUMMY_INITIAL_EXPERIENCE = 2;
    private static final int AXE_INITIAL_ATTACK = 1;
    private static final int AXE_INITIAL_DURABILITY = 10;
    private static final int EXPECTED_DUMMY_HEALTH = 1;
    private static final String WRONG_DUMMY_HEALTH_MESSAGE = "Wrong Dummy Health!";
    private static final int WEAPON_ATTACK_POINTS = 1;
    private static final int WEAPON_DURABILITY_POINTS = 2;
    private static final int DUMMY_INITIAL_HEALTH_EXPERIENCE_TEST = 0;

    @Test
    public void losesHealthProperly() {
        Dummy dummy = new Dummy(DUMMY_INITIAL_HEALTH, DUMMY_INITIAL_EXPERIENCE);
        Axe axe = new Axe(AXE_INITIAL_ATTACK, AXE_INITIAL_DURABILITY);
        axe.attack(dummy);
        Assert.assertEquals(WRONG_DUMMY_HEALTH_MESSAGE,
                EXPECTED_DUMMY_HEALTH, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsException() {
        Dummy dummy = new Dummy(DUMMY_INITIAL_HEALTH, DUMMY_INITIAL_EXPERIENCE);
        Axe axe = new Axe(3, 10);
        dummy.takeAttack(axe.getAttackPoints());
        dummy.takeAttack(axe.getAttackPoints());
       // axe.attack(dummy);
       // axe.attack(dummy);
    }


    @Test(expected = IllegalStateException.class)
    public void aliveDummyDontGiveExperience() {
        //Arrange
        Dummy dummy = new Dummy(DUMMY_INITIAL_HEALTH, DUMMY_INITIAL_EXPERIENCE);
        //Act
        dummy.giveExperience();
    }

    @Test
    public void deadDummyGiveExperience() {
        //Arrange
        Dummy dummy = new Dummy(DUMMY_INITIAL_HEALTH_EXPERIENCE_TEST, DUMMY_INITIAL_EXPERIENCE);
        //Assert
        Assert.assertEquals("Dead dummy don't give Experience", DUMMY_INITIAL_EXPERIENCE, dummy.giveExperience());
    }

}
