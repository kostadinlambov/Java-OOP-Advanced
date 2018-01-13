import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class AxeTests {

    private Axe axe = null;
    private Dummy dummy = null;

    @Before
    public void before() {
        System.out.println("before");
        axe = new Axe(5, 1);
        dummy = new Dummy(10, 0);
    }

    @Test
    public void axeLosesDurability() {
        //Arrange
//        Axe axe = new Axe(5, 1);
//        Dummy dummy = new Dummy(10, 0);
        //Act
        axe.attack(dummy);
        //Assert
        Assert.assertEquals("Wrong Durability lose", 0, axe.getDurabilityPoints());
    }

    @Test
    public void testAxeTestsFirstUnitTest() throws NoSuchMethodException {
        //Arrange
        AxeTests axeTests = new AxeTests();

        Class axeTestsClass = AxeTests.class;
        Method method = axeTestsClass.getDeclaredMethod("axeLosesDurability");
        //Assert
        Assert.assertTrue("No such Method!", method != null);
    }

    //Assert
    @Test(expected = IllegalStateException.class)
    public void attackWithBrokenWAxe() {
        //Arrange
//        Axe axe = new Axe(5, 1);
//        Dummy dummy = new Dummy(10, 0);
        //Act
        axe.attack(dummy);
        axe.attack(dummy);
    }

    @After
    public void after() {
        System.out.println("after");
    }
}
