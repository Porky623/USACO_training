/*
ID: philip61
LANG: JAVA
TASK: pprime
*/
package chapter_1;
import java.util.*;
import java.io.*;
class pprime{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      for(int i = 1; i < 10; i++)
      {
         if(a<=i&&i<=b)
         {
            if(isPrime(i))
               out.println(""+i);
         }
      }
      for(int i = 1; i < 10; i++)
      {
         if(a<=11*i&&11*i<=b)
         {
            if(isPrime(11*i))
               out.println(""+11*i);
         }
      }
      for(int i = 1; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            if(a<=101*i+10*j&&101*i+10*j<=b)
            {
               if(isPrime(101*i+10*j))
                  out.println(""+(101*i+10*j));
            }
         }
      }
      for(int i = 1; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            if(a<=1001*i+110*j&&1001*i+110*j<=b)
            {
               if(isPrime(1001*i+110*j))
                  out.println(""+(1001*i+110*j));
            }
         }
      }
      for(int i = 1; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            for(int k = 0; k < 10; k++)
            {
               if(a<=10001*i+1010*j+100*k&&10001*i+1010*j+100*k<=b)
               {
                  if(isPrime(10001*i+1010*j+100*k))
                     out.println(""+(10001*i+1010*j+100*k));
               }
            }
         }
      }
      for(int i = 1; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            for(int k = 0; k < 10; k++)
            {
               if(a<=100001*i+10010*j+1100*k&&100001*i+10010*j+1100*k<=b)
               {
                  if(isPrime(100001*i+10010*j+1100*k))
                     out.println(""+(100001*i+10010*j+1100*k));
               }
            }
         }
      }
      for(int i = 1; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            for(int k = 0; k < 10; k++)
            {
               for(int l = 0; l < 10; l++)
               {
                  if(a<=1000001*i+100010*j+10100*k+1000*l&&1000001*i+100010*j+10100*k+1000*l<=b)
                  {
                     if(isPrime(1000001*i+100010*j+10100*k+1000*l))
                        out.println(""+(1000001*i+100010*j+10100*k+1000*l));
                  }
               }
            }
         }
      }
      for(int i = 1; i < 10; i++)
      {
         for(int j = 0; j < 10; j++)
         {
            for(int k = 0; k < 10; k++)
            {
               for(int l = 0; l < 10; l++)
               {
                  if(a<=10000001*i+1000010*j+100100*k+11000*l&&10000001*i+1000010*j+100100*k+11000*l<=b)
                  {
                     if(isPrime(10000001*i+1000010*j+100100*k+11000*l))
                        out.println(""+(10000001*i+1000010*j+100100*k+11000*l));
                  }
               }
            }
         }
      }
      out.close();
   }
   public static boolean isPrime(int n){
      if(n%2 == 0)
         return false;
      if(n%3 == 0)
         return false;
      for(int i = 7; i <= (int)Math.sqrt(n); i+=6)
      {
         if(n%i == 0)
            return false;
      }
      for(int i = 5; i <= (int)Math.sqrt(n); i+=6)
      {
         if(n%i == 0)
            return false;
      }
      return true;
   }
}