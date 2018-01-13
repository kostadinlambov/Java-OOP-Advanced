package p11_Inferno_Infinity_Command_Pattern.core;

import p11_Inferno_Infinity_Command_Pattern.annotations.Inject;
import p11_Inferno_Infinity_Command_Pattern.models.api.WeaponInterface;
import p11_Inferno_Infinity_Command_Pattern.repositories.Repository;

public abstract class BaseCommand implements Executable {

    @Inject
    private String[] params;
    @Inject
    private Repository<WeaponInterface> weaponRepository;

    protected BaseCommand() {
    }

    public String[] getParams() {
        return this.params;
    }

    public Repository<WeaponInterface> getWeaponRepository() {
        return this.weaponRepository;
    }
}
