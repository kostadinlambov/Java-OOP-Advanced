package panzer.models.miscellaneous;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.Assembler;
import panzer.contracts.AttackModifyingPart;
import panzer.contracts.DefenseModifyingPart;
import panzer.contracts.HitPointsModifyingPart;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleAssemblerTest {

    private Assembler assembler;
    private AttackModifyingPart attackModifyingPart1;
    private AttackModifyingPart attackModifyingPart2;
    private DefenseModifyingPart defenseModifyingPart1;
    private DefenseModifyingPart defenseModifyingPart2;
    private HitPointsModifyingPart hitPointsModifyingPart1;
    private HitPointsModifyingPart hitPointsModifyingPart2;


    @Before
    public void init() {
        this.assembler = new VehicleAssembler();
        this.attackModifyingPart1 = Mockito.mock(AttackModifyingPart.class);
        this.attackModifyingPart2 = Mockito.mock(AttackModifyingPart.class);
        this.defenseModifyingPart1 = Mockito.mock(DefenseModifyingPart.class);
        this.defenseModifyingPart2 = Mockito.mock(DefenseModifyingPart.class);
        this.hitPointsModifyingPart1 = Mockito.mock(HitPointsModifyingPart.class);
        this.hitPointsModifyingPart2 = Mockito.mock(HitPointsModifyingPart.class);

        Mockito.when(this.attackModifyingPart1.getWeight()).thenReturn(1_000_000_000.0);
        Mockito.when(this.attackModifyingPart1.getAttackModifier()).thenReturn(2_000_000_000);
        Mockito.when(this.attackModifyingPart1.getPrice()).thenReturn(new BigDecimal(2_000_000_000));
        Mockito.when(this.attackModifyingPart1.getModel()).thenReturn("1");

        Mockito.when(this.attackModifyingPart2.getWeight()).thenReturn(1_000_000_000.0);
        Mockito.when(this.attackModifyingPart2.getAttackModifier()).thenReturn(2_000_000_000);
        Mockito.when(this.attackModifyingPart2.getPrice()).thenReturn(new BigDecimal(2_000_000_000));
        Mockito.when(this.attackModifyingPart2.getModel()).thenReturn("2");

        Mockito.when(this.defenseModifyingPart1.getWeight()).thenReturn(1_000_000_000.0);
        Mockito.when(this.defenseModifyingPart1.getDefenseModifier()).thenReturn(2_000_000_000);
        Mockito.when(this.defenseModifyingPart1.getPrice()).thenReturn(new BigDecimal(2_000_000_000));
        Mockito.when(this.defenseModifyingPart1.getModel()).thenReturn("3");

        Mockito.when(this.defenseModifyingPart2.getWeight()).thenReturn(1_000_000_000.0);
        Mockito.when(this.defenseModifyingPart2.getDefenseModifier()).thenReturn(2_000_000_000);
        Mockito.when(this.defenseModifyingPart2.getPrice()).thenReturn(new BigDecimal(2_000_000_000));
        Mockito.when(this.defenseModifyingPart2.getModel()).thenReturn("4");

        Mockito.when(this.hitPointsModifyingPart1.getWeight()).thenReturn(1_000_000_000.0);
        Mockito.when(this.hitPointsModifyingPart1.getHitPointsModifier()).thenReturn(2_000_000_000);
        Mockito.when(this.hitPointsModifyingPart1.getPrice()).thenReturn(new BigDecimal(2_000_000_000));
        Mockito.when(this.hitPointsModifyingPart1.getModel()).thenReturn("5");

        Mockito.when(this.hitPointsModifyingPart2.getWeight()).thenReturn(1_000_000_000.0);
        Mockito.when(this.hitPointsModifyingPart2.getHitPointsModifier()).thenReturn(2_000_000_000);
        Mockito.when(this.hitPointsModifyingPart2.getPrice()).thenReturn(new BigDecimal(2_000_000_000));
        Mockito.when(this.hitPointsModifyingPart2.getModel()).thenReturn("6");


        this.assembler.addArsenalPart(attackModifyingPart1);
        this.assembler.addArsenalPart(attackModifyingPart2);
        this.assembler.addShellPart(defenseModifyingPart1);
        this.assembler.addShellPart(defenseModifyingPart2);
        this.assembler.addEndurancePart(hitPointsModifyingPart1);
        this.assembler.addEndurancePart(hitPointsModifyingPart2);
    }


    @Test
    public void getTotalWeight() throws Exception {
        double expected = 6_000_000_000.0;
        double actual = this.assembler.getTotalWeight();

        Assert.assertEquals(expected, actual, Double.MIN_VALUE);
    }

    @Test
    public void getTotalPrice() throws Exception {
        BigDecimal expected = new BigDecimal(12_000_000_000.0);
        BigDecimal actual = this.assembler.getTotalPrice();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalAttackModification() throws Exception {
        long expected = 4_000_000_000L;
        long actual = this.assembler.getTotalAttackModification();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalDefenseModification() throws Exception {
        long expected = 4_000_000_000L;
        long actual = this.assembler.getTotalDefenseModification();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTotalHitPointModification() throws Exception {
        long expected = 4_000_000_000L;
        long actual = this.assembler.getTotalHitPointModification();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addArsenalPart() throws Exception {

        //List<Part> partList = new ArrayList<>();

        Class<?> assemblerClass = assembler.getClass();
        Constructor constructor = assemblerClass.getDeclaredConstructor();

        Field arsenalPartsField = assemblerClass.getDeclaredField("arsenalParts");
        arsenalPartsField.setAccessible(true);
        List<AttackModifyingPart> arsenalParts = (List<AttackModifyingPart>) arsenalPartsField.get(assembler);


        arsenalParts.add(attackModifyingPart1);
        arsenalParts.add(attackModifyingPart2);


        int expected = 4;
        int actual = arsenalParts.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addShellPart() throws Exception {


    }

    @Test
    public void addEndurancePart() throws Exception {
    }
}