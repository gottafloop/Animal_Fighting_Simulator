//package com.company;
import java.util.ArrayList;

public class Boss extends Animal
{
    private String name; // different from species
    private int stompDamage;
    private double weakenPercent; // should always be a negative number
    private int poisonDamage;
    private final int poisonIncrement = 10;
    private ArrayList<String> lines = new ArrayList<String>();;

    public Boss() //default constructor
    {
        super("Pig", 30, 1500, 50, 10, true, true, "Enemy");
        name = "John Villian";
        stompDamage = 25;
        weakenPercent = -0.1;
        poisonDamage = 5;
        lines.add("Mwahahahaha");
    }

    public Boss(String species, int attack, int health, int defense, int mobility, boolean canFly, boolean aquatic, String side, String name, int stompDamage, double weakenPercent, int poisonDamage, ArrayList<String> lines) // main constructor
    {
        super(species, attack, health, defense, mobility, canFly, aquatic, side);
        //species, attack, health, defense, mobility, can fly, aquatic, side
        this.name = name;
        this.stompDamage = stompDamage;
        this.weakenPercent = weakenPercent;
        this.poisonDamage = poisonDamage;
        this.lines = lines;
    }

    public String getName()
    {
        return name;
    }

    public int getPoisonDamage()
    {
        return poisonDamage;
    }

    public void stomp(ArrayList<Animal> arr) // overloaded from dinosaur class
    {
        System.out.println(name + " uses stomp ability! Deals " + stompDamage + " to all animals.");
        for (int i = 0; i < arr.size(); i++)
        {
            arr.get(i).attacked(stompDamage);
        }
    }

    public void weaken(ArrayList<Animal> arr) //permanently weaken one random animal
    {
        int statWeakened = (int)(Math.random() * 3 + 1);
        int animalIndex = (int)(Math.random() * arr.size());

        if (statWeakened == 1) // weakens attack
        {
            int attackWeakened = (int)(arr.get(animalIndex).getAttack() * weakenPercent);
            arr.get(animalIndex).addAttack(attackWeakened);
            System.out.println(this.getName() + " weakens " +
                    arr.get(animalIndex).getSpecies() + " 's attack " +
                    "by " + attackWeakened);
        }
        else if (statWeakened == 2) // weakens defense
        {
            int defenseWeakened = (int)(arr.get(animalIndex).getDefense() * weakenPercent);
            arr.get(animalIndex).addDefense(defenseWeakened);
            System.out.println(this.getName() + " weakens " +
                    arr.get(animalIndex).getSpecies() + " 's defense " +
                    "by " + defenseWeakened);
        }
        else // weakens mobility
        {
            int mobilityWeakened = (int)(arr.get(animalIndex).getMobility() * weakenPercent);
            arr.get(animalIndex).addMobility(mobilityWeakened);
            System.out.println(this.getName() + " weakens " +
                    arr.get(animalIndex).getSpecies() + " 's mobility " +
                    "by " + mobilityWeakened);
        }

    }

    public void increasePoison()
    {
        System.out.println(this.getName() + " increases poison by " + poisonIncrement);
        poisonDamage += poisonIncrement;
    }

    public void poison(ArrayList<Animal> arr) // dot
    {
        System.out.println(this.getName() + "'s poison damage deals " + poisonDamage + " to all animals.");
        for (int i = 0; i < arr.size(); i++)
        {
            arr.get(i).attacked(poisonDamage);
        }
    }

    public String randomLine() // returns a random line of dialogue
    {
        int randIndex = (int)(Math.random() * lines.size());
        return lines.get(randIndex);
    }

    public String toString()
    {
        return "Name: " + name +
                "\nStomp Damage: " + stompDamage +
                "\nWeaken Percent: " + weakenPercent +
                "\nPoison Damage: " + poisonDamage +
                "\n" + super.toString();
    }

}