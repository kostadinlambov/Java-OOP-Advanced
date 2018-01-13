package p11_Inferno_Infinity_Command_Pattern.core.commands;

import p11_Inferno_Infinity_Command_Pattern.core.BaseCommand;
import p11_Inferno_Infinity_Command_Pattern.models.api.WeaponInterface;

import java.util.Map;

public class AddCommand extends BaseCommand {
    @Override
    public String execute() {
        Map<String, WeaponInterface> weapons = super.getWeaponRepository().findAll();
        if (weapons.containsKey(super.getParams()[0])) {
            weapons.get(super.getParams()[0]).addGem(super.getParams()[2], Integer.parseInt(super.getParams()[1]));
        }
        return null;
    }
}
