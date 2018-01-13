package hell.factories;

import hell.entities.items.CommonItem;
import hell.interfaces.Item;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ItemFactory {

    private ItemFactory(){}

    public static Item createItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitpointsBonus, int damageBonus) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> itemClass = CommonItem.class;
        Constructor constructor = itemClass.getDeclaredConstructor(String.class, int.class,int.class, int.class, int.class, int.class);
        Item commonItem = (Item) constructor.newInstance( name,  strengthBonus,  agilityBonus,  intelligenceBonus,  hitpointsBonus,  damageBonus);

        return commonItem;
    }
}
