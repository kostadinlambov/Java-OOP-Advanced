package p12_Inferno_Infinity_Command_Pattern.repositories;

import p12_Inferno_Infinity_Command_Pattern.entities.interfaces.Weapon;

import java.util.HashMap;
import java.util.Map;

public class WeaponRepository<T extends Weapon> implements Repository<Weapon>{
    private Map<String, Weapon> weaponMap;

    public WeaponRepository() {
        this.weaponMap = new HashMap<>();
    }


    @Override
    public void add(Weapon weapon) {
        this.weaponMap.putIfAbsent(weapon.getName(), weapon);
    }
}
