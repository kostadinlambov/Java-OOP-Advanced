package p11_Inferno_Infinity_Command_Pattern.models.impl;

import p11_Inferno_Infinity_Command_Pattern.enumerations.WeaponTypes;

public class Knife extends Weapon {
    public Knife(String name) {
        super(name, WeaponTypes.KNIFE.getMinDamage(), WeaponTypes.KNIFE.getMaxDamage(), WeaponTypes.KNIFE.getSockets());
    }
}
