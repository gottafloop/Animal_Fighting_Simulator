//package com.company;


public class Battle
{
    public static void attack(Animal attacker, Animal defender)
    {
        int missChance = 5;
        if (defender.getFly() && defender.getAquatic()) // if the defending animal can both swim and fly
        {
            if (attacker.getFly() && attacker.getAquatic())// checks if attacking animal can both swim and fly
            {
                missChance += 0;
            }
            else if (attacker.getFly())//checks if attacking animal can fly
            {
                missChance += 10;
            }
            else if (attacker.getAquatic())//checks if the attacking animal can swim
            {
                missChance += 10;
            }
            else //if the attacking animal can neither fly nor swim
            {
                missChance += 20;
            }
        }
        else if (defender.getFly()) //if the defender can only fly
        {
            if (!attacker.getFly()) // if the attacker cannot fly
            {
                missChance += 10;
            }
        }

        else if (defender.getAquatic()) // if the defender can only swim
        {
            if (!attacker.getAquatic()) // if the attacker cannot swim
            {
                missChance += 10;
            }
        }

        int attackChance = (int)(Math.random() * 100 + 1);
        missChance += defender.getMobility();

        if (attackChance > missChance) // attacking animal doesn't miss
        {

            int damage = attacker.getAttack();

            if (defender.getDefense() >= damage)
            {
                damage = 1;
            }
            else
            {
                damage -= defender.getDefense();
            }

            defender.attacked(damage);
            System.out.println(attacker.getSide() + " " + attacker.getSpecies() + " deals " + damage + " damage to " + defender.getSide() + " " + defender.getSpecies());
        }
        else // attacking animal misses
        {
            System.out.println(attacker.getSide() + " " + attacker.getSpecies() + " missed");
        }

    }

    public static void shoot(Animal shooter, Animal victim) // duck shooting animal
    {
        int missChance = 10 + victim.getMobility();
        int hitChance = (int) (Math.random() + 100 + 1);

        if (hitChance > missChance) // duck doesn't miss
        {
            shooter.shootGun();
            victim.attacked((int)(shooter.getCaliber()));
            System.out.println(shooter.getSide() + " Duck shoots " + victim.getSide() + " " + victim.getSpecies() + " and deals " + (int) (shooter.getCaliber()) + " damage");
            System.out.println(shooter.getSide() + " Duck has " + shooter.getBullets() + " bullets left");
        } else // duck misses
        {
            System.out.println(shooter.getSide() + " Duck misses shot");
        }

    }

}