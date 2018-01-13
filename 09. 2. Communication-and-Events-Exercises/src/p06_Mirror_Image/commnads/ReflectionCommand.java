package p06_Mirror_Image.commnads;

import p06_Mirror_Image.WizardImpl;
import p06_Mirror_Image.interfaces.Command;
import p06_Mirror_Image.interfaces.Wizard;

import java.util.List;
import java.util.stream.Collectors;

public class ReflectionCommand implements Command {

    int wizardId;
    List<Wizard> wizardList;

    public ReflectionCommand(int wizardId, List<Wizard> wizardList) {
        this.wizardId = wizardId;
        this.wizardList = wizardList;
    }

    @Override
    public void execute() {

        Wizard wizard = this.wizardList.get(wizardId);


        List<Wizard> wizardCastList = this.wizardList.stream()
                .skip(this.wizardId).collect(Collectors.toList());

        for (int i = 0; i < wizardCastList.size(); i++) {
            Wizard castingWizard = wizardCastList.get(i);
           // if( !castingWizard.isHasCastReflectionSpell()){
                System.out.printf("%s %d casts Reflection%n", castingWizard.getName(), castingWizard.getId());
                castingWizard.setHasCastReflectionSpell(true);
                int mirrorWizardMagicalPower = castingWizard.getMagicalPower() / 2;
                int mirrorWizardId = castingWizard.getId() +1;

                for (int j = 0; j < 2; j++) {
                    Wizard mirrorWizard = new WizardImpl(castingWizard.getName(), mirrorWizardMagicalPower);

                    mirrorWizard.setId(mirrorWizardId);
                    wizardList.add(mirrorWizard);
                    mirrorWizardId++;
                }
           // }
        }

    }
}
