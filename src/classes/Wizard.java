package classes;


import java.util.Random;

public class Wizard extends Character {

    private int mana;
    private int intelligence;

    private static String[] wizardsNameList = new String[] {"Merlin", "Potter", "Houdini","Bellatrix",
            "Lestrange", "DoctorStrange", "Gandalf", "Voldemort", "Poppins", "Annagreth", "Lilith",
            "Dafaris", "Azahne", "Dhaneas", "Sadarin", "Urihan", "Inneas", "Yzehion", "Onielle", "Esinaxis",
            "Graham Shirley", "Rathal Petwraek", "Dyffros Naenan", "Vulas Petlamin", "Raibyn Chaeyarus", "Jhaan Keywenys", "Eriladar Ravabella",
            "Rilitar Xildi", "Tarron Gilkian", "Ornthalas Ralofina"};

    private static final int MIN_HP_WIZARD = 50;
    private static final int MAX_HP_WIZARD = 100;
    private static final int MIN_MANA_WIZARD = 10;
    private static final int MAX_MANA_WIZARD = 50;
    private static final int MIN_INTELLIGENCE_WIZARD = 1;
    private static final int MAX_INTELLIGENCE_WIZARD = 50;

    public Wizard(String name, int hp, int mana, int intelligence ) {
        super(name);
        setHp(hp);
        setMana(mana);
        setIntelligence(intelligence);
    }

    @Override
    public int attack() {
        int damage;
        if(mana >= 5){
            damage = intelligence;
            mana -= 5;
            System.out.println("⚔ ⚔ ⚔ ⚔ " + getName() + " makes a Fireball with " + damage + " points of power and loses 5 points of mana ⚔ ⚔ ⚔ ⚔");

        } else {
            damage = 2;
            mana += 1;
            System.out.println("⚔ ⚔ ⚔ ⚔ " + getName() + " makes a Staff hit with " + damage + " points of power and recovers 1 point of stamina ⚔ ⚔ ⚔ ⚔");

        }
        return damage;
    }


    // Método para crear Warrior aleatorio
    public static Wizard randomWizard(){

        Random generator = new Random();
        int randomIndex = generator.nextInt(wizardsNameList.length);
        int wizardHp = new Random().nextInt(MAX_HP_WIZARD-MIN_HP_WIZARD) + MIN_HP_WIZARD;
        int wizardMana = new Random().nextInt(MAX_MANA_WIZARD-MIN_MANA_WIZARD) + MIN_MANA_WIZARD;
        int wizardIntelligence = new Random().nextInt(MAX_INTELLIGENCE_WIZARD-MIN_INTELLIGENCE_WIZARD) + MIN_INTELLIGENCE_WIZARD;

        Wizard randomWizard = new Wizard(wizardsNameList[randomIndex], wizardHp, wizardMana, wizardIntelligence);

        return randomWizard;
    }


    @Override
    public String toString() {
//        return "Wizard{" +
//                "name=" + getName() +
//                ", hp=" + getHp() +
//                ", mana=" + mana +
//                ", intelligence=" + intelligence +
//                '}';
        return "Wizard -> " +
                "name: " + getName() +
                " // hp: " + getHp() +
                " // mana: " + mana +
                " // intelligence: " + intelligence;
    }

    /////////////////////////////
    ///// GETTERS / SETTERS /////
    /////////////////////////////

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setMana(int mana) {
        if (mana > MAX_MANA_WIZARD) {
            System.out.println("Inserted mana is greater than the maximum value. Mana will be equal to maximum value: " + MAX_MANA_WIZARD);
            this.mana = MAX_MANA_WIZARD;
        } else if (mana < MIN_MANA_WIZARD) {
            System.out.println("Inserted mana is lower than the minimum value. Mana will be equal to minimum value: " + MIN_MANA_WIZARD);
            this.mana=MIN_MANA_WIZARD;
        } else {
            this.mana = mana;
        }
    }

    public void setIntelligence(int intelligence) {
        if (intelligence > MAX_INTELLIGENCE_WIZARD) {
            System.out.println("Inserted intelligence is greater than the maximum value. Intelligence will be equal to maximum value: " + MAX_INTELLIGENCE_WIZARD);
            this.intelligence = MAX_INTELLIGENCE_WIZARD;
        } else if (intelligence < MIN_INTELLIGENCE_WIZARD) {
            System.out.println("Inserted intelligence is lower than the minimum value. Intelligence will be equal to minimum value: " + MIN_INTELLIGENCE_WIZARD);
            this.intelligence=MIN_INTELLIGENCE_WIZARD;
        } else {
            this.intelligence = intelligence;
        }
    }

    @Override
    public void setHp(int hp) {
        if (hp > MAX_HP_WIZARD) {
            System.out.println("Inserted hp is greater than the maximum value. Hp will be equal to maximum value: " + MAX_HP_WIZARD);
            super.setHp(MAX_HP_WIZARD);
        } else if (hp < MIN_HP_WIZARD) {
            System.out.println("Inserted hp is lower than the minimum value. Hp will be equal to minimum value: " + MIN_HP_WIZARD);
            super.setHp(MIN_HP_WIZARD);
        } else {
            super.setHp(hp);
        }
    }

    @Override
    public String getstatus() {
        return getStatusHP() + " and " + getMana() + " points of mana ❦ ❦ ❦ ❦";
    }

    public static int getMinHpWizard() {
        return MIN_HP_WIZARD;
    }

    public static int getMaxHpWizard() {
        return MAX_HP_WIZARD;
    }

    public static int getMinManaWizard() {
        return MIN_MANA_WIZARD;
    }

    public static int getMaxManaWizard() {
        return MAX_MANA_WIZARD;
    }

    public static int getMinIntelligenceWizard() {
        return MIN_INTELLIGENCE_WIZARD;
    }

    public static int getMaxIntelligenceWizard() {
        return MAX_INTELLIGENCE_WIZARD;
    }

    public static String[] getWizardsNameList() {
        return wizardsNameList;
    }
}
