/*
ID: philip61
LANG: JAVA
TASK: palsquare
*/
package chapter_1;
import java.util.*;
import java.io.*;
class palsquare{
   static HashMap<Integer,Character> translation;
   static HashMap<Character,Integer> transBack;
   public static boolean isPalindrome(String n)
   {
      StringBuilder N = new StringBuilder(n);
      if(N.charAt(0) == N.charAt(N.length()-1))
      {
         if(N.length()>2)
         {
            N.deleteCharAt(0);
            N.deleteCharAt(N.length()-1);
            return isPalindrome(N.toString());}
         else
            return true;
      }
      else
         return false;
   }
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      int base = Integer.parseInt(st.nextToken());
   
   translation = new HashMap<Integer,Character>();
   translation.put(0,'0');
   translation.put(1,'1');
   translation.put(2,'2');
   translation.put(3,'3');
   translation.put(4,'4');
   translation.put(5,'5');
   translation.put(6,'6');
   translation.put(7,'7');
   translation.put(8,'8');
   translation.put(9,'9');
   translation.put(10,'A');
   translation.put(11,'B');
   translation.put(12,'C');
   translation.put(13,'D');
   translation.put(14,'E');
   translation.put(15,'F');
   translation.put(16,'G');
   translation.put(17,'H');
   translation.put(18,'I');
   translation.put(19,'J');
   
   transBack = new HashMap<Character,Integer>();
   transBack.put('0',0);
   transBack.put('1',1);
   transBack.put('2',2);
   transBack.put('3',3);
   transBack.put('4',4);
   transBack.put('5',5);
   transBack.put('6',6);
   transBack.put('7',7);
   transBack.put('8',8);
   transBack.put('9',9);
   transBack.put('A',10);
   transBack.put('B',11);
   transBack.put('C',12);
   transBack.put('D',13);
   transBack.put('E',14);
   transBack.put('F',15);
   transBack.put('G',16);
   transBack.put('H',17);
   transBack.put('I',18);
   transBack.put('J',19);
      for(int i = 1; i < 300; i++)
      {
         StringBuilder N = new StringBuilder("");
         int x = i;
         while(x>0)
         {
            N.insert(0,translation.get(x%base));
            x /= base;
         }
         StringBuilder N2 = new StringBuilder("");
         x = (int)Math.pow(i,2);
         while(x>0)
         {
            N2.insert(0,translation.get(x%base));
            x /= base;
         }
         if(isPalindrome(N2.toString()))
            out.println(N.toString()+" "+N2.toString());
      }
      out.close();
   }
}