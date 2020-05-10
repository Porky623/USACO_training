/*
ID: philip61
LANG: JAVA
TASK: castle
*/
package chapter_2;
import java.util.*;
import java.io.*;
class castle{
   static int M, N;
   static boolean[][] castle;
   static int[][] rooms;
   static int[] components;
   static int[] original;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("castle.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
      StringTokenizer stmn = new StringTokenizer(f.readLine());
      M = Integer.parseInt(stmn.nextToken());
      N = Integer.parseInt(stmn.nextToken());
      castle = new boolean[N*M][4];
      original = new int[N*M];
      rooms = new int[N][M];
      for(int i = 0; i < N; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         for(int j = 0; j < M; j++)
         {
            original[i*M+j] = Integer.parseInt(st.nextToken());
            for(int k = 0; k < 4; k++)
               castle[i*M+j][k] = false;
            rooms[i][j] = -1;
         }
      }
      for(int i = 0; i < N*M; i++)
      {
         int j = original[i];
         if(j>=8)
         {
            castle[i][3] = true;
            j-=8;
         }
         if(j>=4)
         {
            castle[i][2] = true;
            j-=4;
         }
         if(j>=2){
            castle[i][1] = true;
            j-=2;
         }
         if(j>=1){
            castle[i][0] = true;
            j-=1;
         }
      }
      List<Integer> sizes = new ArrayList<Integer>();
      int count = 1;
      for(int i = 0; i < N; i++)
      {
         for(int j = 0; j < M; j++)
         {
            if(rooms[i][j] == -1)
            {
               sizes.add(search(i,j,count));
               count++;
            }
         }
      }
      int maxSize = 0;
      for(int i = 0; i < sizes.size(); i++)
      {
         maxSize = Math.max(maxSize,sizes.get(i));
      }
      out.println(""+sizes.size());
      out.println(""+maxSize);
      int takeOut = 0;
      int wall = M*(N-1);
      boolean E = true;
      for(int j = 0; j < M; j++)
      {
         for(int i = N-1; i >=0; i--)
         {
            if(castle[i*M+j][1])
            {
               if(i>0)
               {
                  if(sizes.get(rooms[i][j]-1)+sizes.get(rooms[i-1][j]-1)>takeOut&&rooms[i][j]!=rooms[i-1][j])
                  {
                     takeOut = sizes.get(rooms[i][j]-1)+sizes.get(rooms[i-1][j]-1);
                     wall = i*M+j;
                     E = false;
                  }
               }
            }
            if(castle[i*M+j][2])
            {
               if(j<M-1)
               {
                  if(sizes.get(rooms[i][j]-1)+sizes.get(rooms[i][j+1]-1)>takeOut&&rooms[i][j]!=rooms[i][j+1])
                  {
                     takeOut = sizes.get(rooms[i][j]-1)+sizes.get(rooms[i][j+1]-1);
                     wall = i*M+j;
                     E = true;
                  }
               }
            }
         }
      }
      out.println(""+takeOut);
      String finalWall = "";
      finalWall+=((int)(wall/M)+1)+" "+(wall%M+1)+" ";
      if(E)
         finalWall+="E";
      else
         finalWall+="N";
      out.println(finalWall);
      out.close();
   }
   private static int search(int r, int c, int num){
      if(rooms[r][c] != -1)
         return 0;
      rooms[r][c] = num;
      int size = 1;
      if(!castle[r*M+c][0])
      {
         size+=search(r,c-1,num);
      }
      if(!castle[r*M+c][1])
      {
         size+=search(r-1,c,num);
      }
      if(!castle[r*M+c][2])
      {
         size+=search(r,c+1,num);
      }
      if(!castle[r*M+c][3])
      {
         size+=search(r+1,c,num);
      }
      return size;
   }
}