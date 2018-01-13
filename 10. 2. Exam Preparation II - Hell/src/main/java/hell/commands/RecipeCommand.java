package hell.commands;

import hell.entities.miscellaneous.ItemCollection;
import hell.factories.RecipeFactory;
import hell.interfaces.*;
import hell.repositories.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class RecipeCommand implements Executable {

    private static final String CREATE_RECIPE_FORMAT = "Added recipe - %s to Hero - %s";

    @ItemCollection
    private List<String> params;

    @ItemCollection
    private Repository repository;

    @ItemCollection
    private OutputWriter writer;

    @Override
    public void execute() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        List<String> recipeItemList = this.params.subList(7,this.params.size());

        String[] recipeParams=  recipeItemList.stream().toArray(String[]::new);

        Recipe recipeItem = RecipeFactory.createRecipe(this.params.get(0), Integer.parseInt(this.params.get(2)),
                Integer.parseInt(this.params.get(3)), Integer.parseInt(this.params.get(4)),
                Integer.parseInt(this.params.get(5)), Integer.parseInt(this.params.get(6)), recipeParams);

        Hero currentHero = this.repository.getHeroByName(this.params.get(1));
        currentHero.addRecipe(recipeItem);

        this.writer.writeLine(CREATE_RECIPE_FORMAT, this.params.get(0), this.params.get(1));

    }
}
