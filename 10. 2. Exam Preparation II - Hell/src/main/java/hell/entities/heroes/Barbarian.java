package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Barbarian extends BaseHero {
    private static final int HERO_BASE_STRENGTH = 90;
    private static final int HERO_BASE_AGILITY = 25;
    private static final int HERO_BASE_INTELLIGENCE = 10;
    private static final int HERO_BASE_HITPOINTS = 350;
    private static final int HERO_BASE_DAMAGE = 150;

    public Barbarian(String name, Inventory inventory) {
        super(name, HERO_BASE_STRENGTH, HERO_BASE_AGILITY,
                HERO_BASE_INTELLIGENCE, HERO_BASE_HITPOINTS, HERO_BASE_DAMAGE, inventory);
    }
}
