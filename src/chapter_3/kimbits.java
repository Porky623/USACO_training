/*
ID: philip61
TASK: kimbits
LANG: JAVA
 */
package chapter_3;
import java.util.*;
import java.io.*;
public class kimbits {
	private static int[][] dp=new int[32][32];
	public static void main(String[] args) throws IOException{
		Scanner f = new Scanner(new File("kimbits.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));
		int N = f.nextInt();
		int L = f.nextInt();
		int I = f.nextInt();
		for(int i = 0; i < 32; i++) {
			dp[0][i]=1;
			dp[i][i]=1;
			dp[i][0]=1;
		}
		for(int i = 1; i < 32; i++) {
			for(int j = 1; j < 32; j++) {
				dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
			}
		}
		String s = "";
		for(int i = 0; i < N; i++){
			if(dp[N-i-1][L]>=I){
				s+="0";
			}
			else{
				I-=dp[N-i-1][L];
				L--;
				s+="1";
			}
		}
		out.println(s);
		out.close();
	}
}
