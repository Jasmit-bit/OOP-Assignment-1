package org.uob.a1;

public class Score {
    private final int PUZZLE_VALUE= 10;
    private int startingScore;
    private int currentScore;
    private int numberOfRoomsVisited;
    private int puzzlesSolved;
    private Room[] rooms;

    public Score(int startingScore)
    {
        this.startingScore = startingScore;
        rooms = new Room[10];

        numberOfRoomsVisited = 0;
        puzzlesSolved = 0;

    }
    public void visitRoom()
    {
        numberOfRoomsVisited++;

    }
    public void solvePuzzle()
    {
        puzzlesSolved++;
        currentScore += PUZZLE_VALUE;

    }
    public double getScore()
    {
        currentScore = startingScore - numberOfRoomsVisited + (puzzlesSolved * PUZZLE_VALUE);
        return currentScore;
    }

    public boolean roomVisited(String roomName)
    {
        for(int i = 0; i < numberOfRoomsVisited; i++)
        {
            if(rooms[i].getName().equals(roomName))
            {
                return true;
            }
        }
        return false;
    }

    public void AddRoom(Room givenRoom)
    {
        visitRoom();
        for(int i = 0 ; i < rooms.length; i++)
        {
            if(rooms[i] == null)
            {
                rooms[i] = givenRoom;
                break;
            }
        }
    }




        
}