package p12_Inferno_Infinity_Command_Pattern.core;

import p12_Inferno_Infinity_Command_Pattern.core.commands.BaseCommand;
import p12_Inferno_Infinity_Command_Pattern.entities.interfaces.Weapon;
import p12_Inferno_Infinity_Command_Pattern.factories.WeaponFactory;

public class CreateCommand extends BaseCommand {


    @Override
    public String execute() {
        Weapon weapon = null;
//        switch (super.getParams()[0]) {
//            case "Axe":
//                weapon = WeaponFactory.createAxeWeapon(super.getParams()[1]);
//                break;
//            case "Sword":
//                weapon =  WeaponFactory.createSwordWeapon(super.getParams()[1]);
//            break;
//            case "Knife":
//                weapon =  WeaponFactory.createKnifeWeapon(super.getParams()[1]);
//                break;
//
//        }
//        super.getWeaponRepository().add(weapon);
        return null;
    }
}
