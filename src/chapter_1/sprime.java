/*
ID: philip61
LANG: JAVA
TASK: sprime
*/
package chapter_1;
import java.util.*;
import java.io.*;
class sprime{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
      StringTokenizer st= new StringTokenizer(f.readLine());
      int N = Integer.parseInt(st.nextToken());
      superprime(N, out);
      out.close();
   }
   public static void superprime(int n, PrintWriter out)
   {
      recur(2, n, out); //try leading 2, 3, 5, 7, i.e. all the single-digit primes
      recur(3, n, out); 
      recur(5, n, out);
      recur(7, n, out);
   }
   private static void recur(int k, int n, PrintWriter out)
   {
      if(n == 1)
      {
         if(isPrime(k))
            out.println(""+k);
      }
      else if(isPrime(k))
      {
         recur(1+k*10, n-1, out);
         recur(3+k*10, n-1, out);
         recur(5+k*10, n-1, out);
         recur(7+k*10, n-1, out);
         recur(9+k*10, n-1, out);
      }
      
   }
   public static boolean isPrime(int n){
      if(n==2)
         return true;
      if(n==3)
         return true;
      if(n==5)
         return true;
      if(n==7)
         return true;
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