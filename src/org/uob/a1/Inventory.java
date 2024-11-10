package org.uob.a1;

public class Inventory {
    private final int MAX_ITEMS = 10;
    private String[] inventory;
    private int numOfItems;

    public Inventory()
    {
        inventory = new String[MAX_ITEMS];
        numOfItems = 0;

    }
    public void addItem(String item)
    {
        if(numOfItems < MAX_ITEMS)
        {
            numOfItems++;
            for(int i = 0; i< inventory.length; i++)
            {
                if(inventory[i] == null)
                {
                    inventory[i] = item;
                    break;
                }
            }

        }
        else
        {
            System.out.println("Inventory is full you can't pick any more things up");
        }
    }
    public int hasItem(String item)
    {
        for (int i = 0; i < numOfItems; i++)
        {

            if(inventory[i] != null && inventory[i].equals(item))
            {
                return i;
            }
        }
        return -1;
    }
    public void removeItem(String item)
    {
        if(numOfItems >0) {
            int indexOfItem = hasItem(item);
            inventory[indexOfItem] = null;
            numOfItems--;
        }
        else
        {
            System.out.println("Inventory is empty you cant drop anything");
        }

    }
    public String displayInventory()
    {
        String inventoryAsAString = "";
        for(int i = 0; i < numOfItems; i++)
        {
            if(inventory[i]!= null) {
                inventoryAsAString += inventory[i] + " ";
            }
        }

        return inventoryAsAString;
    }

   
}