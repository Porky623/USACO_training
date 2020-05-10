/*
ID: philip61
TASK: nocows
LANG: JAVA
 */
package chapter_2;
import java.util.*;
import java.io.*;
public class nocows {
	   public static void main(String[] args) throws IOException{
		      BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
		      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
		      StringTokenizer st = new StringTokenizer(f.readLine());
		      int N = Integer.parseInt(st.nextToken());
		      if(N%2==0) {
		    	  out.println("0");
		    	  out.close();
		    	  System.exit(0);
		      }
		      N/=2;
		      int K = Integer.parseInt(st.nextToken())-1;
		      long[][] dp = new long[K+1][N+1];
		      for(int i = 0; i <= K; i++) {
		    	  dp[i][0]=1;
		      }
		      for(int j = 1; j <= N; j++) {
			      for(int i = 1; i <= K; i++) {
			    	  for(int m = 0; m < j; m++) {
			    		  dp[i][j]+=dp[i-1][m]*dp[i-1][j-1-m];
			    		  dp[i][j]%=9901;
			    	  }
			      }
		      }
		      out.println((dp[K][N]-dp[K-1][N]+9901)%9901);
		      out.close();
	   }
}
