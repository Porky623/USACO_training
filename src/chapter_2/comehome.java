/*
ID: philip61
TASK: comehome
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class comehome {
   private static HashMap<Character,HashMap<Character,Integer>> pa;
   private static int[][] paths;
   private final static int INF = 20000000;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("comehome.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));
      pa = new HashMap<Character,HashMap<Character,Integer>>();
      for(int i = 0; i < 26; i++) {
         HashMap<Character,Integer> temp = new HashMap<Character,Integer>();
         pa.put((char)(i+'A'), temp);
         HashMap<Character,Integer> temp2 = new HashMap<Character,Integer>();
         pa.put((char)(i+'a'), temp2);
      }
      int N = Integer.parseInt(f.readLine());
      paths = new int[52][52];
      for(int i = 0; i < 52; i++) {
         for(int j = 0; j < 52; j++) {
            if(i!=j)
               paths[i][j]=INF;
         }
      }
      for(int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(f.readLine());
         Character a = st.nextToken().charAt(0);
         Character b = st.nextToken().charAt(0);
         int l = Integer.parseInt(st.nextToken());
         if(a!=b) {
            HashMap<Character,Integer> temp = pa.get(a);
            HashMap<Character,Integer> temp2 = pa.get(b);
            if(!temp.containsKey(b)) {
               temp.put(b, l);
               addPath(a,b,l);
            }
            else if(l<temp.get(b)) {
               temp.put(b, l);
               addPath(a,b,l);
            }
            if(!temp2.containsKey(a)||l<temp2.get(a))
            temp2.put(a,l);
         }
      }
      makePaths();
      int in = 0;
      int min = paths[0][25];
      for(int i = 1; i < 25; i++) {
         if(paths[i][25]<min) {
            min=paths[i][25];
            in=i;
         }
      }
      out.println((char)(in+'A')+" "+min);
      out.close();
   }
   private static void makePaths() {
      for (int k = 0; k < 52; k++){
         for (int i = 0; i < 52; i++){
            for (int j = 0; j < 52; j++){
               if (paths[i][k] + paths[k][j] < paths[i][j])
                  paths[i][j] =paths[j][i]= paths[i][k] + paths[k][j];
            }
         }
      }
   }
   private static void addPath(char a, char b, int x) {
      if(!Character.isLowerCase(a)) {
         if(!Character.isLowerCase(b)) {
            paths[a-'A'][b-'A']=x;
            paths[b-'A'][a-'A']=x;
            return;
         }
         paths[a-'A'][26+b-'a']=x;
         paths[26+b-'a'][a-'A']=x;
         return;
      }
      if(!Character.isLowerCase(b)) {
         paths[26+a-'a'][b-'A']=x;
         paths[b-'A'][26+a-'a']=x;
         return;
      }
      paths[26+a-'a'][26+b-'a']=x;
      paths[26+b-'a'][26+a-'a']=x;
   }
}
