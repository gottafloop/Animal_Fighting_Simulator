//package com.company;

public class Food
{
    private String name;
    //multiplies stats
    private int attackBoost;
    private double healAmount;
    private int defenseBoost;
    private int mobilityBoost;

    public Food() // default constructor
    {
        name = "Pellets";
        attackBoost = 3;
        healAmount = 2.5;
        defenseBoost = 2;
        mobilityBoost = 1;
    }

    public Food(String n, int a, double h, int d, int m) //main constructor
    {
        name = n;
        attackBoost = a;
        healAmount = h;
        defenseBoost = d;
        mobilityBoost = m;
    }

    public String getName()
    {
        return name;
    }

    public void consume(Animal a)
    {
        a.addAttack((int)(a.getAttack() * attackBoost));
        a.heal((int)(a.getHealth() * healAmount));
        a.addDefense((int)(a.getDefense() * defenseBoost));
        a.addMobility((int)(a.getMobility() * mobilityBoost));
    }

    public static Food generateFood() // generates random food item
    {
        int chance = (int)(Math.random() * 5 + 1);

        if (chance == 1)
        {
            return new Food("Carrot", 2, 3.5, 2, 2);
        }
        else if (chance == 2)
        {
            return new Food("Sunflower Seeds", 1, 5.0, 2, 3);
        }
        else if (chance == 3)
        {
            return new Food("Steak", 10, 1.0, 1, 1);
        }
        else if (chance == 4)
        {
            return new Food("Golden Apple", 5, 5.0, 5, 5);
        }
        else
        {
            return new Food("Shrimp", 2, 3.0, 4, 4);
        }
        //5 food items, can add more
    }

    public String toString()
    {
        return "Name: " + name +
                "\nAttack Boost: " + attackBoost +
                "\nHealth Boost: " + healAmount +
                "\nDefense Boost: " + defenseBoost +
                "\nMobility Boost: " + mobilityBoost;
    }

}