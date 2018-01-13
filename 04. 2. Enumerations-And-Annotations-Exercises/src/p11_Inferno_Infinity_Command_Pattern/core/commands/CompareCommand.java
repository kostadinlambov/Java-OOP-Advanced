package p11_Inferno_Infinity_Command_Pattern.core.commands;

import p11_Inferno_Infinity_Command_Pattern.core.BaseCommand;
import p11_Inferno_Infinity_Command_Pattern.models.api.WeaponInterface;

import java.util.Map;

public class CompareCommand extends BaseCommand {
    @Override
    public String execute() {
        Map<String, WeaponInterface> weapons = super.getWeaponRepository().findAll();
        if (weapons.containsKey(super.getParams()[0]) && weapons.containsKey(super.getParams()[1])) {
            int compareIndex = weapons.get(super.getParams()[0]).compareTo(weapons.get(super.getParams()[1]));

            WeaponInterface weaponInterface = null;
            if (compareIndex > 0) {
                weaponInterface = weapons.get(super.getParams()[0]);
            } else if (compareIndex < 0) {
                weaponInterface = weapons.get(super.getParams()[1]);
            }
            if (weaponInterface != null) {
                return String.format("%s (Item Level: %s)", weaponInterface, weaponInterface.getItemLevel());
            }
        }
        return null;
    }
}
