package org.uob.a1;

import java.util.Scanner;

public class Game{
    public static Room[] rooms = new Room[10];
    public static Map diagram = new Map(10,10);
    public static Room currentRoom;
    public static Position UserPosition = new Position(8,1);
    public static Inventory inventory = new Inventory();
    public static Scanner scanner = new Scanner(System.in);
    public static Score score = new Score(0);
    public static boolean currentlyInRoom ;


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

    public static void helpScreen()
    {
        System.out.println("\"move <direction>\" - (<direction> can be \"north\", \"south\", \"east\", \"west\"). The\n" +
                "player moves to a new room based on the direction.\n" +
                "• \"look\" - Displays a description of the room the player is in.\n" +
                "• \"look <feature>\" - Displays a more detailed description of a feature of a room.\n" +
                "• \"look <item>\" - Displays a description of an item.\n" +
                "• \"inventory\" - Displays a list of all items the player has obtained.\n" +
                "• \"score\" - Displays the user’s current score.\n" +
                "• \"map\" - Displays a text-based map of the current explored game world.\n" +
                "• \"help\" - Displays a help message.\n" +
                "• \"quit\" - Quits the game. \n " +
                "• \"clear\" - clears the terminal.\n"


        );

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

    public static void UpdateMapWithUserPosition(Position pos) {
        diagram.placeRoom(pos,'X');
    }


    // responsible for the user's movement between rooms and the map
    public static void getUserDirection(Position userPosition , String userMove)
    {

        boolean valid ;
        boolean thereIsRoom;

        switch (userMove) {

            case  "move north":
                valid = checkIfNewPositionInMap(userPosition.x, userPosition.y-1);
                thereIsRoom =checkIfThereIsARoom(userPosition.x, userPosition.y-1);

                if(!valid)
                {
                    System.out.println("That location is not on the map please select a different move");
                    checkUserMove();
                }

                if(valid && thereIsRoom == false) {
                    if(currentlyInRoom == false)// this makes it so that you dont overwrite the rooms once you leave them
                    {
                        diagram.placeRoom(userPosition, '.'); //removes the users old position
                    }
                    userPosition.y = userPosition.y - 1; // you start from the bottom so you have to reduce the y value
                    UpdateMapWithUserPosition(userPosition);
                    currentlyInRoom= false;
                    System.out.println("Your new location doesn't have a room you are somewhere in the jokers hallway enter 'map' to view the map");
                }

                if(valid && thereIsRoom)
                {
                    diagram.placeRoom(userPosition, '.');
                    userPosition.y = userPosition.y - 1;
                    currentRoom = getRoom(userPosition.x, userPosition.y);
                    System.out.println("You are now entering the " + currentRoom.getName());
                    currentlyInRoom = true;
                    CheckIfRoomHasPuzzle(currentRoom);


                }
                break;

            case "move south":
                valid = checkIfNewPositionInMap(userPosition.x, userPosition.y+1);
                thereIsRoom =checkIfThereIsARoom(userPosition.x, userPosition.y+1);
                if(!valid)
                {
                    System.out.println("That location is not on the map please select a different move");
                    checkUserMove();
                }

                if(valid && thereIsRoom == false) {
                    if(currentlyInRoom == false)// this makes it so that you dont overwrite the rooms once you leave them
                    {
                        diagram.placeRoom(userPosition, '.'); //removes the users old position
                    }

                    userPosition.y = userPosition.y + 1; // you start from the bottom so you have to reduce the y value
                    UpdateMapWithUserPosition(userPosition);
                    currentlyInRoom= false;
                    System.out.println("Your new location doesn't have a room you are somewhere in the jokers hallway enter 'map' to view the map");
                }
                if(valid && thereIsRoom)
                {
                    diagram.placeRoom(userPosition, '.');
                    userPosition.y = userPosition.y + 1;
                    currentRoom = getRoom(userPosition.x, userPosition.y);
                    currentlyInRoom = true;
                    System.out.println("You are now entering the " + currentRoom.getName());
                    CheckIfRoomHasPuzzle(currentRoom);

                }

                break;

            case "move west":
                valid = checkIfNewPositionInMap(userPosition.x-1, userPosition.y);
                thereIsRoom = checkIfThereIsARoom(userPosition.x-1, userPosition.y );
                if(!valid)
                {
                    System.out.println("That location is not on the map please select a different move");
                    checkUserMove();
                }
                if(valid && thereIsRoom == false) {
                    if(currentlyInRoom == false)// this makes it so that you dont overwrite the rooms once you leave them
                    {
                        diagram.placeRoom(userPosition, '.'); //removes the users old position
                    }

                    userPosition.x = userPosition.x - 1; // you start from the bottom so you have to reduce the y value
                    UpdateMapWithUserPosition(userPosition);
                    currentlyInRoom= false;
                    System.out.println("Your new location doesn't have a room you are somewhere in the jokers hallway enter 'map' to view the map");
                }
                if(valid && thereIsRoom)
                {
                    diagram.placeRoom(userPosition, '.');
                    userPosition.x = userPosition.x - 1;
                    currentRoom = getRoom(userPosition.x, userPosition.y);
                    currentlyInRoom = true;
                    System.out.println("You are now entering the " + currentRoom.getName());
                    CheckIfRoomHasPuzzle(currentRoom);

                }

                break;
            case "move east":
                valid = checkIfNewPositionInMap(userPosition.x+1, userPosition.y);
                thereIsRoom = checkIfThereIsARoom(userPosition.x+1, userPosition.y );

                if(!valid)
                {
                    System.out.println("That location is not on the map please select a different move");
                    checkUserMove();
                }
                if(valid && thereIsRoom == false) {
                    if (currentlyInRoom == false) {
                        diagram.placeRoom(userPosition, '.'); //removes the users old position
                    }
                    userPosition.x = userPosition.x + 1; // you start from the bottom so you have to reduce the y value
                    UpdateMapWithUserPosition(userPosition);
                    currentlyInRoom= false;
                    System.out.println("Your new location doesn't have a room you are somewhere in the jokers hallway enter 'map' to view the map");
                }
                if(valid && thereIsRoom)
                {
                    diagram.placeRoom(userPosition, '.');
                    userPosition.x = userPosition.x + 1;
                    currentRoom = getRoom(userPosition.x, userPosition.y);
                    currentlyInRoom = true;
                    System.out.println("You are now entering the " + currentRoom.getName());
                    CheckIfRoomHasPuzzle(currentRoom);

                }
                break;
        }


    }

    // this is the method that deals with user inputs, so all the commands and their relating if statements are here
    public static void checkUserMove()
    {
        System.out.println("Please enter a command");
        System.out.print(">> ");
        String userMove = scanner.nextLine();
        userMove = userMove.toLowerCase();

        if(userMove.equals("move north") || userMove.equals("move south")||userMove.equals("move west") || userMove.equals("move east"))
        {
            getUserDirection(UserPosition,userMove);

        }
        else if(userMove.equals("help"))
        {
            helpScreen();
        }
        else if(userMove.equals("quit"))
        {
            System.exit(0);
        }
        else if(userMove.equals("look"))
        {
            System.out.println(currentRoom.getDescription());
        }
        else if(userMove.equals("inventory"))
        {
            System.out.println(inventory.displayInventory());
        }
        else if(userMove.equals("score"))
        {
            System.out.println(score.getScore());
        }
        else if(userMove.equals("map"))
        {
            if(currentlyInRoom) {
                System.out.println(diagram.display());
                System.out.println("You are currently in the " + currentRoom.getName() + " which is marked on the map as " + currentRoom.getSymbol());
            }
            else
            {
                System.out.println(diagram.display());
                System.out.println("Your current location is marked with an X");
            }
        }
        else if(userMove.equals("clear"))
        {
            clearScreen();
        }
        else
        {
            System.out.println("That move was not recognised please enter a valid command") ;
            checkUserMove();
        }

    }

    public static void CheckIfRoomHasPuzzle(Room newRoom)
    {
        String roomName = newRoom.getName();

        switch (roomName)
        {
            case "Toilet":
                enterToiletPuzzle();
                break;
            case "Bedroom":
                enterBedroom();
                break;
        }
    }

    public static void enterBedroom()
    {
        if(inventory.hasItem("code") != -1)
        {
            // asci art from https://emojicombos.com/check-mark-ascii-art
            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣷⣶⣴⣾⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⣀⣤⣤⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣤⣤⣄⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀\n" +
                    "⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀\n" +
                    "⢀⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀\n" +
                    "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠈⢻⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⢿⣿⣿⣿⣿⣿⣿⣿⡿⠻⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⢈⣿⣿⣿⣿⣿⣿⣯⡀⠀⠈⠻⣿⣿⣿⠟⠁⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⡁\n" +
                    "⣾⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠈⠛⠁⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷\n" +
                    "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                    "⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁\n" +
                    "⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀\n" +
                    "⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠉⠛⠛⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠛⠛⠉⠁⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⠿⢿⡻⠿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀");


            System.out.println("Access was granted, the code you picked up in the main lobby granted you the access ");

        }
        else
        {
            System.out.println("✖");
            System.out.println("Access Denied, you dont have the code");

            System.out.println(">> it may be worth it to go and pick up the code from the main lobby marked on the map as ");
        }
    }


    public static void clearScreen()
    {
        for(int i =0 ; i<30 ; i++)
        {
            System.out.println();
        }
    }



    //Puzzle 1 to enter the toilet you need to flip the light switch on
    public static void enterToiletPuzzle()
    {

        System.out.println("The lights in the toilet don't seem to be on you can't leave or move from this room because you can see anything");
        System.out.println(">> A ray of light shines to your left and it reveals 3 switches - maybe these turn the lights on ");

        boolean switchOneTurnedOn = false;
        boolean switchTwoTurnedOn = false;

        boolean lightTurnedOn = false;

        while(lightTurnedOn == false)
        {
            System.out.println("Please enter a switch number (1-3)");
            String switchNumber = scanner.nextLine();
            //switch 3 will turn the lights on
            switch(switchNumber)
            {
                case "1":
                    if(switchOneTurnedOn)
                    {
                        System.out.println("The switch is already turned on! ");

                    }
                    else {
                        System.out.println(">> You flipped switch 1 on");
                        System.out.println(">> Unfortunately the lights didn't come on, but the boiler did turn on,  try a different switch");
                        switchOneTurnedOn = true;
                    }
                    break;
                case  "2":
                    if(switchTwoTurnedOn){
                        System.out.println("The switch is already turned on! ");
                    }
                    else{
                        System.out.println(">> You flipped switch 2 on");
                        System.out.println(">> Unfortunately the lights didn't come on, but the speakers did turn on they are playing clown music,  try a different switch");
                        switchTwoTurnedOn = true;
                    }
                    break;
                case  "3":
                    System.out.println(">> You flipped switch 3 on");
                    lightTurnedOn = true;
                    System.out.println("  ..---..\n" +
                            " /       \\\n" +
                            "|         |\n" +
                            ":         ;\n" +
                            " \\  \\~/  /\n" +
                            "  `, Y ,'\n" +
                            "   |_|_|\n" +
                            "   |===|\n" +
                            "   |===|\n" +
                            "    \\_/");

                    System.out.println(">> The lights turned on Congratulations!");
                    break;
                default:
                    System.out.println("That switch number does not exist");
                    break;


            }
        }



    }



    public static void main(String[] args)
    {


        String welcome = "Welcome player, in this game you are a detective which has been tasked with finding batman as he has gone missing";
        int timeToWait = 5;
        for(int i = 0; i< welcome.length();i++)
        {
            System.out.print(welcome.charAt(i));
            try {
                Thread.sleep(timeToWait);
            }
            catch(Exception ex)
            {
                System.out.println("Slow fade in failed");
            }
        }
        createRooms();
        System.out.println();
        currentRoom= getRoom(UserPosition.x, UserPosition.y);// the user starts off in the main lobby
        currentlyInRoom = true;
        System.out.println("You are currently in " + currentRoom.getName() + " There seems to be a note on the door please enter 'look note' if you would like to have a look at the note");

        System.out.println();

        System.out.println("Please enter your command or enter help to learn more about commands in the game");

        while(true) {
            checkUserMove();
        }













    }

}