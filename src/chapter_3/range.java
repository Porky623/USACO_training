/*
ID: philip61
TASK: range
LANG: JAVA
 */
package chapter_3;
import java.io.*;
public class range {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("range.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("range.out")));
		int N = Integer.parseInt(f.readLine());
		boolean[][][] dp = new boolean[N+1][N][N];
		boolean[][] square = new boolean[N][N];
		int[] num = new int[N+1];
		for(int i = 0; i < N; i++) {
			String k = f.readLine();
			for(int j = 0; j < N; j++) {
				square[i][j]=dp[1][i][j]=k.charAt(j)=='1';
			}
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= N-i; j++) {
				for(int k = 0; k <=N-i; k++) {
					dp[i][j][k]=dp[i-1][j][k]&&dp[i-1][j+1][k]&&dp[i-1][j][k+1]&&dp[i-1][j+1][k+1];
					if(dp[i][j][k])
						num[i]++;
				}
			}
		}
		for(int i = 2; i <=N&&num[i]>0; i++) {
			out.println(i+" "+num[i]);
		}
		out.close();
		f.close();
	}
}
