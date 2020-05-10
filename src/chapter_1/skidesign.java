/*
ID: philip61
LANG: JAVA
TASK: skidesign
*/
package chapter_1;
import java.util.*;
import java.io.*;
class skidesign{
   static int highest,lowest,N;
   public static int calcCost(int x, int y,int[] h)
   {
      int[] temp = new int[N];
      for(int i = 0; i < N; i++)
      {
         temp[i] = h[i];
      }
      int cost = 0;
      for(int i = 0; i < N; i++)
      {
         if(temp[i]<lowest+x)
            cost+=(int)Math.pow(lowest+x-temp[i],2);
         if(temp[i]>highest-y)
            cost+=(int)Math.pow(temp[i]-highest+y,2);
      }
      return cost;
   }
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      N = Integer.parseInt(stn.nextToken());
      int[] original = new int[N];
      int[] after = new int[N];
      StringTokenizer sti = new StringTokenizer(f.readLine());
      lowest = original[0] = Integer.parseInt(sti.nextToken());
      after[0] = original[0];
      highest = 0;
      for(int i = 1; i < N; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         original[i] = Integer.parseInt(st.nextToken());
         after[i] = original[i];
         lowest = Math.min(original[i],lowest);
         highest = Math.max(original[i],highest);
      }
      int minCost = 99999999;
      int distance = highest-lowest-17;
      if(distance <=0)
         out.println(""+0);
      else
      {
      for(int i = 0; i < distance; i++)
      {
         minCost = Math.min(minCost,calcCost(i,distance-i,original));
      }
      out.println(""+minCost);
      }
      out.close();
   }
}