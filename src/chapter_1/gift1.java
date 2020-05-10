/*
ID: philip61
LANG: JAVA
TASK: gift1
*/
package chapter_1;
import java.util.*;
import java.io.*;
class gift1{
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
      StringTokenizer st1 = new StringTokenizer(f.readLine());
      int NP = Integer.parseInt(st1.nextToken());
      
      String[] names = new String[NP];
      for(int i = 0; i < NP; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         names[i] = st.nextToken();
      }
      
      int[] amountGiven = new int[NP];
      int[] numGiven = new int[NP];
      int[] finAmounts = new int[NP];
      for(int i = 0; i < NP; i++)
      {
         finAmounts[i] = 0;
      }
      String[][] givenTo = new String[NP][];
      String[] temp;
      
      for(int i = 0; i < NP; i++)
      {
         StringTokenizer whoIs = new StringTokenizer(f.readLine());
         String person = whoIs.nextToken();
         int index = 0;
         for(int j = 0; j < NP; j++)
         {
            if(names[j].equals(person))
               index = j;
         }
         StringTokenizer moneyGiven = new StringTokenizer(f.readLine());
         amountGiven[index] = Integer.parseInt(moneyGiven.nextToken());
         numGiven[index] = Integer.parseInt(moneyGiven.nextToken());
         String[] namesGiven = new String[numGiven[index]];
         
         for(int j = 0; j < numGiven[index]; j++)
         {
            StringTokenizer givenName = new StringTokenizer(f.readLine());
            namesGiven[j] = givenName.nextToken();
         }
         temp = namesGiven;
         givenTo[index] = temp;
      }
      
      for(int i = 0; i < NP; i++)
      {
         finAmounts[i] -= amountGiven[i];
         if(numGiven[i] == 0)
            finAmounts[i]+=amountGiven[i];
         else
            finAmounts[i] += amountGiven[i]%numGiven[i];
         temp = givenTo[i];
         for(int j = 0; j < numGiven[i]; j++)
         {
            int index = 0;
            for(int k = 0; k < NP; k++)
            {
               if(names[k].equals(temp[j]))
                  index = k;
            }
            finAmounts[index] += amountGiven[i]/numGiven[i];
         }
      }
      for(int i = 0; i < NP; i++)
      {
         out.println(names[i]+" " + finAmounts[i]);
      }
      out.close();
   }
}