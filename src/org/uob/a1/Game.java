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

    // this function creates the rooms and adds the 'look' features for each room
    public static void createRooms()
    {
        {
            //first I will create all the rooms
            Position PosOfMainLobby = new Position(8, 1);
            Room mainLobby = new Room("Main Lobby", "Hmm this room seems to have loads of sofas does the Joker actually have this many friends to be using all these sofas",
                    'M', PosOfMainLobby);
            mainLobby.roomFeature = "The note reads - 'Oh Robin! I knew you would come you are so predictable go free him if you can!'";
            mainLobby.roomFeatureName = "look note";
            diagram.placeRoom(PosOfMainLobby, mainLobby.getSymbol());
            rooms[0]= mainLobby;

            Position PosOfGarage = new Position(3, 4);
            Room garage = new Room("Garage", "Wow the Joker has a garage with a very nice collection, wait is that the batmobile" +
                    " Batman has to be somewhere around here, enter 'look batmobile' to have a closer look at the batmobile", 'G', PosOfGarage);
            garage.roomFeature = "The light reflects off the pearly black paint of the car, but something white shines inside the car - a vintage Joker Card";
            garage.roomFeatureName = "look batmobile";
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
                    "the kitchen has a fancy wood decor and loads of appliances, enter 'look counter' ", 'K', PosOfKitchen);
            kitchen.roomFeature = "The counters have shreds of cheese all over them, the Joker must know Batman is allergic to cheese, he must be trying to hurt him";
            diagram.placeRoom(PosOfKitchen, kitchen.getSymbol());
            kitchen.roomFeatureName = "look counter";
            rooms[2]= kitchen;

            Position PosOfDrinksBar = new Position(9, 7);
            Room drinksBar = new Room("Drinks Bar", " Looks like the Joker is quite the alcohol enjoyer he has a drinks bar in his basement " +
                    " there seems to be Henessy and grey goose bottles in the windows just like those in the student flats enter 'look window' to have a look through the window", 'D', PosOfDrinksBar);
            drinksBar.roomFeature= "The window's glass is kept clean and is very see through, from the corner of your eye you see a light shining from the bedroom it might be worth investigating the bedroom";
            diagram.placeRoom(PosOfDrinksBar, drinksBar.getSymbol());
            drinksBar.roomFeatureName = "look window";
            rooms[3]= drinksBar;

            Position PosOfConservatory = new Position(5, 3);
            Room conservatory = new Room("Conservatory", "This is a room meant to be enjoyed with the sun by the looks of it, its covered in glass shame that his lair is underground enter 'look garden' to have a look at the garden through the window",
                    'C', PosOfConservatory);

            drinksBar.roomFeature = "looking through the window into the garden you see lots of trees, but how is that possible underground with minimal sunlight maybe the windows in this place are not actually real windows";
            drinksBar.roomFeatureName = "look garden";
                diagram.placeRoom(PosOfConservatory, conservatory.getSymbol());
            rooms[4]= conservatory;

            Position PosOfPantry = new Position(6, 4);
            Room pantry = new Room("Pantry", "This is the pantry, the Joker seems to have a lot of china plates around here ", 'P', PosOfPantry);
            pantry.roomFeatureName = "look plates";
            pantry.roomFeature = "looking at the plates you see a note it says- I knew you would come looking for your boss come to the bedroom if you dare ";
            diagram.placeRoom(PosOfPantry, pantry.getSymbol());
            rooms[5]= pantry;


            Position PosOfToilet = new Position(7, 2);
            Room toilet = new Room("Toilet", "Welcome to the Joker's toilet, Its a very bright room with a big shower and blue lights everywhere ",
                    'T', PosOfToilet);
            toilet.roomFeatureName = "look wall";
            toilet.roomFeature = "The wall looks suspicious its almost like its not a real wall maybe the joker has a secret room behind here, curiously you tried" +
                    " to run through it... OUCH! no it was a real wall and now you hurt yourself ";
            diagram.placeRoom(PosOfToilet, toilet.getSymbol());
            rooms[6] = toilet;

            Position PosOfBedroom = new Position(6, 9);
            Room bedroom = new Room("Bedroom", "Welcome the Joker's bedroom. And yes it is as miserable as you may think its all grey with smiles on the walls",
                    'B', PosOfBedroom);
            bedroom.roomFeatureName = "look under-Bed";
            bedroom.roomFeature = "You crouched and looked under the bed and you saw Batman! he is tied and is trying to escape,... you untied him and set him free";
            diagram.placeRoom(PosOfBedroom, bedroom.getSymbol());
            rooms[7] = bedroom;

            Position PosOfGarden = new Position(7, 8);
            Room Garden = new Room("Garden", "Take a deep breath you are out of the Joker's cave from here you can see his garden furniture", 'O', PosOfGarden);
            Garden.roomFeatureName = "look over-fence";
            Garden.roomFeature = "You hopped up and got a slight glimpse of whats around the compound - lots of water, lets hope the joker doesn't throw you into it ";
            diagram.placeRoom(PosOfGarden, Garden.getSymbol());
            rooms[8] = Garden;

            Position PosOfTerrace = new Position(9, 6);
            Room Terrace = new Room("Terrace", " You have managed to make it to the terrace of the house in the cave here you can see faint lights in the distance and a fancy helicopter", 'T', PosOfTerrace);
            Terrace.roomFeatureName = "look helicopter";
            Terrace.roomFeature = "You look at the helicopter in the distance and see a bat logo, looks like Batman's butler is also searching for him";
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
    // additional subroutine that deals with the look user inputs so that the other procedure doesn't become blocked up
    // Here I also make sure that the player is in the given room before letting them look at a specific place
    public static void dealWithLook(String userWord)
    {
        if(userWord.equals("look"))
        {
            System.out.println(currentRoom.getDescription());
        }
        else if(userWord.equals("look note"))
        {
            if(currentRoom.getName().equals("Main Lobby"))
            {
                System.out.println(currentRoom.roomFeature);
                System.out.println("Stuck to the note there is a code which says code for the bedroom would you like to pick up the code?");
                System.out.println("enter 'take code' to pick up the code.");
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }


        }
        else if(userWord.equals("look batmobile"))
        {
            if(currentRoom.getName().equals("Garage"))
            {
                System.out.println(currentRoom.roomFeature);
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }
        }
        else if(userWord.equals("look counter "))
        {
            if(currentRoom.getName().equals("Kitchen"))
            {
                System.out.println(currentRoom.roomFeature);
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }
        }
        else if(userWord.equals("look window"))
        {
            if(currentRoom.getName().equals("Drinks Bar"))
            {
                System.out.println(currentRoom.roomFeature);
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }
        }
        else if(userWord.equals("look garden"))
        {
            if(currentRoom.getName().equals("Conservatory"))
            {
                System.out.println(currentRoom.roomFeature);
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }
        }
        else if(userWord.equals("look plates"))
        {
            if(currentRoom.getName().equals("Pantry"))
            {
                System.out.println(currentRoom.roomFeature);
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }
        }
        else if(userWord.equals("look wall"))
        {
            if(currentRoom.getName().equals("Toilet"))
            {
                System.out.println(currentRoom.roomFeature);
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }
        }
        else if(userWord.equals("look under-bed"))
        {
            if(currentRoom.getName().equals("Bedroom"))
            {
                System.out.println(currentRoom.roomFeature);
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }
        }
        else if(userWord.equals("look over-fence"))
        {
            if(currentRoom.getName().equals("Garden"))
            {
                System.out.println(currentRoom.roomFeature);
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }
        }
        else if(userWord.equals("look helicopter"))
        {
            if(currentRoom.getName().equals("Terrace"))
            {
                System.out.println(currentRoom.roomFeature);
            }
            else
            {
                System.out.println("That feature doesnt exist in this room!");
            }
        }
        else if(userWord.equals("look code"))
        {
            if(inventory.hasItem("code") != 1)
            {
                System.out.println("This the code you picked up from the Main Lobby it grants you access to the Joker's bedroom");
            }
        }
        else if(userWord.equals("look cards"))
        {
            if(inventory.hasItem("Deck Of Cards")!= -1)
            {
                System.out.println("The cards which you are holding a very slim and sharp around the edges these could do serious damage if thrown");
            }
            else
            {
                System.out.println("You don't have this item");
            }
        }

    }

    public static int generateNumber()
    {
        int givenNumber = 0;
        givenNumber = 1 + (int)(Math.random() * 11);
        return givenNumber;

    }

    public static void play21()
    {
        boolean userWins = false;

        int card1forComputer = generateNumber();
        int card2forComputer = generateNumber();
        int cardScoreForComputer = card1forComputer + card2forComputer;
        boolean computerBust = false;



        int card1forUser = generateNumber();
        int card2forUser = generateNumber();
        int cardScoreForUser = card1forUser + card2forUser;
        boolean userBust = false;

        System.out.println("You currently have a " + card1forUser + " card and a " + card2forUser + " card in your hand totalling to " + cardScoreForUser);

        while(true)
        {
            System.out.println("Would you like to hit or hold ? hit gives you another card and holding means you dont get another card");
            String choice = scanner.nextLine();
            if(choice.equals("hit"))
            {
                int newCard = generateNumber();
                System.out.println("The dealer handed you a " + newCard);
                cardScoreForUser += newCard;
                if(cardScoreForUser >21)
                {
                    System.out.println("You have gone bust your new card takes you over 21, and the dealer wins");
                    userBust = true;
                    break;
                }
            } else if (choice.equals("hold")) {
                break;
            }
            else
            {
                System.out.println("That is not a valid choice. Try again.");
            }

        }
        if(userBust == false) {
            System.out.println("The dealer reveals his hand");
            System.out.println("The dealer currently has a " + card1forComputer + " card and a " + card2forComputer + " card, totalling to " + cardScoreForComputer);
            while (cardScoreForComputer < 17) {
                if (cardScoreForComputer < 17) {
                    int newCard = generateNumber();
                    System.out.println("The dealer drew a " + newCard);
                    cardScoreForComputer += newCard;
                }
                if (cardScoreForComputer > 21) {
                    System.out.println("The dealer has gone bust you win");
                    score.solvePuzzle();
                    userWins = true;
                    computerBust = true;
                    break;

                }
            }
        }
        if(userBust == false && computerBust == false)
        {
            System.out.println("Your total score is " + cardScoreForUser + " The dealers score is " + cardScoreForComputer );
            if(cardScoreForUser > cardScoreForComputer)
            {
                System.out.println("You win");
                score.solvePuzzle();
                userWins = true;
            }
            else if(cardScoreForUser < cardScoreForComputer)
            {
                System.out.println("You lose");
            }
            else if (cardScoreForUser == cardScoreForComputer)
            {
                System.out.println("Your scores are equal its a draw!");
            }
        }

        if(userWins)
        {
            inventory.addItem("Deck Of Cards");
            System.out.println("Congratulations for winning, the moving statue gave you a deck of cards, if you would like more information about the cards please enter 'look cards'");
            System.out.println("--->>>> A deck of cards has been added to your inventory");
        }








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
                    System.out.println("You moved north you are somewhere in the jokers hallway enter 'map' to view the map");
                }

                if(valid && thereIsRoom)
                {


                    diagram.placeRoom(userPosition, '.');
                    userPosition.y = userPosition.y - 1;
                    currentRoom = getRoom(userPosition.x, userPosition.y);
                    if(score.roomVisited(currentRoom.getName()) == false)
                    {
                        score.AddRoom(currentRoom);
                    }
                    System.out.println("You are now entering the " + currentRoom.getName());
                    System.out.println("Enter '" +  currentRoom.roomFeatureName + "' for a more detailed description of this rooms feature");
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
                    System.out.println("You moved south you are somewhere in the jokers hallway enter 'map' to view the map");
                }
                if(valid && thereIsRoom)
                {
                    diagram.placeRoom(userPosition, '.');
                    userPosition.y = userPosition.y + 1;
                    currentRoom = getRoom(userPosition.x, userPosition.y);
                    if(score.roomVisited(currentRoom.getName()) == false)
                    {
                        score.AddRoom(currentRoom);
                    }
                    currentlyInRoom = true;
                    System.out.println("You are now entering the " + currentRoom.getName());
                    CheckIfRoomHasPuzzle(currentRoom);
                    System.out.println("Enter '" +  currentRoom.roomFeatureName + "' for a more detailed description of this rooms feature");


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
                    System.out.println("You moved west you are somewhere in the jokers hallway enter 'map' to view the map");
                }
                if(valid && thereIsRoom)
                {
                    diagram.placeRoom(userPosition, '.');
                    userPosition.x = userPosition.x - 1;
                    currentRoom = getRoom(userPosition.x, userPosition.y);
                    currentlyInRoom = true;
                    if(score.roomVisited(currentRoom.getName()) == false)
                    {
                        score.AddRoom(currentRoom);
                    }
                    System.out.println("You are now entering the " + currentRoom.getName());

                    CheckIfRoomHasPuzzle(currentRoom);
                    System.out.println("Enter '" +  currentRoom.roomFeatureName + "' for a more detailed description of this rooms feature");


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
                    System.out.println("You moved east you are somewhere in the jokers hallway enter 'map' to view the map");
                }
                if(valid && thereIsRoom)
                {
                    diagram.placeRoom(userPosition, '.');
                    userPosition.x = userPosition.x + 1;
                    currentRoom = getRoom(userPosition.x, userPosition.y);
                    if(score.roomVisited(currentRoom.getName()) == false)
                    {
                        score.AddRoom(currentRoom);
                    }
                    currentlyInRoom = true;
                    System.out.println("You are now entering the " + currentRoom.getName());
                    System.out.println("Enter '" +  currentRoom.roomFeatureName + "' for a more detailed description of this rooms feature");

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

        if(userMove.contains("look"))
        {
            dealWithLook(userMove);
        }
        else {


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
        else if(userMove.equals("play 21") && currentRoom.getName().equals("Drinks Bar"))
        {
            play21();

        }
        else if(userMove.equals("take code")&& currentRoom.getName().equals("Main Lobby"))
        {
            inventory.addItem("code");
            System.out.println("--> the code has been added to your inventory");
        }
        else if(userMove.equals("take plunger") && currentRoom.getName().equals("Toilet"))
        {
            inventory.addItem("plunger");
            System.out.println("--> the plunger has been added to your inventory");


        }
        else
        {
            System.out.println("That move was not recognised please enter a valid command") ;
            checkUserMove();
        }
        }

    }

    public static void enterTerrace()
    {
        System.out.println("Looks like the stairs to get to the terrace are blocked");
        System.out.println("It would sure help having a plunger to wall climb");
        if(inventory.hasItem("plunger")!= -1)
        {
            System.out.println("Wait... you do have a plunger");
            System.out.println("You used the plunger to grapple on the wall and get access to the roof");
        }
        else
        {
            System.out.println("It might be worth it to go pick up the plunger from the toilet");
        }

    }


    // checks if there is a puzzle for entering the given room
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
            case "Drinks Bar" :
                System.out.println("There seems to be a moving statue which wants to play blackjack with you, if you want to play enter 'play 21'");
                break;
            case "Terrace" :
                enterTerrace();
                break;
        }
    }

    // add a previous location so that when they are not allowed in they get sent back or in the other constructor
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
            score.solvePuzzle();

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
                    score.solvePuzzle();
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

        System.out.println("Wow there is a shiny new plunger in the corner its suction would help in certain scenarios would you like to take it?");
        System.out.println("Enter 'take plunger' to pick up the plunger");


    }


    public static void main(String[] args)
    {
        System.out.println("Welcome player, in this game you are a detective which has been tasked with finding batman as he has gone missing, probe the compound and find Batman");
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