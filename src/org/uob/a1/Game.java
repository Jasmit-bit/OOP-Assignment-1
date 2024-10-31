package org.uob.a1;

import java.util.Scanner; 

public class Game {



    public static void main(String[] args) {
        Map map = new Map(10,10); // Now that I have a map which is 10x6 I should create the rooms



        //first I will create all the rooms
        Position PosOfMainLobby = new Position(8,1);
        Room mainLobby = new Room("Main Lobby", "Hmm this room seems to have loads of sofas does the Joker actually have this many friends to be using all these sofas",
                'M',PosOfMainLobby);
        map.placeRoom(PosOfMainLobby,mainLobby.getSymbol());

        Position PosOfGarage = new Position(3,4);
        Room garage = new Room("Garage", "Wow the Joker has a garage with a very nice collection, wait is that the batmobile" +
                " Batman has to be somewhere around here", 'G',PosOfGarage);
        map.placeRoom(PosOfGarage,garage.getSymbol());

        Position PosOfKitchen  = new Position(8,5);
        Room kitchen = new Room("Kitchen", "Gawd Damn the Joker has some expensive taste in counter tops," +
                "the kitchen has a fancy wood decor and loads of appliances" , 'K',PosOfKitchen);
        map.placeRoom(PosOfKitchen,kitchen.getSymbol());

        Position PosOfDrinksBar = new Position(9,7);
        Room drinksBar = new Room("Drinks Bar", " Looks like the Joker is quite the alcohol enjoyer he has a drinks bar in his basement " +
                " there seems to be Henessy and grey goose bottles in the windows just like those in the student flats",'D',PosOfDrinksBar );
        map.placeRoom(PosOfDrinksBar,drinksBar.getSymbol());

        Position PosOfConservatory = new Position(5,3);
        Room conservatory = new Room("Conservatory", "This is a room meant to be enjoyed with the sun by the looks of it, its covered in glass shame that his lair is underground",
                'C',PosOfConservatory);
        map.placeRoom(PosOfConservatory,conservatory.getSymbol());

        Position PosOfPantry = new Position(6,4);
        Room pantry = new Room("Pantry","This is the pantry, the Joker seems to have a lot of china plates around here ",'P',PosOfPantry);
        map.placeRoom(PosOfPantry,pantry.getSymbol());

        Position PosOfToilet = new Position(7,2);
        Room toilet = new Room("Toilet", "Welcome to the Joker's toilet, Its a very bright room with a big shower and blue lights everywhere ",
                'T',PosOfToilet);
        map.placeRoom(PosOfToilet, toilet.getSymbol());

        Position PosOfBedroom = new Position(6,9);
        Room bedroom = new Room("Bedroom", "Welcome the Joker's bedroom. And yes it is as miserable as you may think its all grey with smiles on the walls",
                'B',PosOfBedroom);
        map.placeRoom(PosOfBedroom,bedroom.getSymbol());

        Position PosOfGarden = new Position(7,8);
        Room Garden = new Room("Garden", "Take a deep breath you are out of the Joker's cave from here you can see his garden furniture" , 'G',PosOfGarden);
        map.placeRoom(PosOfGarden,Garden.getSymbol());

        Position PosOfTerrace = new Position(9,6);
        Room Terrace = new Room("Terrace"," You have managed to make it to the terrace of the house in the cave here you can see faint lights in the distance and a fancy helicopter",'T',PosOfTerrace  );
        map.placeRoom(PosOfTerrace,Terrace.getSymbol());

        System.out.println(map.display());

















    }
    
}