package hell.commands;

import hell.entities.miscellaneous.ItemCollection;
import hell.factories.ItemFactory;
import hell.interfaces.Executable;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ItemCommand implements Executable {

    private static final String CREATE_ITEM_FORMAT = "Added item - %s to Hero - %s";

    @ItemCollection
    private List<String> params;

    @ItemCollection
    private Repository repository;

    @ItemCollection
    private OutputWriter writer;


    @Override
    public void execute() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Item commonItem = ItemFactory.createItem(this.params.get(0), Integer.parseInt(this.params.get(2)), Integer.parseInt(this.params.get(3)), Integer.parseInt(this.params.get(4)), Integer.parseInt(this.params.get(5)), Integer.parseInt(this.params.get(6)));

        Hero currentHero = this.repository.getHeroByName(this.params.get(1));
        currentHero.addItem(commonItem);

        this.writer.writeLine(CREATE_ITEM_FORMAT, this.params.get(0), this.params.get(1));
    }
}
