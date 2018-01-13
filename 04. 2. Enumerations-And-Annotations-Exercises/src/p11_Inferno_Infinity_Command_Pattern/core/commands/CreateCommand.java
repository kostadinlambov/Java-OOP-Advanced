package p11_Inferno_Infinity_Command_Pattern.core.commands;

import p11_Inferno_Infinity_Command_Pattern.models.api.WeaponInterface;
import p11_Inferno_Infinity_Command_Pattern.core.BaseCommand;
import p11_Inferno_Infinity_Command_Pattern.factories.WeaponFactory;

public class CreateCommand extends BaseCommand {
    @Override
    public String execute() {
        WeaponInterface weaponInterface = null;
        switch (super.getParams()[0]) {
            case "AXE":
                weaponInterface = WeaponFactory.createAxeWeapon(super.getParams()[1]);
                break;
            case "SWORD":
                weaponInterface = WeaponFactory.createSwordWeapon(super.getParams()[1]);
                break;
            case "KNIFE":
                weaponInterface = WeaponFactory.createKnifeWeapon(super.getParams()[1]);
                break;
        }
        super.getWeaponRepository().add(weaponInterface);
        return null;
    }
}
