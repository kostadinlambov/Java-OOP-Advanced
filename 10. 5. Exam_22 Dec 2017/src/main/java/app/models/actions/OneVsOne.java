package app.models.actions;

import app.contracts.Action;
import app.contracts.Targetable;

import java.util.List;

public class OneVsOne implements Action {

    public String executeAction(List<Targetable> participants) {
        if (participants.size() != 2){
            return "There should be exactly 2 participants for OneVsOne!";
        }

        StringBuilder sb = new StringBuilder();

        Targetable firstHero = participants.get(0);
        Targetable secondHero = participants.get(1);

        while (firstHero.isAlive()){
            sb.append(firstHero.attack(secondHero));
            sb.append(System.lineSeparator());
            if (secondHero.isAlive()) {
                sb.append(secondHero.attack(firstHero));
                sb.append(System.lineSeparator());
            }else {
                break;
            }
        }

        if (firstHero.isAlive()){
            sb.append(String.format("%s is victorious!%n%s", firstHero.getName(), firstHero.toString()));
        }else {
            sb.append(String.format("%s is victorious!%n%s", secondHero.getName(), secondHero.toString()));
        }

        return sb.toString();
    }
}
