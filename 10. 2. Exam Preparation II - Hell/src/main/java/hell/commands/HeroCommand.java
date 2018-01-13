package hell.commands;

import hell.entities.miscellaneous.ItemCollection;
import hell.factories.HeroFactory;
import hell.interfaces.Executable;
import hell.interfaces.Hero;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class HeroCommand implements Executable {
    private static final String CREATE_HERO_FORMAT = "Created %s - %s";

    @ItemCollection
    private List<String> params;

    @ItemCollection
    private Repository repository;

    @ItemCollection
    private OutputWriter writer;


    @Override
    public void execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Hero hero = HeroFactory.createHero(this.params.get(0), this.params.get(1));
        this.repository.addHero(hero);
        this.writer.writeLine(CREATE_HERO_FORMAT, this.params.get(1), this.params.get(0));
    }
}
