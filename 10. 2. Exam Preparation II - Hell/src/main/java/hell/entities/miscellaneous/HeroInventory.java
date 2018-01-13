package hell.entities.miscellaneous;

import hell.factories.ItemFactory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class HeroInventory implements Inventory {

    @ItemCollection
    private Map<String, Item> commonItems;

    private Map<String, Recipe> recipeItems;

    public HeroInventory() {
        this.commonItems = new LinkedHashMap<String, Item>();
        this.recipeItems = new LinkedHashMap<String, Recipe>();
    }

    @Override
    public long getTotalStrengthBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getStrengthBonus()).sum();
    }

    @Override
    public long getTotalAgilityBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getAgilityBonus()).sum();
    }

    @Override
    public long getTotalIntelligenceBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getIntelligenceBonus()).sum();
    }

    @Override
    public long getTotalHitPointsBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getHitPointsBonus()).sum();
    }

    @Override
    public long getTotalDamageBonus() {
        return this.commonItems.entrySet().stream().mapToLong((x) -> x.getValue().getDamageBonus()).sum();
    }

    @Override
    public void addCommonItem(Item item) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.commonItems.put(item.getName(), item);
        this.checkRecipes();
    }

    @Override
    public void addRecipeItem(Recipe recipe) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.recipeItems.put(recipe.getName(), recipe);
        this.checkRecipes();
    }

    private void checkRecipes() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        for (Recipe recipe : this.recipeItems.values()) {
            List<String> requiredItems = new ArrayList<String>(recipe.getRequiredItems());

            for (Item item : this.commonItems.values()) {
                if (requiredItems.contains(item.getName())) {
                    requiredItems.remove(item.getName());
                }
            }

            if (requiredItems.isEmpty()) {
                this.combineRecipe(recipe);
            }
        }
    }

    private void combineRecipe(Recipe recipe) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < recipe.getRequiredItems().size(); i++) {
            String item = recipe.getRequiredItems().get(i);
            this.commonItems.remove(item);
        }

        Item newItem = ItemFactory.createItem(recipe.getName(), recipe.getStrengthBonus(), recipe.getAgilityBonus(),
                recipe.getIntelligenceBonus(), recipe.getHitPointsBonus(), recipe.getDamageBonus());

        this.commonItems.put(newItem.getName(), newItem);
    }
}