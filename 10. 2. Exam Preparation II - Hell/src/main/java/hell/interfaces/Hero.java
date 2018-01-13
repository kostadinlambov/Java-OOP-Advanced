package hell.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 *  This is the interface for the BaseHero entity
 *  @method String getName() - a getter for the name property of the BaseHero
 *  @method long getStrength() - a getter for the strength property of the BaseHero
 *  @method long getAgility() - a getter for the agility property of the BaseHero
 *  @method long getIntelligence() - a getter for the intelligence property of the BaseHero
 *  @method long getHitPoints() - a getter for the hitPoints property of the BaseHero
 *  @method long getDamage() - a getter for the damage property of the BaseHero
 *  @method Collection<Item> getItems() - a getter which extracts the items from the Inventory of the BaseHero
 *  @method void addItem(Item item) - a method which adds an CommonItem to the Inventory of the BaseHero
 *  @method void addRecipe(Recipe item) - a method which adds an RecipeItem to the Inventory of the BaseHero
 */
public interface Hero {
    String getName();

    long getStrength();

    long getAgility();

    long getIntelligence();

    long getHitPoints();

    long getDamage();

    Collection<Item> getItems() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    void addItem(Item item) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;

    void addRecipe(Recipe recipe) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException;
}