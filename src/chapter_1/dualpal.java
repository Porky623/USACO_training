/*
ID: philip61
LANG: JAVA
TASK: dualpal
*/
package chapter_1;
import java.util.*;
import java.io.*;
class dualpal{
   public static boolean isPalindrome(String n)
   {
      if(n.charAt(0)==n.charAt(n.length()-1))
      {
         if(n.length()<=2)
            return true;
         else
         {
            return isPalindrome(n.substring(1,n.length()-1));
         }
      }
      else
         return false;
   }
   public static String changeBase(int x, int base)
   {
      StringBuilder N = new StringBuilder("");
      int k = x;
      while(k>0)
      {
         N.insert(0,""+k%base);
         k/=base;
      }
      return N.toString();
   }
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(st.nextToken());
      int S = Integer.parseInt(st.nextToken());
      
      int count = 0;
      int currentInt = S+1;
      while(count<N)
      {
         int count2 = 0;
         for(int b = 2; b < 11; b++)
         {
            if(isPalindrome(changeBase(currentInt,b)))
               count2++;
         }
         if(count2>1)
         {
            count++;
            
         out.println(""+currentInt);
         }
         currentInt++;
      }
      out.close();
   }
}