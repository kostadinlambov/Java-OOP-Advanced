package hell.commands;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Executable;
import hell.interfaces.Hero;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.util.List;

public class InspectCommand implements Executable {

    @ItemCollection
    private List<String> params;

    @ItemCollection
    private Repository repository;

    @ItemCollection
    private OutputWriter writer;



    @Override
    public void execute(){
        Hero hero = this.repository.getHeroByName(this.params.get(0));
        writer.writeLine(hero.toString());



    }
}
