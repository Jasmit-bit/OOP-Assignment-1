package org.uob.a1;

public class Score {
    private final int PUZZLE_VALUE= 10;
    private int startingScore;
    private int currentScore;
    private int numberOfRoomsVisited;
    private int puzzlesSolved;

    public Score(int startingScore)
    {
        this.startingScore = startingScore;

        numberOfRoomsVisited = 0;
        puzzlesSolved = 0;

    }
    public void visitRoom()
    {
        numberOfRoomsVisited++;

    }
    public void solvePuzzle()
    {

    }
    public double getScore()
    {
        currentScore = startingScore - numberOfRoomsVisited + (puzzlesSolved * PUZZLE_VALUE);
        return currentScore;
    }


        
}