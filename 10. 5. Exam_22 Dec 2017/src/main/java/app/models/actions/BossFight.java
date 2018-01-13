package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;
import app.models.Config;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BossFight implements Action {

    public String executeAction(List<Targetable> participants) {
        if (participants.size() < 1){
            return "There should be at least 1 participant for boss fight!";
        }

        if (!participants.get(0).getClass().getSimpleName().equals("Boss")) {
            return "Invalid boss.";
        }

        double bossFightReward = Config.BOSS_INDIVIDUAL_REWARD;
        Targetable boss = participants.get(0);
        List<Targetable> heroes = participants.stream().skip(1).collect(Collectors.toList());

        String killer = "";

        while (boss.isAlive()){
            for (Targetable hero : heroes) {
                if (boss.isAlive() && hero.isAlive()) {
                    hero.attack(boss);
                    if (boss.isAlive()) {
                        boss.attack(hero);
                    } else {
                        killer = hero.getName();
                        break;
                    }
                }
            }

            if (!areRemainingAliveHeroes(heroes)) {
                break;
            }
        }

        for (Targetable hero : heroes) {
            if (hero.isAlive()) {
                hero.receiveReward(bossFightReward);
                if (!hero.getName().equals(killer)) {
                    hero.levelUp();
                }
            }
        }

        StringBuilder result = new StringBuilder();

        if (areRemainingAliveHeroes(heroes)) {
            result.append(Config.BOSS_NAME + " has been slain by: ");
            heroes.stream().filter(Targetable::isAlive)
                    .sorted(Comparator.comparing(Targetable::getName)).forEach(hero -> {
                result.append(System.lineSeparator());
                result.append(hero.toString());
            });
        }else {
            boss.levelUp();
            result.append("Boss has slain them all!");
        }

        return result.toString();
    }

    private boolean areRemainingAliveHeroes(List<Targetable> heroes){
        for (Targetable hero : heroes) {
            if (hero.isAlive()){
                return true;
            }
        }

        return false;
    }
}
