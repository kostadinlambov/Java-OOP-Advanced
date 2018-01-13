package p11_Inferno_Infinity_Command_Pattern.models.impl;

import p11_Inferno_Infinity_Command_Pattern.enumerations.WeaponTypes;

public class Sword extends Weapon {
    public Sword(String name) {
        super(name, WeaponTypes.SWORD.getMinDamage(), WeaponTypes.SWORD.getMaxDamage(), WeaponTypes.SWORD.getSockets());
    }
}
