package p06_Mirror_Image;

import p06_Mirror_Image.commnads.FireballCommand;
import p06_Mirror_Image.commnads.ReflectionCommand;
import p06_Mirror_Image.interfaces.Command;
import p06_Mirror_Image.interfaces.Executor;
import p06_Mirror_Image.interfaces.Wizard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Wizard> wizardList = new ArrayList<>();
        Set<Wizard> wizardLSet= new TreeSet<>();

        String[] initialWizardTokens = reader.readLine().split("\\s+");
        String initialWizardName = initialWizardTokens[0];
        int initialWizardMagicalPower = Integer.parseInt(initialWizardTokens[1]);

        Wizard wizard = new WizardImpl(initialWizardName, initialWizardMagicalPower);
        wizardList.add(wizard);
        wizardLSet.add(wizard);

        Executor commandExecutor = new CommandExecutor();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");
            if ("End".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String command = tokens[1];

            switch (command) {
                case "REFLECTION":
                    int wizardId = Integer.parseInt(tokens[0]);
                    Command wizardCommand = new ReflectionCommand(wizardId, wizardList);
                    commandExecutor.executeCommand(wizardCommand);
                    break;
                case "FIREBALL":
                     wizardId = Integer.parseInt(tokens[0]);
                     wizardCommand = new FireballCommand(wizardId, wizardLSet);
                     commandExecutor.executeCommand(wizardCommand);
            }
        }
    }
}
