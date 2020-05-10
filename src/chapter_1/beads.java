/*
ID: philip61
LANG: JAVA
TASK: beads
*/
package chapter_1;
import java.util.*;
import java.io.*;
class beads{
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("beads.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
      StringTokenizer st1 = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(st1.nextToken());
      StringTokenizer st2 = new StringTokenizer(f.readLine());
      char[] beads = new char[2*N];
      String necklace = st2.nextToken();
      for(int i = 0; i < N; i++)
      {
         beads[i] = beads[i+N] = necklace.charAt(i);
      }
      int maxBeads = 1;
      
      for(int i = 0; i < N; i++)
      {
         int countLeft = 0;
         int countRight = 0;
         boolean whiteChain = true;
         int notWhite = i;
         for(int j = i; j >= 0; j--)
         {
            if(whiteChain == true)
            {
               if(beads[j] != 'w')
               {
                  notWhite = j;
                  whiteChain = false;
               }
               countLeft++;
            }
            else if(beads[j] == beads[notWhite] || beads[j] == 'w')
            {
               countLeft++;
            }
            else
               break;
         }
         whiteChain = true;
         notWhite = i+1;
         for(int j = i+1; j < 2*N; j++)
         {
            if(whiteChain == true)
            {
               if(beads[j] != 'w')
               {
                  notWhite = j;
                  whiteChain = false;
               }
               countRight++;
            }
            else if(beads[j] == beads[notWhite] || beads[j] == 'w')
            {
               countRight++;
            }
            else
               break;
         }
         if(maxBeads < countLeft + countRight)
            maxBeads = countLeft + countRight;
      }
      if(maxBeads > N)
         maxBeads = N;
      out.println(""+maxBeads);
      out.close();
   }
}