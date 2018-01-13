package hell.factories;

import hell.interfaces.Hero;
import hell.interfaces.Inventory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HeroFactory {
    private static final String HERO_PACKAGE_NAME = "hell.entities.heroes.";

    private HeroFactory() {
    }

    public static Hero createHero(String heroName, String heroType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> heroClass = Class.forName(HERO_PACKAGE_NAME + heroType);
        Constructor<?> constructor = heroClass.getDeclaredConstructor(String.class, Inventory.class);
        Hero hero = (Hero) constructor.newInstance(heroName, InventoryFactory.makeInventory());
        return hero;
    }
}
