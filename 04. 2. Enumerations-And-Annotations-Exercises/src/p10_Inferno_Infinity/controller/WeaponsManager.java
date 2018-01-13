package p10_Inferno_Infinity.controller;

import p10_Inferno_Infinity.entities.enumerations.WeaponType;
import p10_Inferno_Infinity.entities.implementations.WeaponsImpl;
import p10_Inferno_Infinity.entities.contracts.Weapon;

import java.util.LinkedHashMap;
import java.util.Map;

public class WeaponsManager {

    private Map<String, Weapon> weaponMap;

    public WeaponsManager() {
        this.weaponMap = new LinkedHashMap<>();
    }

    public void createWeapon(String name, WeaponType weaponType) {
        Weapon weapon = new WeaponsImpl(name, weaponType);
        weaponMap.putIfAbsent(name, weapon);
    }

    public void addGem(String weaponName, int socketIndex, String gemType) {
        if (weaponMap.containsKey(weaponName)) {
            Weapon weapon = weaponMap.get(weaponName);
            weapon.addGem(socketIndex, gemType);
        }
    }

    public void removeGem(String weaponName, int socketIndex) {
        if (weaponMap.containsKey(weaponName)) {
            Weapon weapon = weaponMap.get(weaponName);
            weapon.removeGem(socketIndex);
        }
    }

    public void print(String weaponName) {
        if (weaponMap.containsKey(weaponName)) {
            Weapon weapon = weaponMap.get(weaponName);
            System.out.println(weapon);
        }
    }

    public void compare(String firstWeaponName, String secondWeaponName) {
        if (weaponMap.containsKey(firstWeaponName) &&
                weaponMap.containsKey(secondWeaponName)) {
            Weapon firstWeapon = weaponMap.get(firstWeaponName);
            Weapon secondWeapon = weaponMap.get(secondWeaponName);

            if(firstWeapon.compareTo(secondWeapon) >= 0){
                System.out.println(firstWeapon + firstWeapon.additionalPrint());
            }else{
                System.out.println(secondWeapon + secondWeapon.additionalPrint());
            }
        }
    }
}
