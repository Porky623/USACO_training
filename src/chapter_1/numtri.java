/*
ID: philip61
LANG: JAVA
TASK: numtri
*/
package chapter_1;
import java.util.*;
import java.io.*;
class numtri{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(stn.nextToken());
      int[][] numbers = new int[N][N];
      for(int i = 1; i <= N; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         for(int j = 0; j < i; j++)
         {
            numbers[i-1][j] = Integer.parseInt(st.nextToken());
         }
      }
      for(int i = N-2; i >=0; i--)
      {
         for(int j = 0; j < i+1; j++)
         {
            numbers[i][j] +=Math.max(numbers[i+1][j],numbers[i+1][j+1]);
         }
      }
      out.println(""+numbers[0][0]);
      out.close();
   }
}