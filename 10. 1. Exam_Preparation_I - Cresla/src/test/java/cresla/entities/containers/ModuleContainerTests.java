package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

public class ModuleContainerTests {
    private Container container;
    private AbsorbingModule absorbingModuleMocked1;
    private AbsorbingModule absorbingModuleMocked2;
    private EnergyModule energyModuleMocked1;
    private EnergyModule energyModuleMocked2;

    @Before
    public void before() {
        this.container = new ModuleContainer(2);
        this.absorbingModuleMocked1 = Mockito.mock(AbsorbingModule.class);
        this.absorbingModuleMocked2 = Mockito.mock(AbsorbingModule.class);
        this.energyModuleMocked1 = Mockito.mock(EnergyModule.class);
        this.energyModuleMocked2 = Mockito.mock(EnergyModule.class);

        Mockito.when(this.absorbingModuleMocked1.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(this.absorbingModuleMocked1.getId()).thenReturn(1);
        Mockito.when(this.absorbingModuleMocked2.getHeatAbsorbing()).thenReturn(2_000_000_000);
        Mockito.when(this.absorbingModuleMocked2.getId()).thenReturn(2);
        Mockito.when(energyModuleMocked1.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(energyModuleMocked1.getId()).thenReturn(3);
        Mockito.when(energyModuleMocked2.getEnergyOutput()).thenReturn(2_000_000_000);
        Mockito.when(energyModuleMocked2.getId()).thenReturn(4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullEnergyModule() {
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNullAbsorbingModuleTest() {
        this.container.addAbsorbingModule(null);
    }

    @Test
    public void removeModule() {
        this.container.addAbsorbingModule(this.absorbingModuleMocked1);
        this.container.addEnergyModule(this.energyModuleMocked1);
        this.container.addEnergyModule(this.energyModuleMocked2);
        Assert.assertEquals(0, this.container.getTotalHeatAbsorbing());
        Assert.assertEquals(4_000_000_000L, this.container.getTotalEnergyOutput());
    }

    @Test(expected = NoSuchElementException.class)
    public void zeroSize() {
        this.container = new ModuleContainer(0);
        this.container.addAbsorbingModule(this.absorbingModuleMocked1);
    }

    @Test
    public void emptyContainer() {
        Assert.assertEquals(0, this.container.getTotalEnergyOutput());
        Assert.assertEquals(0, this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void returnLongValueOfHeatAbsorbing() {
        this.container.addAbsorbingModule(this.absorbingModuleMocked1);
        this.container.addAbsorbingModule(this.absorbingModuleMocked2);

        Assert.assertEquals(4000000000L, this.container.getTotalHeatAbsorbing());
    }
}
