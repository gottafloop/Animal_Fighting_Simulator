//package com.company;

import java.util.ArrayList;

public class Chest
{
    private String name;
    private ArrayList<Food> items;

    public Chest() // default constructor. Generates random food items
    {
        name = "Regular Chest";
        items = new ArrayList<Food>();
        while (items.size() < 5)
        {
            items.add(Food.generateFood());
        }

    }

    public Chest(String name, ArrayList<Food> items) // main constructor
    {
        this.name = name;
        this.items = items;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Food> getItems()
    {
        return items;
    }

    public String toString()
    {
        String text = "Name: " + name + "\n";
        for (int i = 0; i < items.size(); i++)
        {
            text += i+1 + (". " + items.get(i).toString() + "\n");
        }
        return text;

    }
}