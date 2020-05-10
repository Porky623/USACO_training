/*
ID: philip61
LANG: JAVA
TASK: namenum
*/
package chapter_1;
import java.util.*;
import java.io.*;
class namenum{
   public static HashMap<Character,Integer> dictionari;
   public static long getNum(String key)
   {
      long finish = 0;
      for(int i = 0; i < key.length(); i++)
      {
         finish*=10;
         if(dictionari.containsKey(key.charAt(i)))
         {
         finish+=dictionari.get(key.charAt(i));
         }
         else
         return -1;
      }
      return finish;
   }
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
      StringTokenizer st = new StringTokenizer(f.readLine());
      long N = Long.parseLong(st.nextToken());
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
      BufferedReader g = new BufferedReader(new FileReader("dict.txt"));
      String[] dictionary = new String[4617];
      for(int i = 0; i < 4617; i++)
      {
         StringTokenizer st1 = new StringTokenizer(g.readLine());
         dictionary[i] = st1.nextToken();
      }
      dictionari = new HashMap<Character,Integer>();
      dictionari.put('A',2);
      dictionari.put('B',2);
      dictionari.put('C',2);
      dictionari.put('D',3);
      dictionari.put('E',3);
      dictionari.put('F',3);
      dictionari.put('G',4);
      dictionari.put('H',4);
      dictionari.put('I',4);
      dictionari.put('J',5);
      dictionari.put('K',5);
      dictionari.put('L',5);
      dictionari.put('M',6);
      dictionari.put('N',6);
      dictionari.put('O',6);
      dictionari.put('P',7);
      dictionari.put('R',7);
      dictionari.put('S',7);
      dictionari.put('T',8);
      dictionari.put('U',8);
      dictionari.put('V',8);
      dictionari.put('W',9);
      dictionari.put('X',9);
      dictionari.put('Y',9);
      long[] dictNums = new long[4617];
      boolean any = false;
      for(int i = 0 ; i < 4617; i++)
      {
         dictNums[i] = getNum(dictionary[i]);
         if(dictNums[i] == N)
         {
            out.println(dictionary[i]);
            any = true;
            }
      }
      if(any == false)
         out.println("NONE");
      out.close();
      }
}