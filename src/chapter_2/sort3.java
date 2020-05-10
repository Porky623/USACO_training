/*
ID: philip61
LANG: JAVA
TASK: sort3
*/
package chapter_2;
import java.io.*;
import java.util.*;
class sort3{
   static int N;
   static int[] original, count;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      N = Integer.parseInt(stn.nextToken());
      original = new int[N];
      count = new int[]{0,0,0};
      for(int i = 0; i < N; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         original[i] = Integer.parseInt(st.nextToken());
         count[original[i]-1]++;
      }
      int[] sec1 = new int[count[0]];
      int[] sec2 = new int[count[1]];
      int[] sec3 = new int[count[2]];
      for(int i = 0; i < count[0]; i++)
      {
         sec1[i] = original[i];
      }
      for(int i = 0; i < count[1]; i++)
      {
         sec2[i] = original[i+count[0]];
      }
      for(int i = 0; i < count[2]; i++)
      {
         sec3[i] = original[i+count[0]+count[1]];
      }
      int swaps = 0;
      for(int i = 0; i < count[0]; i++)
      {
         if(sec1[i]==2)
         {
            boolean proceed = true;
            int j = 0;
            do{
               if(sec2[j]==1)
               {
                  sec1[i] = 1;
                  sec2[j] = 2;
                  swaps++;
                  proceed = false;
               }
               j++;
            }while(proceed&&j<count[1]);
         }
         if(sec1[i]==3)
         {
            boolean proceed = true;
            int j = 0;
            do{
               if(sec3[j]==1)
               {
                  sec1[i] = 1;
                  sec3[j] = 3;
                  swaps++;
                  proceed = false;
               }
               j++;
            }while(proceed&&j<count[2]);
         }
      }
      for(int i = 0; i < count[1]; i++)
      {
         if(sec2[i]==3)
         {
            boolean proceed = true;
            int j = 0;
            do{
               if(sec3[j]==2)
               {
                  sec2[i] = 2;
                  sec3[j] = 3;
                  swaps++;
                  proceed = false;
               }
               j++;
            }while(proceed&&j<count[2]);
         }
      }
      for(int i = 0; i < count[0]; i++)
      {
         if(sec1[i]!=1)
            swaps+=2;
      }
      out.println(""+swaps);
      out.close();
   }
}