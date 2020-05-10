/*
ID: philip61
TASK: game1
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class game1 {
	private static int N,sum=0;
	private static int[] board;
	private static int[][] dp;
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("game1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("game1.out")));
		N=f.nextInt();
		board = new int[N];
		dp=new int[N][N];
		for(int i = 0; i < N; i++) {
			board[i]=f.nextInt();
			dp[i][i]=board[i];
			sum+= board[i];
		}
      for(int a = 0; a < N; a++){
         for(int i = 0; i < N-a; i++){
            int x = findE(i+1,i+a)+board[i];
            int b = findE(i,i+a-1)+board[i+a];
            dp[i][i+a]=Math.max(x,b);
         }
      }
		/*for(int j = 0; j < N; j++) {
			for(int i = 0; i < j; i++) {
				int a = findE(i+1,j)+board[i];
				int b = findE(i,j-1)+board[j];
				dp[i][j]=Math.max(a,b);
			}
		}*/
		out.println(dp[0][N-1]+" "+(sum-dp[0][N-1]));
		out.close();
		f.close();
	}
	private static int findE(int start, int stop) {
		if(start>=stop)
			return 0;
		return Math.min(dp[start+1][stop], dp[start][stop-1]);
	}
}
