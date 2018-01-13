package hell.repositories;

import hell.interfaces.Hero;

import java.util.Map;

public interface Repository {
    void addHero(Hero hero);

    Hero getHeroByName(String heroName);

    Map<String, Hero> getHeroes();
}
