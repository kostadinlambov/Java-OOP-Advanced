package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Map;

public abstract class BaseHero implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitpoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence, int hitpoints, int damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitpoints = hitpoints;
        this.damage = damage;
        this.inventory = inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitpoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Item> getItems() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> inventoryClass = HeroInventory.class;

        Field heroInventoryField = inventoryClass.getDeclaredFields()[0];
        heroInventoryField.setAccessible(true);

        Map<String, Item> commonItemsMap = (Map<String, Item>) heroInventoryField.get(this.inventory);
        Collection<Item> commonItems = commonItemsMap.values();
        return commonItems;
    }

    @Override
    public void addItem(Item item) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        this.inventory.addRecipeItem(recipe);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hero: %s, Class: %s", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());
        sb.append(String.format("HitPoints: %d, Damage: %d", this.getHitPoints(), this.getDamage())).append(System.lineSeparator());
        sb.append(String.format("Strength: %d", this.getStrength())).append(System.lineSeparator());
        sb.append(String.format("Agility: %d", this.getAgility())).append(System.lineSeparator());
        sb.append(String.format("Intelligence: %d", this.getIntelligence())).append(System.lineSeparator());

        try {
            if (this.getItems().size() == 0) {
                sb.append("Items: None").append(System.lineSeparator());
            } else {
                sb.append(("Items:")).append(System.lineSeparator());
                for (Item item : this.getItems()) {
                    sb.append(String.format("###Item: %s", item.getName())).append(System.lineSeparator());
                    sb.append(String.format("###+%d Strength", item.getStrengthBonus())).append(System.lineSeparator());
                    sb.append(String.format("###+%d Agility", item.getAgilityBonus())).append(System.lineSeparator());
                    sb.append(String.format("###+%d Intelligence", item.getIntelligenceBonus())).append(System.lineSeparator());
                    sb.append(String.format("###+%d HitPoints", item.getHitPointsBonus())).append(System.lineSeparator());
                    sb.append(String.format("###+%d Damage", item.getDamageBonus())).append(System.lineSeparator());
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        return sb.toString().trim();
    }
}
