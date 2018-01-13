package p11_Inferno_Infinity_Command_Pattern.models.impl;

import p11_Inferno_Infinity_Command_Pattern.enumerations.WeaponTypes;

public class Axe extends Weapon {
    public Axe(String name) {
        super(name, WeaponTypes.AXE.getMinDamage(), WeaponTypes.AXE.getMaxDamage(), WeaponTypes.AXE.getSockets());
    }
}
