/*
ID: philip61
LANG: JAVA
TASK: namenum
*/
package chapter_1;
import java.util.*;
import java.io.*;
class namenum1{
   final static char[][] keypad = new char[][]{ {},{}, {'A','B','C'},{'D','E','F'},{'G','H','I'},{'J','K','L'},{'M','N','O'},{'P','R','S'},{'T','U','V'},{'W','X','Y'} };
   static List<String> names;
   static String[] dictionary;
   public static void findNames(long N, int k, int m, String current)
   {
      if(N<=2147483647)
      {
         int x = (int)N;
         findName(x,k,m,current);
         return;
      }
      else if(k == 1)
      {
         StringBuilder name = new StringBuilder(current);
         name.append(keypad[(int)N][m]);
         names.add(name.toString());
      }
      else
      {
         for(int i = 0; i < 3; i++)
         {
            StringBuilder name = new StringBuilder(current);
            long index = N;
            int index2;
            int count = 0;
            while(index>2147483647)
            {
               index /= 10;
               count++;
            }
            index2 = (int)(index);
            while(index2>=10)
            {
               index2 /=10;
               count++;
            }
            name.append(keypad[index2][m]);
            findNames((long)(N%(Math.pow(10,count))),k-1,i,name.toString());
         }
      }
   }
   public static void findName(int N, int k, int m, String current)
   {
      if(k == 1)
      {
         StringBuilder name = new StringBuilder(current);
         name.append(keypad[N][m]);
         names.add(name.toString());
      }
      else
      {
         for(int i = 0; i < 3; i++)
         {
            StringBuilder name = new StringBuilder(current);
            int index = N;
            int count = 0;
            while(index>=10)
            {
               index /=10;
               count++;
            }
            name.append(keypad[index][m]);
            findName(N%((int)Math.pow(10,count)),k-1,i,name.toString());
         }
      }
   }

   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
      StringTokenizer st = new StringTokenizer(f.readLine());
      long N = Long.parseLong(st.nextToken());
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
      BufferedReader g = new BufferedReader(new FileReader("dict.txt"));
      dictionary = new String[4617];
      for(int i = 0; i < 4617; i++)
      {
         StringTokenizer st1 = new StringTokenizer(g.readLine());
         dictionary[i] = st1.nextToken();
      }
      long l = N;
      int k = 0;
      while(l>2147483647)
      {
         l /= 10;
         k++;
      }
      int x = (int)l;
      while(x>0)
      {
         x /=10;
         k++;
      }
      names = new ArrayList<String>();
      findNames(N,k,0,"");
      findNames(N,k,1,"");
      findNames(N,k,2,"");
      
      boolean any = false;
      Map<String,Integer> dictionari = new HashMap<String,Integer>();
      for(int i = 0; i < dictionary.length; i++)
      {
         dictionari.put(dictionary[i],i);
      }
      for(int i = 0; i < names.size(); i++)
      {
         if(dictionari.containsKey(names.get(i)))
         {
            out.println(names.get(i));
            any = true;
         }
      }
      if(any == false)
         out.println("NONE");
      out.close();
   }
}