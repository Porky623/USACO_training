/*
ID: philip61
LANG: JAVA
TASK: crypt1
*/
package chapter_1;
import java.util.*;
import java.io.*;
class crypt1{
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(stn.nextToken());
      StringTokenizer st = new StringTokenizer(f.readLine());
      int[] digits = new int[N];
      for(int i = 0; i < N; i++)
      {
         digits[i] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(digits);
      boolean check1;
      boolean check2;
      boolean check3;
      int count = 0;
      for(int i = 0; i < digits.length; i++)
      {
         for(int j = 0; j < digits.length; j++)
         {
            for(int k = 0; k < digits.length; k++)
            {
               for(int l = 0; l < digits.length; l++)
               {
                  for(int m = 0; m < digits.length; m++)
                  {
                     int ABC = 100*digits[i]+10*digits[j]+digits[k];
                     int LM = 10*digits[l]+digits[m];
                     
                     check1 = checkSet(ABC*digits[l],digits);
                     check2 = checkSet(ABC*digits[m],digits);
                     check3 = checkSet(ABC*LM,digits);
                     if(check1==true&&check2==true&&check3==true)
                     {
                        if(ABC*digits[l]<1000&&ABC*digits[m]<1000)
                           count++;
                     }
                  }
               }
            }
         }
      }
      out.println(""+count);
      out.close();
   }
   public static boolean checkSet(int x,int[] digits)
   {
      String number = ""+x;
      boolean hasAll = true;
      for(int i = 0; i < number.length(); i++)
      {
         boolean isIn = false;
         for(int j = 0; j < digits.length; j++)
         {
            if(Integer.parseInt(number.substring(i,i+1)) == digits[j])
               isIn = true;
         }
         if(isIn == false)
            hasAll = false;
      }
      return hasAll;
   }
}