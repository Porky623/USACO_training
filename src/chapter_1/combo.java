/*
ID: philip61
LANG: JAVA
TASK: combo
*/
package chapter_1;
import java.util.*;
import java.io.*;
class combo{
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("combo.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(stn.nextToken());
      StringTokenizer stf = new StringTokenizer(f.readLine());
      int[] johnCombo = new int[3];
      for(int i = 0; i < 3; i++)
      {
         johnCombo[i] = Integer.parseInt(stf.nextToken());
      }
      int[] masterCombo = new int[3];
      StringTokenizer stm = new StringTokenizer(f.readLine());
      for(int i = 0; i < 3; i++)
      {
         masterCombo[i] = Integer.parseInt(stm.nextToken());
      }
      
      boolean[] list = new boolean[N*N*N];
      for(int i = 0; i < N*N*N; i++)
      {
         list[i] = false;
      }
      for(int i = -2; i < 3; i++)
      {
         for(int j = -2; j < 3; j++)
         {
            for(int k = -2; k < 3; k++)
            {
               int a = (johnCombo[0]+N+i-1)%N;
               int b = (johnCombo[1]+N+j-1)%N;
               int c = (johnCombo[2]+N+k-1)%N;
               int index = a*N*N+b*N+c;
               list[index] = true;
            }
         }
      }
      for(int i = -2; i < 3; i++)
      {
         for(int j = -2; j < 3; j++)
         {
            for(int k = -2; k < 3; k++)
            {
               int a = (masterCombo[0]+N+i-1)%N;
               int b = (masterCombo[1]+N+j-1)%N;
               int c = (masterCombo[2]+N+k-1)%N;
               int index = a*N*N+b*N+c;
               list[index] = true;
            }
         }
      }
      int count = 0;
      for(int i = 0; i < N*N*N; i++)
      {
         if(list[i])
            count++;
      }
      out.println(""+count);
      out.close();
   }
}