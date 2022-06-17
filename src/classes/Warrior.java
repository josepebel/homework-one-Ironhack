package classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class Warrior extends Character {

    private int stamina;
    private int strength;

    private static String[] warriorsNameList =new String[] {"Thor", "Rocky", "Hulk", "Hercules", "Gladiator",
            "Goku", "Kratos", "Atila", "Qrajahr", "Krazahl", "Iharis", "Orohith", "Rhutorn", "Isiqia",
            "Ugorim", "Eharad", "Exivius", "Udarim", "Inexeor", "Agorith", "Vrahith", "Ferdinando Digby", "Alphons Clapham", "Portier Braxton",
            "Mirko Home", "Winton Davenport", "Diether Lea", "Kurt Bradford", "Ernest Smit", "Pearson Anderton", "Graham Shirley"};

    private static final int MIN_HP_WARRIOR = 100;
    private static final int MAX_HP_WARRIOR = 200;
    private static final int MIN_STAMINA_WARRIOR = 10;
    private static final int MAX_STAMINA_WARRIOR = 50;
    private static final int MIN_STRENGTH_WARRIOR = 1;
    private static final int MAX_STRENGTH_WARRIOR = 25;


    public Warrior(String name, int hp, int stamina, int strength ) {
        super(name);
        setHp(hp);
        setStamina(stamina);
        setStrength(strength);
    }



    @Override
    public int attack() {
        int damage;
        if(this.stamina>=5){
            damage = this.strength;
            this.stamina -= 5;
            System.out.println("⚔ ⚔ ⚔ ⚔ " + getName() + " makes a Heavy Attack with " + damage + " points of power and loses 5 points of stamina ⚔ ⚔ ⚔ ⚔");
        } else {
            BigDecimal weakAttack = new BigDecimal(this.strength*0.5);
            damage = weakAttack.setScale(0, RoundingMode.HALF_UP).intValue();
            this.stamina +=1;
            System.out.println("⚔ ⚔ ⚔ ⚔ " + getName() + " makes a Weak Attack with " + damage + " points of power and recovers 1 point of stamina ⚔ ⚔ ⚔ ⚔");

        }
        return damage;
    }


    // Método para crear Warrior aleatorio
    public static Warrior randomWarrior(){

        Random generator = new Random();
        int randomIndex = generator.nextInt(warriorsNameList.length);
        int warriorHp = new Random().nextInt(MAX_HP_WARRIOR-MIN_HP_WARRIOR) + MIN_HP_WARRIOR;
        int warriorStamina = new Random().nextInt(MAX_STAMINA_WARRIOR-MIN_STAMINA_WARRIOR) + MIN_STAMINA_WARRIOR;
        int warriorStrength = new Random().nextInt(MAX_STRENGTH_WARRIOR-MIN_STRENGTH_WARRIOR) + MIN_STRENGTH_WARRIOR;

        Warrior randomWarrior = new Warrior(warriorsNameList[randomIndex], warriorHp, warriorStamina, warriorStrength);

        return randomWarrior;
    }

    @Override
    public String toString() {
//        return "Warrior{" +
//                "name=" + getName() +
//                ", hp=" + getHp() +
//                ", stamina=" + stamina +
//                ", strength=" + strength +
//                '}';
                return "Warrior -> " +
                "name: " + getName() +
                " // hp: " + getHp() +
                " // stamina: " + stamina +
                " // strength: " + strength;

    }


    /////////////////////////////
    ///// GETTERS / SETTERS /////
    /////////////////////////////

    public int getStamina() {
        return stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStamina(int stamina) {
        if (stamina > MAX_STAMINA_WARRIOR) {
            System.out.println("Inserted stamina is greater than the maximum value. Stamina will be equal to maximum value: " + MAX_STAMINA_WARRIOR);
            this.stamina = MAX_STAMINA_WARRIOR;
        } else if (stamina < MIN_STAMINA_WARRIOR) {
            System.out.println("Inserted stamina is lower than the minimum value. Stamina will be equal to minimum value: " + MIN_STAMINA_WARRIOR);
            this.stamina = MIN_STAMINA_WARRIOR;
        } else {
            this.stamina = stamina;
        }
    }

    public void setStrength(int strength) {
        if (strength > MAX_STRENGTH_WARRIOR) {
            System.out.println("Inserted strength is greater than the maximum value. Strength will be equal to maximum value: " + MAX_STRENGTH_WARRIOR);
            this.strength = MAX_STRENGTH_WARRIOR;
        } else if (strength < MIN_STRENGTH_WARRIOR) {
            System.out.println("Inserted strength is lower than the minimum value. Strength will be equal to minimum value: " + MIN_STRENGTH_WARRIOR);
            this.strength = MIN_STRENGTH_WARRIOR;
        } else {
            this.strength = strength;
        }
    }

    @Override
    public void setHp(int hp) {
        if (hp > MAX_HP_WARRIOR) {
            System.out.println("Inserted hp is greater than the maximum value. Hp will be equal to maximum value: " + MAX_HP_WARRIOR);
            super.setHp(MAX_HP_WARRIOR);
        } else if (hp < MIN_HP_WARRIOR) {
            System.out.println("Inserted hp is lower than the minimum value. Hp will be equal to minimum value: " + MIN_HP_WARRIOR);
            super.setHp(MIN_HP_WARRIOR);
        } else {
            super.setHp(hp);
        }
    }

    @Override
    public String getstatus() {

        return getStatusHP() + " and " + getStamina() + " points of stamina ❦ ❦ ❦ ❦";

    }

    public static int getMinHpWarrior() {
        return MIN_HP_WARRIOR;
    }

    public static int getMaxHpWarrior() {
        return MAX_HP_WARRIOR;
    }

    public static int getMinStaminaWarrior() {
        return MIN_STAMINA_WARRIOR;
    }

    public static int getMaxStaminaWarrior() {
        return MAX_STAMINA_WARRIOR;
    }

    public static int getMinStrengthWarrior() {
        return MIN_STRENGTH_WARRIOR;
    }

    public static int getMaxStrengthWarrior() {
        return MAX_STRENGTH_WARRIOR;
    }

    public static String[] getWarriorsNameList() {
        return warriorsNameList;
    }
}
