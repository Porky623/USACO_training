/*
ID: philip61
LANG: JAVA
TASK: barn1
*/
package chapter_1;
import java.util.*;
import java.io.*;
class barn1{
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
      StringTokenizer stmsc = new StringTokenizer(f.readLine());
      int M = Integer.parseInt(stmsc.nextToken());
      int S = Integer.parseInt(stmsc.nextToken());
      int C = Integer.parseInt(stmsc.nextToken());
      int[] cows = new int[C];
      for(int i = 0; i < C; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         cows[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(cows);
      int[] gaps = new int[C-1];
      for(int i = 0; i < C-1; i++)
      {
         gaps[i] = cows[i+1]-cows[i];
      }
      Arrays.sort(gaps);
      int covered = C;
      if(M>=C)
      {
         out.println(""+C);
      }
      else
      {
         for(int i = 0; i < C-M; i++)
         {
            covered+=gaps[i]-1;
         }
         out.println(""+covered);
      }
      out.close();
   }
}