package hell.factories;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;

public class InventoryFactory {
    private InventoryFactory() {
    }

    public static Inventory makeInventory() {
        return new HeroInventory();
    }
}
