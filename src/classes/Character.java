package classes;

import interfaces.Attacker;

import java.util.Objects;

public abstract class Character implements Attacker {

    private static int numCharacters;

    private final int id;
    private String name;
    private int hp;
    private boolean isAlive;

    public Character(String name) {
        numCharacters++;
        this.id = numCharacters;
        this.name = name;
        this.isAlive = true;
    }
    
    //takeDamage method
    public void takeDamage(int damage){
        hp = Math.max(hp -= damage, 0);
    }

    /////////////////////////////
    ///// GETTERS / SETTERS /////
    /////////////////////////////

    public static int getNumCharacters() {
        return numCharacters;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = (hp >= 1) ? hp : 1;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean checkStats() {
        if (getHp() == 0) {
            setAlive(false);
        } else{
            System.out.println(getstatus());
        }

        return isAlive();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return name.equals(character.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getStatusHP(){
        return "❦ ❦ ❦ ❦ " + getName() + " now has " + getHp() + "hp";
    }

    public abstract String getstatus();
}
