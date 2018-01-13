package hell.entities.items;

import hell.interfaces.Recipe;


import java.util.Arrays;
import java.util.List;

public class RecipeItem extends BaseItem implements Recipe {

    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitpointsBonus,
                      int damageBonus, String... requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus);
        this.setRequiredItems(requiredItems);
    }

    private void setRequiredItems(String... requiredItems ) {
        this.requiredItems = Arrays.asList(requiredItems);
    }

    @Override
    public List<String> getRequiredItems() {
        return this.requiredItems;
    }


}
