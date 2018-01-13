package p12_Inferno_Infinity_Command_Pattern.core.commands;

import p12_Inferno_Infinity_Command_Pattern.core.Command;
import p12_Inferno_Infinity_Command_Pattern.entities.interfaces.Weapon;
import p12_Inferno_Infinity_Command_Pattern.repositories.Repository;

public abstract class BaseCommand implements Command {
    private String[] params;
    private Repository<Weapon> weaponRepository;

    protected BaseCommand() {
    }

    public String[] getParams() {
        return this.params;
    }

    public Repository<Weapon> getWeaponRepository() {
        return this.weaponRepository;
    }
}
