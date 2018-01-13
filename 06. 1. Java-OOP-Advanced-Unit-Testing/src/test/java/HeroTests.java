import interfaces.Target;
import interfaces.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {
    private static final int TARGET_RETURN_HEALTH = 5;
    private static final int TARGET_GIVES_EXPERIENCE = 5;
    private static final int WEAPON_ATTACK_POINTS = 1;
    private static final int EXPECTED_WEAPON_ATTACK_POINTS = 1;
    private static final int WEAPON_DURABILITY_POINTS = 2;
    private static final int EXPECTED_HERO_EXPERIENCE = 5;

    @Test
    public void heroGainsExperienceWhenAttack() {

        Target target = Mockito.mock(Target.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(TARGET_GIVES_EXPERIENCE);

   //     Target target = new Target() {
//            public int getHealth() {
//                return TARGET_RETURN_HEALTH;
//            }
//
//            public void takeAttack(int attackPoints) {
//
//            }
//
//            public int giveExperience() {
//                return TARGET_GIVES_EXPERIENCE;
//            }
//
//            public boolean isDead() {
//                return true;
//            }
//        };



        Weapon weaponMock = Mockito.mock(Weapon.class);
        Mockito.when(weaponMock.getAttackPoints()).thenReturn(WEAPON_ATTACK_POINTS);
        Mockito.when(weaponMock.getDurabilityPoints()).thenReturn(WEAPON_DURABILITY_POINTS);

        Hero hero = new Hero("Stamat", weaponMock);
        hero.attack(target);

        Assert.assertEquals("Message!", EXPECTED_WEAPON_ATTACK_POINTS, weaponMock.getAttackPoints());

        Assert.assertEquals("Wrong hero exp!", EXPECTED_HERO_EXPERIENCE,
                hero.getExperience());
    }

//    @Test
//    public void heroGainsExperienceWhenAttack() {
//        Target target = new Target() {
//            public int getHealth() {
//                return TARGET_RETURN_HEALTH;
//            }
//
//            public void takeAttack(int attackPoints) {
//
//            }
//
//            public int giveExperience() {
//                return TARGET_GIVES_EXPERIENCE;
//            }
//
//            public boolean isDead() {
//                return true;
//            }
//        };
//
//        Weapon weapon = new Weapon() {
//            public int getAttackPoints() {
//                return WEAPON_ATTACK_POINTS;
//            }
//
//            public int getDurabilityPoints() {
//                return WEAPON_DURABILITY_POINTS;
//            }
//
//            public void attack(Target target) {
//
//            }
//        };
//
//        Hero hero = new Hero("Stamat", weapon);
//        hero.attack(target);
//
//        Assert.assertEquals("Wrong hero exp!", EXPECTED_HERO_EXPERIENCE,
//                hero.getExperience());
//
//    }
}
