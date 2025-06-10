//package com.company;

public class Animal
{
    private String species;
    private int attack;
    private int health;
    private int defense;
    private int mobility;
    private boolean canFly;
    private boolean aquatic;
    private String side;

    public Animal()
    {
        species = "Human";
        attack = 3;
        health = 50;
        defense = 1;
        mobility = 3;
        canFly = false;
        aquatic = false;
        side = "User";
    }

    public Animal(String s, int a, int h, int d, int m, boolean cf, boolean aq, String si)
    {
        species = s;
        attack = a;
        health = h;
        defense = d;
        mobility = m;
        canFly = cf;
        aquatic = aq;
        side = si;
    }

    //species, attack, health, defense, mobility, can fly, aquatic, side

    public String getSpecies()
    {
        return species;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getHealth()
    {
        return health;
    }

    public int getDefense()
    {
        return defense;
    }

    public int getMobility()
    {
        return mobility;
    }

    public boolean getFly()
    {
        return canFly;
    }

    public boolean getAquatic()
    {
        return aquatic;
    }

    public String getSide()
    {
        return side;
    }

    public void addAttack(int amount)
    {
        attack += amount;
    }

    public void heal(int amount)
    {
        health += amount;
    }

    public void addDefense(int amount)
    {
        defense += amount;
    }

    public void addMobility(int amount)
    {
        mobility += amount;
    }




    public void attacked(int dmg)
    {
        health -= dmg;
    }




    public String toString()
    {
        return "Type: " + species + "\n" +
                "Attack: " + attack + "\n" +
                "Health: " + health + "\n" +
                "Defense: " + defense + "\n" +
                "Mobility: " + mobility + "\n" +
                "Can Fly: " + canFly + "\n" +
                "Can Swim: " + aquatic;
    }

    public String sideAndName()
    {
        return side + " " + species;
    }


    //temp methods for duck
    public int getBullets()
    {
        System.out.println("duck error");
        return -1;
    }

    public String getGun()
    {
        System.out.println("duck error");
        return "duck error";
    }

    public double getCaliber()
    {
        System.out.println("duck error");
        return -1;
    }

    public void shootGun() //
    {
        System.out.println("Shooting error");
    }





}