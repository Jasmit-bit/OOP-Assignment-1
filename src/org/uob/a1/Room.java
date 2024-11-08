package org.uob.a1;

public class Room {
    private String name,description;
    private  char symbol;
    private Position position;
    public String artForTheRoom = " ";
    public String RoomPuzzle = null;
    public String roomItem = null;
    public String roomItemDescription = null;
    public String roomFeature = null;
    public String roomFeatureName = null;




    public Room(String name, String description, char symbol, Position position)
    {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public char getSymbol() {
        return symbol;
    }
    public Position getPosition() {
        return position;
    }
}