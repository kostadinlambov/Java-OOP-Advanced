package hell.entities.heroes;

import hell.interfaces.Inventory;

public class Assassin extends BaseHero {
    private static final int HERO_BASE_STRENGTH = 25;
    private static final int HERO_BASE_AGILITY = 100;
    private static final int HERO_BASE_INTELLIGENCE = 15;
    private static final int HERO_BASE_HITPOINTS = 150;
    private static final int HERO_BASE_DAMAGE = 300;

    public Assassin(String name, Inventory inventory) {
        super(name, HERO_BASE_STRENGTH, HERO_BASE_AGILITY,
                HERO_BASE_INTELLIGENCE, HERO_BASE_HITPOINTS, HERO_BASE_DAMAGE, inventory);
    }
}
