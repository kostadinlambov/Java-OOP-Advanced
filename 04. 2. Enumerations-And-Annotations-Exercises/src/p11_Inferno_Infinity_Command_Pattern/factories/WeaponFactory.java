package p11_Inferno_Infinity_Command_Pattern.factories;

import p11_Inferno_Infinity_Command_Pattern.models.api.WeaponInterface;
import p11_Inferno_Infinity_Command_Pattern.models.impl.Axe;
import p11_Inferno_Infinity_Command_Pattern.models.impl.Knife;
import p11_Inferno_Infinity_Command_Pattern.models.impl.Sword;

public final class WeaponFactory {
    private WeaponFactory() {
    }

    public static WeaponInterface createAxeWeapon(String name) {
        return new Axe(name);
    }

    public static WeaponInterface createSwordWeapon(String name) {
        return new Sword(name);
    }

    public static WeaponInterface createKnifeWeapon(String name) {
        return new Knife(name);
    }
}
