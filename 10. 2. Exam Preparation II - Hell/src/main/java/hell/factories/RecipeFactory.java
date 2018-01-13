package hell.factories;

import hell.entities.items.RecipeItem;

import hell.interfaces.Recipe;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RecipeFactory {

    private RecipeFactory() {
    }

    public static Recipe createRecipe(String name, int strengthBonus, int agilityBonus, int intelligenceBonus,
                                      int hitpointsBonus, int damageBonus, String... requiredItems)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> recipeClass = RecipeItem.class;
        Constructor constructor = recipeClass.getDeclaredConstructor(String.class, int.class,
                int.class, int.class, int.class, int.class, String[].class);

        Recipe recipeItem = (Recipe) constructor.newInstance(name, strengthBonus,
                agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus, requiredItems);
        return recipeItem;
    }
}
