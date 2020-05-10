/*
ID: philip61
LANG: JAVA
TASK: preface
*/
package chapter_2;
import java.util.*;
import java.io.*;
public class preface{
   static int N;
   static int[] used;
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new FileReader("preface.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
      StringTokenizer st = new StringTokenizer(f.readLine());
      N = Integer.parseInt(st.nextToken());
      used = new int[7];
      for(int i = 0; i < 7; i++)
      {
         used[i] = 0;
      }
      for(int i = 1; i <= N; i++) {
    	  calc(i);
      }
      if(used[0]!=0) {
    	  out.println("I "+used[0]);
      }
      if(used[1]!=0) {
    	  out.println("V "+used[1]);
      }
      if(used[2]!=0) {
    	  out.println("X "+used[2]);
      }
      if(used[3]!=0) {
    	  out.println("L "+used[3]);
      }
      if(used[4]!=0) {
    	  out.println("C "+used[4]);
      }
      if(used[5]!=0) {
    	  out.println("D "+used[5]);
      }
      if(used[6]!=0) {
    	  out.println("M "+used[6]);
      }
      out.close();
   }
   private static void calc(int x) {
	   while(x>=1000) {
		   used[6]++;
		   x-=1000;
	   }
	   if(x>=900) {
		   used[6]++;
		   used[4]++;
		   x-=900;
	   }
	   if(x>=500) {
		   used[5]++;
		   x-=500;
	   }
	   if(x>=400) {
		   used[5]++;
		   used[4]++;
		   x-=400;
	   }
	   while(x>=100) {
		   used[4]++;
		   x-=100;
	   }
	   if(x>=90) {
		   used[2]++;
		   used[4]++;
		   x-=90;
	   }
	   if(x>=50) {
		   used[3]++;
		   x-=50;
	   }
	   if(x>=40) {
		   used[3]++;
		   used[2]++;
		   x-=40;
	   }
	   while(x>=10) {
		   used[2]++;
		   x-=10;
	   }
	   if(x>=9) {
		   used[2]++;
		   used[0]++;
		   x-=9;
	   }
	   if(x>=5) {
		   used[1]++;
		   x-=5;
	   }
	   if(x>=4) {
		   used[1]++;
		   used[0]++;
		   x-=4;
	   }
	   while(x>=1) {
		   used[0]++;
		   x--;
	   }
   }
}