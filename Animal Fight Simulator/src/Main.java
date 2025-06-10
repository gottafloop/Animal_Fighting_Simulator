//package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to animal fight. In this game, you must collect " +
                "animals and have them fight another group of animals." +
                " Some animals are stronger than other animals, so try to get lucky and" +
                " catch strong animals. Ducks are special because they have guns.");

        input.nextLine();

        ArrayList<Animal> userAnimals = new ArrayList<Animal>();

        System.out.println("Before you fight the other animals, you first need to collect animals yourself. " +
                "You will collect 5 animals and fight 10 random animals.");

        input.nextLine();

        System.out.println("Since you have less animals, to make things more fair, your animals will always attack first" +
                " unless you are fighting a duck. If two ducks are fighting, your duck will shoot first.");

        input.nextLine();

        ArrayList<Animal> tempArr = new ArrayList<Animal>();

        while (userAnimals.size() < 5) //number of animals user will have
        {
            while(tempArr.size() < 3)
            {
                tempArr.add(generateAnimal("User"));
            }

            System.out.println("1.\n" + tempArr.get(0) + "\n");
            System.out.println("2.\n" + tempArr.get(1) + "\n");
            System.out.println("3.\n" + tempArr.get(2) + "\n");

            System.out.println("Enter 1, 2, or 3 to select an animal.");

            int userChoice = input.nextInt();

            if (userChoice == 1)
            {
                userAnimals.add(tempArr.get(0));
                System.out.println("You selected the " + tempArr.get(0).getSpecies() + "\n");
            }
            else if (userChoice == 2)
            {
                userAnimals.add(tempArr.get(1));
                System.out.println("You selected the " + tempArr.get(1).getSpecies() + "\n");
            }
            else
            {
                userAnimals.add(tempArr.get(2));
                System.out.println("You selected the " + tempArr.get(2).getSpecies() + "\n");
            }

            input.nextLine(); //buffer
            input.nextLine();

            while(tempArr.size() > 0)
            {
                tempArr.remove(0);
            }

        }
        System.out.println("Here is your group of animals: ");
        for (Animal a : userAnimals)
        {
            System.out.println(a.getSpecies());
        }

        input.nextLine();

        ArrayList<Animal> enemyAnimals = new ArrayList<Animal>();

        //temporarily only fight 1 animal for testing sake
        while(enemyAnimals.size() < 10)
        {
            enemyAnimals.add(generateAnimal("Enemy"));
        }

        System.out.println("Here is the group of animals you will be fighting: ");
        for (Animal a : enemyAnimals)
        {
            System.out.println(a.getSpecies());
        }

        input.nextLine();

        System.out.println("May the fighting begin!");

        boolean fighting = true;
        Animal animal1;
        Animal animal2;
        boolean moveToDinosaur = false;

        //input.nextLine();

        while (fighting)
        {

            input.nextLine(); //switch

            System.out.println("Remaining user animals: ");
            for (Animal a : userAnimals)
            {
                System.out.println(a.getSpecies());
            }

            input.nextLine();

            System.out.println("Remaining enemy animals: ");
            for (Animal a : enemyAnimals)
            {
                System.out.println(a.getSpecies());
            }

            animal1 = userAnimals.get(0);
            animal2 = enemyAnimals.get(0);

            input.nextLine();

            System.out.println(animal1.getSide() + " " + animal1.getSpecies() + " is fighting " + animal2.getSide() + " " + animal2.getSpecies());

            boolean battle = true;
            while (battle)
            {

                input.nextLine();


                //if user animal is a duck, shoots until out of bullets or enemy animal dead
                if (animal1.getSpecies().equalsIgnoreCase("duck") && animal1.getBullets() > 0)
                {
                    while (animal1.getBullets() > 0 && animal2.getHealth() > 0)
                    {
                        Battle.shoot(animal1, animal2); // might have to move shoot method from battle class to duck class
                        //input.nextLine(); separates shoot line and health
                        System.out.println(animal1.getSide() + " " + animal1.getSpecies() + " Health: " + animal1.getHealth());
                        System.out.println(animal2.getSide() + " " + animal2.getSpecies() + " Health: " + animal2.getHealth());
                        input.nextLine();
                    }


                    battle = false;

                    if (animal2.getHealth() <= 0)
                    {
                        enemyAnimals.remove(0);
                        System.out.println(animal2.getSide() + " " + animal2.getSpecies() + " has been defeated!");
                        if (animal1.getBullets() <= 0)
                        {
                            System.out.println(animal1.getSide() + " Duck has run out of bullets!\n");
                        }
                    }
                    else
                    {
                        System.out.println(animal1.getSide() + " Duck has run out of bullets!\n");
                    }

                }
                else if (animal2.getSpecies().equalsIgnoreCase("duck") && animal2.getBullets() > 0) // checks if the enemy animal is a duck
                {
                    while (animal2.getBullets() > 0 && animal1.getHealth() > 0)
                    {
                        Battle.shoot(animal2, animal1);
                        //input.nextLine(); separates shoot line and health
                        System.out.println(animal2.getSide() + " " + animal2.getSpecies() + " Health: " + animal2.getHealth());
                        System.out.println(animal1.getSide() + " " + animal1.getSpecies() + " Health: " + animal1.getHealth());
                        input.nextLine();
                    }

                    battle = false;

                    if (animal1.getHealth() <= 0)
                    {
                        userAnimals.remove(0);
                        System.out.println(animal1.getSide() + " " + animal1.getSpecies() + " has been defeated!");
                        if (animal2.getBullets() <= 0)
                        {
                            System.out.println(animal2.getSide() + " " + " Duck has run out of bullets!");
                        }
                    }
                    else
                    {
                        System.out.println(animal2.getSide() + " Duck has run out of bullets!");
                    }

                }
                else // if no battling animals are ducks
                {
                    Battle.attack(animal1, animal2); // attacker, defender
                    System.out.println(animal1.getSide() + " " + animal1.getSpecies() + " Health: " + animal1.getHealth());
                    System.out.println(animal2.getSide() + " " + animal2.getSpecies() + " Health: " + animal2.getHealth());

                    input.nextLine();

                    if (animal2.getHealth() <= 0)
                    {
                        enemyAnimals.remove(0);
                        System.out.println(animal2.getSide() + " " + animal2.getSpecies() + " has been defeated!");
                        battle = false;
                    }

                    if (battle)
                    {
                        Battle.attack(animal2, animal1);
                        System.out.println(animal1.getSide() + " " + animal1.getSpecies() + " Health: " + animal1.getHealth());
                        System.out.println(animal2.getSide() + " " + animal2.getSpecies() + " Health: " + animal2.getHealth());
                    }




                    if (animal1.getHealth() <= 0)
                    {
                        userAnimals.remove(0);
                        System.out.println(animal1.getSide() + " " + animal1.getSpecies() + " has been eliminated!");
                        battle = false;
                        input.nextLine();
                    }
                }




            }

            if (userAnimals.size() <= 0)
            {
                fighting = false;
                System.out.println("Your animals have been defeated. The enemy animals have won.");
            }
            else if (enemyAnimals.size() <= 0)
            {
                fighting = false;
                System.out.println("Your animals have defeated the enemy animals. You win!");
                moveToDinosaur = true;
            }

        }

        boolean moveToBoss1 = false;
        if (moveToDinosaur)
        {
            input.nextLine();
            System.out.println("Congratulations on defeating the enemy animals." +
                    " Now, you must fight dinosaurs, which are much stronger than " +
                    "regular animals. In order to defeat them, you're gonna need more, " +
                    "stronger animals. Let's first get you 10 more animals.");

            input.nextLine();

            int newSize = userAnimals.size() + 10;

            while (userAnimals.size() < newSize)
            {
                while(tempArr.size() < 3)
                {
                    tempArr.add(generateAnimal("User"));
                }

                System.out.println("1.\n" + tempArr.get(0) + "\n");
                System.out.println("2.\n" + tempArr.get(1) + "\n");
                System.out.println("3.\n" + tempArr.get(2) + "\n");

                System.out.println("Enter 1, 2, or 3 to select an animal.");

                int userChoice = input.nextInt();

                if (userChoice == 1)
                {
                    userAnimals.add(tempArr.get(0));
                    System.out.println("You selected the " + tempArr.get(0).getSpecies() + "\n");
                }
                else if (userChoice == 2)
                {
                    userAnimals.add(tempArr.get(1));
                    System.out.println("You selected the " + tempArr.get(1).getSpecies() + "\n");
                }
                else
                {
                    userAnimals.add(tempArr.get(2));
                    System.out.println("You selected the " + tempArr.get(2).getSpecies() + "\n");
                }

                input.nextLine(); //buffer
                input.nextLine();

                while(tempArr.size() > 0)
                {
                    tempArr.remove(0);
                }
            }

            System.out.println("Here is your new list of animals:");
            for (int i = 0; i < userAnimals.size(); i++)
            {
                System.out.println(userAnimals.get(i).getSpecies());
            }

            input.nextLine();

            System.out.println("Now that we have your new animals, lets make them stronger." +
                    "each animal will get some food to eat, which buffs their stats. Choose " +
                    "food for each animal.");

            input.nextLine();

            ArrayList<Food> tempFoodArr = new ArrayList<Food>();
            for (int i = 0; i < userAnimals.size(); i++)
            {
                System.out.println("Choose food for " + userAnimals.get(i).getSpecies() + " to eat.");
                input.nextLine();
                while (tempFoodArr.size() < 3)
                {
                    tempFoodArr.add(Food.generateFood());
                }

                for (int x =  0; x < tempFoodArr.size(); x++)
                {
                    System.out.println(x+1 + ". " + tempFoodArr.get(x) + "\n");
                }

                int foodChoice = input.nextInt();

                if (foodChoice == 1)
                {
                    tempFoodArr.get(0).consume(userAnimals.get(i));
                    System.out.println("You chose the " + tempFoodArr.get(0).getName());
                    input.nextLine();
                    input.nextLine();
                    System.out.println(userAnimals.get(i).getSpecies() + " new stats: ");
                    System.out.println(userAnimals.get(i));
                }
                else if (foodChoice == 2)
                {
                    tempFoodArr.get(1).consume(userAnimals.get(i));
                    System.out.println("You chose the " + tempFoodArr.get(1).getName());
                    input.nextLine();
                    input.nextLine();
                    System.out.println(userAnimals.get(i).getSpecies() + " new stats: ");
                    System.out.println(userAnimals.get(i));
                }
                else
                {
                    tempFoodArr.get(2).consume(userAnimals.get(i));
                    System.out.println("You chose the " + tempFoodArr.get(2).getName());
                    input.nextLine();
                    input.nextLine();
                    System.out.println(userAnimals.get(i).getSpecies() + " new stats: ");
                    System.out.println(userAnimals.get(i));
                }

                while (tempFoodArr.size() > 0)
                {
                    tempFoodArr.remove(0);
                }

                input.nextLine();

            }

            System.out.println("You've received new, stronger animals. It's " +
                    "time to fight the dinosaurs. You will fight 5 of them. Be warned, they're very strong and " +
                    "have special abilities. Good luck!");

            input.nextLine();

            ArrayList<Dinosaur> dinoArr = new ArrayList<Dinosaur>();

            while (dinoArr.size() < 5)
            {
                dinoArr.add(Dinosaur.generateDinosaur());
            }

            System.out.println("List of dinosaurs you will be fighting: ");
            for (Dinosaur d : dinoArr)
            {
                System.out.println(d.getSpecies());
            }

            input.nextLine();

            System.out.println("May the fighting begin!");

            Animal userAnimal;
            Dinosaur enemyDinosaur;

            boolean dinoFighting = true; //change
            boolean dinoBattle = true;
            boolean stunned = false;
            while (dinoFighting)
            {
                dinoBattle = true;
                input.nextLine();

                userAnimal = userAnimals.get(0);
                enemyDinosaur = dinoArr.get(0);


                System.out.println("Remaining User Animals:");
                for (Animal a : userAnimals)
                {
                    System.out.println(a.getSpecies());
                }

                input.nextLine();

                System.out.println("Remaining Dinosaurs: ");
                for (Dinosaur d : dinoArr)
                {
                    System.out.println(d.getSpecies());
                }

                input.nextLine();

                System.out.println(userAnimal.getSpecies() + " is fighting " + enemyDinosaur.getSpecies());

                input.nextLine();
                while (dinoBattle)
                {
                    if (userAnimal.getSpecies().equalsIgnoreCase("duck") && userAnimal.getBullets() > 0) // duck shooting
                    {
                        while (userAnimal.getBullets() > 0 && enemyDinosaur.getHealth() > 0)
                        {
                            Battle.shoot(userAnimal, enemyDinosaur);
                            System.out.println(userAnimal.getSpecies() + " Health: " + userAnimal.getHealth());
                            System.out.println(enemyDinosaur.getSpecies() + " Health: " + enemyDinosaur.getHealth());
                            input.nextLine();
                        }

                        dinoBattle = false;

                        //look for reason duck stopped shooting
                        if (enemyDinosaur.getHealth() <= 0)
                        {
                            System.out.println(enemyDinosaur.getSpecies() + " has been defeated!\n");
                            if (userAnimal.getBullets() <= 0)
                            {
                                System.out.println(userAnimal.getSpecies() + " has run out of bullets!\n");
                            }
                        }
                        else
                        {
                            System.out.println(userAnimal.getSpecies() + " has run out of bullets!\n");
                        }


                    }
                    else //normal fighting
                    {
                        if (stunned)
                        {
                            System.out.println(userAnimal.getSpecies() + " is stunned!");
                            stunned = false;
                        }
                        else
                        {
                            Battle.attack(userAnimal, enemyDinosaur);
                        }
                        System.out.println(userAnimal.getSpecies() + " Health: " + userAnimal.getHealth());
                        System.out.println(enemyDinosaur.getSpecies() + " Health: " + enemyDinosaur.getHealth());

                        input.nextLine();

                        if (enemyDinosaur.getHealth() <= 0)
                        {
                            dinoArr.remove(0);
                            System.out.println(enemyDinosaur.getSpecies() + " has been defeated!");
                            dinoBattle = false;
                            input.nextLine();
                        }

                        if (dinoBattle) // multiple abilities/attacks
                        {
                            int attackChance = (int)(Math.random() * 6 + 1);

                            if (attackChance == 1)
                            {
                                enemyDinosaur.roar();
                            }
                            else if (attackChance == 2)
                            {
                                stunned = enemyDinosaur.tailSwipe(userAnimal);
                            }
                            else if (attackChance == 3)
                            {
                                int stompAmount = (int)(Math.random() * 5 + 2);
                                enemyDinosaur.stomp(userAnimals, stompAmount);
                            }
                            else
                            {
                                Battle.attack(enemyDinosaur, userAnimal);
                            }
                            System.out.println(userAnimal.getSpecies() + " Health: " + userAnimal.getHealth());
                            System.out.println(enemyDinosaur.getSpecies() + " Health: " + enemyDinosaur.getHealth());


                        }

                        input.nextLine();

                        for (int x = 0; x < userAnimals.size(); x++)
                        {
                            if (userAnimals.get(x).getHealth() <= 0)
                            {
                                System.out.println(userAnimals.get(x).getSpecies() +
                                        " has been defeated!");
                                userAnimals.remove(x);
                            }
                        }

                        input.nextLine();


                    }

                }//end of dinobattle

                stunned = false;

                if (userAnimals.size() <= 0)
                {
                    dinoFighting = false;
                    System.out.println("Your animals have been defeated. The dinosaurs have won.");
                }
                else if (dinoArr.size() <= 0)
                {
                    dinoFighting = false;
                    System.out.println("The dinosaurs have been defeated. You win!");
                    moveToBoss1 = true;
                }


            } //end of main dino fight loop
        } //end of if user moves to dinosaur

        input.nextLine();

        boolean moveToBoss2 = false;
        if (moveToBoss1)
        {
            System.out.println("Congratulations on defeating the dinosaurs!" +
                    " Despite them being much bigger than your animals, with the " +
                    "right boosts, they managed to pull it off.");

            input.nextLine();

            System.out.println("Now you must defeat Pablo the Pibble, the mastermind " +
                    "behind all the enemy animals. He is very strong, so you must " +
                    "get more animals and increase their power further.");

            input.nextLine();

            System.out.println("Collect another 5 animals.");

            int newSize = userAnimals.size() + 5;
            while (userAnimals.size() < newSize)
            {
                while(tempArr.size() < 3)
                {
                    tempArr.add(generateAnimal("User"));
                }

                System.out.println("1.\n" + tempArr.get(0) + "\n");
                System.out.println("2.\n" + tempArr.get(1) + "\n");
                System.out.println("3.\n" + tempArr.get(2) + "\n");

                System.out.println("Enter 1, 2, or 3 to select an animal.");

                int userChoice = input.nextInt();

                if (userChoice == 1)
                {
                    userAnimals.add(tempArr.get(0));
                    System.out.println("You selected the " + tempArr.get(0).getSpecies() + "\n");
                }
                else if (userChoice == 2)
                {
                    userAnimals.add(tempArr.get(1));
                    System.out.println("You selected the " + tempArr.get(1).getSpecies() + "\n");
                }
                else
                {
                    userAnimals.add(tempArr.get(2));
                    System.out.println("You selected the " + tempArr.get(2).getSpecies() + "\n");
                }

                input.nextLine(); //buffer
                input.nextLine();

                while(tempArr.size() > 0)
                {
                    tempArr.remove(0);
                }
            }

            System.out.println("Here's your new list of animals: ");
            for (Animal a : userAnimals)
            {
                System.out.println(a.getSpecies());
            }

            input.nextLine();

            System.out.println("\nPablo is very strong, so you must " +
                    "feed your animals more food to boost them further.");

            input.nextLine();

            System.out.println("This time, you will be granted a chest you can choose from. Each chest " +
                    "will have the same piece of food for each animal. Alternatively, you can choose a random chest.");

            input.nextLine();

            System.out.println("\n1. Steak Chest" +
                    "\n2. Golden Apple Chest" +
                    "\n3. Sunflower Seed Chest" +
                    "\n4. Carrot Chest" +
                    "\n5. Shrimp Chest" +
                    "\n6. Random Chest");

            int chestChoice = input.nextInt();
            Chest userChest;
            ArrayList<Food> chestContent = new ArrayList<Food>();
            if (chestChoice == 1)
            {
                for (int i = 0; i < userAnimals.size(); i++)
                {
                    chestContent.add(new Food("Steak", 10, 1.0, 1, 1));
                }
                userChest = new Chest("Steak Chest", chestContent);
            }
            else if (chestChoice == 2)
            {
                for (int i = 0; i < userAnimals.size(); i++)
                {
                    chestContent.add(new Food("Golden Apple", 5, 5.0, 5, 5));
                }
                userChest = new Chest("Golden Apple Chest", chestContent);
            }
            else if (chestChoice == 3)
            {
                for (int i = 0; i < userAnimals.size(); i++)
                {
                    chestContent.add(new Food("Sunflower Seeds", 1, 5.0, 2, 3));
                }
                userChest = new Chest("Sunflower Seed Chest", chestContent);
            }
            else if (chestChoice == 4)
            {
                for (int i = 0; i < userAnimals.size(); i++)
                {
                    chestContent.add(new Food("Carrot", 2, 3.5, 2, 2));
                }
                userChest = new Chest("Carrot Chest", chestContent);
            }
            else if (chestChoice == 5)
            {
                for (int i = 0; i < userAnimals.size(); i++)
                {
                    chestContent.add(new Food("Shrimp", 2, 3.0, 4, 4));
                }
                userChest = new Chest("Shrimp Chest", chestContent);
            }
            else //random chest
            {
                for (int i = 0; i < userAnimals.size(); i++)
                {
                    chestContent.add(Food.generateFood());
                }
                userChest = new Chest("Random Chest", chestContent);
            }

            System.out.println("You chose the " + userChest.getName());
            input.nextLine();
            System.out.println("Your animals will now consume the chest contents.");

            input.nextLine();

            for (int i = 0; i < userAnimals.size(); i++)
            {
                System.out.println(userAnimals.get(i).getSpecies() + " is eating " + userChest.getItems().get(i).getName());
                userChest.getItems().get(i).consume(userAnimals.get(i));
                input.nextLine();
                System.out.println("New Stats: ");
                System.out.println(userAnimals.get(i));
                System.out.println();
                input.nextLine();
            }

            System.out.println("You're ready to fight Pablo the Pibble. Good luck!");

            input.nextLine();


            ArrayList<String> pabloLines = new ArrayList<String>();
            pabloLines.add("There is no use resisting against a pibble!");
            pabloLines.add("Pibble destroy!");
            pabloLines.add("Pibble Blast!");
            pabloLines.add("I am going to feed you to my pibble children.");
            pabloLines.add("Say goodbye.");
            Boss pablo = new Boss ("Pablo", 250, 5000, 75, 15, false, false, "Enemy", "Pablo", 50, -0.05, 10, pabloLines);
            //species, attack, health, defense, mobility, canFly, aquatic, side, name, stompDamage, weakenPercent, poisonDamage, lines

            System.out.println("Pablo: I, am Pablo.");
            input.nextLine();
            System.out.println("Pablo: Pablo the Pibble");
            input.nextLine();
            System.out.println("How dare you destroy my precious minions!");
            System.out.println("I guess I should just destroy you and your animals myself.");
            input.nextLine();
            System.out.println("You're not prepared to face the power of a pibble!");

            boolean pabloFight = true;
            boolean pabloDefeated = false;

            while (pabloFight)
            {
                input.nextLine();
                System.out.println("Remaining Animals: ");
                for (int i = 0; i < userAnimals.size(); i++)
                {
                    System.out.println(userAnimals.get(i).getSpecies());
                }

                Animal currentAnimal = userAnimals.get(0);

                input.nextLine();

                if (currentAnimal.getSpecies().equalsIgnoreCase("duck") && currentAnimal.getBullets() > 0) // duck shooting
                {
                    while (currentAnimal.getBullets() > 0 && pablo.getHealth() > 0)
                    {
                        Battle.shoot(currentAnimal, pablo);
                        System.out.println(currentAnimal.getSpecies() + " Health: " + currentAnimal.getHealth());
                        System.out.println(pablo.getSpecies() + " Health: " + pablo.getHealth());
                        input.nextLine();
                    }

                    //look for reason duck stopped shooting
                    if (pablo.getHealth() <= 0)
                    {
                        if (currentAnimal.getBullets() <= 0)
                        {
                            System.out.println(currentAnimal.getSpecies() + " has run out of bullets!\n");
                        }
                        pabloFight = false;
                        pabloDefeated = true;
                    }
                    else
                    {
                        System.out.println(currentAnimal.getSpecies() + " has run out of bullets!\n");
                    }


                }


                Battle.attack(currentAnimal, pablo);
                System.out.println(currentAnimal.getSpecies() + " Health: " + currentAnimal.getHealth());
                System.out.println(pablo.getName() + " Health: " + pablo.getHealth());


                input.nextLine();

                if (pablo.getHealth() <= 0)
                {
                    pabloFight = false;
                    pabloDefeated = true;
                }

                if (pabloFight)
                {
                    int attackChance = (int)(Math.random() * 6 + 1);

                    if (attackChance == 1)
                    {
                        pablo.stomp(userAnimals);
                    }
                    else if (attackChance == 2)
                    {
                        pablo.increasePoison();
                    }
                    else if (attackChance == 3)
                    {
                        pablo.weaken(userAnimals);
                    }
                    else
                    {
                        Battle.attack(pablo, currentAnimal);
                    }

                    pablo.poison(userAnimals);

                    input.nextLine();

                    System.out.println("Pablo: " + pablo.randomLine());
                }

                for (int i = 0; i < userAnimals.size(); i++)
                {
                    if (userAnimals.get(i).getHealth() <= 0)
                    {
                        System.out.println(userAnimals.get(i).getSpecies() + " has been defeated!");
                        userAnimals.remove(i);
                    }
                }

                if (userAnimals.size() <= 0)
                {
                    pabloFight = false;
                    System.out.println("Pablo: Any last words?");
                    String pabloLastWords = input.nextLine();

                    if (pabloLastWords.indexOf("please") >= 0)
                    {
                        System.out.println("Pablo: Pleading is futile. Goodbye (eats you).");
                    }
                    else if (pabloLastWords.indexOf("no") >= 0)
                    {
                        System.out.println("Pablo: Don't resist. You will be my dinner (eats you).");
                    }
                    else {
                        System.out.println("Pablo: I'm going to eat you and play with your bones. (eats you and plays with your bones)");
                    }


                }
            } //end of pablofight

            if (pabloDefeated)
            {
                System.out.println("Pablo: How can this be? I am Pablo the Pibble, destroyer of worlds.");
                input.nextLine();
                System.out.println("Pablo: How could I be beaten by a mere human?");
                input.nextLine();
                System.out.println("Pablo: I will reme-\n(dies)");
                input.nextLine();
                System.out.println("Congratulations, you defeated Pablo the Pibble, the evil mastermind" +
                        " behind why you were getting attacked by so many animals.");
                input.nextLine();
                System.out.println("It's not over yet. Someone's coming.");
                input.nextLine();
                System.out.println("Stella: Hello. I am Stella the Seal. The inventor of animals.");
                input.nextLine();
                System.out.println("Stella: I see you've used my animals to do your bidding. All animals come from me, as I created all of them.");
                input.nextLine();
                System.out.println("Stella: I don't think you want to give up your animals very easily. Then I'll have to fight you myself " +
                        "and avenge Pablo. I didn't like him that much though.");
                input.nextLine();
                System.out.println("Stella: Fighting is useless. You are using my very creation against me.");
                input.nextLine();
                moveToBoss2 = true;
            }


        } // end of bossifght1

        if (moveToBoss2)
        {
            boolean stellaFight = true;
            boolean stellaDefeated = false;
            ArrayList<String> stellaLines = new ArrayList<String>();
            stellaLines.add("I'm going to flop you.");
            stellaLines.add("My kids will come back to me eventually.");
            stellaLines.add("I will eat so much fish after I eat you.");
            stellaLines.add("I will always galumph after you, no matter how far.");
            Boss stella = new Boss("Stella", 500, 10000, 100, 50, true, true, "Enemy", "Stella the Seal", 100, -0.2, 20, stellaLines);
            //species, attack, health, defense, mobility, canFly, aquatic, side, name, stompDamage, weakenPercent, poisonDamage, lines

            while (stellaFight)
            {
                input.nextLine();
                System.out.println("Remaining Animals: ");
                for (int i = 0; i < userAnimals.size(); i++)
                {
                    System.out.println(userAnimals.get(i).getSpecies());
                }

                Animal currentAnimal = userAnimals.get(0);

                input.nextLine();

                if (currentAnimal.getSpecies().equalsIgnoreCase("duck") && currentAnimal.getBullets() > 0) // duck shooting
                {
                    while (currentAnimal.getBullets() > 0 && stella.getHealth() > 0)
                    {
                        Battle.shoot(currentAnimal, stella);
                        System.out.println(currentAnimal.getSpecies() + " Health: " + currentAnimal.getHealth());
                        System.out.println(stella.getSpecies() + " Health: " + stella.getHealth());
                        input.nextLine();
                    }

                    //look for reason duck stopped shooting
                    if (stella.getHealth() <= 0)
                    {
                        if (currentAnimal.getBullets() <= 0)
                        {
                            System.out.println(currentAnimal.getSpecies() + " has run out of bullets!\n");
                        }
                        stellaFight = false;
                        stellaDefeated = true;
                    }
                    else
                    {
                        System.out.println(currentAnimal.getSpecies() + " has run out of bullets!\n");
                    }


                }


                Battle.attack(currentAnimal, stella);
                System.out.println(currentAnimal.getSpecies() + " Health: " + currentAnimal.getHealth());
                System.out.println(stella.getName() + " Health: " + stella.getHealth());


                input.nextLine();

                if (stella.getHealth() <= 0)
                {
                    stellaFight = false;
                    stellaDefeated = true;
                }

                if (stellaFight)
                {
                    int attackChance = (int)(Math.random() * 6 + 1);

                    if (attackChance == 1)
                    {
                        stella.stomp(userAnimals);
                    }
                    else if (attackChance == 2)
                    {
                        stella.increasePoison();
                        stella.increasePoison();
                    }
                    else if (attackChance == 3)
                    {
                        stella.weaken(userAnimals);
                    }
                    else
                    {
                        Battle.attack(stella, currentAnimal);
                    }

                    stella.poison(userAnimals);

                    input.nextLine();

                    System.out.println("Stella: " + stella.randomLine());
                }

                for (int i = 0; i < userAnimals.size(); i++)
                {
                    if (userAnimals.get(i).getHealth() <= 0)
                    {
                        System.out.println(userAnimals.get(i).getSpecies() + " has been defeated!");
                        userAnimals.remove(i);
                    }
                }

                if (userAnimals.size() <= 0)
                {
                    stellaFight = false;
                    System.out.println("Stella: To no surprise, you lost. Last words?");
                    String stellaLastWords = input.nextLine();

                    if (stellaLastWords.indexOf("please") >= 0)
                    {
                        System.out.println("Stella: I don't care about your feelings. I will eat you with the fish. (eats you with the fish)");
                    }
                    else if (stellaLastWords.indexOf("no") >= 0)
                    {
                        System.out.println("Stella: I'll eat you with extra fish. (eats you with extra fish)");
                    }
                    else {
                        System.out.println("Stella: Your words are crushed under the weight of, me, I guess. (kills you)");
                    }


                }
            }//end of stella fight

            if (stellaDefeated)
            {
                System.out.println("Stella: Wow, I guess you really beat me huh.");
                input.nextLine();
                System.out.println("Stella: Well, you didn't actually kill me. I am the inventor of animals. No way I'd just die like that.");
                input.nextLine();
                System.out.println("Stella: I will say you have impressed me enough to not want to eat you anymore. Good job.");
                input.nextLine();
                System.out.println("And with that, concludes your journey.");
                input.nextLine();
                System.out.println("You've defeated enemies, dinosaurs, the evil mastermind, and even the inventor of animals.");
                input.nextLine();
                System.out.println("You are quite the animal owner. Good job winning!");
            }

        } //end of bossfight2



    }



    public static Animal generateAnimal(String side) { // generates random animal
        int num = (int) (Math.random() * 89 + 1);
        if (num <= 5) {
            return new Animal("Mouse", 1, 10, 1, 8, false, false, side);
        } else if (num > 5 && num <= 10)
        {
            return new Animal("Dog", 10, 100, 3, 5, false, false, side);
        } else if (num > 10 && num <= 15)
        {
            return new Animal("Eagle", 7, 50, 0, 7, true, false, side);
        } else if (num > 15 && num <= 20)
        {
            return new Animal("Goat", 5, 100, 3, 3, false, false, side);
        } else if (num > 20 && num <= 25)
        {
            return new Animal("Clownfish", 1, 5, 0, 1, false, true, side);
        } else if (num > 25 && num <= 30)
        {
            return new Animal("Cow", 12, 300, 7, 2, false, false, side);
        } else if (num > 30 && num <= 35)
        {
            return new Animal("Seagull", 3, 35, 0, 4, true, false, side);
        } else if (num > 35 && num <= 40)
        {
            return new Animal("House Cat", 3, 75, 1, 8, false, false, side);
        }
        else if (num > 40 && num <= 43)
        {
            return new Animal("Swordfish", 15, 125, 1, 10, false, true, side);
        } else if (num > 43 && num <= 46)
        {
            return new Animal("Lion", 35, 250, 3, 9, false, false, side);
        }
        else if (num > 46 && num <= 48)
        {
            return new Animal("Tiger", 40, 300, 3, 10, false, false, side);
        }
        else if (num > 48 && num <= 50)
        {
            return new Animal("Polar Bear", 50, 375, 4, 5, false, true, side);
        }
        else if (num > 50 && num <= 52)
        {
            return new Animal("Elephant", 15, 1000, 20, 2, false, false, side);
        }
        else if (num > 52 && num <= 54) {
            return new Animal("Orca", 25, 750, 3, 6, false, true, side);
        }
        else if (num > 54 && num <= 57) {
            return new Animal("Shark", 30, 200, 0, 4, false, true, side);
        }
        else if (num > 57 && num <= 59)
        {
            return new Animal("Crocodile", 40, 250, 5, 2, false, true, side);
        }
        else if (num > 59 && num <= 61)
        {
            return new Animal("Snake", 10, 30, 0, 25, false, false, side);
        }
        else if (num > 61 && num <= 63)
        {
            return new Animal("Hippo", 60, 500, 3, 1, false, true, side);
        }
        else if (num > 63 && num <= 65)
        {
            return new Animal("Rhino", 40, 550, 10, 1, false, false, side);
        }
        else if (num > 65 && num <= 68)
        {
            return new Animal("Frog", 1, 10, 0, 2, false, true, side);
        }
        else if (num > 68 && num <= 71)
        {
            return new Animal("Capybara", 2, 75, 0, 3, false, true, side);
        }
        else if (num > 71 && num <= 74)
        {
            return new Animal("Kangaroo", 15, 250, 1, 5, false, false, side);
        }
        else if (num > 74 && num <= 76)
        {
            return new Animal("Cheetah", 20, 200, 0, 15, false, false, side);
        }
        else if (num > 76 && num <= 79)
        {
            return new Animal("Raccoon", 7, 75, 1, 5, false, false, side);
        }
        else if (num > 79 && num <= 82)
        {
            return new Animal("Pig", 3, 125, 0, 2, false, false, side);
        }
        else if (num > 82 && num <= 85)
        {
            return new Animal("Wolf", 10, 200, 1, 9, false, false, side);
        }
        else if (num > 85 && num <= 88)
        {
            return new Animal("Ostrich", 5, 300, 0, 10, false, false, side);
        }
        else {
            int gunNum = (int) (Math.random() * 3 + 1);
            if (gunNum == 1) {
                return new Duck();
            } else if (gunNum == 2) {
                return new Duck("M4A1", 50, 5.56, side);
            } else {
                return new Duck("Pistol", 12, 3.2, side);
            }

            //gun, bullets, caliber
        }
    }
    //name, attack, health, defense, mobility, canfly, aquatic

    /*
    List of animals:
    Duck
Dog X
ElephantX
SharkX
TigerX
LionX
Eagle X
Seagull X
Swordfish
Clownfish X
Goat X
House CatX
Cow X
OrcaX
Polar BearX
Mouse X
16 total animals

Animal Expansion dlc
Crocodile
Snake
Hippo
Rhino
Frog
Capybara
Kangaroo
Cheetah
Raccoon
Pig
Wolf
Ostrich

     */


}