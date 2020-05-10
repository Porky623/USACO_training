/*
ID: philip61
LANG: JAVA
TASK: skidesign
*/
package chapter_1;
import java.util.*;
import java.io.*;
class skidesign1{
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(stn.nextToken());
      int[] original = new int[N];
      int[] after = new int[N];
      StringTokenizer sti = new StringTokenizer(f.readLine());
      int lowest = original[0] = Integer.parseInt(sti.nextToken());
      after[0] = original[0];
      int highest = 0;
      for(int i = 1; i < N; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         original[i] = Integer.parseInt(st.nextToken());
         after[i] = original[i];
         lowest = Math.min(original[i],lowest);
         highest = Math.max(original[i],highest);
      }
      while((highest-lowest)>17)
      {
         int countLow = 0;
         int countHigh = 0;
         int low = 0;
         int high = 0;
         for(int i = 0; i < N; i++)
         {
            if(after[i] == lowest)
               low++;
            if(after[i] == highest)
               high++;
         }
         if(low>high)
         {
            for(int i = 0; i < N; i++)
            {
               if(after[i] == lowest)
                  after[i]++;
            }
            lowest++;
            countLow++;
         }
         else if(low<high)
         {
            for(int i = 0; i < N; i++)
            {
               if(after[i] == highest)
                  after[i]--;
            }
            highest--;
            countHigh++;
         }
         else if(low == high)
         {
            if(countLow>=countHigh)
            {
               for(int i = 0; i < N; i++)
               {
                  if(after[i] == lowest)
                     after[i]++;
               countLow++;
               }
               lowest++;
            }
            else if(low<high)
            {
               for(int i = 0; i < N; i++)
               {
                  if(after[i] == highest)
                     after[i]--;
               countHigh++;
               }
               highest--;
            }
         }
      }
      int cost = 0;
      for(int i = 0; i < N; i++)
      {
         cost+=(int)(Math.pow(after[i]-original[i],2));
      }
      out.println(""+cost);
      out.close();
   }
}