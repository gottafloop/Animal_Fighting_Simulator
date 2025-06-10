//package com.company;
import java.util.ArrayList;

public class Dinosaur extends Animal
{
    private int stompDamage;
    private double roarVolume;
    private int tailSwipeDamage;

    public Dinosaur() // default consturctor
    {
        super("T-Rex", 100, 1000, 50, 3, false, false, "Enemy");
        stompDamage = 20;
        roarVolume = 0.1;
        tailSwipeDamage = 25;
    }
    //species, attack, health, defense, mobility, can fly, aquatic, side

    public Dinosaur(String species, int attack, int health, int defense, int mobility, boolean canFly, boolean aquatic, String side, int stompDamage, double roarVolume, int tailSwipeDamage)
    {
        super(species, attack, health, defense, mobility, canFly, aquatic, side);
        this.stompDamage = stompDamage;
        this.roarVolume = roarVolume;
        this.tailSwipeDamage = tailSwipeDamage;
    }// main constructor

    public void stomp(ArrayList<Animal> arr, int numAnimalsStomped)
    {

        System.out.println(this.sideAndName() + " uses stomp ability that deals " + stompDamage + " damage to " + numAnimalsStomped + " random animals " +
                "(unlucky animals can be hit more than once)");

        for (int i = 0; i < numAnimalsStomped; i++)
        {
            int chance = (int)(Math.random() * arr.size());
            arr.get(chance).attacked(stompDamage);
            System.out.println(arr.get(chance).getSpecies() + " is stomped!");
        }
    }

    public void roar()
    {
        System.out.println(this.sideAndName() + " uses roar ability!");

        int chance = (int)(Math.random() * 4 + 1);
        int amount;

        if (chance == 1) // boost attack
        {
            amount = (int)(this.getAttack() * roarVolume + 1);
            this.addAttack(amount);
            System.out.println(this.sideAndName() + " boosts their attack by " + amount);
        }
        else if (chance == 2) // boost health
        {
            amount = (int)(this.getHealth() * roarVolume + 1);
            this.heal(amount);
            System.out.println(this.sideAndName() + " heals " + amount + " health");
        }
        else if (chance == 3) // boost defense
        {
            amount = (int)(this.getDefense() * roarVolume + 1);
            this.addDefense(amount);
            System.out.println(this.sideAndName() + " boosts their defense by " + amount);
        }
        else // boost mobility
        {
            amount = (int)(this.getMobility() * roarVolume + 1);
            this.addMobility(amount);
            System.out.println(this.sideAndName() + " boosts their mobility by " + amount);
        }
    }

    public boolean tailSwipe(Animal victim)
    {
        victim.attacked(tailSwipeDamage);
        System.out.println(this.sideAndName() + " tail swipes and stuns " + victim.sideAndName() + " and deals " + tailSwipeDamage + " damage.");
        return true;
    }

    public static Dinosaur generateDinosaur() // generates a random dinosaur
    {
        int chance = (int)(Math.random() * 6 + 1);
        if (chance == 1)
        {
            return new Dinosaur();//t rex
        }
        else if (chance == 2)
        {
            return new Dinosaur("Stegosaurus", 50, 1000, 30, 3, false, false, "Enemy", 10, 0.15, 20);
        }
        else if (chance == 3)
        {
            return new Dinosaur("Brachiosaurus", 20, 2500, 10, 2, false, false, "Enemy", 20, 0.05, 20);
        }
        else if (chance == 4)
        {
            return new Dinosaur("Velociraptor", 30, 350, 3, 8, false, false, "Enemy", 5, 0.2, 7);
        }
        else if (chance == 5)
        {
            return new Dinosaur("Ankylosaurus", 30, 800, 50, 2, false, false, "Enemy", 10, 0.1, 150);
        }
        else //six
        {
            return new Dinosaur("Tricerotops", 30, 900, 40, 3, false, false, "Enemy", 10, 0.1, 25);
        }
    }
    // species, attack, health, defense, mobility, canFly, aquatic, side, stompDamage, roarVolume, tailSwipeDamage

}