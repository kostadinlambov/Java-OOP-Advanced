package hell.repositories;

import hell.interfaces.Hero;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HeroRepository implements Repository {

    private Map<String, Hero> heroes;

    public HeroRepository() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public void addHero(Hero hero){
        this.heroes.put(hero.getName(), hero);
    }

    @Override
    public Hero getHeroByName(String heroName) {
        return this.heroes.get(heroName);
    }

    @Override
    public Map<String, Hero> getHeroes() {
        return Collections.unmodifiableMap(this.heroes);
    }
}
