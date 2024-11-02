package org.uob.a1;

import java.util.Scanner; 

public class Game {

    public static Scanner reader = new Scanner(System.in);
    public static Position userPosition = new Position(1,1);
    public static Map diagram = new Map(10,10);
    public static Room[] rooms = new Room[10];
    public static Room currentRoom = null;
    public static boolean currentlyInRoom = false;
    public static Inventory inventory = new Inventory();



    public static void createRooms()
    {
        {
            //first I will create all the rooms
            Position PosOfMainLobby = new Position(8, 1);
            Room mainLobby = new Room("Main Lobby", "Hmm this room seems to have loads of sofas does the Joker actually have this many friends to be using all these sofas",
                    'M', PosOfMainLobby);
            diagram.placeRoom(PosOfMainLobby, mainLobby.getSymbol());
            rooms[0]= mainLobby;

            Position PosOfGarage = new Position(3, 4);
            Room garage = new Room("Garage", "Wow the Joker has a garage with a very nice collection, wait is that the batmobile" +
                    " Batman has to be somewhere around here", 'G', PosOfGarage);
            diagram.placeRoom(PosOfGarage, garage.getSymbol());
            {
                garage.artForTheRoom = "                     @\n" +
                        "               (__)    (__) _____/\n" +
                        "            /| (oo) _  (oo)/----/_____    *\n" +
                        "  _o\\______/_|\\_\\/_/_|__\\/|____|//////== *- *  * -\n" +
                        " /_________   \\   00 |   00 |       /== -* * -\n" +
                        "[_____/^^\\_____\\_____|_____/^^\\_____]     *- * -\n" +
                        "      \\__/                 \\__/";
            }
            rooms[1]= garage;

            Position PosOfKitchen = new Position(8, 5);
            Room kitchen = new Room("Kitchen", "Gawd Damn the Joker has some expensive taste in counter tops," +
                    "the kitchen has a fancy wood decor and loads of appliances", 'K', PosOfKitchen);
            diagram.placeRoom(PosOfKitchen, kitchen.getSymbol());
            rooms[2]= kitchen;

            Position PosOfDrinksBar = new Position(9, 7);
            Room drinksBar = new Room("Drinks Bar", " Looks like the Joker is quite the alcohol enjoyer he has a drinks bar in his basement " +
                    " there seems to be Henessy and grey goose bottles in the windows just like those in the student flats", 'D', PosOfDrinksBar);
            diagram.placeRoom(PosOfDrinksBar, drinksBar.getSymbol());
            rooms[3]= drinksBar;

            Position PosOfConservatory = new Position(5, 3);
            Room conservatory = new Room("Conservatory", "This is a room meant to be enjoyed with the sun by the looks of it, its covered in glass shame that his lair is underground",
                    'C', PosOfConservatory);
            diagram.placeRoom(PosOfConservatory, conservatory.getSymbol());
            rooms[4]= conservatory;

            Position PosOfPantry = new Position(6, 4);
            Room pantry = new Room("Pantry", "This is the pantry, the Joker seems to have a lot of china plates around here ", 'P', PosOfPantry);
            diagram.placeRoom(PosOfPantry, pantry.getSymbol());
            rooms[5]= pantry;


            Position PosOfToilet = new Position(7, 2);
            Room toilet = new Room("Toilet", "Welcome to the Joker's toilet, Its a very bright room with a big shower and blue lights everywhere ",
                    'T', PosOfToilet);
            diagram.placeRoom(PosOfToilet, toilet.getSymbol());
            rooms[6] = toilet;

            Position PosOfBedroom = new Position(6, 9);
            Room bedroom = new Room("Bedroom", "Welcome the Joker's bedroom. And yes it is as miserable as you may think its all grey with smiles on the walls",
                    'B', PosOfBedroom);
            diagram.placeRoom(PosOfBedroom, bedroom.getSymbol());
            rooms[7] = bedroom;

            Position PosOfGarden = new Position(7, 8);
            Room Garden = new Room("Garden", "Take a deep breath you are out of the Joker's cave from here you can see his garden furniture", 'O', PosOfGarden);
            diagram.placeRoom(PosOfGarden, Garden.getSymbol());
            rooms[8] = Garden;

            Position PosOfTerrace = new Position(9, 6);
            Room Terrace = new Room("Terrace", " You have managed to make it to the terrace of the house in the cave here you can see faint lights in the distance and a fancy helicopter", 'T', PosOfTerrace);
            diagram.placeRoom(PosOfTerrace, Terrace.getSymbol());
            rooms[9] = Terrace;
        }

    }
//    public static void createItems()
//    {
//        String Hammer = "Hammer";
//        inventory.addItem(Hammer);
//
//        String DeckOfCards = "Deck of Cards";
//        inventory.addItem(DeckOfCards);
//
//        String Plunger = "Plunger";
//        inventory.addItem(Plunger);
//
//        String Knife = "Knife";
//        inventory.addItem(Knife);
//
//        String Football = "Football";
//        inventory.addItem(Football);
//
//        String BatShurkiken = "Bat Shurkiken";
//        inventory.addItem(BatShurkiken);
//
//
//
//    }

    public static void UpdateMapWithUserPosition(Position pos) {
        diagram.placeRoom(pos,'X');
        System.out.println(diagram.display());


    }

    public static void clearScreen()
    {
        for(int i = 0; i< 30 ; i++)
        {
            System.out.println(" ");
        }
    }

    public static void enterRoom(int x, int y)
    {
        currentlyInRoom = true;
        clearScreen();
        currentRoom = getRoom(x,y);
        System.out.println(currentRoom.artForTheRoom);
        System.out.println("You have entered the " + currentRoom.getName());
        System.out.println("please type look to have a look around the room");
        String userMove = reader.nextLine();
        if(userMove.equals("look"))
        {
            System.out.println(currentRoom.getDescription());
        }



    }

    public static Room getRoom(int x, int y)
    {
        Room roomToReturn = null;
        for(int i = 0 ; i<rooms.length ; i++)
        {
            if(rooms[i].getPosition().x == x && rooms[i].getPosition().y == y)
            {
                return rooms[i];
            }
        }
        return roomToReturn;
    }





    // gets the users direction (WASD)
    public static void getUserDirection(Position userPosition)
    {
        char direction ;
        boolean validUserInput = false;
        String directionAsAString = "";

        do {
            try {
                System.out.print("Enter the direction: ");
                 directionAsAString = reader.nextLine();
                 if(directionAsAString == null)
                 {
                     System.out.println("Please enter something");
                     continue;
                 }

                if (directionAsAString.length() > 1) {
                    System.out.println("Please enter a single character W/A/S/D :");
                }
                else
                {
                    validUserInput = true;
                }

            } catch (Exception e) {
                System.out.println("Please enter a valid direction :");
            }
        }while (validUserInput == false);

        direction = directionAsAString.charAt(0);
        direction = Character.toUpperCase(direction); // makes the user input non case sensitive

        boolean valid = false;
        boolean thereIsRoom = false;


            switch (direction) {

                case 'W':
                    valid = checkIfNewPositionInMap(userPosition.x, userPosition.y-1);
                    thereIsRoom =checkIfThereIsARoom(userPosition.x, userPosition.y-1);

                    if(valid && thereIsRoom == false) {
                        diagram.placeRoom(userPosition, '.'); //removes the users old position
                        userPosition.y = userPosition.y - 1; // you start from the bottom so you have to reduce the y value
                        UpdateMapWithUserPosition(userPosition);
                    }
                    else if(thereIsRoom) {
                        enterRoom(userPosition.x, userPosition.y-1);

                    }
                    else
                    {
                        System.out.println("You are out of bounds");
                        getUserDirection(userPosition);
                    }

                    break;

                case 'S':
                    valid = checkIfNewPositionInMap(userPosition.x, userPosition.y+1);
                    if(valid) {
                        diagram.placeRoom(userPosition, '.'); //removes the users old position
                        userPosition.y = userPosition.y + 1;
                        UpdateMapWithUserPosition(userPosition);
                    }
                    else
                    {
                        System.out.println("You are out of bounds");
                        getUserDirection(userPosition);
                    }

                    break;

                case 'A':
                    valid = checkIfNewPositionInMap(userPosition.x-1, userPosition.y);
                    if(valid) {
                        diagram.placeRoom(userPosition, '.'); //removes the users old position
                        userPosition.x = userPosition.x - 1;
                        UpdateMapWithUserPosition(userPosition);
                    }
                    else
                    {
                        System.out.println("You are out of bounds");
                        getUserDirection(userPosition);
                    }

                    break;
                case 'D':
                    valid = checkIfNewPositionInMap(userPosition.x+1, userPosition.y);
                    if(valid) {
                        diagram.placeRoom(userPosition, '.'); //removes the users old position
                        userPosition.x = userPosition.x + 1;
                        UpdateMapWithUserPosition(userPosition);
                    }
                    else {
                        System.out.println("You are out of bounds");
                        getUserDirection(userPosition);
                    }

                    break;
            }


        }

    public static boolean checkIfNewPositionInMap(int x, int y)
    {
            boolean validUserInput = false;

            if((x >= 0) && (y >= 0) && (x < diagram.GetWidth()) && (y < diagram.GetHeight())) // there is a "quicker" way of returning this ,but I am doing this for better readability of code
            {
                validUserInput = true;
            }
            else {
                validUserInput = false;
            }


            return validUserInput;
        }

    public static boolean checkIfThereIsARoom(int x, int y)
    {

        for(int i = 0 ; i<rooms.length ; i++)
        {
            if(rooms[i].getPosition().x == x && rooms[i].getPosition().y == y)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //creates the rooms and adds them to the array so all the Game class can see it
        createRooms();


        Score score = new Score(0);
        Position userPosition = new Position(0,9);
        diagram.placeRoom(userPosition,'X');
        System.out.println(diagram.display());
        while(currentlyInRoom == false) {
            getUserDirection(userPosition);
        }





















    }
    
}