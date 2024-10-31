package org.uob.a1;

import java.util.Scanner; 

public class Game {

    public static Scanner reader = new Scanner(System.in);
    public static Position userPosition = new Position(1,1);
    public static Map diagram = new Map(10,10);

    public static void UpdateMapWithUserPosition(Position pos) {
        diagram.placeRoom(pos,'X');
        System.out.println(diagram.display());


    }
    public static void getUserDirection(Position userPosition)
    {
        char direction = reader.next().charAt(0);
        direction = Character.toUpperCase(direction); // makes the user input non case sensitive


        switch (direction)
        {
            case 'W':
                diagram.placeRoom(userPosition,'.'); //removes the users old position
                userPosition.y = userPosition.y - 1; // you start from the bottom so you have to reduce the y value
                UpdateMapWithUserPosition(userPosition);
                break;

            case 'S':
                diagram.placeRoom(userPosition,'.'); //removes the users old position
                userPosition.y = userPosition.y + 1;
                UpdateMapWithUserPosition(userPosition);
                break;

            case 'A':
                diagram.placeRoom(userPosition,'.'); //removes the users old position
                userPosition.x = userPosition.x - 1;
                UpdateMapWithUserPosition(userPosition);
                break;
            case 'D':
                diagram.placeRoom(userPosition,'.'); //removes the users old position
                userPosition.x = userPosition.x + 1;
                UpdateMapWithUserPosition(userPosition);
                break;


        }



    }

    public static void main(String[] args) {
         // Now that I have a map which is 10x6 I should create the rooms


        {
            //first I will create all the rooms
            Position PosOfMainLobby = new Position(8, 1);
            Room mainLobby = new Room("Main Lobby", "Hmm this room seems to have loads of sofas does the Joker actually have this many friends to be using all these sofas",
                    'M', PosOfMainLobby);
            diagram.placeRoom(PosOfMainLobby, mainLobby.getSymbol());

            Position PosOfGarage = new Position(3, 4);
            Room garage = new Room("Garage", "Wow the Joker has a garage with a very nice collection, wait is that the batmobile" +
                    " Batman has to be somewhere around here", 'G', PosOfGarage);
            diagram.placeRoom(PosOfGarage, garage.getSymbol());

            Position PosOfKitchen = new Position(8, 5);
            Room kitchen = new Room("Kitchen", "Gawd Damn the Joker has some expensive taste in counter tops," +
                    "the kitchen has a fancy wood decor and loads of appliances", 'K', PosOfKitchen);
            diagram.placeRoom(PosOfKitchen, kitchen.getSymbol());

            Position PosOfDrinksBar = new Position(9, 7);
            Room drinksBar = new Room("Drinks Bar", " Looks like the Joker is quite the alcohol enjoyer he has a drinks bar in his basement " +
                    " there seems to be Henessy and grey goose bottles in the windows just like those in the student flats", 'D', PosOfDrinksBar);
            diagram.placeRoom(PosOfDrinksBar, drinksBar.getSymbol());

            Position PosOfConservatory = new Position(5, 3);
            Room conservatory = new Room("Conservatory", "This is a room meant to be enjoyed with the sun by the looks of it, its covered in glass shame that his lair is underground",
                    'C', PosOfConservatory);
            diagram.placeRoom(PosOfConservatory, conservatory.getSymbol());

            Position PosOfPantry = new Position(6, 4);
            Room pantry = new Room("Pantry", "This is the pantry, the Joker seems to have a lot of china plates around here ", 'P', PosOfPantry);
            diagram.placeRoom(PosOfPantry, pantry.getSymbol());

            Position PosOfToilet = new Position(7, 2);
            Room toilet = new Room("Toilet", "Welcome to the Joker's toilet, Its a very bright room with a big shower and blue lights everywhere ",
                    'T', PosOfToilet);
            diagram.placeRoom(PosOfToilet, toilet.getSymbol());

            Position PosOfBedroom = new Position(6, 9);
            Room bedroom = new Room("Bedroom", "Welcome the Joker's bedroom. And yes it is as miserable as you may think its all grey with smiles on the walls",
                    'B', PosOfBedroom);
            diagram.placeRoom(PosOfBedroom, bedroom.getSymbol());

            Position PosOfGarden = new Position(7, 8);
            Room Garden = new Room("Garden", "Take a deep breath you are out of the Joker's cave from here you can see his garden furniture", 'G', PosOfGarden);
            diagram.placeRoom(PosOfGarden, Garden.getSymbol());

            Position PosOfTerrace = new Position(9, 6);
            Room Terrace = new Room("Terrace", " You have managed to make it to the terrace of the house in the cave here you can see faint lights in the distance and a fancy helicopter", 'T', PosOfTerrace);
            diagram.placeRoom(PosOfTerrace, Terrace.getSymbol());
        }
        Score score = new Score(0);
        Position userPosition = new Position(0,9);
        diagram.placeRoom(userPosition,'X');
        System.out.println(diagram.display());
        while(true) {
            getUserDirection(userPosition);
        }





















    }
    
}