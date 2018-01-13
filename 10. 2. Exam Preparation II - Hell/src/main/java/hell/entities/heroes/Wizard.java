package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Wizard extends BaseHero {
    private static final int HERO_BASE_STRENGTH = 25;
    private static final int HERO_BASE_AGILITY = 25;
    private static final int HERO_BASE_INTELLIGENCE = 100;
    private static final int HERO_BASE_HITPOINTS = 100;
    private static final int HERO_BASE_DAMAGE = 250;

    public Wizard(String name, Inventory inventory) {
        super(name, HERO_BASE_STRENGTH, HERO_BASE_AGILITY,
                HERO_BASE_INTELLIGENCE, HERO_BASE_HITPOINTS, HERO_BASE_DAMAGE, inventory);
    }
}
