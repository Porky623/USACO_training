/*
ID: philip61
LANG: JAVA
TASK: transform
*/
package chapter_1;
import java.util.*;
import java.io.*;
class transform{
   static char[][] temp;
   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("transform.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
      StringTokenizer st1 = new StringTokenizer(f.readLine());
      int N = Integer.parseInt(st1.nextToken());
      temp = new char[N][N];
      char[][] originalPattern = new char[N][N];
      char[][] afterPattern = new char[N][N];
      for(int i = 0; i < N; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         String line = st.nextToken();
         for(int j = 0; j < N; j++)
         {
            originalPattern[i][j] = line.charAt(j);
         }
      }
      for(int i = 0; i < N; i++)
      {
         StringTokenizer st = new StringTokenizer(f.readLine());
         String line = st.nextToken();
         for(int j = 0; j < N; j++)
         {
            afterPattern[i][j] = line.charAt(j);
         }
      }
      
      if(Arrays.deepEquals(afterPattern,rotate(originalPattern)))
      {
         out.println("1");
      }
      else if(Arrays.deepEquals(afterPattern,rotate(rotate(originalPattern))))
      {
         out.println("2");
      }
      else if(Arrays.deepEquals(afterPattern,rotate(rotate(rotate(originalPattern)))))
      {
         out.println("3");
      }
      else if(Arrays.deepEquals(afterPattern,reflect(originalPattern)))
      {
         out.println("4");
      }
      else if(Arrays.deepEquals(afterPattern,reflect(rotate(originalPattern)))||Arrays.deepEquals(afterPattern,reflect(rotate(rotate(originalPattern))))||Arrays.deepEquals(afterPattern,reflect(rotate(rotate(rotate(originalPattern))))))
      {
         out.println("5");
      }
      else if(Arrays.deepEquals(afterPattern,originalPattern))
      {
         out.println("6");
      }
      else
         out.println("7");
      out.close();
   }
   public static char[][] rotate(char[][] pat)
   {
      int N = pat.length;
      char[][] temp2 = new char[N][N];
      for(int i = 0; i < N; i++)
      {
         for(int j = 0; j < N; j++)
         {
            temp2[j][N-i-1] = pat[i][j];
         }
      }
      return temp2;
   }
   public static char[][] reflect(char[][] pat)
   {
      int N = pat.length;
      char[][] temp2 = new char[N][N];
      for(int i = 0; i < N; i++)
      {
         for(int j = 0; j < N; j++)
         {
            temp2[i][N-1-j] = pat[i][j];
         }
      }
      return temp2;
   }
}