/*
ID: philip61
LANG: JAVA
TASK: wormhole
*/
package chapter_1;
import java.util.*;
import java.io.*;
class wormhole{
   static int N;
   static int[] xCoord,yCoord,partner,nextOnRight;
   public static boolean cycleExists(){
      for(int i = 1; i <= N; i++)
      {
         int pos = i;
         for(int j = 0; j < N; j++)
         {
               pos = nextOnRight[partner[pos]];
         }
         if(pos!=0)
            return true;
      }
      return false;
   }
   public static int solve(){
      int total = 0;
      int i = 0;
      for(i = 1; i <= N; i++)
      {
         if(partner[i] == 0)
            break;
      }
      if(i>N)
      {
         if(cycleExists())
            return 1;
         else
            return 0;
      }
      for(int j = i+1; j <=N; j++)
      {
         if(partner[j] == 0)
         {
            partner[i] = j;
            partner[j] = i;
            total+=solve();
            partner[i] = partner[j] = 0;
         }
      }
      return total;
   }
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      N = Integer.parseInt(stn.nextToken());
      xCoord = new int[N+1];
      yCoord = new int[N+1];
      partner = new int[N+1];
      nextOnRight = new int[N+1];
      for(int i = 1; i <= N; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         xCoord[i] = Integer.parseInt(st.nextToken());
         yCoord[i] = Integer.parseInt(st.nextToken());
         partner[i] = 0;
         nextOnRight[i] = 0;
      }
      for(int i = 1; i <= N; i++)
      {
         for(int j = 1; j <= N; j++)
         {
            if(xCoord[j]>xCoord[i] && yCoord[i]==yCoord[j])
            {
               if(nextOnRight[i] == 0 ||xCoord[j]-xCoord[i]<xCoord[nextOnRight[i]]-xCoord[i])
               {
                  nextOnRight[i] = j;
               }
            }
         }
      }
      out.println(""+solve());
      out.close();
   }
}