/*
ID: philip61
LANG: JAVA
TASK: ariprog
*/
package chapter_1;
import java.util.*;
import java.io.*;
class ariprog{
   static int N,M;
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
      StringTokenizer stn = new StringTokenizer(f.readLine());
      N = Integer.parseInt(stn.nextToken());
      StringTokenizer stm = new StringTokenizer(f.readLine());
      M = Integer.parseInt(stm.nextToken());
      int MM2 = M*M*2;
      boolean[] bisquares = new boolean[MM2+1];
      for(int i = 0; i < bisquares.length; i++)
      {
         bisquares[i] = false;
      }
      for(int i = 0; i <= M; i++)
      {
         for(int j = 0; j <= M; j++)
         {
            bisquares[(int)(Math.pow(i,2)+Math.pow(j,2))] = true;
         }
      }
      List<int[]> sequences = new ArrayList<int[]>();
      for(int i = 0; i < MM2; i++)
      {
         if(!bisquares[i]) 
            continue;
         label:
            for(int j = 1; j < (MM2-i)/(N-1)+1; j++)
         {
            for(int k = 1; k < N; k++)
            {
               if(!bisquares[i+j*k])
                  continue label;
                  
            }
            
            sequences.add(new int[]{i,j});
         }
         
      }
      int[][] sequences1 = new int[sequences.size()][2];
      for(int i = 0; i < sequences1.length; i++)
         sequences1[i] = sequences.get(i);
      Arrays.sort(sequences1,
         new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
               return Integer.compare(a[0],b[0]);}});
      Arrays.sort(sequences1,
         new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
               return Integer.compare(a[1],b[1]);}});
      for(int i = 0; i < sequences1.length; i++)
      {
         out.println(sequences1[i][0]+" "+sequences1[i][1]);
      }
      if(sequences1.length == 0)
         out.println("NONE");
      out.close();
   }
}