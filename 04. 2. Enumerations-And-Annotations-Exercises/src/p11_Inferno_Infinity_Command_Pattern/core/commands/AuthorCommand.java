package p11_Inferno_Infinity_Command_Pattern.core.commands;

import p11_Inferno_Infinity_Command_Pattern.annotations.CustomAnnotation;
import p11_Inferno_Infinity_Command_Pattern.core.BaseCommand;
import p11_Inferno_Infinity_Command_Pattern.models.impl.Weapon;

public class AuthorCommand extends BaseCommand {
    @Override
    public String execute() {
        CustomAnnotation annotation = Weapon.class.getAnnotation(CustomAnnotation.class);
        return String.format("Author: %s", annotation.author());
    }
}
