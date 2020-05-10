/*
ID: philip61
LANG: JAVA
TASK: milk3
*/
package chapter_1;
import java.util.*;
import java.io.*;
class milk3{
   static int[] cap;
   static boolean[][][] done;
   static List<Integer> sets;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      cap = new int[3];
      cap[0] = Integer.parseInt(st.nextToken());
      cap[1] = Integer.parseInt(st.nextToken());
      cap[2] = Integer.parseInt(st.nextToken());
      sets = new ArrayList<Integer>();
      done = new boolean[cap[0]+1][cap[1]+1][cap[2]+1];
      recur(0,0,cap[2]);
      int[] ans = new int[sets.size()];
      for(int i = 0; i < ans.length; i++)
      {
         ans[i] = sets.get(i);
      }
      Arrays.sort(ans);
      boolean first = true;
      for(int i : ans)
      {
         if(!first)
            out.print(" ");
         first = false;
         out.print(i);
      }
      out.println();
      out.close();
   }
   public static void recur(int a, int b, int c){
      if(done[a][b][c])
         return;
      done[a][b][c] = true;
      if(a == 0)
         sets.add(c);
      recur(a+Math.min(c,cap[0]-a),b,c-Math.min(c,cap[0]-a));
      recur(a-Math.min(cap[2]-c,a),b,c+Math.min(cap[2]-c,a));
      recur(a+Math.min(b,cap[0]-a),b-Math.min(b,cap[0]-a),c);
      recur(a-Math.min(cap[1]-b,a),b+Math.min(cap[1]-b,a),c);
      recur(a,b+Math.min(c,cap[1]-b),c-Math.min(c,cap[1]-b));
      recur(a,b-Math.min(cap[2]-c,b),c+Math.min(cap[2]-c,b));
   }
}