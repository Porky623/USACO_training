/*
ID: philip61
LANG: JAVA
TASK: milk2
*/
package chapter_1;
import java.util.*;
import java.io.*;
class milk2{
   static int[][] intervals;
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
      StringTokenizer sc = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(sc.nextToken());
      intervals = new int[N][2];
      for(int i = 0; i < N; i++)
      {
         StringTokenizer sc1 = new StringTokenizer(f.readLine());
         intervals[i][0] = Integer.parseInt(sc1.nextToken());
         intervals[i][1] = Integer.parseInt(sc1.nextToken());
      }
      Arrays.sort(intervals,Comparator.comparing((int[] arr) -> arr[0]));
      ArrayList<String> times = new ArrayList<String>();
      int startInt = intervals[0][0];
      int endInt = intervals[0][1];
      times.add(""+startInt);
      for(int i = 1; i < N; i++)
      {
         if(intervals[i][0]>endInt)
         {
            times.add(""+endInt);
            times.add(""+intervals[i][0]);
            startInt = intervals[i][0];
         }
         if(endInt<intervals[i][1])
            endInt = intervals[i][1];
      }
      times.add(""+endInt);
      
      int numInts = times.size();
      int maxMilk = 0;
      int maxIdle = 0;
      for(int i = 0; i < numInts/2; i++)
      {
         int startTime = Integer.parseInt(times.get(2*i));
         int endTime = Integer.parseInt(times.get(2*i+1));
         if(maxMilk<(endTime - startTime))
            maxMilk = endTime - startTime;
      }
      for(int i = 0; i < numInts/2-1; i++)
      {
         int endTime = Integer.parseInt(times.get(2*i+1));
         int startTime = Integer.parseInt(times.get(2*i+2));
         maxIdle = Math.max(maxIdle,startTime-endTime);
      }
      out.println(maxMilk + " " + maxIdle);
      out.close();
   }
}