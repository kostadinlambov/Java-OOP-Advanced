package p10_Inferno_Infinity.entities.implementations;

import p10_Inferno_Infinity.entities.enumerations.Gems;
import p10_Inferno_Infinity.entities.enumerations.WeaponType;
import p10_Inferno_Infinity.entities.contracts.Weapon;

public class WeaponsImpl implements Weapon {

    private String name;
    private WeaponType weaponType;
    private Gems[] gems;

    public WeaponsImpl(String name, WeaponType weaponType) {
        this.setName(name);
        this.setWeaponType(weaponType);
        this.setGems();
    }

    @Override
    public double getLevel() {
        return ((this.calculateCurrentMinDamage() + this.calculateCurrentMaxDamage())/2.0) +
                this.calculateGemsTotalStrength() + this.calculateGemsTotalAgility() +
                this.calculateGemsTotalVitality();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    private void setGems() {
        this.gems = new Gems[this.weaponType.getNumberOfSockets()];
    }

    private int calculateCurrentMinDamage() {
        return this.weaponType.getMinDamage() + calculateGemsTotalStrength() * 2 +
                calculateGemsTotalAgility();
    }

    private int calculateCurrentMaxDamage() {
        return this.weaponType.getMaxDamage() + calculateGemsTotalStrength() * 3 +
                calculateGemsTotalAgility() * 4;
    }

    private int calculateGemsTotalStrength() {
        int totalStrength = 0;
        for (Gems gem : gems) {
            if (gem != null) {
                totalStrength += gem.getStrength();
            }
        }
        return totalStrength;
    }

    private int calculateGemsTotalAgility() {
        int totalAgility = 0;
        for (Gems gem : gems) {
            if (gem != null) {
                totalAgility += gem.getAgility();
            }
        }
        return totalAgility;
    }

    private int calculateGemsTotalVitality() {
        int totalVitality = 0;
        for (Gems gem : gems) {
            if (gem != null) {
                totalVitality += gem.getVitality();
            }
        }
        return totalVitality;
    }

    @Override
    public void addGem(int socketIndex, String gemType) {
        if (socketIndex >= 0 && socketIndex <= this.gems.length - 1) {
            Gems gem = Gems.valueOf(gemType);
            gems[socketIndex] = gem;
        }
    }

    @Override
    public void removeGem(int socketIndex) {
        if (socketIndex >= 0 && socketIndex <= this.gems.length - 1
                && this.gems[socketIndex] != null) {
            this.gems[socketIndex] = null;
        }
    }

    @Override
    public int compareTo(Weapon weapon) {
        return Double.compare(this.getLevel(), weapon.getLevel());
    }

    @Override
    public String additionalPrint(){
       return String.format(" (Item Level: %.1f)", this.getLevel());
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.calculateCurrentMinDamage(),
                this.calculateCurrentMaxDamage(), this.calculateGemsTotalStrength(),
                this.calculateGemsTotalAgility(), this.calculateGemsTotalVitality());
    }
}
