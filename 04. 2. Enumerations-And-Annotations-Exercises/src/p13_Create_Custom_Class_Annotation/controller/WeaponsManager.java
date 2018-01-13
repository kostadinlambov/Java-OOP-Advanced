package p13_Create_Custom_Class_Annotation.controller;

import p13_Create_Custom_Class_Annotation.entities.enumerations.WeaponType;
import p13_Create_Custom_Class_Annotation.entities.implementations.WeaponsImpl;
import p13_Create_Custom_Class_Annotation.entities.interfaces.MyAnnotation;
import p13_Create_Custom_Class_Annotation.entities.interfaces.Weapon;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

            if (firstWeapon.compareTo(secondWeapon) >= 0) {
                System.out.println(firstWeapon + firstWeapon.additionalPrint());
            } else {
                System.out.println(secondWeapon + secondWeapon.additionalPrint());
            }
        }
    }

    public void getAuthor() {
        Class cl = WeaponsImpl.class;
        MyAnnotation myAnnotation = (MyAnnotation) cl.getAnnotation(MyAnnotation.class);
        System.out.println("Author: " + myAnnotation.author());
    }

    public void getRevision() {
        Class cl = WeaponsImpl.class;
        MyAnnotation myAnnotation = (MyAnnotation) cl.getAnnotation(MyAnnotation.class);
        System.out.println("Revision: " + myAnnotation.revision());

    }

    public void getDescription() {
        Class cl = WeaponsImpl.class;
        MyAnnotation myAnnotation = (MyAnnotation) cl.getAnnotation(MyAnnotation.class);
        System.out.println("Class description: " + myAnnotation.description());

    }

    public void getReviewers() {
        Class cl = WeaponsImpl.class;
        MyAnnotation myAnnotation = (MyAnnotation) cl.getAnnotation(MyAnnotation.class);
        System.out.println("Reviewers: "
                + Arrays.stream(myAnnotation.reviewers()).collect(Collectors.joining(", ")));

    }
}
