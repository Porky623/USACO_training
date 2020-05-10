/*
ID: philip61
LANG: JAVA
TASK: milk
*/
package chapter_1;
import java.util.*;
import java.io.*;
class milk{
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("milk.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
      StringTokenizer stnm = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(stnm.nextToken());
      int M = Integer.parseInt(stnm.nextToken());
      int[][] farmers = new int[M][2];
      for(int i = 0; i < M; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         farmers[i][0] = Integer.parseInt(st.nextToken());
         farmers[i][1] = Integer.parseInt(st.nextToken());
      }
      
      Arrays.sort(farmers, Comparator.comparing((int[] arr) -> arr[0]));
      int bought = 0;
      int cost = 0;
      for(int i = 0; i < M; i++)
      {
         if(bought==N)
            break;
         else if(bought+farmers[i][1]>N)
         {
            cost += (N-bought)*farmers[i][0];
            bought = N;
         }
         else
         {
            cost += farmers[i][1]*farmers[i][0];
            bought += farmers[i][1];
         }
      }
      out.println(""+cost);
      out.close();
   }
}