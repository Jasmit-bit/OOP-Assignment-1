package org.uob.a1;

public class Map {
   public char[][] map;
   final private char EMPTY = '.';
   private int width, height;

   public Map(int width, int height) {
       map = new char[width][height];
       this.width = width;
       this.height = height;
       for(int y = 0; y < height; y++) {
           for(int x = 0; x < width; x++) {
               map[x][y] = EMPTY;
           }
       }

   }

   public void placeRoom(Position pos, char symbol)
   {
   }
   public String display()
   {
       StringBuilder mapAsAString = new StringBuilder();
       for(int y = 0; y < height; y++)
       {
           for (int x = 0; x < width; x++)
           {
               mapAsAString.append(map[x][y]);
               mapAsAString.append("|");

           }
           mapAsAString.append("\n");

       }
       return mapAsAString.toString();

   }

}