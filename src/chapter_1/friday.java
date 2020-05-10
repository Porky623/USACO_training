/*
ID: philip61
LANG: JAVA
TASK: friday
*/
package chapter_1;
import java.util.*;
import java.io.*;
class friday{
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("friday.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(st.nextToken());
      
      int currentDay = 0;
      int[] numDays = new int[12];
      numDays[0] = numDays[2] = numDays[4] = numDays[6] = numDays[7] = numDays[9] = numDays[11] = 31;
      numDays[1] = 28;
      numDays[3] = numDays[5] = numDays[8] = numDays[10] = 30;
      int[] numTimes = new int[7];
      numTimes[0] = 1;
      for(int i = 1; i < 7; i++)
      {
         numTimes[i] = 0;
      }
      for(int i = 0; i < N; i++)
      {
         if(i%4 == 0 && (i %100 != 0 || i == 100))
         {
            numDays[1] = 29;
         }
         else
            numDays[1] = 28;
         if(i<N-1)
         {
            for(int j = 0 ; j < 12; j++)
            {
               currentDay = (currentDay+numDays[j])%7;
               numTimes[currentDay]++;
            }
         }
         else
         {
            for(int j = 0; j < 11; j++)
            {
               currentDay = (currentDay+numDays[j])%7;
               numTimes[currentDay]++;
            }
         }
      }
      out.println(numTimes[0]+" "+numTimes[1]+" "+numTimes[2]+" "+numTimes[3]+" "+numTimes[4]+" "+numTimes[5]+" "+numTimes[6]);
      out.close();
   }
}