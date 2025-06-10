//package com.company;

public class Duck extends Animal
{
    private String gun;
    private int bullets;
    private double caliber;
    private String side;

    //default constructor
    public Duck()
    {
        super("Duck", 3, 3, 5, 4, true, true, "User");
        gun = "AK-47";
        bullets = 30;
        caliber = 7.62;
        side = "User";
    }

    //main constructor
    public Duck(String g, int b, double c, String s)
    {
        super("Duck", 3, 3, 5, 4, true, true, s);
        gun = g;
        bullets = b;
        caliber = c;
        side = s;
    }

    @Override
    public String toString()
    {
        return super.toString() +
                "\nGun: " + gun +
                "\nBullets: " + bullets +
                "\nCaliber: " + caliber;

    }

    //name, attack, health, defense, mobility, canfly, aquatic, gun, bullets, caliber

    @Override
    public String getGun()
    {
        return gun;
    }

    @Override
    public int getBullets()
    {
        return bullets;
    }

    @Override
    public double getCaliber()
    {
        return caliber;
    }

    @Override
    public void shootGun()
    {
        bullets--;
    }





}