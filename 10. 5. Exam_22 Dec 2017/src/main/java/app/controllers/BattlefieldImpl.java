package app.controllers;

import app.contracts.*;

import java.util.*;
import java.util.stream.Collectors;

public class BattlefieldImpl implements Battlefield {

    private Writer writer;
    private ActionFactory actionFactory;
    private TargetableFactory targetableFactory;
    private SpecialFactory specialFactory;

    private Map<String, Targetable> participants;
    private List<Action> executedActions;

    public BattlefieldImpl(ActionFactory actionFactory, TargetableFactory targetableFactory, SpecialFactory specialFactory, Writer writer) {
        this.executedActions = new ArrayList<>();
        this.participants = new TreeMap<>();
        this.writer = writer;
        this.actionFactory = actionFactory;
        this.targetableFactory = targetableFactory;
        this.specialFactory = specialFactory;
    }

    @Override
    public void createAction(String actionName, String... participantNames) {
        try {
            Action action = this.actionFactory.create(actionName);

            List<Targetable> actionParticipants = new ArrayList<>();
            for (String name : participantNames){
                if (this.participants.containsKey(name)){
                    actionParticipants.add(this.participants.get(name));
                } else {
                    this.writer.writeLine(String.format("%s is not on the battlefield. %s failed.", name, actionName));
                    return;
                }
            }

            writer.writeLine(action.executeAction(actionParticipants));
            checkForDeadParticipants();
            this.executedActions.add(action);
        } catch (Exception e) {
            writer.writeLine("Action does not exist.");
        }
    }

    @Override
    public void createParticipant(String name, String className) {

        if (this.participants.containsKey(name)){
            writer.writeLine("Participant with that name already exists.");
            return;
        }

        try {
            Targetable targetable = this.targetableFactory.create(name, className);
            this.participants.put(targetable.getName(), targetable);
            this.writer.writeLine(String.format("%s %s entered the battlefield.", targetable.getClass().getSimpleName(), targetable.getName()));
        } catch (Exception e) {
            writer.writeLine("Participant class does not exist.");
        }
    }

    @Override
    public void createSpecial(String name, String specialName) {
        if (!this.participants.containsKey(name)) {
            writer.writeLine("Participant with that name does not exist.");
        }

        Targetable participant = this.participants.get(name);
        List<String> participantInterfacesNames = Arrays.stream(participant.getClass().getSuperclass().getInterfaces()[0].getInterfaces()).map(Class::getSimpleName).collect(Collectors.toList());

        if (participantInterfacesNames.contains("Specialist")) {
            try {
                Specialist specialist = (Specialist) participant;
                Special special = this.specialFactory.create(specialName);
                specialist.setSpecial(special);
            } catch (Exception e) {
                this.writer.writeLine("Special does not exist.");
            }
        } else {
            writer.writeLine("Participant cannot have special abilities.");
        }
    }

    @Override
    public void reportParticipants(){
        if (this.participants.size() < 1){
            this.writer.writeLine("There are no participants on the battlefield.");
            return;
        }
        for (String name : this.participants.keySet()) {
            this.writer.writeLine(this.participants.get(name).toString());
            this.writer.writeLine("* * * * * * * * * * * * * * * * * * * *");
        }
    }

    @Override
    public void reportActions(){
        if (this.executedActions.size() < 1){
            this.writer.writeLine("There are no actions on the battlefield.");
            return;
        }

        for (Action executedAction : executedActions) {
            this.writer.writeLine(executedAction.getClass().getSimpleName());
        }
    }

    private void checkForDeadParticipants(){
        Map<String, Targetable> aliveParticipants = new TreeMap<>();

        for (String name : this.participants.keySet()) {
            if (!this.participants.get(name).isAlive()){
                this.writer.writeLine(String.format("%s has been removed from the battlefield.", name));
            }else {
                aliveParticipants.put(name, this.participants.get(name));
            }
        }

        this.participants = aliveParticipants;
    }
}
