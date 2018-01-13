package hell.commands;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Executable;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuitCommand implements Executable {

    @ItemCollection
    private List<String> params;

    @ItemCollection
    private Repository repository;

    @ItemCollection
    private OutputWriter writer;

    @Override
    public void execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Map<String, Hero> heroMap = this.repository.getHeroes();

        Map<String, Hero> sortedMap = heroMap.entrySet().stream()
                .sorted((first, second) -> {
                    if (Long.compare(second.getValue().getAgility() + second.getValue().getStrength() + second.getValue().getIntelligence(),
                            first.getValue().getAgility() + first.getValue().getStrength() + first.getValue().getIntelligence()
                            ) == 0) {
                        return Long.compare(second.getValue().getHitPoints() + second.getValue().getDamage(),
                                first.getValue().getHitPoints() + first.getValue().getDamage());
                    }
                    return Long.compare(second.getValue().getAgility() + second.getValue().getStrength() + second.getValue().getIntelligence(),
                            first.getValue().getAgility() + first.getValue().getStrength() + first.getValue().getIntelligence());

                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));

        int counter = 1;

        StringBuilder sb = new StringBuilder();
        for (Hero hero : sortedMap.values()) {

            sb.append(String.format("%d. %s: %s", counter, hero.getClass().getSimpleName(), hero.getName())).append(System.lineSeparator());
            sb.append(String.format("###HitPoints: %d", hero.getHitPoints())).append(System.lineSeparator());
            sb.append(String.format("###Damage: %d", hero.getDamage())).append(System.lineSeparator());
            sb.append(String.format("###Strength: %d", hero.getStrength())).append(System.lineSeparator());
            sb.append(String.format("###Agility: %d", hero.getAgility())).append(System.lineSeparator());
            sb.append(String.format("###Intelligence: %d", hero.getIntelligence())).append(System.lineSeparator());
            if(hero.getItems().isEmpty()){
                sb.append("###Items: None").append(System.lineSeparator());
            }else{
                String collection = hero.getItems().stream().map(Item::getName).collect(Collectors.joining(", "));
                sb.append(String.format("###Items: %s", collection)).append(System.lineSeparator());
            }
            counter++;
        }
        writer.writeLine(sb.toString().trim());

    }
}
