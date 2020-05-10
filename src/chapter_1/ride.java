/*
ID: philip61
LANG: JAVA
TASK: ride
*/
package chapter_1;
import java.util.*;
import java.io.*;
class ride{
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("ride.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
      StringTokenizer st1 = new StringTokenizer(f.readLine());
      StringTokenizer st2 = new StringTokenizer(f.readLine());
      String comet = st1.nextToken();
      String group = st2.nextToken();
      
      int cometNum = 1;
      int groupNum = 1;
      for(int i = 0; i < comet.length(); i++)
      {
         cometNum *= (comet.charAt(i)-64);
      }
      for(int i = 0; i < group.length(); i++)
      {
         groupNum *= (group.charAt(i)-64);
      }
      if(cometNum % 47 == groupNum % 47)
         out.println("GO");
      else
         out.println("STAY");
      out.close();
   }
}