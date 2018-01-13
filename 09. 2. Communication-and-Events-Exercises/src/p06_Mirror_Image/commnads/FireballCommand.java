package p06_Mirror_Image.commnads;

import p06_Mirror_Image.WizardImpl;
import p06_Mirror_Image.interfaces.Command;
import p06_Mirror_Image.interfaces.Wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FireballCommand implements Command {

    int wizardId;
    Set<Wizard> wizardLSet;


    public FireballCommand(int wizardId, Set<Wizard> wizardLSet) {
        this.wizardId = wizardId;
        this.wizardLSet = wizardLSet;
    }

    @Override
    public void execute() {
//        Wizard wizard = wizardLSet.
//        System.out.printf("%s %d casts Fireball for %d damage", wizard.getName(),
//                wizard.getId(), wizard.getMagicalPower());

//
//        System.out.printf("%s %d casts Fireball for %d damage%n", wizard.getName(),
//                wizard.getId(), wizard.getMagicalPower());

//
//        List<Wizard> wizardCastList = this.wizardList.stream()
//                .skip(this.wizardId).collect(Collectors.toList());
//
//        List<Wizard> wizardCastList1 = this.wizardList.subList(this.wizardId, this.wizardList.size()-1);
//
//        for (Wizard wizard1 : wizardCastList) {
//            System.out.printf("%s %d casts Fireball for %d damage%n", wizard1.getName(),
//                    wizard1.getId(), wizard1.getMagicalPower());
//        }



    }
}
