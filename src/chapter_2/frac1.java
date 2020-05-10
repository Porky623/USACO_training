/*
ID: philip61
LANG: JAVA
TASK: frac1
*/
package chapter_2;
import java.util.*;
import java.io.*;
class frac1{
   static double N;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      N = Integer.parseInt(st.nextToken());
      double[][] fractions = new double[(int)((N+2)*(N+1)/2-1)][3];
      for(double i = 1.0; i <= N; i++)
      {
         for(double j = 0.0; j <= i; j++)
         {
            fractions[(int)((i)*(i+1.0)/2+j-1.0)][2] = i;
            fractions[(int)((i)*(i+1.0)/2+j-1.0)][1] = j;
            fractions[(int)((i)*(i+1.0)/2+j-1.0)][0] = j/i;
         }
      }
      Arrays.sort(fractions,Comparator.comparing((double[] arr) -> arr[0]));
      double currentFrac = fractions[0][0];
      for(int i = 1; i < fractions.length; i++)
      {
         if(fractions[i][0]==currentFrac)
         {
            fractions[i][0] = -1.0;
         }
         else
         {
            currentFrac = fractions[i][0];
         }
      }
      for(int i = 0; i < fractions.length; i++)
      {
         if(fractions[i][0] != -1.0)
         {
            out.println((int)(fractions[i][1])+"/"+(int)(fractions[i][2]));
         }
      }
      out.close();
   }
}