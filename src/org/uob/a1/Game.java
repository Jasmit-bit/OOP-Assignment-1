package org.uob.a1;

import java.util.Scanner;

public class Game{
    public static Room[] rooms = new Room[10];
    public static Map diagram = new Map(6,6);
    public static Room currentRoom;
    public static Position UserPosition = new Position(4,2);// starts in the main lobby
    public static Inventory inventory = new Inventory();
    public static Scanner scanner = new Scanner(System.in);
    public static Score score = new Score(0);
    public static boolean currentlyInRoom ;
    public static boolean canPickUpShield = false;
    public static boolean refusedEntry = false;



    // this function gets the room given a set of coordinates its helpful for when the user move around the map and the map needs to be updated
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
            Position PosOfMainLobby = new Position(4, 2);
            Room mainLobby = new Room("Main Lobby", "Hmm this room seems to have loads of sofas does the Joker actually have this many friends to be using all these sofas",
                    'M', PosOfMainLobby);
            mainLobby.roomFeature = "The note reads - 'Oh Robin! I knew you would come you are so predictable go free him if you can!'";
            mainLobby.roomFeatureName = "look note";
            diagram.placeRoom(PosOfMainLobby, mainLobby.getSymbol());
            rooms[0]= mainLobby;

            Position PosOfGarage = new Position(1, 3);
            Room garage = new Room("Garage", "Wow the Joker has a garage with a very nice collection, wait is that the batmobile" +
                    " Batman has to be somewhere around here, enter 'look batmobile' to have a closer look at the batmobile", 'G', PosOfGarage);
            garage.roomFeature = "The light reflects off the pearly black paint of the car, but something white shines inside the car - a vintage Joker Card";
            garage.roomFeatureName = "look batmobile";
            diagram.placeRoom(PosOfGarage, garage.getSymbol());


            rooms[1]= garage;

            Position PosOfKitchen = new Position(5, 2);
            Room kitchen = new Room("Kitchen", "Gawd Damn the Joker has some expensive taste in counter tops," +
                    "the kitchen has a fancy wood decor and loads of appliances, enter 'look counter' ", 'K', PosOfKitchen);
            kitchen.roomFeature = "The counters have shreds of cheese all over them, the Joker must know Batman is allergic to cheese, he must be trying to hurt him";
            diagram.placeRoom(PosOfKitchen, kitchen.getSymbol());
            kitchen.roomFeatureName = "look counter";
            rooms[2]= kitchen;

            Position PosOfDrinksBar = new Position(2, 1);
            Room drinksBar = new Room("Drinks Bar", " Looks like the Joker is quite the alcohol enjoyer he has a drinks bar in his basement " +
                    " there seems to be Henessy and grey goose bottles in the windows just like those in the student flats enter 'look window' to have a look through the window", 'D', PosOfDrinksBar);
            drinksBar.roomFeature= "The window's glass is kept clean and is very see through, from the corner of your eye you see a light shining from the bedroom it might be worth investigating the bedroom";
            diagram.placeRoom(PosOfDrinksBar, drinksBar.getSymbol());
            drinksBar.roomFeatureName = "look window";
            rooms[3]= drinksBar;

            Position PosOfConservatory = new Position(5, 4);
            Room conservatory = new Room("Conservatory", "This is a room meant to be enjoyed with the sun by the looks of it, its covered in glass shame that his lair is underground enter 'look garden' to have a look at the garden through the window",
                    'C', PosOfConservatory);

            drinksBar.roomFeature = "looking through the window into the garden you see lots of trees, but how is that possible underground with minimal sunlight maybe the windows in this place are not actually real windows";
            drinksBar.roomFeatureName = "look garden";
                diagram.placeRoom(PosOfConservatory, conservatory.getSymbol());
            rooms[4]= conservatory;

            Position PosOfPantry = new Position(0, 0);
            Room pantry = new Room("Pantry", "This is the pantry, the Joker seems to have a lot of china plates around here ", 'P', PosOfPantry);
            pantry.roomFeatureName = "look plates";
            pantry.roomFeature = "looking at the plates you see a note it says- I knew you would come looking for your boss come to the bedroom if you dare ";
            diagram.placeRoom(PosOfPantry, pantry.getSymbol());
            rooms[5]= pantry;


            Position PosOfToilet = new Position(4, 0);
            Room toilet = new Room("Toilet", "Welcome to the Joker's toilet, Its a very bright room with a big shower and blue lights everywhere ",
                    'T', PosOfToilet);
            toilet.roomFeatureName = "look wall";
            toilet.roomFeature = "The wall looks suspicious its almost like its not a real wall maybe the joker has a secret room behind here, curiously you tried" +
                    " to run through it... OUCH! no it was a real wall and now you hurt yourself ";
            diagram.placeRoom(PosOfToilet, toilet.getSymbol());
            rooms[6] = toilet;

            Position PosOfBedroom = new Position(0, 5);
            Room bedroom = new Room("Bedroom", "Welcome the Joker's bedroom. And yes it is as miserable as you may think its all grey with smiles on the walls",
                    'B', PosOfBedroom);
            bedroom.roomFeatureName = "look bed";
            bedroom.roomFeature = "Honing your focus on the bed your eyes are cursed by a wave of purple fabric, the Joker really does like to colour green";
            diagram.placeRoom(PosOfBedroom, bedroom.getSymbol());
            rooms[7] = bedroom;

            Position PosOfGarden = new Position(3, 3);
            Room Garden = new Room("Garden", "Take a deep breath you are out of the Joker's cave from here you can see his garden furniture", 'O', PosOfGarden);
            Garden.roomFeatureName = "look over-fence";
            Garden.roomFeature = "You hopped up and got a slight glimpse of whats around the compound - lots of water, lets hope the joker doesn't throw you into it ";
            diagram.placeRoom(PosOfGarden, Garden.getSymbol());
            rooms[8] = Garden;

            Position PosOfTerrace = new Position(2, 4);
            Room Terrace = new Room("Terrace", " You have managed to make it to the terrace of the house in the cave here you can see faint lights in the distance and a fancy helicopter", 'U', PosOfTerrace);
            Terrace.roomFeatureName = "look helicopter";
            Terrace.roomFeature = "You look at the helicopter in the distance and see a bat logo, looks like Batman's butler is also searching for him";
            diagram.placeRoom(PosOfTerrace, Terrace.getSymbol());
            rooms[9] = Terrace;
        }

    }

    // this function prints all the 'standard' commands letting the user know what happens
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
    // checks if we go outside the array for the map or not
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
    // checks if there is a new room in the coordinate we are going to move to
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

    //updates the users position
    public static void UpdateMapWithUserPosition(Position pos) {
        diagram.placeRoom(pos,'X');
    }
    // additional subroutine that deals with the look user inputs so that the other procedure doesn't become blocked up
    // Here I also make sure that the player is in the given room before letting them look at a specific place

    // user input for look statements
    public static void dealWithLook(String userWord)
    {
        if(userWord.equals("look"))
        {
            if(currentlyInRoom){
            System.out.println(currentRoom.getDescription());}
            else
            {
                System.out.println("");
            }
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
        else if(userWord.equals("look bed"))
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
        else if(userWord.equals("look plunger"))
        {
            if(inventory.hasItem("plunger") != -1)
            {
                System.out.println("This is a plunger you picked up from the toilet earlier, its suction would definitely help in some scenarios");
            }
            else
            {
                System.out.println("You dont have this item");
            }
        }
        else if(userWord.equals("look shield"))
        {
            System.out.println("This is a shiny new shield, it sure would help if someone attacked you");
        }
        else
        {
            System.out.println("Unrecognized look statement");
        }

    }

    // generates a card number in order to play the blackjack game
    public static int generateNumber()
    {
        int givenNumber = 0;
        givenNumber = 1 + (int)(Math.random() * 11);
        return givenNumber;

    }

    // plays blackjack in order to get the cards
    public static void play21()
    {
        boolean userWins = false;
        boolean repeat = false;
        do {

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
            repeat = false;
            inventory.addItem("cards");
            System.out.println("Congratulations for winning, the moving statue gave you a deck of cards, if you would like more information about the cards please enter 'look cards'");
            System.out.println("--->>>> A deck of cards has been added to your inventory");
        }
        else
        {
            System.out.println("You lost this time but would you like to replay? enter 'replay' to play again");
            String userChoice = scanner.nextLine();
            userChoice = userChoice.toLowerCase();
            if(userChoice.equals("replay"))
            {
                repeat = true;
            }
            else
            {
                repeat = false;
            }
        }
        }while(repeat == true);









    }

    // responsible for the user's movement between rooms and the map
    public static void getUserDirection(Position userPosition , String userMove)
    {

        boolean valid ;
        boolean thereIsRoom;
        Position previousPosition = new Position(UserPosition.x, userPosition.y); // this is used to pass to the method which checks if there is an puzzle before entering the room and if there is it sends the user back to the previous location
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
                    CheckIfRoomHasPuzzle(currentRoom,previousPosition);

                    if(refusedEntry == false) {
                        if (score.roomVisited(currentRoom.getName()) == false) {
                            score.AddRoom(currentRoom);
                        }
                        System.out.println("You are now entering the " + currentRoom.getName());
                        System.out.println("Enter '" + currentRoom.roomFeatureName + "' for a more detailed description of this rooms feature");
                        currentlyInRoom = true;
                    }


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
                    CheckIfRoomHasPuzzle(currentRoom,previousPosition);

                    if(refusedEntry == false) {
                    if(score.roomVisited(currentRoom.getName()) == false)
                    {
                        score.AddRoom(currentRoom);
                    }
                    currentlyInRoom = true;
                    System.out.println("You are now entering the " + currentRoom.getName());

                    System.out.println("Enter '" +  currentRoom.roomFeatureName + "' for a more detailed description of this rooms feature");
}

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
                    CheckIfRoomHasPuzzle(currentRoom,previousPosition);

                    if(refusedEntry == false) {
                        currentlyInRoom = true;
                        if (score.roomVisited(currentRoom.getName()) == false) {
                            score.AddRoom(currentRoom);
                        }
                        System.out.println("You are now entering the " + currentRoom.getName());


                        System.out.println("Enter '" + currentRoom.roomFeatureName + "' for a more detailed description of this rooms feature");
                    }

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
                    CheckIfRoomHasPuzzle(currentRoom,previousPosition);

                    if(refusedEntry == false) {
                        currentlyInRoom = true;
                        if (score.roomVisited(currentRoom.getName()) == false) {
                            score.AddRoom(currentRoom);
                        }
                        System.out.println("You are now entering the " + currentRoom.getName());


                        System.out.println("Enter '" + currentRoom.roomFeatureName + "' for a more detailed description of this rooms feature");
                    }

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
        else if(userMove.equals("get shield") && currentRoom.getName().equals("Bedroom") && canPickUpShield == true)
        {
            inventory.addItem("shield");
            System.out.println("shield was added to your inventory");
        }
        else if(userMove.equals("start fight") && currentRoom.getName().equals("Bedroom"))
        {
            battleScene();
        }
        else
        {
            System.out.println("That move was not recognised please enter a valid command") ;
            checkUserMove();
        }
        }

    }

    // the puzzle for entering the terrace
    public static void enterTerrace(Position previousPosition)
    {
        System.out.println("Looks like the stairs to get to the terrace are blocked");
        System.out.println("It would sure help having a plunger to wall climb");
        if(inventory.hasItem("plunger")!= -1)
        {
            System.out.println("Wait... you do have a plunger");
            System.out.println("You used the plunger to grapple on the wall and get access to the roof");
            refusedEntry = false;
        }
        else
        {
            System.out.println("It might be worth it to go pick up the plunger from the toilet");
            refusedEntry = true;
            UpdateMapWithUserPosition(previousPosition);
            UserPosition = previousPosition;
        }

    }


    // checks if there is a puzzle for entering the given room
    public static void CheckIfRoomHasPuzzle(Room newRoom, Position previousLocation)
    {
        String roomName = newRoom.getName();
        switch (roomName)
        {
            case "Toilet":
                refusedEntry = false;
                enterToiletPuzzle();
                break;
            case "Bedroom":
                enterBedroom(previousLocation);
                break;
            case "Drinks Bar" :
                refusedEntry = false;
                System.out.println("There seems to be a moving statue which wants to play blackjack with you, if you want to play enter 'play 21'");
                break;
            case "Terrace" :
                enterTerrace(previousLocation);
                break;
            default:
                refusedEntry = false;
                break;
        }
    }

    // add a previous location so that when they are not allowed in they get sent back or in the other constructor
    public static void enterBedroom(Position previousPosition)
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
            System.out.println("As soon as you open the door you see shield would you like to pick it up?");
            System.out.println("to pick up the shield please enter 'get shield'");
            canPickUpShield = true;
            refusedEntry = false;
            System.out.println("(intense fighting music starts to play) The Joker pops up and invites you to a fight to free batman");
            System.out.println("If you would like to initiate the fight please enter 'start fight' ");


        }
        else
        {
            System.out.println("✖");
            System.out.println("Access Denied, you dont have the code");
            UserPosition = previousPosition;
            UpdateMapWithUserPosition(previousPosition);
            refusedEntry = true;
            UpdateMapWithUserPosition(previousPosition);

            System.out.println(">> it may be worth it to go and pick up the code from the main lobby marked on the map as M ");
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

                    // asci art from https://www.asciiart.eu/electronics/light-bulbs
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

        // you can only pick up the plunger if you haven't already picked up the plunger
        if(inventory.hasItem("plunger") == -1) {
            System.out.println("Wow there is a shiny new plunger in the corner its suction would help in certain scenarios would you like to take it?");
            System.out.println("Enter 'take plunger' to pick up the plunger");
        }

    }

    // finish this, this is the battle scene in which the joker is to fight with you and your items are the cards, and shield
    public static void battleScene()
    {
        System.out.println("The joker pops out of nowhere and challenges you to a battle which you cant refuse");
        if(inventory.hasItem("cards") != -1)
        {
            System.out.println("Luckily you played 21 and won the deck of cards, which are very sharp and can be used as a weapon");
        }
        else
        {
            System.out.println("You don't have any viable items to fight the joker with, luckily the joker has some morals");
            System.out.println("He gives you a hint to go get the cards from the Drinks Bar");
            return;
        }

        int userHealth = 100;
        int jokerHealth = 100;

        int plungerDamage = 25;
        int cardsDamage = 50;
        int shieldHealth = 75;

        int jokerDamage = 45;

        while(jokerHealth>0)
        {
            int jokerDamageThisTurn = (int)(Math.random()*jokerDamage);

            System.out.println("The joker is trying to attack you");
            if(shieldHealth> 0) {
                System.out.println("Please enter 'defend' if you would like to defend");
                String userChoice = scanner.nextLine();
                if(userChoice.equals("defend"))
                {
                    System.out.println("The joker dealt " + jokerDamageThisTurn + " damage");
                    shieldHealth = shieldHealth - jokerDamageThisTurn;
                    System.out.println("The shield's health is " + shieldHealth);
                    if(shieldHealth<0)
                    {
                        System.out.println("The shield broke and the excess damage was dealt to you");
                        userHealth += shieldHealth;
                    }
                }
                else
                {
                    System.out.println("You did not defend");
                  System.out.println("The joker dealt " + jokerDamageThisTurn + " damage");
                  userHealth = userHealth - jokerDamageThisTurn;
                  System.out.println("Your new health is " + userHealth);
                }

            }
            System.out.println("Its now your turn to attack");
            boolean validAnswer = false;
            int dmgToDeal = 0;
            while(validAnswer == false) {
                System.out.println("The current items in your inventory are " + inventory.displayInventory());
                System.out.println("You can't throw your code or shield");
                System.out.println("Which item would you like to throw, just enter the items name");
                String item = scanner.nextLine();
                 dmgToDeal = 0;

                if (item.equals("cards") && inventory.hasItem("cards") != -1) {
                    dmgToDeal = cardsDamage;
                    validAnswer = true;
                }
                else if (item.equals("plunger") && inventory.hasItem("plunger") != -1) {
                    dmgToDeal = plungerDamage;
                    validAnswer = true;
                    System.out.println("You threw the plunger it briefly stuck to the Joker's face before falling off");
                    System.out.println("--> the plunger was removed from your inventory");
                    inventory.removeItem("plunger");
                }
                else {
                    System.out.println("Invalid item to throw please enter a valid item");
                }
            }
            jokerHealth = jokerHealth- dmgToDeal;
            System.out.println("You dealt " + dmgToDeal + " to the joker");
            if(jokerHealth >= 0)
            {
                System.out.println("The joker's current Health is " + jokerHealth);

            }
            else
            {
                System.out.println("And you injured the Joker");
                System.out.println("The joker screams -  NOOOO HOW COULD THIS BE I WILL BE BACK FOR THE BOTH OF YOU");
                score.solvePuzzle();
                System.out.println("You finished the game! you can continue to roam and exploring the map or you can quit");
            }


        }

    }

    public static void main(String[] args)
    {

        System.out.println("Welcome player, in this game you are a detective which has been tasked with finding batman as he has gone missing, probe the compound and find Batman");
        createRooms();
        int count = 0; // gives you a chance of picking up the shield
        System.out.println();
        currentRoom= getRoom(UserPosition.x, UserPosition.y);// the user starts off in the main lobby
        currentlyInRoom = true;
        System.out.println("You are currently in " + currentRoom.getName() + " There seems to be a note on the door please enter 'look note' if you would like to have a look at the note");
        System.out.println();
        System.out.println("Please enter your command or enter help to learn more about commands in the game");

        while(true)
        {
            checkUserMove();
        }
    }

}