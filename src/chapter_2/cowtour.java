/*
ID: philip61
TASK: cowtour
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class cowtour {
   private static double[][] dist,path;
   private static int[][] loc;
   private static double minD;
   private static int N;
   private static double INF = 300000;
   private static double[] far;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
      PrintWriter out = new PrintWriter(new FileWriter("cowtour.out"));
      N = Integer.parseInt(f.readLine());
      loc = new int[N][2];
      dist = new double[N][N];
      path = new double[N][N];
      minD = INF;
      for(int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(f.readLine());
         loc[i][0]=Integer.parseInt(st.nextToken());
         loc[i][1]=Integer.parseInt(st.nextToken());
      }
      for(int i = 0; i < N; i++) {
         for(int j = 0; j < N; j++) {
            dist[i][j]=Math.hypot(loc[i][0]-loc[j][0], loc[i][1]-loc[j][1]);
         }
      }
      for(int i = 0; i < N; i++) {
         for(int j = 0; j < N; j++) {
            if(i!=j)
               path[i][j]=INF;
         }
      }
      for(int i = 0; i < N; i++) {
         String k = f.readLine();
         for(int j = 0; j < N; j++) {
            if(k.charAt(j)=='1')
               path[i][j]=dist[i][j];
         }
      }
      makePaths();
      far = new double[N];
      for(int i = 0; i < N; i++) {
         for(int j = 0; j < N; j++) {
            if(path[i][j]>far[i]&&path[i][j]!=INF)
               far[i]=path[i][j];
         }
      }
      double[] diam = new double[N];
      for(int i = 0; i < N; i++) {
         diam[i]=INF;
      }
      for(int i = 0; i < N; i++) {
         if(diam[i]==INF) {
            double max = 0;
            for(int j = 0; j < N; j++) {
               if(path[i][j]<INF) {
                  if(far[j]>max)
                     max=far[j];
               }
            }
            for(int j = 0; j < N; j++) {
               if(path[i][j]<INF){
                  diam[j]=max;
               }
            }
         }
      }
      for(int i = 0; i < N; i++) {
         for(int j = 0; j < N; j++) {
            if(path[i][j]==INF) {
               double a,b;
               if(diam[i]<=diam[j])
                  a=diam[j];
               else
                  a=diam[i];
               if(far[i]+dist[i][j]+far[j]>a)
                  b=far[i]+dist[i][j]+far[j];
               else
                  b=a;
               if(b<minD)
                  minD=b;
            }
         }
      }
      String k = ""+(minD+0.0000005);
      int i;
      for(i = 0; k.charAt(i)!='.'; i++) {
         out.print(k.charAt(i));
      }
      out.print('.');
      i++;
      int j;
      for(j=i; j < k.length()&&j-i<6; j++) {
         out.print(k.charAt(j));
      }
      if(j-i<6) {
         for(int a = j-i; a < 6; a++) {
            out.print(k.charAt(a+i));
         }
      }
      out.println();
      out.close();
   }
   private static void makePaths(){
      for (int k = 0; k < N; k++){
         for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
               if (path[i][k] + path[k][j] < path[i][j])
                  path[i][j] = path[i][k] + path[k][j];
            }
         }
      }
   }
}