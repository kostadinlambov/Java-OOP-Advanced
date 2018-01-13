package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static org.mockito.Mockito.when;


public class HeroInventoryTest {

    private Inventory inventory;
    private Item mockedItem;
    private Recipe mockedRecipe;

    @Before
    public void initialize() throws IllegalAccessException {
        this.inventory = new HeroInventory();
        this.mockedItem = Mockito.mock(Item.class);
        this.mockedRecipe =Mockito.mock(Recipe.class);
    }

    @Test
    public void correctCombineItems() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        when(this.mockedItem.getName()).thenReturn("Knife");
        when(this.mockedRecipe.getName()).thenReturn("Knife");
        this.inventory.addCommonItem(mockedItem);
        this.inventory.addRecipeItem(mockedRecipe);
        Assert.assertEquals(this.inventory.getTotalIntelligenceBonus(), mockedRecipe.getIntelligenceBonus());

    }

    @Test
    public void addingNewRecipeShouldIncreaseItemsSize() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        this.inventory.addRecipeItem(this.mockedRecipe);
        Field field = this.inventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Recipe> recipeMap = (Map<String, Recipe>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

    @Test
    public void addingNewCommonShouldIncreaseItemsSize() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        this.inventory.addRecipeItem(this.mockedRecipe);
        Field field = this.inventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Item> recipeMap = (Map<String, Item>) field.get(this.inventory);
        Assert.assertEquals("Incorrect items count", 1, recipeMap.size());
    }

    @Test
    public void strengthGetterShouldReturnCorrectResult() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        when(this.mockedItem.getStrengthBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void agilityGetterShouldReturnCorrectResult() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        when(this.mockedItem.getAgilityBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void intelligenceGetterShouldReturnCorrectResult() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        when(this.mockedItem.getIntelligenceBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void hitPointsGetterShouldReturnCorrectResult() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        when(this.mockedItem.getHitPointsBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void damageGetterShouldReturnCorrectResult() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        when(this.mockedItem.getDamageBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.mockedItem);
        Assert.assertEquals(10, this.inventory.getTotalDamageBonus());
    }
}
